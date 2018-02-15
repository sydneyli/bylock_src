package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.p005a.C0051a;
import android.support.v4.view.p005a.C0059i;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: MyApp */
public class C0074a {
    private static final C0075d f311b;
    private static final Object f312c = f311b.mo80a();
    final Object f313a = f311b.mo81a(this);

    static {
        if (VERSION.SDK_INT >= 16) {
            f311b = new C0080e();
        } else if (VERSION.SDK_INT >= 14) {
            f311b = new C0077b();
        } else {
            f311b = new C0076g();
        }
    }

    Object m510a() {
        return this.f313a;
    }

    public void m511a(View view, int i) {
        f311b.mo82a(f312c, view, i);
    }

    public void m513a(View view, AccessibilityEvent accessibilityEvent) {
        f311b.mo89d(f312c, view, accessibilityEvent);
    }

    public boolean m516b(View view, AccessibilityEvent accessibilityEvent) {
        return f311b.mo85a(f312c, view, accessibilityEvent);
    }

    public void m517c(View view, AccessibilityEvent accessibilityEvent) {
        f311b.mo88c(f312c, view, accessibilityEvent);
    }

    public void mo93d(View view, AccessibilityEvent accessibilityEvent) {
        f311b.mo87b(f312c, view, accessibilityEvent);
    }

    public void mo91a(View view, C0051a c0051a) {
        f311b.mo83a(f312c, view, c0051a);
    }

    public boolean m515a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f311b.mo86a(f312c, viewGroup, view, accessibilityEvent);
    }

    public C0059i m509a(View view) {
        return f311b.mo79a(f312c, view);
    }

    public boolean mo92a(View view, int i, Bundle bundle) {
        return f311b.mo84a(f312c, view, i, bundle);
    }
}
