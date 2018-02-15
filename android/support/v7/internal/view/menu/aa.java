package android.support.v7.internal.view.menu;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

/* compiled from: MyApp */
class aa extends C0170n implements OnMenuItemClickListener {
    final /* synthetic */ C0172w f632b;

    aa(C0172w c0172w, OnMenuItemClickListener onMenuItemClickListener) {
        this.f632b = c0172w;
        super(onMenuItemClickListener);
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        return ((OnMenuItemClickListener) this.a).onMenuItemClick(this.f632b.m1277a(menuItem));
    }
}
