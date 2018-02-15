package net.client.by.lock.p012d;

import android.content.Intent;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import net.client.by.lock.gui.activity.MainActivity;
import net.client.by.lock.p014c.C0325c;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p016f.C0363h;
import net.client.by.lock.service.C0446c;

/* compiled from: MyApp */
public class C0351r {
    private static C0351r f1527l = null;
    private static SecureRandom f1528n = null;
    String f1529a = null;
    String f1530b;
    int f1531c;
    String f1532d = null;
    boolean f1533e;
    boolean f1534f = false;
    C0350q f1535g;
    private C0363h f1536h = new C0363h("", "name");
    private C0363h f1537i = new C0363h("publicMessage");
    private C0363h f1538j = new C0363h("description");
    private C0363h f1539k = new C0363h(Boolean.valueOf(false), "isConnected");
    private Integer f1540m = Integer.valueOf(-1);
    private ArrayList f1541o = new ArrayList();
    private ArrayList f1542p = new ArrayList();
    private HashMap f1543q = new HashMap();
    private C0363h f1544r = new C0363h(Integer.valueOf(3), "status");
    private boolean f1545s = false;
    private String f1546t = null;

    private C0351r() {
    }

    public void m2367a(byte[] bArr) {
        f1528n = new SecureRandom(bArr);
    }

    public SecureRandom m2361a() {
        return f1528n;
    }

    public static void m2358a(boolean z) {
        if (z) {
            f1527l.f1539k.m2468a(Boolean.valueOf(false));
            f1527l.f1546t = null;
            f1527l.f1537i.deleteObservers();
            f1527l.f1538j.deleteObservers();
            f1527l.f1539k.deleteObservers();
            f1527l.f1544r.deleteObservers();
            f1527l.f1536h.deleteObservers();
            f1527l.f1530b = "";
            f1527l.f1532d = "";
            f1527l.f1534f = false;
            C0446c.f1955a = null;
            f1527l.f1545s = false;
            f1528n = null;
        }
        f1527l.f1540m = Integer.valueOf(-1);
        f1527l.f1529a = "";
        Intent intent = new Intent(MainActivity.f1648t);
        intent.putExtra("caption", "Disconnected");
        C0325c.m2086a().m2088b().sendBroadcast(intent);
        f1527l.f1533e = false;
        f1527l.f1537i.m2468a((Object) "");
        f1527l.f1535g = null;
        f1527l.f1538j.m2468a((Object) "");
        f1527l.f1541o.clear();
        f1527l.f1542p.clear();
        f1527l.f1543q.clear();
    }

    public synchronized void m2363a(Integer num) {
        if (this.f1544r.m2467a() != num) {
            this.f1544r.m2468a((Object) num);
            this.f1545s = false;
        }
    }

    public synchronized void m2370b(Integer num) {
        if (this.f1544r.m2467a() != num) {
            this.f1544r.m2468a((Object) num);
            C0332j.m2148a().m2167b(num);
            this.f1545s = false;
        }
    }

    public C0363h m2369b() {
        return this.f1544r;
    }

    public synchronized void m2365a(C0337c c0337c, Integer num) {
        Integer num2 = (Integer) this.f1543q.get(c0337c);
        if (num2 == null) {
            this.f1543q.put(c0337c, num);
        } else if (num.intValue() > num2.intValue()) {
            this.f1543q.put(c0337c, num);
        }
    }

    public synchronized Set m2373c() {
        HashMap hashMap;
        hashMap = new HashMap();
        hashMap.putAll(this.f1543q);
        return hashMap.entrySet();
    }

    public synchronized void m2364a(String str) {
        this.f1541o.add(str);
    }

    public synchronized void m2371b(String str) {
        this.f1542p.add(str);
    }

    public synchronized String[] m2378d() {
        return (String[]) this.f1541o.toArray(new String[0]);
    }

    public synchronized String[] m2380e() {
        return (String[]) this.f1542p.toArray(new String[0]);
    }

    public synchronized void m2368a(String[] strArr, String[] strArr2, Set set) {
        int i = 0;
        synchronized (this) {
            for (Object remove : strArr) {
                this.f1541o.remove(remove);
            }
            int length = strArr2.length;
            while (i < length) {
                this.f1542p.remove(strArr2[i]);
                i++;
            }
            for (Entry entry : set) {
                Integer num = (Integer) this.f1543q.get(entry.getKey());
                if (num != null && num.equals(entry.getValue())) {
                    this.f1543q.remove(entry.getKey());
                }
            }
        }
    }

    private void m2360v() {
        if (this.f1536h.m2467a() == null || ((String) this.f1536h.m2467a()).length() <= 0) {
            this.f1538j.m2468a(this.f1530b);
        } else {
            this.f1538j.m2468a((String) this.f1536h.m2467a());
        }
    }

    public C0363h m2381f() {
        return this.f1538j;
    }

    public void m2383g() {
        this.f1534f = true;
    }

    public boolean m2386h() {
        return this.f1534f;
    }

    public static C0351r m2359i() {
        if (f1527l == null) {
            if (C0446c.f1955a == null) {
                f1527l = new C0351r();
                C0446c.f1955a = f1527l;
            } else {
                f1527l = C0446c.f1955a;
            }
        } else if (C0446c.f1955a == null) {
            C0446c.f1955a = f1527l;
        }
        return f1527l;
    }

    public String m2388j() {
        return this.f1529a;
    }

    public void m2375c(String str) {
        this.f1529a = str;
    }

    public String m2389k() {
        return this.f1530b;
    }

    public void m2377d(String str) {
        this.f1530b = str;
        m2360v();
    }

    public String m2390l() {
        return this.f1532d;
    }

    public void m2362a(int i) {
        this.f1531c = i;
    }

    public int m2391m() {
        return this.f1531c;
    }

    public void m2379e(String str) {
        String str2 = this.f1532d;
        this.f1532d = str;
        this.f1535g.mo329c();
        C0332j.m2148a().m2175c(str2);
    }

    public void m2382f(String str) {
        this.f1532d = str;
    }

    public void m2372b(boolean z) {
        this.f1533e = z;
    }

    public C0363h m2392n() {
        return this.f1536h;
    }

    public void m2384g(String str) {
        this.f1536h.m2468a((Object) str);
        m2360v();
    }

    public void m2385h(String str) {
        if (!str.equals(this.f1536h.m2467a())) {
            this.f1536h.m2468a((Object) str);
            m2360v();
            C0332j.m2148a().m2182e(str);
        }
    }

    public C0363h m2393o() {
        return this.f1537i;
    }

    public void m2387i(String str) {
        this.f1537i.m2468a((Object) str);
    }

    public C0350q m2394p() {
        return this.f1535g;
    }

    public void m2366a(C0350q c0350q) {
        this.f1535g = c0350q;
    }

    public boolean m2395q() {
        return this.f1529a != null && this.f1529a.length() > 0;
    }

    public boolean m2396r() {
        return this.f1530b != null && this.f1530b.length() > 0 && this.f1532d != null && this.f1532d.length() > 0;
    }

    public Integer m2397s() {
        return this.f1540m;
    }

    public void m2374c(Integer num) {
        if (num.intValue() > this.f1540m.intValue()) {
            this.f1540m = num;
        }
    }

    public C0363h m2398t() {
        return this.f1539k;
    }

    public String m2399u() {
        return this.f1546t;
    }

    public void m2376c(boolean z) {
        if (z) {
            C0351r.m2359i().m2370b(Integer.valueOf(2));
        } else if (this.f1545s) {
            C0351r.m2359i().m2370b(Integer.valueOf(3));
        }
        this.f1545s = z;
    }
}
