package net.client.by.lock.gui.activity;

import android.app.Activity;
import android.support.v4.app.C0029p;
import android.support.v4.app.C0035v;
import android.support.v4.app.Fragment;
import android.view.inputmethod.InputMethodManager;

/* compiled from: MyApp */
public class ad extends C0035v {
    private static InputMethodManager f1719a;
    private static Activity f1720b = null;

    public ad(C0029p c0029p, InputMethodManager inputMethodManager) {
        super(c0029p);
        f1719a = inputMethodManager;
    }

    public Fragment mo345a(int i) {
        switch (i) {
            case 0:
                return new ar();
            case 1:
                return new aw();
            case 2:
                return new am();
            case 3:
                return new ah();
            case 4:
                return new ae();
            default:
                return new am();
        }
    }

    public int mo346b() {
        return 5;
    }
}
