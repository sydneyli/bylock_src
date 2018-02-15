package android.support.v7.internal.widget;

import android.view.View;

/* compiled from: MyApp */
class C0211v implements Runnable {
    final /* synthetic */ C0194u f971a;

    C0211v(C0194u c0194u) {
        this.f971a = c0194u;
    }

    public void run() {
        View b = this.f971a.m1571b();
        if (b != null && b.getWindowToken() != null) {
            this.f971a.mo267c();
        }
    }
}
