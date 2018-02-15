package android.support.v4.view;

import android.support.v4.view.p005a.C0051a;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: MyApp */
class C0079c implements C0078j {
    final /* synthetic */ C0074a f333a;
    final /* synthetic */ C0077b f334b;

    C0079c(C0077b c0077b, C0074a c0074a) {
        this.f334b = c0077b;
        this.f333a = c0074a;
    }

    public boolean mo98a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f333a.m516b(view, accessibilityEvent);
    }

    public void mo100b(View view, AccessibilityEvent accessibilityEvent) {
        this.f333a.mo93d(view, accessibilityEvent);
    }

    public void mo97a(View view, Object obj) {
        this.f333a.mo91a(view, new C0051a(obj));
    }

    public void mo101c(View view, AccessibilityEvent accessibilityEvent) {
        this.f333a.m517c(view, accessibilityEvent);
    }

    public boolean mo99a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f333a.m515a(viewGroup, view, accessibilityEvent);
    }

    public void mo96a(View view, int i) {
        this.f333a.m511a(view, i);
    }

    public void mo102d(View view, AccessibilityEvent accessibilityEvent) {
        this.f333a.m513a(view, accessibilityEvent);
    }
}
