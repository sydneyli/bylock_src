package android.support.v7.internal.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: MyApp */
class C0208p implements OnItemClickListener {
    final /* synthetic */ C0191l f967a;
    private final C0193o f968b;

    public C0208p(C0191l c0191l, C0193o c0193o) {
        this.f967a = c0191l;
        this.f968b = c0193o;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f968b.mo259a(this.f967a, view, i, j);
    }
}
