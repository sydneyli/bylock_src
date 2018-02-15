package android.support.v4.widget;

import android.database.DataSetObserver;

/* compiled from: MyApp */
class C0104d extends DataSetObserver {
    final /* synthetic */ C0101a f424a;

    private C0104d(C0101a c0101a) {
        this.f424a = c0101a;
    }

    public void onChanged() {
        this.f424a.f389a = true;
        this.f424a.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.f424a.f389a = false;
        this.f424a.notifyDataSetInvalidated();
    }
}
