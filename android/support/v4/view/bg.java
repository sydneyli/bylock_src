package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;

/* compiled from: MyApp */
class bg {
    public static boolean m670a(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public static void m669a(View view, Object obj) {
        view.setAccessibilityDelegate((AccessibilityDelegate) obj);
    }
}
