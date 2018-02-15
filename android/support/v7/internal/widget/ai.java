package android.support.v7.internal.widget;

import android.support.v7.internal.widget.ScrollingTabContainerView.TabView;
import android.support.v7.p006a.C0130e;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/* compiled from: MyApp */
class ai extends BaseAdapter {
    final /* synthetic */ ScrollingTabContainerView f909a;

    private ai(ScrollingTabContainerView scrollingTabContainerView) {
        this.f909a = scrollingTabContainerView;
    }

    public int getCount() {
        return this.f909a.f894e.getChildCount();
    }

    public Object getItem(int i) {
        return ((TabView) this.f909a.f894e.getChildAt(i)).getTab();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            return this.f909a.m1526a((C0130e) getItem(i), true);
        }
        ((TabView) view).m1523a((C0130e) getItem(i));
        return view;
    }
}
