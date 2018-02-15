package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

/* compiled from: MyApp */
public class bj {
    static final bm f318a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f318a = new bl();
        } else {
            f318a = new bk();
        }
    }

    public static int m678a(ViewConfiguration viewConfiguration) {
        return f318a.mo90a(viewConfiguration);
    }
}
