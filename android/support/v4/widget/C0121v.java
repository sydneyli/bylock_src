package android.support.v4.widget;

import android.widget.OverScroller;

/* compiled from: MyApp */
class C0121v {
    public static boolean m980a(Object obj) {
        return ((OverScroller) obj).isFinished();
    }

    public static int m981b(Object obj) {
        return ((OverScroller) obj).getCurrX();
    }

    public static int m982c(Object obj) {
        return ((OverScroller) obj).getCurrY();
    }

    public static boolean m983d(Object obj) {
        return ((OverScroller) obj).computeScrollOffset();
    }

    public static void m979a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((OverScroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    public static void m984e(Object obj) {
        ((OverScroller) obj).abortAnimation();
    }

    public static int m985f(Object obj) {
        return ((OverScroller) obj).getFinalX();
    }

    public static int m986g(Object obj) {
        return ((OverScroller) obj).getFinalY();
    }
}
