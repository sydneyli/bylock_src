package net.client.by.lock.p014c;

import android.content.Context;
import android.content.Intent;
import net.client.by.lock.C0322b;
import net.client.by.lock.p011a.C0289c;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.service.BackgroundService;

/* compiled from: MyApp */
public class C0330h {
    private static C0330h f1431a = null;
    private Context f1432b;

    public static C0330h m2111a() {
        try {
            if (f1431a == null) {
                f1431a = new C0330h();
            }
        } catch (Exception e) {
            C0322b.m2076e("ServiceManager", e.toString());
        }
        return f1431a;
    }

    Context m2117b() {
        if (this.f1432b == null) {
            return BackgroundService.m2756a();
        }
        return this.f1432b;
    }

    public synchronized void m2113a(Context context) {
        this.f1432b = context;
        this.f1432b.startService(new Intent(this.f1432b, BackgroundService.class));
    }

    public synchronized void m2119c() {
        Context a = BackgroundService.m2756a();
        if (a != null) {
            a.stopService(new Intent(a, BackgroundService.class));
        }
    }

    public void m2115a(C0289c c0289c) {
        Intent intent = new Intent("by.lock.BackgroundService");
        intent.putExtra("what", 4);
        intent.putExtra("id", c0289c.m1913E().m2237K());
        intent.putExtra("callId", c0289c.m1955q());
        m2117b().sendBroadcast(intent);
        C0322b.m2077i("ServiceManager", "call.getId() " + c0289c.m1955q().length);
    }

    public void m2121d() {
        Intent intent = new Intent("by.lock.BackgroundService");
        intent.putExtra("what", 5);
        m2117b().sendBroadcast(intent);
    }

    public void m2122e() {
        Intent intent = new Intent("by.lock.BackgroundService");
        intent.putExtra("what", 7);
        m2117b().sendBroadcast(intent);
    }

    public void m2116a(C0337c c0337c, int i) {
        Intent intent = new Intent("by.lock.BackgroundService");
        intent.putExtra("what", 9);
        intent.putExtra("friendUserId", c0337c.m2237K());
        intent.putExtra("arg1", i);
        intent.putExtra("arg2", 1);
        m2117b().sendBroadcast(intent);
    }

    public void m2118b(C0337c c0337c, int i) {
        Intent intent = new Intent("by.lock.BackgroundService");
        intent.putExtra("what", 9);
        intent.putExtra("friendUserId", c0337c.m2237K());
        intent.putExtra("arg1", i);
        intent.putExtra("arg2", 0);
        m2117b().sendBroadcast(intent);
    }

    public void m2114a(String str) {
        Intent intent = new Intent("by.lock.BackgroundService");
        intent.putExtra("what", 8);
        intent.putExtra("error", str);
        m2117b().sendBroadcast(intent);
    }

    public void m2120c(C0337c c0337c, int i) {
        Intent intent = new Intent("by.lock.BackgroundService");
        intent.putExtra("what", i);
        intent.putExtra("friendUserId", c0337c.m2237K());
        intent.putExtra("arg1", 1);
        m2117b().sendBroadcast(intent);
    }

    public void m2112a(int i) {
        Intent intent = new Intent("by.lock.BackgroundService");
        intent.putExtra("what", i);
        intent.putExtra("arg1", 0);
        m2117b().sendBroadcast(intent);
    }
}
