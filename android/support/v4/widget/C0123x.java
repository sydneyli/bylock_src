package android.support.v4.widget;

import android.support.v4.view.au;
import android.view.View;

/* compiled from: MyApp */
class C0123x implements Runnable {
    final View f441a;
    final /* synthetic */ SlidingPaneLayout f442b;

    C0123x(SlidingPaneLayout slidingPaneLayout, View view) {
        this.f442b = slidingPaneLayout;
        this.f441a = view;
    }

    public void run() {
        if (this.f441a.getParent() == this.f442b) {
            au.m580a(this.f441a, 0, null);
            this.f442b.m812d(this.f441a);
        }
        this.f442b.f388t.remove(this);
    }
}
