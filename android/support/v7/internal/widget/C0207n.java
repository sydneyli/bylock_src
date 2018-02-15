package android.support.v7.internal.widget;

import android.database.DataSetObserver;
import android.os.Parcelable;

/* compiled from: MyApp */
class C0207n extends DataSetObserver {
    final /* synthetic */ C0191l f965a;
    private Parcelable f966b = null;

    C0207n(C0191l c0191l) {
        this.f965a = c0191l;
    }

    public void onChanged() {
        this.f965a.f763u = true;
        this.f965a.f744A = this.f965a.f768z;
        this.f965a.f768z = this.f965a.mo244e().getCount();
        if (!this.f965a.mo244e().hasStableIds() || this.f966b == null || this.f965a.f744A != 0 || this.f965a.f768z <= 0) {
            this.f965a.m1443n();
        } else {
            this.f965a.onRestoreInstanceState(this.f966b);
            this.f966b = null;
        }
        this.f965a.m1438i();
        this.f965a.requestLayout();
    }

    public void onInvalidated() {
        this.f965a.f763u = true;
        if (this.f965a.mo244e().hasStableIds()) {
            this.f966b = this.f965a.onSaveInstanceState();
        }
        this.f965a.f744A = this.f965a.f768z;
        this.f965a.f768z = 0;
        this.f965a.f766x = -1;
        this.f965a.f767y = Long.MIN_VALUE;
        this.f965a.f764v = -1;
        this.f965a.f765w = Long.MIN_VALUE;
        this.f965a.f758p = false;
        this.f965a.m1438i();
        this.f965a.requestLayout();
    }
}
