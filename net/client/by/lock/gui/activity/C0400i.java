package net.client.by.lock.gui.activity;

import net.client.by.lock.p014c.C0330h;

/* compiled from: MyApp */
class C0400i implements Runnable {
    final /* synthetic */ C0399h f1810a;
    private final /* synthetic */ String f1811b;

    C0400i(C0399h c0399h, String str) {
        this.f1810a = c0399h;
        this.f1811b = str;
    }

    public void run() {
        this.f1810a.f1806a.m1956r();
        this.f1810a.f1808c.m2581a(1000);
        C0330h.m2111a().m2112a(11);
        this.f1810a.f1806a.m1938b().m2468a(this.f1811b);
    }
}
