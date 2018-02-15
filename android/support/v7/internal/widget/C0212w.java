package android.support.v7.internal.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

/* compiled from: MyApp */
class C0212w implements OnItemSelectedListener {
    final /* synthetic */ C0194u f972a;

    C0212w(C0194u c0194u) {
        this.f972a = c0194u;
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        if (i != -1) {
            C0213x a = this.f972a.f927e;
            if (a != null) {
                a.f973a = false;
            }
        }
    }

    public void onNothingSelected(AdapterView adapterView) {
    }
}
