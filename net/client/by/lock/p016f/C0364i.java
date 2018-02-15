package net.client.by.lock.p016f;

import java.util.Observable;
import java.util.Observer;

/* compiled from: MyApp */
class C0364i implements Observer {
    final /* synthetic */ C0363h f1560a;

    private C0364i(C0363h c0363h) {
        this.f1560a = c0363h;
    }

    public void update(Observable observable, Object obj) {
        this.f1560a.m2468a(((C0363h) observable).m2467a());
    }
}
