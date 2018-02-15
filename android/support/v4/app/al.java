package android.support.v4.app;

import android.os.Build.VERSION;

/* compiled from: MyApp */
public class al {
    private static final ar f117a;

    static {
        if (VERSION.SDK_INT >= 16) {
            f117a = new av();
        } else if (VERSION.SDK_INT >= 14) {
            f117a = new au();
        } else if (VERSION.SDK_INT >= 11) {
            f117a = new at();
        } else {
            f117a = new as();
        }
    }
}
