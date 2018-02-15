package net.client.by.lock.gui.activity;

import net.client.by.lock.p014c.C0330h;

/* compiled from: MyApp */
class C0396e implements Runnable {
    final /* synthetic */ C0395d f1802a;

    C0396e(C0395d c0395d) {
        this.f1802a = c0395d;
    }

    public void run() {
        this.f1802a.f1801a.f1612f.m1951m();
        this.f1802a.f1801a.m2581a(1000);
        C0330h.m2111a().m2112a(11);
        this.f1802a.f1801a.f1612f.m1938b().m2468a((Object) "Cancelled Call");
    }
}
