package net.client.by.lock.p012d;

import java.util.Observable;
import java.util.Observer;
import net.client.by.lock.p016f.C0363h;

/* compiled from: MyApp */
class C0338d implements Observer {
    final /* synthetic */ C0337c f1488a;

    private C0338d(C0337c c0337c) {
        this.f1488a = c0337c;
    }

    public void update(Observable observable, Object obj) {
        C0363h d = this.f1488a.f1486w;
        boolean z = ((Integer) this.f1488a.f1474k.m2467a()).intValue() > 0 || ((Boolean) this.f1488a.f1475l.m2467a()).booleanValue() || ((Boolean) this.f1488a.f1476m.m2467a()).booleanValue() || ((Boolean) this.f1488a.f1477n.m2467a()).booleanValue();
        d.m2468a(Boolean.valueOf(z));
    }
}
