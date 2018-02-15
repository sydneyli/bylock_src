package android.support.v7.internal.widget;

import android.util.SparseArray;
import android.view.View;

/* compiled from: MyApp */
class C0197d {
    final /* synthetic */ AbsSpinnerICS f955a;
    private final SparseArray f956b = new SparseArray();

    C0197d(AbsSpinnerICS absSpinnerICS) {
        this.f955a = absSpinnerICS;
    }

    public void m1591a(int i, View view) {
        this.f956b.put(i, view);
    }

    View m1589a(int i) {
        View view = (View) this.f956b.get(i);
        if (view != null) {
            this.f956b.delete(i);
        }
        return view;
    }

    void m1590a() {
        SparseArray sparseArray = this.f956b;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View view = (View) sparseArray.valueAt(i);
            if (view != null) {
                this.f955a.removeDetachedView(view, true);
            }
        }
        sparseArray.clear();
    }
}
