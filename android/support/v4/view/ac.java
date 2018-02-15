package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.p001b.p002a.C0041b;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* compiled from: MyApp */
public class ac {
    static final ag f314a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 14) {
            f314a = new af();
        } else if (i >= 11) {
            f314a = new ae();
        } else {
            f314a = new ad();
        }
    }

    public static void m525a(MenuItem menuItem, int i) {
        if (menuItem instanceof C0041b) {
            ((C0041b) menuItem).setShowAsAction(i);
        } else {
            f314a.mo56a(menuItem, i);
        }
    }

    public static MenuItem m524a(MenuItem menuItem, View view) {
        if (menuItem instanceof C0041b) {
            return ((C0041b) menuItem).setActionView(view);
        }
        return f314a.mo55a(menuItem, view);
    }

    public static MenuItem m526b(MenuItem menuItem, int i) {
        if (menuItem instanceof C0041b) {
            return ((C0041b) menuItem).setActionView(i);
        }
        return f314a.mo57b(menuItem, i);
    }

    public static MenuItem m523a(MenuItem menuItem, C0087n c0087n) {
        if (menuItem instanceof C0041b) {
            return ((C0041b) menuItem).mo224a(c0087n);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }
}
