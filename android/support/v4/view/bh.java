package android.support.v4.view;

import android.view.View;

/* compiled from: MyApp */
class bh {
    public static void m671a(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void m673a(View view, int i, int i2, int i3, int i4) {
        view.postInvalidate(i, i2, i3, i4);
    }

    public static void m674a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static int m675b(View view) {
        return view.getImportantForAccessibility();
    }

    public static void m672a(View view, int i) {
        view.setImportantForAccessibility(i);
    }
}
