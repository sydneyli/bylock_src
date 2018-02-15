package android.support.v4.view.p005a;

import android.os.Build.VERSION;

/* compiled from: MyApp */
public class C0067q {
    private static final C0068t f309a;
    private final Object f310b;

    static {
        if (VERSION.SDK_INT >= 16) {
            f309a = new C0072u();
        } else if (VERSION.SDK_INT >= 15) {
            f309a = new C0071s();
        } else if (VERSION.SDK_INT >= 14) {
            f309a = new C0070r();
        } else {
            f309a = new C0069v();
        }
    }

    public C0067q(Object obj) {
        this.f310b = obj;
    }

    public static C0067q m484a() {
        return new C0067q(f309a.mo50a());
    }

    public void m486a(boolean z) {
        f309a.mo52a(this.f310b, z);
    }

    public void m485a(int i) {
        f309a.mo53b(this.f310b, i);
    }

    public void m487b(int i) {
        f309a.mo51a(this.f310b, i);
    }

    public void m488c(int i) {
        f309a.mo54c(this.f310b, i);
    }

    public int hashCode() {
        return this.f310b == null ? 0 : this.f310b.hashCode();
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
        C0067q c0067q = (C0067q) obj;
        if (this.f310b == null) {
            if (c0067q.f310b != null) {
                return false;
            }
            return true;
        } else if (this.f310b.equals(c0067q.f310b)) {
            return true;
        } else {
            return false;
        }
    }
}
