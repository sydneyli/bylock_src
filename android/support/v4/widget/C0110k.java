package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

/* compiled from: MyApp */
public class C0110k {
    private static final C0111n f434b;
    private Object f435a;

    static {
        if (VERSION.SDK_INT >= 14) {
            f434b = new C0113m();
        } else {
            f434b = new C0112l();
        }
    }

    public C0110k(Context context) {
        this.f435a = f434b.mo136a(context);
    }

    public void m911a(int i, int i2) {
        f434b.mo137a(this.f435a, i, i2);
    }

    public boolean m912a() {
        return f434b.mo138a(this.f435a);
    }

    public void m915b() {
        f434b.mo141b(this.f435a);
    }

    public boolean m913a(float f) {
        return f434b.mo139a(this.f435a, f);
    }

    public boolean m916c() {
        return f434b.mo142c(this.f435a);
    }

    public boolean m914a(Canvas canvas) {
        return f434b.mo140a(this.f435a, canvas);
    }
}
