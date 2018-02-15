package net.client.by.lock.p011a;

import java.util.Observable;
import java.util.Observer;
import net.client.by.lock.p016f.C0363h;

/* compiled from: MyApp */
class C0290d implements Observer {
    final /* synthetic */ C0289c f1261a;

    private C0290d(C0289c c0289c) {
        this.f1261a = c0289c;
    }

    public void update(Observable observable, Object obj) {
        if ((obj instanceof String) && obj.equals("online") && !((Boolean) ((C0363h) observable).m2467a()).booleanValue()) {
            this.f1261a.m1958t();
        }
    }
}
