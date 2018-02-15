package android.support.v4.view.p005a;

import android.graphics.Rect;
import android.os.Build.VERSION;

/* compiled from: MyApp */
public class C0051a {
    private static final C0052c f302a;
    private final Object f303b;

    static {
        if ("JellyBeanMR2".equals(VERSION.CODENAME)) {
            f302a = new C0056e();
        } else if (VERSION.SDK_INT >= 16) {
            f302a = new C0055d();
        } else if (VERSION.SDK_INT >= 14) {
            f302a = new C0054b();
        } else {
            f302a = new C0053f();
        }
    }

    public C0051a(Object obj) {
        this.f303b = obj;
    }

    public Object m364a() {
        return this.f303b;
    }

    public int m369b() {
        return f302a.mo25a(this.f303b);
    }

    public void m365a(int i) {
        f302a.mo26a(this.f303b, i);
    }

    public void m366a(Rect rect) {
        f302a.mo27a(this.f303b, rect);
    }

    public void m370b(Rect rect) {
        f302a.mo31b(this.f303b, rect);
    }

    public boolean m371c() {
        return f302a.mo35f(this.f303b);
    }

    public boolean m372d() {
        return f302a.mo36g(this.f303b);
    }

    public boolean m373e() {
        return f302a.mo39j(this.f303b);
    }

    public boolean m374f() {
        return f302a.mo40k(this.f303b);
    }

    public boolean m375g() {
        return f302a.mo44o(this.f303b);
    }

    public boolean m376h() {
        return f302a.mo37h(this.f303b);
    }

    public boolean m377i() {
        return f302a.mo41l(this.f303b);
    }

    public boolean m378j() {
        return f302a.mo38i(this.f303b);
    }

    public boolean m379k() {
        return f302a.mo42m(this.f303b);
    }

    public boolean m380l() {
        return f302a.mo43n(this.f303b);
    }

    public void m368a(boolean z) {
        f302a.mo29a(this.f303b, z);
    }

    public CharSequence m381m() {
        return f302a.mo33d(this.f303b);
    }

    public CharSequence m382n() {
        return f302a.mo30b(this.f303b);
    }

    public void m367a(CharSequence charSequence) {
        f302a.mo28a(this.f303b, charSequence);
    }

    public CharSequence m383o() {
        return f302a.mo34e(this.f303b);
    }

    public CharSequence m384p() {
        return f302a.mo32c(this.f303b);
    }

    public String m385q() {
        return f302a.mo45p(this.f303b);
    }

    public int hashCode() {
        return this.f303b == null ? 0 : this.f303b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0051a c0051a = (C0051a) obj;
        if (this.f303b == null) {
            if (c0051a.f303b != null) {
                return false;
            }
            return true;
        } else if (this.f303b.equals(c0051a.f303b)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        m366a(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        m370b(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(m381m());
        stringBuilder.append("; className: ").append(m382n());
        stringBuilder.append("; text: ").append(m383o());
        stringBuilder.append("; contentDescription: ").append(m384p());
        stringBuilder.append("; viewId: ").append(m385q());
        stringBuilder.append("; checkable: ").append(m371c());
        stringBuilder.append("; checked: ").append(m372d());
        stringBuilder.append("; focusable: ").append(m373e());
        stringBuilder.append("; focused: ").append(m374f());
        stringBuilder.append("; selected: ").append(m375g());
        stringBuilder.append("; clickable: ").append(m376h());
        stringBuilder.append("; longClickable: ").append(m377i());
        stringBuilder.append("; enabled: ").append(m378j());
        stringBuilder.append("; password: ").append(m379k());
        stringBuilder.append("; scrollable: " + m380l());
        stringBuilder.append("; [");
        int b = m369b();
        while (b != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b);
            b &= numberOfTrailingZeros ^ -1;
            stringBuilder.append(C0051a.m363b(numberOfTrailingZeros));
            if (b != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static String m363b(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }
}
