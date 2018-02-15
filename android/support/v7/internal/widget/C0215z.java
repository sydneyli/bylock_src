package android.support.v7.internal.widget;

import android.database.DataSetObserver;

/* compiled from: MyApp */
class C0215z extends DataSetObserver {
    final /* synthetic */ C0194u f976a;

    private C0215z(C0194u c0194u) {
        this.f976a = c0194u;
    }

    public void onChanged() {
        if (this.f976a.m1580f()) {
            this.f976a.mo267c();
        }
    }

    public void onInvalidated() {
        this.f976a.m1575d();
    }
}
