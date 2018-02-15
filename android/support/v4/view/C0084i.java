package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: MyApp */
final class C0084i extends AccessibilityDelegate {
    final /* synthetic */ C0078j f337a;

    C0084i(C0078j c0078j) {
        this.f337a = c0078j;
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.f337a.mo98a(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f337a.mo100b(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f337a.mo97a(view, (Object) accessibilityNodeInfo);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f337a.mo101c(view, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f337a.mo99a(viewGroup, view, accessibilityEvent);
    }

    public void sendAccessibilityEvent(View view, int i) {
        this.f337a.mo96a(view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.f337a.mo102d(view, accessibilityEvent);
    }
}
