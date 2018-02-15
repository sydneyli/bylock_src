package android.support.v4.view.p005a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: MyApp */
final class C0066o extends AccessibilityNodeProvider {
    final /* synthetic */ C0063p f308a;

    C0066o(C0063p c0063p) {
        this.f308a = c0063p;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.f308a.mo47a(i);
    }

    public List findAccessibilityNodeInfosByText(String str, int i) {
        return this.f308a.mo48a(str, i);
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.f308a.mo49a(i, i2, bundle);
    }
}
