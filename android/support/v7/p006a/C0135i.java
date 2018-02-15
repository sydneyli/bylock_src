package android.support.v7.p006a;

import android.support.v7.internal.view.menu.C0174q;
import android.view.Menu;

/* compiled from: MyApp */
class C0135i implements Runnable {
    final /* synthetic */ C0134h f465a;

    C0135i(C0134h c0134h) {
        this.f465a = c0134h;
    }

    public void run() {
        C0174q a = this.f465a.m1055k();
        if (this.f465a.a.m1011a(0, (Menu) a) && this.f465a.a.m1013a(0, null, a)) {
            this.f465a.m1054c(a);
        } else {
            this.f465a.m1054c(null);
        }
        this.f465a.f463l = false;
    }
}
