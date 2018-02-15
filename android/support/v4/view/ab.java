package android.support.v4.view;

import android.view.KeyEvent;

/* compiled from: MyApp */
class ab {
    public static int m520a(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    public static boolean m521a(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    public static boolean m522b(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
