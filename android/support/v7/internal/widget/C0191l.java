package android.support.v7.internal.widget;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;

/* compiled from: MyApp */
abstract class C0191l extends ViewGroup {
    int f744A;
    int f745B = -1;
    long f746C = Long.MIN_VALUE;
    boolean f747D = false;
    private int f748a;
    private View f749b;
    private boolean f750c;
    private boolean f751d;
    private C0209r f752e;
    @ExportedProperty(category = "scrolling")
    int f753k = 0;
    int f754l;
    int f755m;
    long f756n = Long.MIN_VALUE;
    long f757o;
    boolean f758p = false;
    int f759q;
    boolean f760r = false;
    C0200q f761s;
    C0193o f762t;
    boolean f763u;
    @ExportedProperty(category = "list")
    int f764v = -1;
    long f765w = Long.MIN_VALUE;
    @ExportedProperty(category = "list")
    int f766x = -1;
    long f767y = Long.MIN_VALUE;
    @ExportedProperty(category = "list")
    int f768z;

    public abstract View mo243c();

    public abstract Adapter mo244e();

    C0191l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void mo260a(C0193o c0193o) {
        this.f762t = c0193o;
    }

    public boolean m1429a(View view, int i, long j) {
        if (this.f762t == null) {
            return false;
        }
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        this.f762t.mo259a(this, view, i, j);
        return true;
    }

    public void m1428a(C0200q c0200q) {
        this.f761s = c0200q;
    }

    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    public void addView(View view, int i) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    public void addView(View view, LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    public void removeView(View view) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    public void removeViewAt(int i) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f748a = getHeight();
    }

    @CapturedViewProperty
    public int m1435f() {
        return this.f764v;
    }

    @CapturedViewProperty
    public long m1436g() {
        return this.f765w;
    }

    boolean m1437h() {
        return false;
    }

    public void setFocusable(boolean z) {
        boolean z2 = true;
        Adapter e = mo244e();
        boolean z3 = e == null || e.getCount() == 0;
        this.f750c = z;
        if (!z) {
            this.f751d = false;
        }
        if (!z || (z3 && !m1437h())) {
            z2 = false;
        }
        super.setFocusable(z2);
    }

    public void setFocusableInTouchMode(boolean z) {
        boolean z2 = true;
        Adapter e = mo244e();
        boolean z3 = e == null || e.getCount() == 0;
        this.f751d = z;
        if (z) {
            this.f750c = true;
        }
        if (!z || (z3 && !m1437h())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    void m1438i() {
        boolean z;
        boolean z2 = false;
        Adapter e = mo244e();
        boolean z3 = e == null || e.getCount() == 0;
        if (!z3 || m1437h()) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.f751d) {
            z3 = true;
        } else {
            z3 = false;
        }
        super.setFocusableInTouchMode(z3);
        if (z && this.f750c) {
            z3 = true;
        } else {
            z3 = false;
        }
        super.setFocusable(z3);
        if (this.f749b != null) {
            if (e == null || e.isEmpty()) {
                z2 = true;
            }
            m1424a(z2);
        }
    }

    private void m1424a(boolean z) {
        if (m1437h()) {
            z = false;
        }
        if (z) {
            if (this.f749b != null) {
                this.f749b.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.f763u) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        if (this.f749b != null) {
            this.f749b.setVisibility(8);
        }
        setVisibility(0);
    }

    public long m1430b(int i) {
        Adapter e = mo244e();
        return (e == null || i < 0) ? Long.MIN_VALUE : e.getItemId(i);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    protected void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f752e);
    }

    void m1439j() {
        if (this.f761s != null) {
            if (this.f760r || this.f747D) {
                if (this.f752e == null) {
                    this.f752e = new C0209r();
                }
                post(this.f752e);
            } else {
                mo242a();
            }
        }
        if (this.f766x != -1 && isShown() && !isInTouchMode()) {
            sendAccessibilityEvent(4);
        }
    }

    private void mo242a() {
        if (this.f761s != null) {
            int f = m1435f();
            if (f >= 0) {
                View c = mo243c();
                this.f761s.mo271a(this, c, f, mo244e().getItemId(f));
                return;
            }
            this.f761s.mo270a(this);
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        View c = mo243c();
        if (c != null && c.getVisibility() == 0 && c.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
            return true;
        }
        return false;
    }

    protected boolean canAnimate() {
        return super.canAnimate() && this.f768z > 0;
    }

    void m1440k() {
        boolean z;
        int i = this.f768z;
        if (i > 0) {
            int m;
            boolean z2;
            if (this.f758p) {
                this.f758p = false;
                m = m1442m();
                if (m >= 0 && m1426a(m, true) == m) {
                    m1433d(m);
                    z2 = true;
                    if (!z2) {
                        m = m1435f();
                        if (m >= i) {
                            m = i - 1;
                        }
                        if (m < 0) {
                            m = 0;
                        }
                        i = m1426a(m, true);
                        if (i >= 0) {
                            m = m1426a(m, false);
                        } else {
                            m = i;
                        }
                        if (m >= 0) {
                            m1433d(m);
                            m1441l();
                            z = true;
                        }
                    }
                    z = z2;
                }
            }
            z2 = false;
            if (z2) {
                m = m1435f();
                if (m >= i) {
                    m = i - 1;
                }
                if (m < 0) {
                    m = 0;
                }
                i = m1426a(m, true);
                if (i >= 0) {
                    m = i;
                } else {
                    m = m1426a(m, false);
                }
                if (m >= 0) {
                    m1433d(m);
                    m1441l();
                    z = true;
                }
            }
            z = z2;
        } else {
            z = false;
        }
        if (!z) {
            this.f766x = -1;
            this.f767y = Long.MIN_VALUE;
            this.f764v = -1;
            this.f765w = Long.MIN_VALUE;
            this.f758p = false;
            m1441l();
        }
    }

    void m1441l() {
        if (this.f766x != this.f745B || this.f767y != this.f746C) {
            m1439j();
            this.f745B = this.f766x;
            this.f746C = this.f767y;
        }
    }

    int m1442m() {
        int i = this.f768z;
        if (i == 0) {
            return -1;
        }
        long j = this.f756n;
        int i2 = this.f755m;
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(i - 1, Math.max(0, i2));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        Object obj = null;
        Adapter e = mo244e();
        if (e == null) {
            return -1;
        }
        int i3 = min;
        int i4 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (e.getItemId(i4) != j) {
                Object obj2 = min == i + -1 ? 1 : null;
                Object obj3 = i3 == 0 ? 1 : null;
                if (obj2 != null && obj3 != null) {
                    break;
                } else if (obj3 != null || (r0 != null && obj2 == null)) {
                    min++;
                    obj = null;
                    i4 = min;
                } else if (obj2 != null || (r0 == null && obj3 == null)) {
                    i3--;
                    obj = 1;
                    i4 = i3;
                }
            } else {
                return i4;
            }
        }
        return -1;
    }

    int m1426a(int i, boolean z) {
        return i;
    }

    void m1432c(int i) {
        this.f766x = i;
        this.f767y = m1430b(i);
    }

    void m1433d(int i) {
        this.f764v = i;
        this.f765w = m1430b(i);
        if (this.f758p && this.f759q == 0 && i >= 0) {
            this.f755m = i;
            this.f756n = this.f765w;
        }
    }

    void m1443n() {
        if (getChildCount() > 0) {
            this.f758p = true;
            this.f757o = (long) this.f748a;
            View childAt;
            if (this.f766x >= 0) {
                childAt = getChildAt(this.f766x - this.f753k);
                this.f756n = this.f765w;
                this.f755m = this.f764v;
                if (childAt != null) {
                    this.f754l = childAt.getTop();
                }
                this.f759q = 0;
                return;
            }
            childAt = getChildAt(0);
            Adapter e = mo244e();
            if (this.f753k < 0 || this.f753k >= e.getCount()) {
                this.f756n = -1;
            } else {
                this.f756n = e.getItemId(this.f753k);
            }
            this.f755m = this.f753k;
            if (childAt != null) {
                this.f754l = childAt.getTop();
            }
            this.f759q = 1;
        }
    }
}
