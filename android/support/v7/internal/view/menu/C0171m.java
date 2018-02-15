package android.support.v7.internal.view.menu;

import android.support.v4.p001b.p002a.C0041b;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: MyApp */
abstract class C0171m extends C0170n {
    private HashMap f633b;
    private HashMap f634c;

    C0171m(Object obj) {
        super(obj);
    }

    final C0041b m1277a(MenuItem menuItem) {
        if (menuItem == null) {
            return null;
        }
        if (this.f633b == null) {
            this.f633b = new HashMap();
        }
        C0041b c0041b = (C0041b) this.f633b.get(menuItem);
        if (c0041b != null) {
            return c0041b;
        }
        c0041b = aj.m1313b(menuItem);
        this.f633b.put(menuItem, c0041b);
        return c0041b;
    }

    final SubMenu m1278a(SubMenu subMenu) {
        if (subMenu == null) {
            return null;
        }
        if (this.f634c == null) {
            this.f634c = new HashMap();
        }
        SubMenu subMenu2 = (SubMenu) this.f634c.get(subMenu);
        if (subMenu2 != null) {
            return subMenu2;
        }
        subMenu2 = aj.m1310a(subMenu);
        this.f634c.put(subMenu, subMenu2);
        return subMenu2;
    }

    final void m1279a() {
        if (this.f633b != null) {
            this.f633b.clear();
        }
        if (this.f634c != null) {
            this.f634c.clear();
        }
    }

    final void m1280a(int i) {
        if (this.f633b != null) {
            Iterator it = this.f633b.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    final void m1281b(int i) {
        if (this.f633b != null) {
            Iterator it = this.f633b.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
