package android.support.v7.internal.widget;

import android.support.v7.internal.widget.ScrollingTabContainerView.TabView;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MyApp */
class aj implements OnClickListener {
    final /* synthetic */ ScrollingTabContainerView f910a;

    private aj(ScrollingTabContainerView scrollingTabContainerView) {
        this.f910a = scrollingTabContainerView;
    }

    public void onClick(View view) {
        ((TabView) view).getTab().m1002d();
        int childCount = this.f910a.f894e.getChildCount();
        for (int i = 0; i < childCount; i++) {
            boolean z;
            View childAt = this.f910a.f894e.getChildAt(i);
            if (childAt == view) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
        }
    }
}
