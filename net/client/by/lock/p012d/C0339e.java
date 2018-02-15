package net.client.by.lock.p012d;

import java.util.Observable;
import java.util.Observer;

/* compiled from: MyApp */
class C0339e implements Observer {
    final /* synthetic */ C0337c f1489a;

    private C0339e(C0337c c0337c) {
        this.f1489a = c0337c;
    }

    public void update(Observable observable, Object obj) {
        if (((Integer) this.f1489a.f1473j.m2470b()).intValue() == 0 && ((Integer) this.f1489a.f1473j.m2467a()).intValue() != 0) {
            this.f1489a.f1479p.m2468a(Boolean.valueOf(true));
        } else if (((Integer) this.f1489a.f1473j.m2470b()).intValue() != 0 && ((Integer) this.f1489a.f1473j.m2467a()).intValue() == 0) {
            this.f1489a.f1479p.m2468a(Boolean.valueOf(false));
        }
    }
}
