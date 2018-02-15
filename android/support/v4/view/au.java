package android.support.v4.view;

import android.graphics.Paint;
import android.os.Build.VERSION;
import android.view.View;

/* compiled from: MyApp */
public class au {
    static final bc f317a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            f317a = new bb();
        } else if (i >= 16) {
            f317a = new ba();
        } else if (i >= 14) {
            f317a = new az();
        } else if (i >= 11) {
            f317a = new ay();
        } else if (i >= 9) {
            f317a = new ax();
        } else {
            f317a = new av();
        }
    }

    public static boolean m584a(View view, int i) {
        return f317a.mo71a(view, i);
    }

    public static int m578a(View view) {
        return f317a.mo65a(view);
    }

    public static void m582a(View view, C0074a c0074a) {
        f317a.mo69a(view, c0074a);
    }

    public static void m585b(View view) {
        f317a.mo72b(view);
    }

    public static void m579a(View view, int i, int i2, int i3, int i4) {
        f317a.mo66a(view, i, i2, i3, i4);
    }

    public static void m583a(View view, Runnable runnable) {
        f317a.mo70a(view, runnable);
    }

    public static int m587c(View view) {
        return f317a.mo74c(view);
    }

    public static void m586b(View view, int i) {
        f317a.mo73b(view, i);
    }

    public static void m580a(View view, int i, Paint paint) {
        f317a.mo67a(view, i, paint);
    }

    public static int m588d(View view) {
        return f317a.mo75d(view);
    }

    public static void m581a(View view, Paint paint) {
        f317a.mo68a(view, paint);
    }

    public static int m589e(View view) {
        return f317a.mo76e(view);
    }

    public static boolean m590f(View view) {
        return f317a.mo77f(view);
    }
}
