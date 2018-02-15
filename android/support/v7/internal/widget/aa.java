package android.support.v7.internal.widget;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

/* compiled from: MyApp */
class aa implements OnScrollListener {
    final /* synthetic */ C0194u f900a;

    private aa(C0194u c0194u) {
        this.f900a = c0194u;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1 && !this.f900a.m1582g() && this.f900a.f925c.getContentView() != null) {
            this.f900a.f947y.removeCallbacks(this.f900a.f942t);
            this.f900a.f942t.run();
        }
    }
}
