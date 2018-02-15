package net.client.by.lock.gui.p017a;

import java.util.Observable;
import java.util.Observer;

/* compiled from: MyApp */
class C0377b implements Observer {
    final /* synthetic */ C0376a f1588a;

    C0377b(C0376a c0376a) {
        this.f1588a = c0376a;
    }

    public void update(Observable observable, Object obj) {
        if (this.f1588a.f1576a != null) {
            this.f1588a.f1576a.post(new C0378c(this, obj));
        }
    }
}
