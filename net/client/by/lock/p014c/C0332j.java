package net.client.by.lock.p014c;

import android.app.Activity;
import android.content.Context;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import net.client.by.lock.C0322b;
import net.client.by.lock.C0333c;
import net.client.by.lock.gui.activity.ae;
import net.client.by.lock.gui.activity.aw;
import net.client.by.lock.p011a.C0289c;
import net.client.by.lock.p012d.C0335b;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p012d.C0341g;
import net.client.by.lock.p012d.C0347l;
import net.client.by.lock.p012d.C0348n;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p013b.C0308a;
import net.client.by.lock.p013b.C0314g;
import net.client.by.lock.p013b.C0315h;
import net.client.by.lock.p016f.C0365j;
import net.client.by.lock.service.BackgroundService;
import net.client.by.lock.task.AddFriendToGroupTask;
import net.client.by.lock.task.AddFriendToRosterTask;
import net.client.by.lock.task.C0448a;
import net.client.by.lock.task.ChangePasswordTask;
import net.client.by.lock.task.CreateGroupWithFriendTask;
import net.client.by.lock.task.DeleteChatTask;
import net.client.by.lock.task.DeleteFileTransferTask;
import net.client.by.lock.task.DeleteMailTask;
import net.client.by.lock.task.FileTask;
import net.client.by.lock.task.GetFileTransferInformationTask;
import net.client.by.lock.task.GetFriendInformationTask;
import net.client.by.lock.task.GetRosterEventTask;
import net.client.by.lock.task.LoginTask;
import net.client.by.lock.task.LogoutTask;
import net.client.by.lock.task.ReadMailTask;
import net.client.by.lock.task.ReceiveChatTask;
import net.client.by.lock.task.ReceiveFileTask;
import net.client.by.lock.task.RegisterTask;
import net.client.by.lock.task.RemoveFriendFromGroupTask;
import net.client.by.lock.task.RemoveFriendTask;
import net.client.by.lock.task.RemoveGroupTask;
import net.client.by.lock.task.RenameFriendTask;
import net.client.by.lock.task.RenameGroupTask;
import net.client.by.lock.task.SendChatTask;
import net.client.by.lock.task.SendFileTask;
import net.client.by.lock.task.SendMailTask;
import net.client.by.lock.task.SetNewPasswordTask;
import net.client.by.lock.task.UpdateNameTask;
import net.client.by.lock.task.UpdatePublicMessageTask;
import net.client.by.lock.task.UpdateStatusTask;
import net.client.by.lock.task.call.AnswerCallTask;
import net.client.by.lock.task.call.CancelCallTask;
import net.client.by.lock.task.call.CloseCallTask;
import net.client.by.lock.task.call.MakeCallTask;
import net.client.by.lock.task.call.RejectCallTask;

/* compiled from: MyApp */
public class C0332j {
    private static C0332j f1445c = null;
    private HashMap f1446a = new HashMap();
    private final Object f1447b = new Object();

    private C0332j() {
    }

    public static C0332j m2148a() {
        if (f1445c == null) {
            f1445c = new C0332j();
        }
        return f1445c;
    }

    private C0448a m2150a(Class cls, Object obj) {
        return m2149a(null, cls, obj);
    }

    private C0448a m2149a(Context context, Class cls, Object obj) {
        C0448a c0448a;
        Throwable th;
        Throwable th2;
        C0448a c0448a2 = null;
        if (context == null) {
            context = C0325c.m2086a().m2088b();
        }
        if (C0351r.m2359i().m2386h() && !cls.equals(LogoutTask.class)) {
            c0448a = null;
        } else if (cls.equals(RegisterTask.class) || cls.equals(LoginTask.class) || C0351r.m2359i().m2395q()) {
            Random random = new Random();
            random.setSeed(System.nanoTime());
            String str = System.currentTimeMillis() + "_" + random.nextInt();
            synchronized (this.f1447b) {
                try {
                    c0448a = (C0448a) cls.getConstructor(new Class[]{Context.class, Object.class}).newInstance(new Object[]{context, obj});
                    try {
                        c0448a.setTaskId(str);
                        c0448a.execute();
                        this.f1446a.put(str, c0448a);
                    } catch (Throwable e) {
                        th = e;
                        c0448a2 = c0448a;
                        th2 = th;
                        C0365j.m2476a("TaskManager", th2);
                        c0448a = c0448a2;
                        return c0448a;
                    } catch (Throwable e2) {
                        th = e2;
                        c0448a2 = c0448a;
                        th2 = th;
                        C0365j.m2476a("TaskManager", th2);
                        c0448a = c0448a2;
                        return c0448a;
                    } catch (Throwable e22) {
                        th = e22;
                        c0448a2 = c0448a;
                        th2 = th;
                        C0365j.m2476a("TaskManager", th2);
                        c0448a = c0448a2;
                        return c0448a;
                    } catch (Throwable e222) {
                        th = e222;
                        c0448a2 = c0448a;
                        th2 = th;
                        C0365j.m2476a("TaskManager", th2);
                        c0448a = c0448a2;
                        return c0448a;
                    } catch (Throwable e2222) {
                        th = e2222;
                        c0448a2 = c0448a;
                        th2 = th;
                        C0365j.m2476a("TaskManager", th2);
                        c0448a = c0448a2;
                        return c0448a;
                    }
                } catch (InstantiationException e3) {
                    th2 = e3;
                    C0365j.m2476a("TaskManager", th2);
                    c0448a = c0448a2;
                    return c0448a;
                } catch (IllegalArgumentException e4) {
                    th2 = e4;
                    C0365j.m2476a("TaskManager", th2);
                    c0448a = c0448a2;
                    return c0448a;
                } catch (IllegalAccessException e5) {
                    th2 = e5;
                    C0365j.m2476a("TaskManager", th2);
                    c0448a = c0448a2;
                    return c0448a;
                } catch (InvocationTargetException e6) {
                    th2 = e6;
                    C0365j.m2476a("TaskManager", th2);
                    c0448a = c0448a2;
                    return c0448a;
                } catch (NoSuchMethodException e7) {
                    th2 = e7;
                    C0365j.m2476a("TaskManager", th2);
                    c0448a = c0448a2;
                    return c0448a;
                }
            }
        } else if (cls.equals(LogoutTask.class)) {
            C0330h.m2111a().m2119c();
            Context b = C0325c.m2086a().m2088b();
            if (b != null && (b instanceof Activity)) {
                ((Activity) b).finish();
            }
            C0351r.m2358a(true);
            return null;
        } else {
            C0323a.m2083c(context);
            return null;
        }
        return c0448a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m2155a(java.lang.String r4) {
        /*
        r3 = this;
        r1 = r3.f1447b;
        monitor-enter(r1);
        r0 = r3.f1446a;	 Catch:{ all -> 0x0035 }
        r0 = r0.get(r4);	 Catch:{ all -> 0x0035 }
        r0 = (net.client.by.lock.task.C0448a) r0;	 Catch:{ all -> 0x0035 }
        if (r0 != 0) goto L_0x000f;
    L_0x000d:
        monitor-exit(r1);	 Catch:{ all -> 0x0035 }
    L_0x000e:
        return;
    L_0x000f:
        r2 = r3.f1446a;	 Catch:{ all -> 0x0035 }
        r2.remove(r4);	 Catch:{ all -> 0x0035 }
        r0 = r0.getState();	 Catch:{ all -> 0x0035 }
        r2 = 3;
        if (r0 != r2) goto L_0x0033;
    L_0x001b:
        r0 = r3.f1446a;	 Catch:{ all -> 0x0035 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0035 }
        if (r0 == 0) goto L_0x0033;
    L_0x0023:
        r0 = net.client.by.lock.p012d.C0351r.m2359i();	 Catch:{ all -> 0x0035 }
        r0 = r0.m2386h();	 Catch:{ all -> 0x0035 }
        if (r0 == 0) goto L_0x0033;
    L_0x002d:
        r0 = net.client.by.lock.task.LogoutTask.class;
        r2 = 0;
        r3.m2150a(r0, r2);	 Catch:{ all -> 0x0035 }
    L_0x0033:
        monitor-exit(r1);	 Catch:{ all -> 0x0035 }
        goto L_0x000e;
    L_0x0035:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0035 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.client.by.lock.c.j.a(java.lang.String):void");
    }

    public void m2166b() {
        m2150a(LoginTask.class, null);
    }

    public void m2173c() {
        m2150a(UpdatePublicMessageTask.class, null);
    }

    public void m2157a(String str, String str2, ae aeVar) {
        m2150a(AddFriendToRosterTask.class, new Object[]{str, str2, aeVar});
    }

    public void m2169b(String str) {
        m2150a(GetFileTransferInformationTask.class, (Object) str);
    }

    public void m2153a(Integer num) {
        m2150a(GetFriendInformationTask.class, (Object) num);
    }

    public void m2178d() {
        C0351r.m2359i().m2383g();
        try {
            C0333c.m2187c().m2188a();
        } catch (Throwable e) {
            C0365j.m2476a("TaskManager", e);
        }
        synchronized (this.f1447b) {
            if (this.f1446a.isEmpty()) {
                m2150a(LogoutTask.class, null);
            } else {
                Entry[] entryArr = (Entry[]) this.f1446a.entrySet().toArray(new Entry[0]);
                for (Entry value : entryArr) {
                    ((C0448a) value.getValue()).cancelTask(true);
                }
            }
        }
    }

    public void m2175c(String str) {
        m2150a(ChangePasswordTask.class, (Object) str);
    }

    public void m2161a(C0337c c0337c) {
        m2150a(RenameFriendTask.class, (Object) c0337c);
    }

    public void m2172b(C0337c c0337c) {
        m2150a(RemoveFriendTask.class, (Object) c0337c);
    }

    public void m2177c(C0337c c0337c) {
        m2150a(ReceiveChatTask.class, (Object) c0337c);
    }

    public void m2160a(C0335b c0335b) {
        m2150a(SendChatTask.class, (Object) c0335b);
    }

    public FileTask m2152a(C0315h c0315h) {
        return (FileTask) m2150a(SendFileTask.class, (Object) c0315h);
    }

    public FileTask m2151a(C0314g c0314g) {
        if (c0314g.m2042j() == null) {
            String e;
            String str;
            Object b = C0331i.m2124a().m2132b();
            if (!b.endsWith(File.separator)) {
                b = new StringBuilder(String.valueOf(b)).append(File.separator).toString();
            }
            int lastIndexOf = c0314g.mo325e().lastIndexOf(".");
            if (lastIndexOf == -1) {
                e = c0314g.mo325e();
                str = "";
            } else {
                e = c0314g.mo325e().substring(0, lastIndexOf);
                str = c0314g.mo325e().substring(lastIndexOf);
            }
            String stringBuilder = new StringBuilder(String.valueOf(b)).append(e).append(str).toString();
            int i = 1;
            while (new File(stringBuilder).exists()) {
                stringBuilder = new StringBuilder(String.valueOf(b)).append(e).append(" (").append(i).append(")").append(str).toString();
                i++;
            }
            c0314g.m2027a(new File(stringBuilder));
        }
        return (FileTask) m2150a(ReceiveFileTask.class, (Object) c0314g);
    }

    public void m2179d(String str) {
        m2150a(DeleteFileTransferTask.class, (Object) str);
    }

    public void m2167b(Integer num) {
        m2150a(UpdateStatusTask.class, (Object) num);
    }

    public void m2182e(String str) {
        m2150a(UpdateNameTask.class, (Object) str);
    }

    public void m2158a(C0289c c0289c) {
        m2150a(MakeCallTask.class, (Object) c0289c);
    }

    public void m2170b(C0289c c0289c) {
        m2150a(AnswerCallTask.class, (Object) c0289c);
    }

    public void m2176c(C0289c c0289c) {
        m2150a(RejectCallTask.class, (Object) c0289c);
    }

    public void m2180d(C0289c c0289c) {
        m2150a(CancelCallTask.class, (Object) c0289c);
    }

    public void m2183e(C0289c c0289c) {
        m2150a(CloseCallTask.class, (Object) c0289c);
    }

    public void m2159a(C0308a c0308a, ArrayList arrayList) {
        Object c0315h = new C0315h(c0308a);
        c0315h.m2059a(arrayList);
        m2150a(SendFileTask.class, c0315h);
    }

    public void m2154a(Integer num, Integer num2) {
        m2150a(AddFriendToGroupTask.class, new Integer[]{num, num2});
    }

    public void m2168b(Integer num, Integer num2) {
        m2150a(RemoveFriendFromGroupTask.class, new Integer[]{num, num2});
    }

    public void m2162a(C0337c c0337c, String str) {
        Object arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(c0337c);
        m2150a(CreateGroupWithFriendTask.class, arrayList);
    }

    public void m2174c(Integer num) {
        m2150a(RemoveGroupTask.class, (Object) num);
    }

    public void m2163a(C0341g c0341g) {
        m2150a(RenameGroupTask.class, (Object) c0341g);
    }

    public void m2181e() {
        m2150a(SetNewPasswordTask.class, null);
    }

    public void m2165a(C0348n c0348n, aw awVar) {
        m2150a(SendMailTask.class, new Object[]{c0348n, awVar});
    }

    public void m2164a(C0347l c0347l) {
        m2150a(ReadMailTask.class, (Object) c0347l);
    }

    public void m2185f(String str) {
        m2150a(DeleteMailTask.class, (Object) str);
    }

    public void m2184f() {
        m2149a(BackgroundService.m2756a(), GetRosterEventTask.class, null);
    }

    public void m2171b(C0335b c0335b) {
        m2150a(DeleteChatTask.class, (Object) c0335b);
    }

    public void m2156a(String str, String str2) {
        if (m2150a(RegisterTask.class, new String[]{str, str2}) == null) {
            C0322b.m2076e("TaskManager", "register task null");
        }
    }
}
