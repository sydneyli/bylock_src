package net.client.by.lock.p011a;

import net.client.by.lock.p016f.C0363h;

/* compiled from: MyApp */
public class C0294h {
    private static C0294h f1270b = new C0294h();
    private C0363h f1271a = new C0363h(Boolean.valueOf(true), "available");

    public static C0294h m1972a() {
        return f1270b;
    }

    public synchronized boolean m1973b() {
        boolean z;
        if (((Boolean) this.f1271a.m2467a()).booleanValue()) {
            this.f1271a.m2468a(Boolean.valueOf(false));
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public synchronized void m1974c() {
        this.f1271a.m2468a(Boolean.valueOf(true));
    }
}
