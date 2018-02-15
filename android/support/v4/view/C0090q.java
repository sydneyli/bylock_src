package android.support.v4.view;

import android.os.Build.VERSION;

/* compiled from: MyApp */
public class C0090q {
    static final C0091r f342a;

    static {
        if (VERSION.SDK_INT >= 17) {
            f342a = new C0093t();
        } else {
            f342a = new C0092s();
        }
    }

    public static int m760a(int i, int i2) {
        return f342a.mo115a(i, i2);
    }
}
