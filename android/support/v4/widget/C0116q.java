package android.support.v4.widget;

import android.os.Build.VERSION;

/* compiled from: MyApp */
public class C0116q {
    static final C0117r f439b;
    Object f440a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 14) {
            f439b = new C0120u();
        } else if (i >= 9) {
            f439b = new C0119t();
        } else {
            f439b = new C0118s();
        }
    }

    public boolean m948a() {
        return f439b.mo146a(this.f440a);
    }

    public int m949b() {
        return f439b.mo147b(this.f440a);
    }

    public int m950c() {
        return f439b.mo148c(this.f440a);
    }

    public int m951d() {
        return f439b.mo151f(this.f440a);
    }

    public int m952e() {
        return f439b.mo152g(this.f440a);
    }

    public boolean m953f() {
        return f439b.mo149d(this.f440a);
    }

    public void m947a(int i, int i2, int i3, int i4, int i5) {
        f439b.mo145a(this.f440a, i, i2, i3, i4, i5);
    }

    public void m954g() {
        f439b.mo150e(this.f440a);
    }
}
