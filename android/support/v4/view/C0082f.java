package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.p005a.C0051a;
import android.support.v4.view.p005a.C0059i;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: MyApp */
class C0082f implements C0081m {
    final /* synthetic */ C0074a f335a;
    final /* synthetic */ C0080e f336b;

    C0082f(C0080e c0080e, C0074a c0074a) {
        this.f336b = c0080e;
        this.f335a = c0074a;
    }

    public boolean mo110a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f335a.m516b(view, accessibilityEvent);
    }

    public void mo112b(View view, AccessibilityEvent accessibilityEvent) {
        this.f335a.mo93d(view, accessibilityEvent);
    }

    public void mo108a(View view, Object obj) {
        this.f335a.mo91a(view, new C0051a(obj));
    }

    public void mo113c(View view, AccessibilityEvent accessibilityEvent) {
        this.f335a.m517c(view, accessibilityEvent);
    }

    public boolean mo111a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f335a.m515a(viewGroup, view, accessibilityEvent);
    }

    public void mo107a(View view, int i) {
        this.f335a.m511a(view, i);
    }

    public void mo114d(View view, AccessibilityEvent accessibilityEvent) {
        this.f335a.m513a(view, accessibilityEvent);
    }

    public Object mo106a(View view) {
        C0059i a = this.f335a.m509a(view);
        return a != null ? a.m471a() : null;
    }

    public boolean mo109a(View view, int i, Bundle bundle) {
        return this.f335a.mo92a(view, i, bundle);
    }
}
