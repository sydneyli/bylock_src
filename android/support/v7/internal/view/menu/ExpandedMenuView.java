package android.support.v7.internal.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/* compiled from: MyApp */
public final class ExpandedMenuView extends ListView implements ah, C0168s, OnItemClickListener {
    private C0174q f601a;
    private int f602b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
    }

    public void mo221a(C0174q c0174q) {
        this.f601a = c0174q;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public boolean mo223a(C0187u c0187u) {
        return this.f601a.m1336a((MenuItem) c0187u, 0);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo223a((C0187u) getAdapter().getItem(i));
    }

    public int getWindowAnimations() {
        return this.f602b;
    }
}
