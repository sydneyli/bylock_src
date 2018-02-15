package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p003c.C0043a;
import android.support.v4.widget.C0110k;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: MyApp */
public class ViewPager extends ViewGroup {
    private static final int[] f253a = new int[]{16842931};
    private static final cb ag = new cb();
    private static final Comparator f254c = new bo();
    private static final Interpolator f255d = new bp();
    private boolean f256A;
    private boolean f257B;
    private int f258C;
    private int f259D;
    private int f260E;
    private float f261F;
    private float f262G;
    private float f263H;
    private float f264I;
    private int f265J = -1;
    private VelocityTracker f266K;
    private int f267L;
    private int f268M;
    private int f269N;
    private int f270O;
    private boolean f271P;
    private C0110k f272Q;
    private C0110k f273R;
    private boolean f274S = true;
    private boolean f275T = false;
    private boolean f276U;
    private int f277V;
    private bw f278W;
    private bw aa;
    private bv ab;
    private bx ac;
    private Method ad;
    private int ae;
    private ArrayList af;
    private final Runnable ah = new bq(this);
    private int ai = 0;
    private int f279b;
    private final ArrayList f280e = new ArrayList();
    private final bs f281f = new bs();
    private final Rect f282g = new Rect();
    private ao f283h;
    private int f284i;
    private int f285j = -1;
    private Parcelable f286k = null;
    private ClassLoader f287l = null;
    private Scroller f288m;
    private by f289n;
    private int f290o;
    private Drawable f291p;
    private int f292q;
    private int f293r;
    private float f294s = -3.4028235E38f;
    private float f295t = Float.MAX_VALUE;
    private int f296u;
    private int f297v;
    private boolean f298w;
    private boolean f299x;
    private boolean f300y;
    private int f301z = 1;

    /* compiled from: MyApp */
    public class SavedState extends BaseSavedState {
        public static final Creator CREATOR = C0043a.m312a(new bz());
        int f250a;
        Parcelable f251b;
        ClassLoader f252c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f250a);
            parcel.writeParcelable(this.f251b, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f250a + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.f250a = parcel.readInt();
            this.f251b = parcel.readParcelable(classLoader);
            this.f252c = classLoader;
        }
    }

    public ViewPager(Context context) {
        super(context);
        m347a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m347a();
    }

    void m347a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f288m = new Scroller(context, f255d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f260E = bj.m678a(viewConfiguration);
        this.f267L = (int) (400.0f * f);
        this.f268M = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f272Q = new C0110k(context);
        this.f273R = new C0110k(context);
        this.f269N = (int) (25.0f * f);
        this.f270O = (int) (2.0f * f);
        this.f258C = (int) (16.0f * f);
        au.m582a((View) this, new bu(this));
        if (au.m587c(this) == 0) {
            au.m586b(this, 1);
        }
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.ah);
        super.onDetachedFromWindow();
    }

    private void setScrollState(int i) {
        if (this.ai != i) {
            this.ai = i;
            if (this.ac != null) {
                m336b(i != 0);
            }
            if (this.f278W != null) {
                this.f278W.mo105b(i);
            }
        }
    }

    public void setAdapter(ao aoVar) {
        if (this.f283h != null) {
            this.f283h.m285b(this.f289n);
            this.f283h.mo20a((ViewGroup) this);
            for (int i = 0; i < this.f280e.size(); i++) {
                bs bsVar = (bs) this.f280e.get(i);
                this.f283h.mo21a((ViewGroup) this, bsVar.f321b, bsVar.f320a);
            }
            this.f283h.mo23b((ViewGroup) this);
            this.f280e.clear();
            m340g();
            this.f284i = 0;
            scrollTo(0, 0);
        }
        ao aoVar2 = this.f283h;
        this.f283h = aoVar;
        this.f279b = 0;
        if (this.f283h != null) {
            if (this.f289n == null) {
                this.f289n = new by();
            }
            this.f283h.m277a(this.f289n);
            this.f300y = false;
            boolean z = this.f274S;
            this.f274S = true;
            this.f279b = this.f283h.mo346b();
            if (this.f285j >= 0) {
                this.f283h.mo19a(this.f286k, this.f287l);
                m352a(this.f285j, false, true);
                this.f285j = -1;
                this.f286k = null;
                this.f287l = null;
            } else if (z) {
                requestLayout();
            } else {
                m359c();
            }
        }
        if (this.ab != null && aoVar2 != aoVar) {
            this.ab.m688a(aoVar2, aoVar);
        }
    }

    private void m340g() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((bt) getChildAt(i).getLayoutParams()).f325a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public ao getAdapter() {
        return this.f283h;
    }

    void setOnAdapterChangeListener(bv bvVar) {
        this.ab = bvVar;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        boolean z;
        this.f300y = false;
        if (this.f274S) {
            z = false;
        } else {
            z = true;
        }
        m352a(i, z, false);
    }

    public void m351a(int i, boolean z) {
        this.f300y = false;
        m352a(i, z, false);
    }

    public int getCurrentItem() {
        return this.f284i;
    }

    void m352a(int i, boolean z, boolean z2) {
        m353a(i, z, z2, 0);
    }

    void m353a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.f283h == null || this.f283h.mo346b() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f284i != i || this.f280e.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.f283h.mo346b()) {
                i = this.f283h.mo346b() - 1;
            }
            int i3 = this.f301z;
            if (i > this.f284i + i3 || i < this.f284i - i3) {
                for (int i4 = 0; i4 < this.f280e.size(); i4++) {
                    ((bs) this.f280e.get(i4)).f322c = true;
                }
            }
            if (this.f284i != i) {
                z3 = true;
            }
            if (this.f274S) {
                this.f284i = i;
                if (z3 && this.f278W != null) {
                    this.f278W.mo103a(i);
                }
                if (z3 && this.aa != null) {
                    this.aa.mo103a(i);
                }
                requestLayout();
                return;
            }
            m348a(i);
            m329a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void m329a(int i, boolean z, int i2, boolean z2) {
        int max;
        bs b = m356b(i);
        if (b != null) {
            max = (int) (Math.max(this.f294s, Math.min(b.f324e, this.f295t)) * ((float) getClientWidth()));
        } else {
            max = 0;
        }
        if (z) {
            m350a(max, 0, i2);
            if (z2 && this.f278W != null) {
                this.f278W.mo103a(i);
            }
            if (z2 && this.aa != null) {
                this.aa.mo103a(i);
                return;
            }
            return;
        }
        if (z2 && this.f278W != null) {
            this.f278W.mo103a(i);
        }
        if (z2 && this.aa != null) {
            this.aa.mo103a(i);
        }
        m333a(false);
        scrollTo(max, 0);
        m338d(max);
    }

    public void setOnPageChangeListener(bw bwVar) {
        this.f278W = bwVar;
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.ad == null) {
                try {
                    this.ad = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.ad.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ae == 2) {
            i2 = (i - 1) - i2;
        }
        return ((bt) ((View) this.af.get(i2)).getLayoutParams()).f330f;
    }

    public int getOffscreenPageLimit() {
        return this.f301z;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.f301z) {
            this.f301z = i;
            m359c();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.f290o;
        this.f290o = i;
        int width = getWidth();
        m328a(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.f290o;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f291p = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f291p;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f291p;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    float m344a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    void m350a(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            m333a(false);
            m359c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i6 = clientWidth / 2;
        float a = (((float) i6) * m344a(Math.min(1.0f, (((float) Math.abs(i4)) * 1.0f) / ((float) clientWidth)))) + ((float) i6);
        int abs = Math.abs(i3);
        if (abs > 0) {
            clientWidth = Math.round(1000.0f * Math.abs(a / ((float) abs))) * 4;
        } else {
            clientWidth = (int) (((((float) Math.abs(i4)) / ((((float) clientWidth) * this.f283h.m290c(this.f284i)) + ((float) this.f290o))) + 1.0f) * 100.0f);
        }
        this.f288m.startScroll(scrollX, scrollY, i4, i5, Math.min(clientWidth, 600));
        au.m585b(this);
    }

    bs m345a(int i, int i2) {
        bs bsVar = new bs();
        bsVar.f321b = i;
        bsVar.f320a = this.f283h.mo18a((ViewGroup) this, i);
        bsVar.f323d = this.f283h.m290c(i);
        if (i2 < 0 || i2 >= this.f280e.size()) {
            this.f280e.add(bsVar);
        } else {
            this.f280e.add(i2, bsVar);
        }
        return bsVar;
    }

    void m358b() {
        int b = this.f283h.mo346b();
        this.f279b = b;
        boolean z = this.f280e.size() < (this.f301z * 2) + 1 && this.f280e.size() < b;
        boolean z2 = false;
        int i = this.f284i;
        boolean z3 = z;
        int i2 = 0;
        while (i2 < this.f280e.size()) {
            int i3;
            boolean z4;
            int i4;
            boolean z5;
            bs bsVar = (bs) this.f280e.get(i2);
            int a = this.f283h.m273a(bsVar.f320a);
            if (a == -1) {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            } else if (a == -2) {
                this.f280e.remove(i2);
                i2--;
                if (!z2) {
                    this.f283h.mo20a((ViewGroup) this);
                    z2 = true;
                }
                this.f283h.mo21a((ViewGroup) this, bsVar.f321b, bsVar.f320a);
                if (this.f284i == bsVar.f321b) {
                    i3 = i2;
                    z4 = z2;
                    i4 = Math.max(0, Math.min(this.f284i, b - 1));
                    z5 = true;
                } else {
                    i3 = i2;
                    z4 = z2;
                    i4 = i;
                    z5 = true;
                }
            } else if (bsVar.f321b != a) {
                if (bsVar.f321b == this.f284i) {
                    i = a;
                }
                bsVar.f321b = a;
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = true;
            } else {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            }
            z3 = z5;
            i = i4;
            z2 = z4;
            i2 = i3 + 1;
        }
        if (z2) {
            this.f283h.mo23b((ViewGroup) this);
        }
        Collections.sort(this.f280e, f254c);
        if (z3) {
            i4 = getChildCount();
            for (i2 = 0; i2 < i4; i2++) {
                bt btVar = (bt) getChildAt(i2).getLayoutParams();
                if (!btVar.f325a) {
                    btVar.f327c = 0.0f;
                }
            }
            m352a(i, false, true);
            requestLayout();
        }
    }

    void m359c() {
        m348a(this.f284i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m348a(int r19) {
        /*
        r18 = this;
        r3 = 0;
        r2 = 2;
        r0 = r18;
        r4 = r0.f284i;
        r0 = r19;
        if (r4 == r0) goto L_0x033f;
    L_0x000a:
        r0 = r18;
        r2 = r0.f284i;
        r0 = r19;
        if (r2 >= r0) goto L_0x0030;
    L_0x0012:
        r2 = 66;
    L_0x0014:
        r0 = r18;
        r3 = r0.f284i;
        r0 = r18;
        r3 = r0.m356b(r3);
        r0 = r19;
        r1 = r18;
        r1.f284i = r0;
        r4 = r3;
        r3 = r2;
    L_0x0026:
        r0 = r18;
        r2 = r0.f283h;
        if (r2 != 0) goto L_0x0033;
    L_0x002c:
        r18.m341h();
    L_0x002f:
        return;
    L_0x0030:
        r2 = 17;
        goto L_0x0014;
    L_0x0033:
        r0 = r18;
        r2 = r0.f300y;
        if (r2 == 0) goto L_0x003d;
    L_0x0039:
        r18.m341h();
        goto L_0x002f;
    L_0x003d:
        r2 = r18.getWindowToken();
        if (r2 == 0) goto L_0x002f;
    L_0x0043:
        r0 = r18;
        r2 = r0.f283h;
        r0 = r18;
        r2.mo20a(r0);
        r0 = r18;
        r2 = r0.f301z;
        r5 = 0;
        r0 = r18;
        r6 = r0.f284i;
        r6 = r6 - r2;
        r11 = java.lang.Math.max(r5, r6);
        r0 = r18;
        r5 = r0.f283h;
        r12 = r5.mo346b();
        r5 = r12 + -1;
        r0 = r18;
        r6 = r0.f284i;
        r2 = r2 + r6;
        r13 = java.lang.Math.min(r5, r2);
        r0 = r18;
        r2 = r0.f279b;
        if (r12 == r2) goto L_0x00da;
    L_0x0073:
        r2 = r18.getResources();	 Catch:{ NotFoundException -> 0x00d0 }
        r3 = r18.getId();	 Catch:{ NotFoundException -> 0x00d0 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00d0 }
    L_0x007f:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4 = r4.append(r5);
        r0 = r18;
        r5 = r0.f279b;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r12);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r18.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r18;
        r4 = r0.f283h;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00d0:
        r2 = move-exception;
        r2 = r18.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x007f;
    L_0x00da:
        r6 = 0;
        r2 = 0;
        r5 = r2;
    L_0x00dd:
        r0 = r18;
        r2 = r0.f280e;
        r2 = r2.size();
        if (r5 >= r2) goto L_0x033c;
    L_0x00e7:
        r0 = r18;
        r2 = r0.f280e;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.bs) r2;
        r7 = r2.f321b;
        r0 = r18;
        r8 = r0.f284i;
        if (r7 < r8) goto L_0x01cf;
    L_0x00f9:
        r7 = r2.f321b;
        r0 = r18;
        r8 = r0.f284i;
        if (r7 != r8) goto L_0x033c;
    L_0x0101:
        if (r2 != 0) goto L_0x0339;
    L_0x0103:
        if (r12 <= 0) goto L_0x0339;
    L_0x0105:
        r0 = r18;
        r2 = r0.f284i;
        r0 = r18;
        r2 = r0.m345a(r2, r5);
        r10 = r2;
    L_0x0110:
        if (r10 == 0) goto L_0x0180;
    L_0x0112:
        r9 = 0;
        r8 = r5 + -1;
        if (r8 < 0) goto L_0x01d4;
    L_0x0117:
        r0 = r18;
        r2 = r0.f280e;
        r2 = r2.get(r8);
        r2 = (android.support.v4.view.bs) r2;
    L_0x0121:
        r14 = r18.getClientWidth();
        if (r14 > 0) goto L_0x01d7;
    L_0x0127:
        r6 = 0;
    L_0x0128:
        r0 = r18;
        r7 = r0.f284i;
        r7 = r7 + -1;
        r16 = r7;
        r7 = r9;
        r9 = r16;
        r17 = r8;
        r8 = r5;
        r5 = r17;
    L_0x0138:
        if (r9 < 0) goto L_0x0142;
    L_0x013a:
        r15 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1));
        if (r15 < 0) goto L_0x0216;
    L_0x013e:
        if (r9 >= r11) goto L_0x0216;
    L_0x0140:
        if (r2 != 0) goto L_0x01e6;
    L_0x0142:
        r6 = r10.f323d;
        r9 = r8 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x017b;
    L_0x014c:
        r0 = r18;
        r2 = r0.f280e;
        r2 = r2.size();
        if (r9 >= r2) goto L_0x024c;
    L_0x0156:
        r0 = r18;
        r2 = r0.f280e;
        r2 = r2.get(r9);
        r2 = (android.support.v4.view.bs) r2;
        r7 = r2;
    L_0x0161:
        if (r14 > 0) goto L_0x024f;
    L_0x0163:
        r2 = 0;
        r5 = r2;
    L_0x0165:
        r0 = r18;
        r2 = r0.f284i;
        r2 = r2 + 1;
        r16 = r2;
        r2 = r7;
        r7 = r9;
        r9 = r16;
    L_0x0171:
        if (r9 >= r12) goto L_0x017b;
    L_0x0173:
        r11 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r11 < 0) goto L_0x029a;
    L_0x0177:
        if (r9 <= r13) goto L_0x029a;
    L_0x0179:
        if (r2 != 0) goto L_0x025c;
    L_0x017b:
        r0 = r18;
        r0.m331a(r10, r8, r4);
    L_0x0180:
        r0 = r18;
        r4 = r0.f283h;
        r0 = r18;
        r5 = r0.f284i;
        if (r10 == 0) goto L_0x02e8;
    L_0x018a:
        r2 = r10.f320a;
    L_0x018c:
        r0 = r18;
        r4.mo24b(r0, r5, r2);
        r0 = r18;
        r2 = r0.f283h;
        r0 = r18;
        r2.mo23b(r0);
        r5 = r18.getChildCount();
        r2 = 0;
        r4 = r2;
    L_0x01a0:
        if (r4 >= r5) goto L_0x02eb;
    L_0x01a2:
        r0 = r18;
        r6 = r0.getChildAt(r4);
        r2 = r6.getLayoutParams();
        r2 = (android.support.v4.view.bt) r2;
        r2.f330f = r4;
        r7 = r2.f325a;
        if (r7 != 0) goto L_0x01cb;
    L_0x01b4:
        r7 = r2.f327c;
        r8 = 0;
        r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1));
        if (r7 != 0) goto L_0x01cb;
    L_0x01bb:
        r0 = r18;
        r6 = r0.m346a(r6);
        if (r6 == 0) goto L_0x01cb;
    L_0x01c3:
        r7 = r6.f323d;
        r2.f327c = r7;
        r6 = r6.f321b;
        r2.f329e = r6;
    L_0x01cb:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x01a0;
    L_0x01cf:
        r2 = r5 + 1;
        r5 = r2;
        goto L_0x00dd;
    L_0x01d4:
        r2 = 0;
        goto L_0x0121;
    L_0x01d7:
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = r10.f323d;
        r6 = r6 - r7;
        r7 = r18.getPaddingLeft();
        r7 = (float) r7;
        r15 = (float) r14;
        r7 = r7 / r15;
        r6 = r6 + r7;
        goto L_0x0128;
    L_0x01e6:
        r15 = r2.f321b;
        if (r9 != r15) goto L_0x0210;
    L_0x01ea:
        r15 = r2.f322c;
        if (r15 != 0) goto L_0x0210;
    L_0x01ee:
        r0 = r18;
        r15 = r0.f280e;
        r15.remove(r5);
        r0 = r18;
        r15 = r0.f283h;
        r2 = r2.f320a;
        r0 = r18;
        r15.mo21a(r0, r9, r2);
        r5 = r5 + -1;
        r8 = r8 + -1;
        if (r5 < 0) goto L_0x0214;
    L_0x0206:
        r0 = r18;
        r2 = r0.f280e;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.bs) r2;
    L_0x0210:
        r9 = r9 + -1;
        goto L_0x0138;
    L_0x0214:
        r2 = 0;
        goto L_0x0210;
    L_0x0216:
        if (r2 == 0) goto L_0x0230;
    L_0x0218:
        r15 = r2.f321b;
        if (r9 != r15) goto L_0x0230;
    L_0x021c:
        r2 = r2.f323d;
        r7 = r7 + r2;
        r5 = r5 + -1;
        if (r5 < 0) goto L_0x022e;
    L_0x0223:
        r0 = r18;
        r2 = r0.f280e;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.bs) r2;
        goto L_0x0210;
    L_0x022e:
        r2 = 0;
        goto L_0x0210;
    L_0x0230:
        r2 = r5 + 1;
        r0 = r18;
        r2 = r0.m345a(r9, r2);
        r2 = r2.f323d;
        r7 = r7 + r2;
        r8 = r8 + 1;
        if (r5 < 0) goto L_0x024a;
    L_0x023f:
        r0 = r18;
        r2 = r0.f280e;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.bs) r2;
        goto L_0x0210;
    L_0x024a:
        r2 = 0;
        goto L_0x0210;
    L_0x024c:
        r7 = 0;
        goto L_0x0161;
    L_0x024f:
        r2 = r18.getPaddingRight();
        r2 = (float) r2;
        r5 = (float) r14;
        r2 = r2 / r5;
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r5;
        r5 = r2;
        goto L_0x0165;
    L_0x025c:
        r11 = r2.f321b;
        if (r9 != r11) goto L_0x0332;
    L_0x0260:
        r11 = r2.f322c;
        if (r11 != 0) goto L_0x0332;
    L_0x0264:
        r0 = r18;
        r11 = r0.f280e;
        r11.remove(r7);
        r0 = r18;
        r11 = r0.f283h;
        r2 = r2.f320a;
        r0 = r18;
        r11.mo21a(r0, r9, r2);
        r0 = r18;
        r2 = r0.f280e;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x0298;
    L_0x0280:
        r0 = r18;
        r2 = r0.f280e;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.bs) r2;
    L_0x028a:
        r16 = r6;
        r6 = r2;
        r2 = r16;
    L_0x028f:
        r9 = r9 + 1;
        r16 = r2;
        r2 = r6;
        r6 = r16;
        goto L_0x0171;
    L_0x0298:
        r2 = 0;
        goto L_0x028a;
    L_0x029a:
        if (r2 == 0) goto L_0x02c1;
    L_0x029c:
        r11 = r2.f321b;
        if (r9 != r11) goto L_0x02c1;
    L_0x02a0:
        r2 = r2.f323d;
        r6 = r6 + r2;
        r7 = r7 + 1;
        r0 = r18;
        r2 = r0.f280e;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x02bf;
    L_0x02af:
        r0 = r18;
        r2 = r0.f280e;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.bs) r2;
    L_0x02b9:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x028f;
    L_0x02bf:
        r2 = 0;
        goto L_0x02b9;
    L_0x02c1:
        r0 = r18;
        r2 = r0.m345a(r9, r7);
        r7 = r7 + 1;
        r2 = r2.f323d;
        r6 = r6 + r2;
        r0 = r18;
        r2 = r0.f280e;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x02e6;
    L_0x02d6:
        r0 = r18;
        r2 = r0.f280e;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.bs) r2;
    L_0x02e0:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x028f;
    L_0x02e6:
        r2 = 0;
        goto L_0x02e0;
    L_0x02e8:
        r2 = 0;
        goto L_0x018c;
    L_0x02eb:
        r18.m341h();
        r2 = r18.hasFocus();
        if (r2 == 0) goto L_0x002f;
    L_0x02f4:
        r2 = r18.findFocus();
        if (r2 == 0) goto L_0x0330;
    L_0x02fa:
        r0 = r18;
        r2 = r0.m357b(r2);
    L_0x0300:
        if (r2 == 0) goto L_0x030a;
    L_0x0302:
        r2 = r2.f321b;
        r0 = r18;
        r4 = r0.f284i;
        if (r2 == r4) goto L_0x002f;
    L_0x030a:
        r2 = 0;
    L_0x030b:
        r4 = r18.getChildCount();
        if (r2 >= r4) goto L_0x002f;
    L_0x0311:
        r0 = r18;
        r4 = r0.getChildAt(r2);
        r0 = r18;
        r5 = r0.m346a(r4);
        if (r5 == 0) goto L_0x032d;
    L_0x031f:
        r5 = r5.f321b;
        r0 = r18;
        r6 = r0.f284i;
        if (r5 != r6) goto L_0x032d;
    L_0x0327:
        r4 = r4.requestFocus(r3);
        if (r4 != 0) goto L_0x002f;
    L_0x032d:
        r2 = r2 + 1;
        goto L_0x030b;
    L_0x0330:
        r2 = 0;
        goto L_0x0300;
    L_0x0332:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x028f;
    L_0x0339:
        r10 = r2;
        goto L_0x0110;
    L_0x033c:
        r2 = r6;
        goto L_0x0101;
    L_0x033f:
        r4 = r3;
        r3 = r2;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.a(int):void");
    }

    private void m341h() {
        if (this.ae != 0) {
            if (this.af == null) {
                this.af = new ArrayList();
            } else {
                this.af.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.af.add(getChildAt(i));
            }
            Collections.sort(this.af, ag);
        }
    }

    private void m331a(bs bsVar, int i, bs bsVar2) {
        float f;
        float f2;
        int i2;
        bs bsVar3;
        int i3;
        int b = this.f283h.mo346b();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f = ((float) this.f290o) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        if (bsVar2 != null) {
            clientWidth = bsVar2.f321b;
            int i4;
            if (clientWidth < bsVar.f321b) {
                f2 = (bsVar2.f324e + bsVar2.f323d) + f;
                i4 = clientWidth + 1;
                i2 = 0;
                while (i4 <= bsVar.f321b && i2 < this.f280e.size()) {
                    bsVar3 = (bs) this.f280e.get(i2);
                    while (i4 > bsVar3.f321b && i2 < this.f280e.size() - 1) {
                        i2++;
                        bsVar3 = (bs) this.f280e.get(i2);
                    }
                    while (i4 < bsVar3.f321b) {
                        f2 += this.f283h.m290c(i4) + f;
                        i4++;
                    }
                    bsVar3.f324e = f2;
                    f2 += bsVar3.f323d + f;
                    i4++;
                }
            } else if (clientWidth > bsVar.f321b) {
                i2 = this.f280e.size() - 1;
                f2 = bsVar2.f324e;
                i4 = clientWidth - 1;
                while (i4 >= bsVar.f321b && i2 >= 0) {
                    bsVar3 = (bs) this.f280e.get(i2);
                    while (i4 < bsVar3.f321b && i2 > 0) {
                        i2--;
                        bsVar3 = (bs) this.f280e.get(i2);
                    }
                    while (i4 > bsVar3.f321b) {
                        f2 -= this.f283h.m290c(i4) + f;
                        i4--;
                    }
                    f2 -= bsVar3.f323d + f;
                    bsVar3.f324e = f2;
                    i4--;
                }
            }
        }
        int size = this.f280e.size();
        float f3 = bsVar.f324e;
        i2 = bsVar.f321b - 1;
        this.f294s = bsVar.f321b == 0 ? bsVar.f324e : -3.4028235E38f;
        this.f295t = bsVar.f321b == b + -1 ? (bsVar.f324e + bsVar.f323d) - 1.0f : Float.MAX_VALUE;
        for (i3 = i - 1; i3 >= 0; i3--) {
            bsVar3 = (bs) this.f280e.get(i3);
            f2 = f3;
            while (i2 > bsVar3.f321b) {
                f2 -= this.f283h.m290c(i2) + f;
                i2--;
            }
            f3 = f2 - (bsVar3.f323d + f);
            bsVar3.f324e = f3;
            if (bsVar3.f321b == 0) {
                this.f294s = f3;
            }
            i2--;
        }
        f3 = (bsVar.f324e + bsVar.f323d) + f;
        i2 = bsVar.f321b + 1;
        for (i3 = i + 1; i3 < size; i3++) {
            bsVar3 = (bs) this.f280e.get(i3);
            f2 = f3;
            while (i2 < bsVar3.f321b) {
                f2 = (this.f283h.m290c(i2) + f) + f2;
                i2++;
            }
            if (bsVar3.f321b == b - 1) {
                this.f295t = (bsVar3.f323d + f2) - 1.0f;
            }
            bsVar3.f324e = f2;
            f3 = f2 + (bsVar3.f323d + f);
            i2++;
        }
        this.f275T = false;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f250a = this.f284i;
        if (this.f283h != null) {
            savedState.f251b = this.f283h.mo17a();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.f283h != null) {
                this.f283h.mo19a(savedState.f251b, savedState.f252c);
                m352a(savedState.f250a, false, true);
                return;
            }
            this.f285j = savedState.f250a;
            this.f286k = savedState.f251b;
            this.f287l = savedState.f252c;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (checkLayoutParams(layoutParams)) {
            layoutParams2 = layoutParams;
        } else {
            layoutParams2 = generateLayoutParams(layoutParams);
        }
        bt btVar = (bt) layoutParams2;
        btVar.f325a |= view instanceof br;
        if (!this.f298w) {
            super.addView(view, i, layoutParams2);
        } else if (btVar == null || !btVar.f325a) {
            btVar.f328d = true;
            addViewInLayout(view, i, layoutParams2);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void removeView(View view) {
        if (this.f298w) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    bs m346a(View view) {
        for (int i = 0; i < this.f280e.size(); i++) {
            bs bsVar = (bs) this.f280e.get(i);
            if (this.f283h.mo22a(view, bsVar.f320a)) {
                return bsVar;
            }
        }
        return null;
    }

    bs m357b(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return m346a(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    bs m356b(int i) {
        for (int i2 = 0; i2 < this.f280e.size(); i2++) {
            bs bsVar = (bs) this.f280e.get(i2);
            if (bsVar.f321b == i) {
                return bsVar;
            }
        }
        return null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f274S = true;
    }

    protected void onMeasure(int i, int i2) {
        bt btVar;
        int i3;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.f259D = Math.min(measuredWidth / 10, this.f258C);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            int i5;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                btVar = (bt) childAt.getLayoutParams();
                if (btVar != null && btVar.f325a) {
                    int i6 = btVar.f326b & 7;
                    int i7 = btVar.f326b & 112;
                    i3 = Integer.MIN_VALUE;
                    i5 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i5 = 1073741824;
                    }
                    if (btVar.width != -2) {
                        i7 = 1073741824;
                        i3 = btVar.width != -1 ? btVar.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (btVar.height != -2) {
                        i5 = 1073741824;
                        if (btVar.height != -1) {
                            measuredWidth = btVar.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.f296u = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f297v = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f298w = true;
        m359c();
        this.f298w = false;
        i3 = getChildCount();
        for (i5 = 0; i5 < i3; i5++) {
            View childAt2 = getChildAt(i5);
            if (childAt2.getVisibility() != 8) {
                btVar = (bt) childAt2.getLayoutParams();
                if (btVar == null || !btVar.f325a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (btVar.f327c * ((float) paddingLeft)), 1073741824), this.f297v);
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m328a(i, i3, this.f290o, this.f290o);
        }
    }

    private void m328a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f280e.isEmpty()) {
            bs b = m356b(this.f284i);
            int min = (int) ((b != null ? Math.min(b.f324e, this.f295t) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                m333a(false);
                scrollTo(min, getScrollY());
                return;
            }
            return;
        }
        int paddingLeft = (int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))));
        scrollTo(paddingLeft, getScrollY());
        if (!this.f288m.isFinished()) {
            this.f288m.startScroll(paddingLeft, 0, (int) (m356b(this.f284i).f324e * ((float) i)), 0, this.f288m.getDuration() - this.f288m.timePassed());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            bt btVar;
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                btVar = (bt) childAt.getLayoutParams();
                if (btVar.f325a) {
                    int i9 = btVar.f326b & 112;
                    switch (btVar.f326b & 7) {
                        case 1:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case 16:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case 48:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case 80:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + 1;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8++;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8++;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                btVar = (bt) childAt2.getLayoutParams();
                if (!btVar.f325a) {
                    bs a = m346a(childAt2);
                    if (a != null) {
                        i5 = ((int) (a.f324e * ((float) max))) + paddingLeft;
                        if (btVar.f328d) {
                            btVar.f328d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (btVar.f327c * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.f292q = paddingTop;
        this.f293r = i6 - paddingBottom;
        this.f277V = i7;
        if (this.f274S) {
            m329a(this.f284i, false, 0, false);
        }
        this.f274S = false;
    }

    public void computeScroll() {
        if (this.f288m.isFinished() || !this.f288m.computeScrollOffset()) {
            m333a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f288m.getCurrX();
        int currY = this.f288m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!m338d(currX)) {
                this.f288m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        au.m585b(this);
    }

    private boolean m338d(int i) {
        if (this.f280e.size() == 0) {
            this.f276U = false;
            m349a(0, 0.0f, 0);
            if (this.f276U) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        bs i2 = m342i();
        int clientWidth = getClientWidth();
        int i3 = this.f290o + clientWidth;
        float f = ((float) this.f290o) / ((float) clientWidth);
        int i4 = i2.f321b;
        float f2 = ((((float) i) / ((float) clientWidth)) - i2.f324e) / (i2.f323d + f);
        clientWidth = (int) (((float) i3) * f2);
        this.f276U = false;
        m349a(i4, f2, clientWidth);
        if (this.f276U) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    protected void m349a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.f277V > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                bt btVar = (bt) childAt.getLayoutParams();
                if (btVar.f325a) {
                    int max;
                    switch (btVar.f326b & 7) {
                        case 1:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case 3:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3++;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        if (this.f278W != null) {
            this.f278W.mo104a(i, f, i2);
        }
        if (this.aa != null) {
            this.aa.mo104a(i, f, i2);
        }
        if (this.ac != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((bt) childAt2.getLayoutParams()).f325a) {
                    this.ac.m692a(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.f276U = true;
    }

    private void m333a(boolean z) {
        int scrollX;
        boolean z2 = this.ai == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.f288m.abortAnimation();
            scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f288m.getCurrX();
            int currY = this.f288m.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
        }
        this.f300y = false;
        boolean z3 = z2;
        for (scrollX = 0; scrollX < this.f280e.size(); scrollX++) {
            bs bsVar = (bs) this.f280e.get(scrollX);
            if (bsVar.f322c) {
                bsVar.f322c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            au.m583a((View) this, this.ah);
        } else {
            this.ah.run();
        }
    }

    private boolean m334a(float f, float f2) {
        return (f < ((float) this.f259D) && f2 > 0.0f) || (f > ((float) (getWidth() - this.f259D)) && f2 < 0.0f);
    }

    private void m336b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            int i2;
            if (z) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            au.m580a(getChildAt(i), i2, null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.f256A = false;
            this.f257B = false;
            this.f265J = -1;
            if (this.f266K == null) {
                return false;
            }
            this.f266K.recycle();
            this.f266K = null;
            return false;
        }
        if (action != 0) {
            if (this.f256A) {
                return true;
            }
            if (this.f257B) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.f263H = x;
                this.f261F = x;
                x = motionEvent.getY();
                this.f264I = x;
                this.f262G = x;
                this.f265J = aj.m544b(motionEvent, 0);
                this.f257B = false;
                this.f288m.computeScrollOffset();
                if (this.ai == 2 && Math.abs(this.f288m.getFinalX() - this.f288m.getCurrX()) > this.f270O) {
                    this.f288m.abortAnimation();
                    this.f300y = false;
                    m359c();
                    this.f256A = true;
                    setScrollState(1);
                    break;
                }
                m333a(false);
                this.f256A = false;
                break;
                break;
            case 2:
                action = this.f265J;
                if (action != -1) {
                    action = aj.m542a(motionEvent, action);
                    float c = aj.m545c(motionEvent, action);
                    float f = c - this.f261F;
                    float abs = Math.abs(f);
                    float d = aj.m547d(motionEvent, action);
                    float abs2 = Math.abs(d - this.f264I);
                    if (f == 0.0f || m334a(this.f261F, f) || !m355a(this, false, (int) f, (int) c, (int) d)) {
                        if (abs > ((float) this.f260E) && 0.5f * abs > abs2) {
                            this.f256A = true;
                            setScrollState(1);
                            this.f261F = f > 0.0f ? this.f263H + ((float) this.f260E) : this.f263H - ((float) this.f260E);
                            this.f262G = d;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > ((float) this.f260E)) {
                            this.f257B = true;
                        }
                        if (this.f256A && m337b(c)) {
                            au.m585b(this);
                            break;
                        }
                    }
                    this.f261F = c;
                    this.f262G = d;
                    this.f257B = true;
                    return false;
                }
                break;
            case 6:
                m332a(motionEvent);
                break;
        }
        if (this.f266K == null) {
            this.f266K = VelocityTracker.obtain();
        }
        this.f266K.addMovement(motionEvent);
        return this.f256A;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f271P) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.f283h == null || this.f283h.mo346b() == 0) {
            return false;
        }
        if (this.f266K == null) {
            this.f266K = VelocityTracker.obtain();
        }
        this.f266K.addMovement(motionEvent);
        float x;
        int a;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f288m.abortAnimation();
                this.f300y = false;
                m359c();
                this.f256A = true;
                setScrollState(1);
                x = motionEvent.getX();
                this.f263H = x;
                this.f261F = x;
                x = motionEvent.getY();
                this.f264I = x;
                this.f262G = x;
                this.f265J = aj.m544b(motionEvent, 0);
                break;
            case 1:
                if (this.f256A) {
                    VelocityTracker velocityTracker = this.f266K;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f268M);
                    a = (int) ap.m568a(velocityTracker, this.f265J);
                    this.f300y = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    bs i = m342i();
                    m353a(m325a(i.f321b, ((((float) scrollX) / ((float) clientWidth)) - i.f324e) / i.f323d, a, (int) (aj.m545c(motionEvent, aj.m542a(motionEvent, this.f265J)) - this.f263H)), true, true, a);
                    this.f265J = -1;
                    m343j();
                    z = this.f273R.m916c() | this.f272Q.m916c();
                    break;
                }
                break;
            case 2:
                if (!this.f256A) {
                    a = aj.m542a(motionEvent, this.f265J);
                    float c = aj.m545c(motionEvent, a);
                    float abs = Math.abs(c - this.f261F);
                    float d = aj.m547d(motionEvent, a);
                    x = Math.abs(d - this.f262G);
                    if (abs > ((float) this.f260E) && abs > x) {
                        this.f256A = true;
                        if (c - this.f263H > 0.0f) {
                            x = this.f263H + ((float) this.f260E);
                        } else {
                            x = this.f263H - ((float) this.f260E);
                        }
                        this.f261F = x;
                        this.f262G = d;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                    }
                }
                if (this.f256A) {
                    z = false | m337b(aj.m545c(motionEvent, aj.m542a(motionEvent, this.f265J)));
                    break;
                }
                break;
            case 3:
                if (this.f256A) {
                    m329a(this.f284i, true, 0, false);
                    this.f265J = -1;
                    m343j();
                    z = this.f273R.m916c() | this.f272Q.m916c();
                    break;
                }
                break;
            case 5:
                a = aj.m543b(motionEvent);
                this.f261F = aj.m545c(motionEvent, a);
                this.f265J = aj.m544b(motionEvent, a);
                break;
            case 6:
                m332a(motionEvent);
                this.f261F = aj.m545c(motionEvent, aj.m542a(motionEvent, this.f265J));
                break;
        }
        if (z) {
            au.m585b(this);
        }
        return true;
    }

    private boolean m337b(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.f261F - f;
        this.f261F = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.f294s;
        float f5 = ((float) clientWidth) * this.f295t;
        bs bsVar = (bs) this.f280e.get(0);
        bs bsVar2 = (bs) this.f280e.get(this.f280e.size() - 1);
        if (bsVar.f321b != 0) {
            f4 = bsVar.f324e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (bsVar2.f321b != this.f283h.mo346b() - 1) {
            f2 = bsVar2.f324e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.f272Q.m913a(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.f273R.m913a(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.f261F += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        m338d((int) f4);
        return z3;
    }

    private bs m342i() {
        float f;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        if (clientWidth > 0) {
            f = ((float) this.f290o) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        bs bsVar = null;
        while (i2 < this.f280e.size()) {
            int i3;
            bs bsVar2;
            bs bsVar3 = (bs) this.f280e.get(i2);
            bs bsVar4;
            if (obj != null || bsVar3.f321b == i + 1) {
                bsVar4 = bsVar3;
                i3 = i2;
                bsVar2 = bsVar4;
            } else {
                bsVar3 = this.f281f;
                bsVar3.f324e = (f2 + f3) + f;
                bsVar3.f321b = i + 1;
                bsVar3.f323d = this.f283h.m290c(bsVar3.f321b);
                bsVar4 = bsVar3;
                i3 = i2 - 1;
                bsVar2 = bsVar4;
            }
            f2 = bsVar2.f324e;
            f3 = (bsVar2.f323d + f2) + f;
            if (obj == null && scrollX < f2) {
                return bsVar;
            }
            if (scrollX < f3 || i3 == this.f280e.size() - 1) {
                return bsVar2;
            }
            f3 = f2;
            i = bsVar2.f321b;
            obj = null;
            f2 = bsVar2.f323d;
            bsVar = bsVar2;
            i2 = i3 + 1;
        }
        return bsVar;
    }

    private int m325a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f269N || Math.abs(i2) <= this.f267L) {
            i = (int) ((i >= this.f284i ? 0.4f : 0.6f) + (((float) i) + f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f280e.size() <= 0) {
            return i;
        }
        return Math.max(((bs) this.f280e.get(0)).f321b, Math.min(i, ((bs) this.f280e.get(this.f280e.size() - 1)).f321b));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int a = au.m578a(this);
        if (a == 0 || (a == 1 && this.f283h != null && this.f283h.mo346b() > 1)) {
            int height;
            int width;
            if (!this.f272Q.m912a()) {
                a = canvas.save();
                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.f294s * ((float) width));
                this.f272Q.m911a(height, width);
                i = 0 | this.f272Q.m914a(canvas);
                canvas.restoreToCount(a);
            }
            if (!this.f273R.m912a()) {
                a = canvas.save();
                height = getWidth();
                width = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f295t + 1.0f)) * ((float) height));
                this.f273R.m911a(width, height);
                i |= this.f273R.m914a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.f272Q.m915b();
            this.f273R.m915b();
        }
        if (i != 0) {
            au.m585b(this);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f290o > 0 && this.f291p != null && this.f280e.size() > 0 && this.f283h != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.f290o) / ((float) width);
            bs bsVar = (bs) this.f280e.get(0);
            float f2 = bsVar.f324e;
            int size = this.f280e.size();
            int i = bsVar.f321b;
            int i2 = ((bs) this.f280e.get(size - 1)).f321b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > bsVar.f321b && i3 < size) {
                    i3++;
                    bsVar = (bs) this.f280e.get(i3);
                }
                if (i4 == bsVar.f321b) {
                    f3 = (bsVar.f324e + bsVar.f323d) * ((float) width);
                    f2 = (bsVar.f324e + bsVar.f323d) + f;
                } else {
                    float c = this.f283h.m290c(i4);
                    f3 = (f2 + c) * ((float) width);
                    f2 += c + f;
                }
                if (((float) this.f290o) + f3 > ((float) scrollX)) {
                    this.f291p.setBounds((int) f3, this.f292q, (int) ((((float) this.f290o) + f3) + 0.5f), this.f293r);
                    this.f291p.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    private void m332a(MotionEvent motionEvent) {
        int b = aj.m543b(motionEvent);
        if (aj.m544b(motionEvent, b) == this.f265J) {
            b = b == 0 ? 1 : 0;
            this.f261F = aj.m545c(motionEvent, b);
            this.f265J = aj.m544b(motionEvent, b);
            if (this.f266K != null) {
                this.f266K.clear();
            }
        }
    }

    private void m343j() {
        this.f256A = false;
        this.f257B = false;
        if (this.f266K != null) {
            this.f266K.recycle();
            this.f266K = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f299x != z) {
            this.f299x = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        if (this.f283h == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) clientWidth) * this.f294s))) {
                z = false;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollX >= ((int) (((float) clientWidth) * this.f295t))) {
                z = false;
            }
            return z;
        }
    }

    protected boolean m355a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (m355a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z && au.m584a(view, -i)) {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m354a(keyEvent);
    }

    public boolean m354a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return m360c(17);
            case 22:
                return m360c(66);
            case 61:
                if (VERSION.SDK_INT < 11) {
                    return false;
                }
                if (C0095v.m765a(keyEvent)) {
                    return m360c(2);
                }
                if (C0095v.m766a(keyEvent, 1)) {
                    return m360c(1);
                }
                return false;
            default:
                return false;
        }
    }

    public boolean m360c(int i) {
        View view;
        boolean d;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 17 || i == 1) {
                d = m361d();
            } else {
                if (i == 66 || i == 2) {
                    d = m362e();
                }
                d = false;
            }
        } else if (i == 17) {
            d = (view == null || m326a(this.f282g, findNextFocus).left < m326a(this.f282g, view).left) ? findNextFocus.requestFocus() : m361d();
        } else {
            if (i == 66) {
                d = (view == null || m326a(this.f282g, findNextFocus).left > m326a(this.f282g, view).left) ? findNextFocus.requestFocus() : m362e();
            }
            d = false;
        }
        if (d) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return d;
    }

    private Rect m326a(Rect rect, View view) {
        Rect rect2;
        if (rect == null) {
            rect2 = new Rect();
        } else {
            rect2 = rect;
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    boolean m361d() {
        if (this.f284i <= 0) {
            return false;
        }
        m351a(this.f284i - 1, true);
        return true;
    }

    boolean m362e() {
        if (this.f283h == null || this.f284i >= this.f283h.mo346b() - 1) {
            return false;
        }
        m351a(this.f284i + 1, true);
        return true;
    }

    public void addFocusables(ArrayList arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    bs a = m346a(childAt);
                    if (a != null && a.f321b == this.f284i) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                bs a = m346a(childAt);
                if (a != null && a.f321b == this.f284i) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                bs a = m346a(childAt);
                if (a != null && a.f321b == this.f284i && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                bs a = m346a(childAt);
                if (a != null && a.f321b == this.f284i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new bt();
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof bt) && super.checkLayoutParams(layoutParams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new bt(getContext(), attributeSet);
    }
}
