package android.support.v7.internal.widget;

import android.view.View;

/* compiled from: MyApp */
class ah implements Runnable {
    final /* synthetic */ View f907a;
    final /* synthetic */ ScrollingTabContainerView f908b;

    ah(ScrollingTabContainerView scrollingTabContainerView, View view) {
        this.f908b = scrollingTabContainerView;
        this.f907a = view;
    }

    public void run() {
        this.f908b.smoothScrollTo(this.f907a.getLeft() - ((this.f908b.getWidth() - this.f907a.getWidth()) / 2), 0);
        this.f908b.f890a = null;
    }
}
