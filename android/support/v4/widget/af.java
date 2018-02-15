package android.support.v4.widget;

import android.support.v4.view.aj;
import android.support.v4.view.ap;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

/* compiled from: MyApp */
public class af {
    private static final Interpolator f400v = new ag();
    private int f401a;
    private int f402b;
    private int f403c;
    private float[] f404d;
    private float[] f405e;
    private float[] f406f;
    private float[] f407g;
    private int[] f408h;
    private int[] f409i;
    private int[] f410j;
    private int f411k;
    private VelocityTracker f412l;
    private float f413m;
    private float f414n;
    private int f415o;
    private int f416p;
    private C0116q f417q;
    private final ah f418r;
    private View f419s;
    private boolean f420t;
    private final ViewGroup f421u;
    private final Runnable f422w;

    public int m859a() {
        return this.f401a;
    }

    public int m866b() {
        return this.f415o;
    }

    public void m860a(View view, int i) {
        if (view.getParent() != this.f421u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f421u + ")");
        }
        this.f419s = view;
        this.f403c = i;
        this.f418r.mo134b(view, i);
        m867b(1);
    }

    public View m872c() {
        return this.f419s;
    }

    public int m875d() {
        return this.f402b;
    }

    public void m877e() {
        this.f403c = -1;
        m857g();
        if (this.f412l != null) {
            this.f412l.recycle();
            this.f412l = null;
        }
    }

    public void m878f() {
        m877e();
        if (this.f401a == 2) {
            int b = this.f417q.m949b();
            int c = this.f417q.m950c();
            this.f417q.m954g();
            int b2 = this.f417q.m949b();
            int c2 = this.f417q.m950c();
            this.f418r.mo130a(this.f419s, b2, c2, b2 - b, c2 - c);
        }
        m867b(0);
    }

    public boolean m864a(View view, int i, int i2) {
        this.f419s = view;
        this.f403c = -1;
        return m848a(i, i2, 0, 0);
    }

    public boolean m862a(int i, int i2) {
        if (this.f420t) {
            return m848a(i, i2, (int) ap.m568a(this.f412l, this.f403c), (int) ap.m569b(this.f412l, this.f403c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean m848a(int i, int i2, int i3, int i4) {
        int left = this.f419s.getLeft();
        int top = this.f419s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f417q.m954g();
            m867b(0);
            return false;
        }
        this.f417q.m947a(left, top, i5, i6, m844a(this.f419s, i5, i6, i3, i4));
        m867b(2);
        return true;
    }

    private int m844a(View view, int i, int i2, int i3, int i4) {
        int b = m850b(i3, (int) this.f414n, (int) this.f413m);
        int b2 = m850b(i4, (int) this.f414n, (int) this.f413m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) m843a(i2, b2, this.f418r.m886b(view)))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) m843a(i, b, this.f418r.mo125a(view)))));
    }

    private int m843a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f421u.getWidth();
        int i4 = width / 2;
        float a = (m841a(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        if (i4 > 0) {
            width = Math.round(Math.abs(a / ((float) i4)) * 1000.0f) * 4;
        } else {
            width = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        return Math.min(width, 600);
    }

    private int m850b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs <= i3) {
            return i;
        }
        if (i <= 0) {
            return -i3;
        }
        return i3;
    }

    private float m842a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs <= f3) {
            return f;
        }
        if (f <= 0.0f) {
            return -f3;
        }
        return f3;
    }

    private float m841a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    public boolean m865a(boolean z) {
        if (this.f401a == 2) {
            boolean a;
            boolean f = this.f417q.m953f();
            int b = this.f417q.m949b();
            int c = this.f417q.m950c();
            int left = b - this.f419s.getLeft();
            int top = c - this.f419s.getTop();
            if (left != 0) {
                this.f419s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.f419s.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                this.f418r.mo130a(this.f419s, b, c, left, top);
            }
            if (f && b == this.f417q.m951d() && c == this.f417q.m952e()) {
                this.f417q.m954g();
                a = this.f417q.m948a();
            } else {
                a = f;
            }
            if (!a) {
                if (z) {
                    this.f421u.post(this.f422w);
                } else {
                    m867b(0);
                }
            }
        }
        return this.f401a == 2;
    }

    private void m845a(float f, float f2) {
        this.f420t = true;
        this.f418r.mo129a(this.f419s, f, f2);
        this.f420t = false;
        if (this.f401a == 1) {
            m867b(0);
        }
    }

    private void m857g() {
        if (this.f404d != null) {
            Arrays.fill(this.f404d, 0.0f);
            Arrays.fill(this.f405e, 0.0f);
            Arrays.fill(this.f406f, 0.0f);
            Arrays.fill(this.f407g, 0.0f);
            Arrays.fill(this.f408h, 0);
            Arrays.fill(this.f409i, 0);
            Arrays.fill(this.f410j, 0);
            this.f411k = 0;
        }
    }

    private void m854d(int i) {
        if (this.f404d != null) {
            this.f404d[i] = 0.0f;
            this.f405e[i] = 0.0f;
            this.f406f[i] = 0.0f;
            this.f407g[i] = 0.0f;
            this.f408h[i] = 0;
            this.f409i[i] = 0;
            this.f410j[i] = 0;
            this.f411k &= (1 << i) ^ -1;
        }
    }

    private void m856e(int i) {
        if (this.f404d == null || this.f404d.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.f404d != null) {
                System.arraycopy(this.f404d, 0, obj, 0, this.f404d.length);
                System.arraycopy(this.f405e, 0, obj2, 0, this.f405e.length);
                System.arraycopy(this.f406f, 0, obj3, 0, this.f406f.length);
                System.arraycopy(this.f407g, 0, obj4, 0, this.f407g.length);
                System.arraycopy(this.f408h, 0, obj5, 0, this.f408h.length);
                System.arraycopy(this.f409i, 0, obj6, 0, this.f409i.length);
                System.arraycopy(this.f410j, 0, obj7, 0, this.f410j.length);
            }
            this.f404d = obj;
            this.f405e = obj2;
            this.f406f = obj3;
            this.f407g = obj4;
            this.f408h = obj5;
            this.f409i = obj6;
            this.f410j = obj7;
        }
    }

    private void m846a(float f, float f2, int i) {
        m856e(i);
        float[] fArr = this.f404d;
        this.f406f[i] = f;
        fArr[i] = f;
        fArr = this.f405e;
        this.f407g[i] = f2;
        fArr[i] = f2;
        this.f408h[i] = m855e((int) f, (int) f2);
        this.f411k |= 1 << i;
    }

    private void m853c(MotionEvent motionEvent) {
        int c = aj.m546c(motionEvent);
        for (int i = 0; i < c; i++) {
            int b = aj.m544b(motionEvent, i);
            float c2 = aj.m545c(motionEvent, i);
            float d = aj.m547d(motionEvent, i);
            this.f406f[b] = c2;
            this.f407g[b] = d;
        }
    }

    public boolean m861a(int i) {
        return (this.f411k & (1 << i)) != 0;
    }

    void m867b(int i) {
        if (this.f401a != i) {
            this.f401a = i;
            this.f418r.mo127a(i);
            if (i == 0) {
                this.f419s = null;
            }
        }
    }

    boolean m870b(View view, int i) {
        if (view == this.f419s && this.f403c == i) {
            return true;
        }
        if (view == null || !this.f418r.mo131a(view, i)) {
            return false;
        }
        this.f403c = i;
        m860a(view, i);
        return true;
    }

    public boolean m863a(MotionEvent motionEvent) {
        int a = aj.m541a(motionEvent);
        int b = aj.m543b(motionEvent);
        if (a == 0) {
            m877e();
        }
        if (this.f412l == null) {
            this.f412l = VelocityTracker.obtain();
        }
        this.f412l.addMovement(motionEvent);
        float y;
        int b2;
        switch (a) {
            case 0:
                float x = motionEvent.getX();
                y = motionEvent.getY();
                b2 = aj.m544b(motionEvent, 0);
                m846a(x, y, b2);
                View d = m876d((int) x, (int) y);
                if (d == this.f419s && this.f401a == 2) {
                    m870b(d, b2);
                }
                a = this.f408h[b2];
                if ((this.f416p & a) != 0) {
                    this.f418r.mo128a(a & this.f416p, b2);
                    break;
                }
                break;
            case 1:
            case 3:
                m877e();
                break;
            case 2:
                b = aj.m546c(motionEvent);
                a = 0;
                while (a < b) {
                    b2 = aj.m544b(motionEvent, a);
                    float c = aj.m545c(motionEvent, a);
                    float d2 = aj.m547d(motionEvent, a);
                    float f = c - this.f404d[b2];
                    float f2 = d2 - this.f405e[b2];
                    m851b(f, f2, b2);
                    if (this.f401a != 1) {
                        View d3 = m876d((int) c, (int) d2);
                        if (d3 == null || !m849a(d3, f, f2) || !m870b(d3, b2)) {
                            a++;
                        }
                    }
                    m853c(motionEvent);
                    break;
                }
                m853c(motionEvent);
                break;
            case 5:
                a = aj.m544b(motionEvent, b);
                float c2 = aj.m545c(motionEvent, b);
                y = aj.m547d(motionEvent, b);
                m846a(c2, y, a);
                if (this.f401a != 0) {
                    if (this.f401a == 2) {
                        View d4 = m876d((int) c2, (int) y);
                        if (d4 == this.f419s) {
                            m870b(d4, a);
                            break;
                        }
                    }
                }
                b = this.f408h[a];
                if ((this.f416p & b) != 0) {
                    this.f418r.mo128a(b & this.f416p, a);
                    break;
                }
                break;
            case 6:
                m854d(aj.m544b(motionEvent, b));
                break;
        }
        if (this.f401a == 1) {
            return true;
        }
        return false;
    }

    public void m868b(MotionEvent motionEvent) {
        int i = 0;
        int a = aj.m541a(motionEvent);
        int b = aj.m543b(motionEvent);
        if (a == 0) {
            m877e();
        }
        if (this.f412l == null) {
            this.f412l = VelocityTracker.obtain();
        }
        this.f412l.addMovement(motionEvent);
        float x;
        float y;
        View d;
        int i2;
        switch (a) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = aj.m544b(motionEvent, 0);
                d = m876d((int) x, (int) y);
                m846a(x, y, i);
                m870b(d, i);
                i2 = this.f408h[i];
                if ((this.f416p & i2) != 0) {
                    this.f418r.mo128a(i2 & this.f416p, i);
                    return;
                }
                return;
            case 1:
                if (this.f401a == 1) {
                    m858h();
                }
                m877e();
                return;
            case 2:
                if (this.f401a == 1) {
                    i = aj.m542a(motionEvent, this.f403c);
                    x = aj.m545c(motionEvent, i);
                    i2 = (int) (x - this.f406f[this.f403c]);
                    i = (int) (aj.m547d(motionEvent, i) - this.f407g[this.f403c]);
                    m852b(this.f419s.getLeft() + i2, this.f419s.getTop() + i, i2, i);
                    m853c(motionEvent);
                    return;
                }
                i2 = aj.m546c(motionEvent);
                while (i < i2) {
                    a = aj.m544b(motionEvent, i);
                    float c = aj.m545c(motionEvent, i);
                    float d2 = aj.m547d(motionEvent, i);
                    float f = c - this.f404d[a];
                    float f2 = d2 - this.f405e[a];
                    m851b(f, f2, a);
                    if (this.f401a != 1) {
                        d = m876d((int) c, (int) d2);
                        if (!m849a(d, f, f2) || !m870b(d, a)) {
                            i++;
                        }
                    }
                    m853c(motionEvent);
                    return;
                }
                m853c(motionEvent);
                return;
            case 3:
                if (this.f401a == 1) {
                    m845a(0.0f, 0.0f);
                }
                m877e();
                return;
            case 5:
                i = aj.m544b(motionEvent, b);
                x = aj.m545c(motionEvent, b);
                y = aj.m547d(motionEvent, b);
                m846a(x, y, i);
                if (this.f401a == 0) {
                    m870b(m876d((int) x, (int) y), i);
                    i2 = this.f408h[i];
                    if ((this.f416p & i2) != 0) {
                        this.f418r.mo128a(i2 & this.f416p, i);
                        return;
                    }
                    return;
                } else if (m874c((int) x, (int) y)) {
                    m870b(this.f419s, i);
                    return;
                } else {
                    return;
                }
            case 6:
                a = aj.m544b(motionEvent, b);
                if (this.f401a == 1 && a == this.f403c) {
                    b = aj.m546c(motionEvent);
                    while (i < b) {
                        int b2 = aj.m544b(motionEvent, i);
                        if (b2 != this.f403c) {
                            if (m876d((int) aj.m545c(motionEvent, i), (int) aj.m547d(motionEvent, i)) == this.f419s && m870b(this.f419s, b2)) {
                                i = this.f403c;
                                if (i == -1) {
                                    m858h();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        m858h();
                    }
                }
                m854d(a);
                return;
            default:
                return;
        }
    }

    private void m851b(float f, float f2, int i) {
        int i2 = 1;
        if (!m847a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m847a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m847a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m847a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f409i;
            iArr[i] = iArr[i] | i2;
            this.f418r.mo133b(i2, i);
        }
    }

    private boolean m847a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f408h[i] & i2) != i2 || (this.f416p & i2) == 0 || (this.f410j[i] & i2) == i2 || (this.f409i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.f402b) && abs2 <= ((float) this.f402b)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f418r.mo135b(i2)) {
            int[] iArr = this.f410j;
            iArr[i] = iArr[i] | i2;
            return false;
        } else if ((this.f409i[i] & i2) != 0 || abs <= ((float) this.f402b)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean m849a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z;
        boolean z2;
        if (this.f418r.mo125a(view) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f418r.m886b(view) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            if ((f * f) + (f2 * f2) <= ((float) (this.f402b * this.f402b))) {
                return false;
            }
            return true;
        } else if (z) {
            if (Math.abs(f) <= ((float) this.f402b)) {
                return false;
            }
            return true;
        } else if (!z2) {
            return false;
        } else {
            if (Math.abs(f2) <= ((float) this.f402b)) {
                return false;
            }
            return true;
        }
    }

    public boolean m873c(int i) {
        int length = this.f404d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (m869b(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean m869b(int i, int i2) {
        if (!m861a(i2)) {
            return false;
        }
        boolean z;
        boolean z2 = (i & 1) == 1;
        if ((i & 2) == 2) {
            z = true;
        } else {
            z = false;
        }
        float f = this.f406f[i2] - this.f404d[i2];
        float f2 = this.f407g[i2] - this.f405e[i2];
        if (z2 && z) {
            if ((f * f) + (f2 * f2) <= ((float) (this.f402b * this.f402b))) {
                return false;
            }
            return true;
        } else if (z2) {
            if (Math.abs(f) <= ((float) this.f402b)) {
                return false;
            }
            return true;
        } else if (!z) {
            return false;
        } else {
            if (Math.abs(f2) <= ((float) this.f402b)) {
                return false;
            }
            return true;
        }
    }

    private void m858h() {
        this.f412l.computeCurrentVelocity(1000, this.f413m);
        m845a(m842a(ap.m568a(this.f412l, this.f403c), this.f414n, this.f413m), m842a(ap.m569b(this.f412l, this.f403c), this.f414n, this.f413m));
    }

    private void m852b(int i, int i2, int i3, int i4) {
        int a;
        int b;
        int left = this.f419s.getLeft();
        int top = this.f419s.getTop();
        if (i3 != 0) {
            a = this.f418r.mo126a(this.f419s, i, i3);
            this.f419s.offsetLeftAndRight(a - left);
        } else {
            a = i;
        }
        if (i4 != 0) {
            b = this.f418r.mo132b(this.f419s, i2, i4);
            this.f419s.offsetTopAndBottom(b - top);
        } else {
            b = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.f418r.mo130a(this.f419s, a, b, a - left, b - top);
        }
    }

    public boolean m874c(int i, int i2) {
        return m871b(this.f419s, i, i2);
    }

    public boolean m871b(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public View m876d(int i, int i2) {
        for (int childCount = this.f421u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f421u.getChildAt(this.f418r.m891c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private int m855e(int i, int i2) {
        int i3 = 0;
        if (i < this.f421u.getLeft() + this.f415o) {
            i3 = 1;
        }
        if (i2 < this.f421u.getTop() + this.f415o) {
            i3 |= 4;
        }
        if (i > this.f421u.getRight() - this.f415o) {
            i3 |= 2;
        }
        if (i2 > this.f421u.getBottom() - this.f415o) {
            return i3 | 8;
        }
        return i3;
    }
}
