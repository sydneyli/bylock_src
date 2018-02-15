package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

/* compiled from: MyApp */
final class C0086l extends AccessibilityDelegate {
    final /* synthetic */ C0081m f338a;

    C0086l(C0081m c0081m) {
        this.f338a = c0081m;
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.f338a.mo110a(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f338a.mo112b(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f338a.mo108a(view, (Object) accessibilityNodeInfo);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f338a.mo113c(view, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f338a.mo111a(viewGroup, view, accessibilityEvent);
    }

    public void sendAccessibilityEvent(View view, int i) {
        this.f338a.mo107a(view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.f338a.mo114d(view, accessibilityEvent);
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        return (AccessibilityNodeProvider) this.f338a.mo106a(view);
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return this.f338a.mo109a(view, i, bundle);
    }
}
