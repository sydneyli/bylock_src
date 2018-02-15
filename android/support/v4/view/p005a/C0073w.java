package android.support.v4.view.p005a;

import android.view.accessibility.AccessibilityRecord;

/* compiled from: MyApp */
class C0073w {
    public static Object m504a() {
        return AccessibilityRecord.obtain();
    }

    public static void m505a(Object obj, int i) {
        ((AccessibilityRecord) obj).setFromIndex(i);
    }

    public static void m507b(Object obj, int i) {
        ((AccessibilityRecord) obj).setItemCount(i);
    }

    public static void m506a(Object obj, boolean z) {
        ((AccessibilityRecord) obj).setScrollable(z);
    }

    public static void m508c(Object obj, int i) {
        ((AccessibilityRecord) obj).setToIndex(i);
    }
}
