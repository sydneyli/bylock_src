package net.client.by.lock.gui.activity;

import java.util.Observable;
import net.client.by.lock.p016f.C0363h;

/* compiled from: MyApp */
class C0398g implements Runnable {
    final /* synthetic */ CallActivity f1804a;
    private final /* synthetic */ Observable f1805b;

    C0398g(CallActivity callActivity, Observable observable) {
        this.f1804a = callActivity;
        this.f1805b = observable;
    }

    public void run() {
        this.f1804a.m2588a(((C0363h) this.f1805b).m2467a());
    }
}
