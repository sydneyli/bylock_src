package android.support.v7.internal.view.menu;

import android.os.Build.VERSION;
import android.support.v4.p001b.p002a.C0041b;
import android.support.v4.p001b.p002a.C0042c;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* compiled from: MyApp */
public final class aj {
    public static Menu m1311a(Menu menu) {
        if (VERSION.SDK_INT >= 14) {
            return new ak(menu);
        }
        return menu;
    }

    public static MenuItem m1312a(MenuItem menuItem) {
        if (VERSION.SDK_INT >= 16) {
            return new ab(menuItem);
        }
        if (VERSION.SDK_INT >= 14) {
            return new C0172w(menuItem);
        }
        return menuItem;
    }

    public static C0042c m1310a(SubMenu subMenu) {
        if (VERSION.SDK_INT >= 14) {
            return new am(subMenu);
        }
        throw new UnsupportedOperationException();
    }

    public static C0041b m1313b(MenuItem menuItem) {
        if (VERSION.SDK_INT >= 16) {
            return new ab(menuItem);
        }
        if (VERSION.SDK_INT >= 14) {
            return new C0172w(menuItem);
        }
        throw new UnsupportedOperationException();
    }
}
