package net.client.by.lock.p012d;

import java.util.Collections;
import java.util.Observable;
import java.util.Observer;
import net.client.by.lock.p016f.C0363h;

/* compiled from: MyApp */
class C0344i implements Observer {
    final /* synthetic */ C0343h f1504a;

    private C0344i(C0343h c0343h) {
        this.f1504a = c0343h;
    }

    public void update(Observable observable, Object obj) {
        C0363h c0363h = (C0363h) observable;
        boolean booleanValue = ((Boolean) c0363h.m2467a()).booleanValue();
        if (c0363h.m2470b() == null) {
            Collections.sort(this.f1504a.m2306e(), this.f1504a.f1503e);
        } else if (((Boolean) c0363h.m2470b()).booleanValue() != booleanValue) {
            if (booleanValue) {
                this.f1504a.f1500b.m2468a(Integer.valueOf(((Integer) this.f1504a.f1500b.m2467a()).intValue() + 1));
            } else {
                this.f1504a.f1500b.m2468a(Integer.valueOf(((Integer) this.f1504a.f1500b.m2467a()).intValue() - 1));
            }
            Collections.sort(this.f1504a.m2306e(), this.f1504a.f1503e);
        }
    }
}
