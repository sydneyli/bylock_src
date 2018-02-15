package android.support.v4.view;

import android.view.MenuItem;
import android.view.View;

/* compiled from: MyApp */
class ai {
    public static void m539a(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }

    public static MenuItem m538a(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static MenuItem m540b(MenuItem menuItem, int i) {
        return menuItem.setActionView(i);
    }
}
