package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.C0090q;
import android.support.v4.view.C0095v;
import android.support.v4.view.au;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: MyApp */
public class DrawerLayout extends ViewGroup {
    private static final int[] f347a = new int[]{16842931};
    private int f348b;
    private int f349c;
    private float f350d;
    private Paint f351e;
    private final af f352f;
    private final af f353g;
    private final C0109j f354h;
    private final C0109j f355i;
    private int f356j;
    private boolean f357k;
    private boolean f358l;
    private int f359m;
    private int f360n;
    private boolean f361o;
    private boolean f362p;
    private C0106g f363q;
    private float f364r;
    private float f365s;
    private Drawable f366t;
    private Drawable f367u;

    /* compiled from: MyApp */
    public class SavedState extends BaseSavedState {
        public static final Creator CREATOR = new C0108i();
        int f344a = 0;
        int f345b = 0;
        int f346c = 0;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f344a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f344a);
        }
    }

    public void setScrimColor(int i) {
        this.f349c = i;
        invalidate();
    }

    public void setDrawerListener(C0106g c0106g) {
        this.f363q = c0106g;
    }

    public void setDrawerLockMode(int i) {
        m789a(i, 3);
        m789a(i, 5);
    }

    public void m789a(int i, int i2) {
        int a = C0090q.m760a(i2, au.m589e(this));
        if (a == 3) {
            this.f359m = i;
        } else if (a == 5) {
            this.f360n = i;
        }
        if (i != 0) {
            (a == 3 ? this.f352f : this.f353g).m877e();
        }
        View a2;
        switch (i) {
            case 1:
                a2 = m788a(a);
                if (a2 != null) {
                    m803i(a2);
                    return;
                }
                return;
            case 2:
                a2 = m788a(a);
                if (a2 != null) {
                    m802h(a2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public int m786a(View view) {
        int e = m799e(view);
        if (e == 3) {
            return this.f359m;
        }
        if (e == 5) {
            return this.f360n;
        }
        return 0;
    }

    void m790a(int i, int i2, View view) {
        int i3 = 1;
        int a = this.f352f.m859a();
        int a2 = this.f353g.m859a();
        if (!(a == 1 || a2 == 1)) {
            i3 = (a == 2 || a2 == 2) ? 2 : 0;
        }
        if (view != null && i2 == 0) {
            C0107h c0107h = (C0107h) view.getLayoutParams();
            if (c0107h.f427b == 0.0f) {
                m795b(view);
            } else if (c0107h.f427b == 1.0f) {
                m797c(view);
            }
        }
        if (i3 != this.f356j) {
            this.f356j = i3;
            if (this.f363q != null) {
                this.f363q.m892a(i3);
            }
        }
    }

    void m795b(View view) {
        C0107h c0107h = (C0107h) view.getLayoutParams();
        if (c0107h.f429d) {
            c0107h.f429d = false;
            if (this.f363q != null) {
                this.f363q.m895b(view);
            }
            sendAccessibilityEvent(32);
        }
    }

    void m797c(View view) {
        C0107h c0107h = (C0107h) view.getLayoutParams();
        if (!c0107h.f429d) {
            c0107h.f429d = true;
            if (this.f363q != null) {
                this.f363q.m893a(view);
            }
            view.sendAccessibilityEvent(32);
        }
    }

    void m791a(View view, float f) {
        if (this.f363q != null) {
            this.f363q.m894a(view, f);
        }
    }

    void m796b(View view, float f) {
        C0107h c0107h = (C0107h) view.getLayoutParams();
        if (f != c0107h.f427b) {
            c0107h.f427b = f;
            m791a(view, f);
        }
    }

    float m798d(View view) {
        return ((C0107h) view.getLayoutParams()).f427b;
    }

    int m799e(View view) {
        return C0090q.m760a(((C0107h) view.getLayoutParams()).f426a, au.m589e(view));
    }

    boolean m793a(View view, int i) {
        return (m799e(view) & i) == i;
    }

    View m787a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (((C0107h) childAt.getLayoutParams()).f429d) {
                return childAt;
            }
        }
        return null;
    }

    View m788a(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((m799e(childAt) & 7) == (i & 7)) {
                return childAt;
            }
        }
        return null;
    }

    static String m780b(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        if ((i & 5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(i);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f358l = true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f358l = true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r12, int r13) {
        /*
        r11 = this;
        r1 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r4 = 0;
        r7 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r10 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = android.view.View.MeasureSpec.getMode(r12);
        r5 = android.view.View.MeasureSpec.getMode(r13);
        r2 = android.view.View.MeasureSpec.getSize(r12);
        r0 = android.view.View.MeasureSpec.getSize(r13);
        if (r3 != r10) goto L_0x001b;
    L_0x0019:
        if (r5 == r10) goto L_0x0046;
    L_0x001b:
        r6 = r11.isInEditMode();
        if (r6 == 0) goto L_0x0048;
    L_0x0021:
        if (r3 != r7) goto L_0x0040;
    L_0x0023:
        if (r5 != r7) goto L_0x0044;
    L_0x0025:
        r1 = r0;
    L_0x0026:
        r11.setMeasuredDimension(r2, r1);
        r5 = r11.getChildCount();
        r3 = r4;
    L_0x002e:
        if (r3 >= r5) goto L_0x0109;
    L_0x0030:
        r6 = r11.getChildAt(r3);
        r0 = r6.getVisibility();
        r7 = 8;
        if (r0 != r7) goto L_0x0050;
    L_0x003c:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x002e;
    L_0x0040:
        if (r3 != 0) goto L_0x0023;
    L_0x0042:
        r2 = r1;
        goto L_0x0023;
    L_0x0044:
        if (r5 == 0) goto L_0x0026;
    L_0x0046:
        r1 = r0;
        goto L_0x0026;
    L_0x0048:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "DrawerLayout must be measured with MeasureSpec.EXACTLY.";
        r0.<init>(r1);
        throw r0;
    L_0x0050:
        r0 = r6.getLayoutParams();
        r0 = (android.support.v4.widget.C0107h) r0;
        r7 = r11.m800f(r6);
        if (r7 == 0) goto L_0x0077;
    L_0x005c:
        r7 = r0.leftMargin;
        r7 = r2 - r7;
        r8 = r0.rightMargin;
        r7 = r7 - r8;
        r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r10);
        r8 = r0.topMargin;
        r8 = r1 - r8;
        r0 = r0.bottomMargin;
        r0 = r8 - r0;
        r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r10);
        r6.measure(r7, r0);
        goto L_0x003c;
    L_0x0077:
        r7 = r11.m801g(r6);
        if (r7 == 0) goto L_0x00da;
    L_0x007d:
        r7 = r11.m799e(r6);
        r7 = r7 & 7;
        r8 = r4 & r7;
        if (r8 == 0) goto L_0x00bc;
    L_0x0087:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Child drawer has absolute gravity ";
        r1 = r1.append(r2);
        r2 = m780b(r7);
        r1 = r1.append(r2);
        r2 = " but this ";
        r1 = r1.append(r2);
        r2 = "DrawerLayout";
        r1 = r1.append(r2);
        r2 = " already has a ";
        r1 = r1.append(r2);
        r2 = "drawer view along that edge";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00bc:
        r7 = r11.f348b;
        r8 = r0.leftMargin;
        r7 = r7 + r8;
        r8 = r0.rightMargin;
        r7 = r7 + r8;
        r8 = r0.width;
        r7 = getChildMeasureSpec(r12, r7, r8);
        r8 = r0.topMargin;
        r9 = r0.bottomMargin;
        r8 = r8 + r9;
        r0 = r0.height;
        r0 = getChildMeasureSpec(r13, r8, r0);
        r6.measure(r7, r0);
        goto L_0x003c;
    L_0x00da:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Child ";
        r1 = r1.append(r2);
        r1 = r1.append(r6);
        r2 = " at index ";
        r1 = r1.append(r2);
        r1 = r1.append(r3);
        r2 = " does not have a valid layout_gravity - must be Gravity.LEFT, ";
        r1 = r1.append(r2);
        r2 = "Gravity.RIGHT or Gravity.NO_GRAVITY";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0109:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onMeasure(int, int):void");
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f357k = true;
        int i5 = i3 - i;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                C0107h c0107h = (C0107h) childAt.getLayoutParams();
                if (m800f(childAt)) {
                    childAt.layout(c0107h.leftMargin, c0107h.topMargin, c0107h.leftMargin + childAt.getMeasuredWidth(), c0107h.topMargin + childAt.getMeasuredHeight());
                } else {
                    int i7;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m793a(childAt, 3)) {
                        i7 = ((int) (((float) measuredWidth) * c0107h.f427b)) + (-measuredWidth);
                        f = ((float) (measuredWidth + i7)) / ((float) measuredWidth);
                    } else {
                        i7 = i5 - ((int) (((float) measuredWidth) * c0107h.f427b));
                        f = ((float) (i5 - i7)) / ((float) measuredWidth);
                    }
                    Object obj = f != c0107h.f427b ? 1 : null;
                    int i8;
                    switch (c0107h.f426a & 112) {
                        case 16:
                            int i9 = i4 - i2;
                            i8 = (i9 - measuredHeight) / 2;
                            if (i8 < c0107h.topMargin) {
                                i8 = c0107h.topMargin;
                            } else if (i8 + measuredHeight > i9 - c0107h.bottomMargin) {
                                i8 = (i9 - c0107h.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
                            break;
                        case 80:
                            i8 = i4 - i2;
                            childAt.layout(i7, (i8 - c0107h.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i7, i8 - c0107h.bottomMargin);
                            break;
                        default:
                            childAt.layout(i7, c0107h.topMargin, measuredWidth + i7, measuredHeight);
                            break;
                    }
                    if (obj != null) {
                        m796b(childAt, f);
                    }
                    int i10 = c0107h.f427b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i10) {
                        childAt.setVisibility(i10);
                    }
                }
            }
        }
        this.f357k = false;
        this.f358l = false;
    }

    public void requestLayout() {
        if (!this.f357k) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((C0107h) getChildAt(i).getLayoutParams()).f427b);
        }
        this.f350d = f;
        if ((this.f352f.m865a(true) | this.f353g.m865a(true)) != 0) {
            au.m585b(this);
        }
    }

    private static boolean m785k(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int height = getHeight();
        boolean f = m800f(view);
        int i2 = 0;
        int width = getWidth();
        int save = canvas.save();
        if (f) {
            int childCount = getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && m785k(childAt) && m801g(childAt)) {
                    if (childAt.getHeight() < height) {
                        i = width;
                    } else if (m793a(childAt, 3)) {
                        i = childAt.getRight();
                        if (i <= i2) {
                            i = i2;
                        }
                        i2 = i;
                        i = width;
                    } else {
                        i = childAt.getLeft();
                        if (i < width) {
                        }
                    }
                    i3++;
                    width = i;
                }
                i = width;
                i3++;
                width = i;
            }
            canvas.clipRect(i2, 0, width, getHeight());
        }
        i = width;
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (this.f350d > 0.0f && f) {
            this.f351e.setColor((((int) (((float) ((this.f349c & -16777216) >>> 24)) * this.f350d)) << 24) | (this.f349c & 16777215));
            canvas.drawRect((float) i2, 0.0f, (float) i, (float) getHeight(), this.f351e);
        } else if (this.f366t != null && m793a(view, 3)) {
            i = this.f366t.getIntrinsicWidth();
            i2 = view.getRight();
            r2 = Math.max(0.0f, Math.min(((float) i2) / ((float) this.f352f.m866b()), 1.0f));
            this.f366t.setBounds(i2, view.getTop(), i + i2, view.getBottom());
            this.f366t.setAlpha((int) (255.0f * r2));
            this.f366t.draw(canvas);
        } else if (this.f367u != null && m793a(view, 5)) {
            i = this.f367u.getIntrinsicWidth();
            i2 = view.getLeft();
            r2 = Math.max(0.0f, Math.min(((float) (getWidth() - i2)) / ((float) this.f353g.m866b()), 1.0f));
            this.f367u.setBounds(i2 - i, view.getTop(), i2, view.getBottom());
            this.f367u.setAlpha((int) (255.0f * r2));
            this.f367u.draw(canvas);
        }
        return drawChild;
    }

    boolean m800f(View view) {
        return ((C0107h) view.getLayoutParams()).f426a == 0;
    }

    boolean m801g(View view) {
        return (C0090q.m760a(((C0107h) view.getLayoutParams()).f426a, au.m589e(view)) & 7) != 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r1 = 1;
        r2 = 0;
        r0 = android.support.v4.view.aj.m541a(r8);
        r3 = r7.f352f;
        r3 = r3.m863a(r8);
        r4 = r7.f353g;
        r4 = r4.m863a(r8);
        r3 = r3 | r4;
        switch(r0) {
            case 0: goto L_0x0027;
            case 1: goto L_0x0063;
            case 2: goto L_0x004e;
            case 3: goto L_0x0063;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r2;
    L_0x0017:
        if (r3 != 0) goto L_0x0025;
    L_0x0019:
        if (r0 != 0) goto L_0x0025;
    L_0x001b:
        r0 = r7.m782d();
        if (r0 != 0) goto L_0x0025;
    L_0x0021:
        r0 = r7.f362p;
        if (r0 == 0) goto L_0x0026;
    L_0x0025:
        r2 = r1;
    L_0x0026:
        return r2;
    L_0x0027:
        r0 = r8.getX();
        r4 = r8.getY();
        r7.f364r = r0;
        r7.f365s = r4;
        r5 = r7.f350d;
        r6 = 0;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x006b;
    L_0x003a:
        r5 = r7.f352f;
        r0 = (int) r0;
        r4 = (int) r4;
        r0 = r5.m876d(r0, r4);
        r0 = r7.m800f(r0);
        if (r0 == 0) goto L_0x006b;
    L_0x0048:
        r0 = r1;
    L_0x0049:
        r7.f361o = r2;
        r7.f362p = r2;
        goto L_0x0017;
    L_0x004e:
        r0 = r7.f352f;
        r4 = 3;
        r0 = r0.m873c(r4);
        if (r0 == 0) goto L_0x0016;
    L_0x0057:
        r0 = r7.f354h;
        r0.m901a();
        r0 = r7.f355i;
        r0.m901a();
        r0 = r2;
        goto L_0x0017;
    L_0x0063:
        r7.m792a(r1);
        r7.f361o = r2;
        r7.f362p = r2;
        goto L_0x0016;
    L_0x006b:
        r0 = r2;
        goto L_0x0049;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f352f.m868b(motionEvent);
        this.f353g.m868b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.f364r = x;
                this.f365s = y;
                this.f361o = false;
                this.f362p = false;
                break;
            case 1:
                boolean z;
                x = motionEvent.getX();
                y = motionEvent.getY();
                View d = this.f352f.m876d((int) x, (int) y);
                if (d != null && m800f(d)) {
                    x -= this.f364r;
                    y -= this.f365s;
                    int d2 = this.f352f.m875d();
                    if ((x * x) + (y * y) < ((float) (d2 * d2))) {
                        View a = m787a();
                        if (a != null) {
                            z = m786a(a) == 2;
                            m792a(z);
                            this.f361o = false;
                            break;
                        }
                    }
                }
                z = true;
                m792a(z);
                this.f361o = false;
            case 3:
                m792a(true);
                this.f361o = false;
                this.f362p = false;
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f361o = z;
        if (z) {
            m792a(true);
        }
    }

    public void m794b() {
        m792a(false);
    }

    void m792a(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0107h c0107h = (C0107h) childAt.getLayoutParams();
            if (m801g(childAt) && (!z || c0107h.f428c)) {
                int width = childAt.getWidth();
                if (m793a(childAt, 3)) {
                    i |= this.f352f.m864a(childAt, -width, childAt.getTop());
                } else {
                    i |= this.f353g.m864a(childAt, getWidth(), childAt.getTop());
                }
                c0107h.f428c = false;
            }
        }
        this.f354h.m901a();
        this.f355i.m901a();
        if (i != 0) {
            invalidate();
        }
    }

    public void m802h(View view) {
        if (m801g(view)) {
            if (this.f358l) {
                C0107h c0107h = (C0107h) view.getLayoutParams();
                c0107h.f427b = 1.0f;
                c0107h.f429d = true;
            } else if (m793a(view, 3)) {
                this.f352f.m864a(view, 0, view.getTop());
            } else {
                this.f353g.m864a(view, getWidth() - view.getWidth(), view.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void m803i(View view) {
        if (m801g(view)) {
            if (this.f358l) {
                C0107h c0107h = (C0107h) view.getLayoutParams();
                c0107h.f427b = 0.0f;
                c0107h.f429d = false;
            } else if (m793a(view, 3)) {
                this.f352f.m864a(view, -view.getWidth(), view.getTop());
            } else {
                this.f353g.m864a(view, getWidth(), view.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public boolean m804j(View view) {
        if (m801g(view)) {
            return ((C0107h) view.getLayoutParams()).f427b > 0.0f;
        } else {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
    }

    private boolean m782d() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((C0107h) getChildAt(i).getLayoutParams()).f428c) {
                return true;
            }
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C0107h(-1, -1);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        if (layoutParams instanceof C0107h) {
            return new C0107h((C0107h) layoutParams);
        }
        return layoutParams instanceof MarginLayoutParams ? new C0107h((MarginLayoutParams) layoutParams) : new C0107h(layoutParams);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0107h) && super.checkLayoutParams(layoutParams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0107h(getContext(), attributeSet);
    }

    private boolean m783e() {
        return m784f() != null;
    }

    private View m784f() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m801g(childAt) && m804j(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !m783e()) {
            return super.onKeyDown(i, keyEvent);
        }
        C0095v.m767b(keyEvent);
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View f = m784f();
        if (f != null && m786a(f) == 0) {
            m794b();
        }
        return f != null;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f344a != 0) {
            View a = m788a(savedState.f344a);
            if (a != null) {
                m802h(a);
            }
        }
        m789a(savedState.f345b, 3);
        m789a(savedState.f346c, 5);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m801g(childAt)) {
                C0107h c0107h = (C0107h) childAt.getLayoutParams();
                if (c0107h.f429d) {
                    savedState.f344a = c0107h.f426a;
                    break;
                }
            }
        }
        savedState.f345b = this.f359m;
        savedState.f346c = this.f360n;
        return savedState;
    }
}
