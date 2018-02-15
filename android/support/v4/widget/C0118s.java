package android.support.v4.widget;

import android.widget.Scroller;

/* compiled from: MyApp */
class C0118s implements C0117r {
    C0118s() {
    }

    public boolean mo146a(Object obj) {
        return ((Scroller) obj).isFinished();
    }

    public int mo147b(Object obj) {
        return ((Scroller) obj).getCurrX();
    }

    public int mo148c(Object obj) {
        return ((Scroller) obj).getCurrY();
    }

    public boolean mo149d(Object obj) {
        return ((Scroller) obj).computeScrollOffset();
    }

    public void mo145a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    public void mo150e(Object obj) {
        ((Scroller) obj).abortAnimation();
    }

    public int mo151f(Object obj) {
        return ((Scroller) obj).getFinalX();
    }

    public int mo152g(Object obj) {
        return ((Scroller) obj).getFinalY();
    }
}
