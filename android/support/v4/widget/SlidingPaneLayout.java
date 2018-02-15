package android.support.v4.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.au;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;

/* compiled from: MyApp */
public class SlidingPaneLayout extends ViewGroup {
    static final ab f369a;
    private int f370b;
    private int f371c;
    private Drawable f372d;
    private final int f373e;
    private boolean f374f;
    private View f375g;
    private float f376h;
    private float f377i;
    private int f378j;
    private boolean f379k;
    private int f380l;
    private float f381m;
    private float f382n;
    private C0125z f383o;
    private final af f384p;
    private boolean f385q;
    private boolean f386r;
    private final Rect f387s;
    private final ArrayList f388t;

    /* compiled from: MyApp */
    class SavedState extends BaseSavedState {
        public static final Creator CREATOR = new aa();
        boolean f368a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f368a = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f368a ? 1 : 0);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            f369a = new ae();
        } else if (i >= 16) {
            f369a = new ad();
        } else {
            f369a = new ac();
        }
    }

    public void setParallaxDistance(int i) {
        this.f380l = i;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.f380l;
    }

    public void setSliderFadeColor(int i) {
        this.f370b = i;
    }

    public int getSliderFadeColor() {
        return this.f370b;
    }

    public void setCoveredFadeColor(int i) {
        this.f371c = i;
    }

    public int getCoveredFadeColor() {
        return this.f371c;
    }

    public void setPanelSlideListener(C0125z c0125z) {
        this.f383o = c0125z;
    }

    void m814a(View view) {
        int i;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        int i2;
        int i3;
        int i4;
        if (view == null || !m811c(view)) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i = 0;
        } else {
            i = view.getLeft();
            i4 = view.getRight();
            i3 = view.getTop();
            i2 = view.getBottom();
        }
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != view) {
                int max = Math.max(paddingLeft, childAt.getLeft());
                int max2 = Math.max(paddingTop, childAt.getTop());
                int min = Math.min(width, childAt.getRight());
                int min2 = Math.min(height, childAt.getBottom());
                if (max < i || max2 < r2 || min > r3 || min2 > r1) {
                    max = 0;
                } else {
                    max = 4;
                }
                childAt.setVisibility(max);
                i5++;
            } else {
                return;
            }
        }
    }

    void m813a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    private static boolean m811c(View view) {
        if (au.m590f(view)) {
            return true;
        }
        if (VERSION.SDK_INT >= 18) {
            return false;
        }
        Drawable background = view.getBackground();
        if (background == null) {
            return false;
        }
        if (background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f386r = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f386r = true;
        int size = this.f388t.size();
        for (int i = 0; i < size; i++) {
            ((C0123x) this.f388t.get(i)).run();
        }
        this.f388t.clear();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            if (mode2 == 0) {
                if (!isInEditMode()) {
                    throw new IllegalStateException("Height must not be UNSPECIFIED");
                } else if (mode2 == 0) {
                    i3 = Integer.MIN_VALUE;
                    i4 = size;
                    size = 300;
                }
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        } else if (!isInEditMode()) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        } else if (mode == Integer.MIN_VALUE) {
            i3 = mode2;
            i4 = size;
            size = size2;
        } else {
            if (mode == 0) {
                i3 = mode2;
                i4 = 300;
                size = size2;
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        }
        switch (i3) {
            case Integer.MIN_VALUE:
                size2 = 0;
                mode2 = (size - getPaddingTop()) - getPaddingBottom();
                break;
            case 1073741824:
                size2 = (size - getPaddingTop()) - getPaddingBottom();
                mode2 = size2;
                break;
            default:
                size2 = 0;
                mode2 = -1;
                break;
        }
        boolean z = false;
        int paddingLeft = (i4 - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.f375g = null;
        int i6 = 0;
        int i7 = size2;
        float f = 0.0f;
        while (i6 < childCount) {
            float f2;
            boolean z2;
            View childAt = getChildAt(i6);
            C0124y c0124y = (C0124y) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                c0124y.f446c = false;
                size2 = paddingLeft;
                f2 = f;
                i5 = i7;
                z2 = z;
            } else {
                if (c0124y.f444a > 0.0f) {
                    f += c0124y.f444a;
                    if (c0124y.width == 0) {
                        size2 = paddingLeft;
                        f2 = f;
                        i5 = i7;
                        z2 = z;
                    }
                }
                mode = c0124y.leftMargin + c0124y.rightMargin;
                if (c0124y.width == -2) {
                    mode = MeasureSpec.makeMeasureSpec(i4 - mode, Integer.MIN_VALUE);
                } else if (c0124y.width == -1) {
                    mode = MeasureSpec.makeMeasureSpec(i4 - mode, 1073741824);
                } else {
                    mode = MeasureSpec.makeMeasureSpec(c0124y.width, 1073741824);
                }
                if (c0124y.height == -2) {
                    i5 = MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE);
                } else if (c0124y.height == -1) {
                    i5 = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                } else {
                    i5 = MeasureSpec.makeMeasureSpec(c0124y.height, 1073741824);
                }
                childAt.measure(mode, i5);
                mode = childAt.getMeasuredWidth();
                i5 = childAt.getMeasuredHeight();
                if (i3 == Integer.MIN_VALUE && i5 > i7) {
                    i7 = Math.min(i5, mode2);
                }
                i5 = paddingLeft - mode;
                boolean z3 = i5 < 0;
                c0124y.f445b = z3;
                z3 |= z;
                if (c0124y.f445b) {
                    this.f375g = childAt;
                }
                size2 = i5;
                i5 = i7;
                float f3 = f;
                z2 = z3;
                f2 = f3;
            }
            i6++;
            z = z2;
            i7 = i5;
            f = f2;
            paddingLeft = size2;
        }
        if (z || f > 0.0f) {
            int i8 = i4 - this.f373e;
            for (i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getVisibility() != 8) {
                    c0124y = (C0124y) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        Object obj = (c0124y.width != 0 || c0124y.f444a <= 0.0f) ? null : 1;
                        i5 = obj != null ? 0 : childAt2.getMeasuredWidth();
                        if (!z || childAt2 == this.f375g) {
                            if (c0124y.f444a > 0.0f) {
                                if (c0124y.width != 0) {
                                    mode = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                } else if (c0124y.height == -2) {
                                    mode = MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE);
                                } else if (c0124y.height == -1) {
                                    mode = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                                } else {
                                    mode = MeasureSpec.makeMeasureSpec(c0124y.height, 1073741824);
                                }
                                if (z) {
                                    size2 = i4 - (c0124y.rightMargin + c0124y.leftMargin);
                                    i6 = MeasureSpec.makeMeasureSpec(size2, 1073741824);
                                    if (i5 != size2) {
                                        childAt2.measure(i6, mode);
                                    }
                                } else {
                                    childAt2.measure(MeasureSpec.makeMeasureSpec(((int) ((c0124y.f444a * ((float) Math.max(0, paddingLeft))) / f)) + i5, 1073741824), mode);
                                }
                            }
                        } else if (c0124y.width < 0 && (i5 > i8 || c0124y.f444a > 0.0f)) {
                            if (obj == null) {
                                size2 = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            } else if (c0124y.height == -2) {
                                size2 = MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE);
                            } else if (c0124y.height == -1) {
                                size2 = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                            } else {
                                size2 = MeasureSpec.makeMeasureSpec(c0124y.height, 1073741824);
                            }
                            childAt2.measure(MeasureSpec.makeMeasureSpec(i8, 1073741824), size2);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i4, i7);
        this.f374f = z;
        if (this.f384p.m859a() != 0 && !z) {
            this.f384p.m878f();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f386r) {
            float f = (this.f374f && this.f385q) ? 1.0f : 0.0f;
            this.f376h = f;
        }
        int i6 = 0;
        int i7 = paddingLeft;
        while (i6 < childCount) {
            int i8;
            int i9;
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                i8 = i7;
            } else {
                C0124y c0124y = (C0124y) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (c0124y.f445b) {
                    int min = (Math.min(paddingLeft, (i5 - paddingRight) - this.f373e) - i7) - (c0124y.leftMargin + c0124y.rightMargin);
                    this.f378j = min;
                    c0124y.f446c = ((c0124y.leftMargin + i7) + min) + (measuredWidth / 2) > i5 - paddingRight;
                    i8 = (c0124y.leftMargin + ((int) (((float) min) * this.f376h))) + i7;
                    i9 = 0;
                } else if (!this.f374f || this.f380l == 0) {
                    i9 = 0;
                    i8 = paddingLeft;
                } else {
                    i9 = (int) ((1.0f - this.f376h) * ((float) this.f380l));
                    i8 = paddingLeft;
                }
                i9 = i8 - i9;
                childAt.layout(i9, paddingTop, i9 + measuredWidth, childAt.getMeasuredHeight() + paddingTop);
                paddingLeft += childAt.getWidth();
            }
            i6++;
            i7 = i8;
        }
        if (this.f386r) {
            if (this.f374f) {
                if (this.f380l != 0) {
                    m806a(this.f376h);
                }
                if (((C0124y) this.f375g.getLayoutParams()).f446c) {
                    m808a(this.f375g, this.f376h, this.f370b);
                }
            } else {
                for (i9 = 0; i9 < childCount; i9++) {
                    m808a(getChildAt(i9), 0.0f, this.f370b);
                }
            }
            m814a(this.f375g);
        }
        this.f386r = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.f386r = true;
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.f374f) {
            this.f385q = view == this.f375g;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r2 = 0;
        r1 = 1;
        r3 = android.support.v4.view.aj.m541a(r8);
        r0 = r7.f374f;
        if (r0 != 0) goto L_0x002d;
    L_0x000a:
        if (r3 != 0) goto L_0x002d;
    L_0x000c:
        r0 = r7.getChildCount();
        if (r0 <= r1) goto L_0x002d;
    L_0x0012:
        r0 = r7.getChildAt(r1);
        if (r0 == 0) goto L_0x002d;
    L_0x0018:
        r4 = r7.f384p;
        r5 = r8.getX();
        r5 = (int) r5;
        r6 = r8.getY();
        r6 = (int) r6;
        r0 = r4.m871b(r0, r5, r6);
        if (r0 != 0) goto L_0x0041;
    L_0x002a:
        r0 = r1;
    L_0x002b:
        r7.f385q = r0;
    L_0x002d:
        r0 = r7.f374f;
        if (r0 == 0) goto L_0x0037;
    L_0x0031:
        r0 = r7.f379k;
        if (r0 == 0) goto L_0x0043;
    L_0x0035:
        if (r3 == 0) goto L_0x0043;
    L_0x0037:
        r0 = r7.f384p;
        r0.m877e();
        r2 = super.onInterceptTouchEvent(r8);
    L_0x0040:
        return r2;
    L_0x0041:
        r0 = r2;
        goto L_0x002b;
    L_0x0043:
        r0 = 3;
        if (r3 == r0) goto L_0x0048;
    L_0x0046:
        if (r3 != r1) goto L_0x004e;
    L_0x0048:
        r0 = r7.f384p;
        r0.m877e();
        goto L_0x0040;
    L_0x004e:
        switch(r3) {
            case 0: goto L_0x005e;
            case 1: goto L_0x0051;
            case 2: goto L_0x0082;
            default: goto L_0x0051;
        };
    L_0x0051:
        r0 = r2;
    L_0x0052:
        r3 = r7.f384p;
        r3 = r3.m863a(r8);
        if (r3 != 0) goto L_0x005c;
    L_0x005a:
        if (r0 == 0) goto L_0x0040;
    L_0x005c:
        r2 = r1;
        goto L_0x0040;
    L_0x005e:
        r7.f379k = r2;
        r0 = r8.getX();
        r3 = r8.getY();
        r7.f381m = r0;
        r7.f382n = r3;
        r4 = r7.f384p;
        r5 = r7.f375g;
        r0 = (int) r0;
        r3 = (int) r3;
        r0 = r4.m871b(r5, r0, r3);
        if (r0 == 0) goto L_0x0051;
    L_0x0078:
        r0 = r7.f375g;
        r0 = r7.m817b(r0);
        if (r0 == 0) goto L_0x0051;
    L_0x0080:
        r0 = r1;
        goto L_0x0052;
    L_0x0082:
        r0 = r8.getX();
        r3 = r8.getY();
        r4 = r7.f381m;
        r0 = r0 - r4;
        r0 = java.lang.Math.abs(r0);
        r4 = r7.f382n;
        r3 = r3 - r4;
        r3 = java.lang.Math.abs(r3);
        r4 = r7.f384p;
        r4 = r4.m875d();
        r4 = (float) r4;
        r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x0051;
    L_0x00a3:
        r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x0051;
    L_0x00a7:
        r0 = r7.f384p;
        r0.m877e();
        r7.f379k = r1;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f374f) {
            return super.onTouchEvent(motionEvent);
        }
        this.f384p.m868b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.f381m = x;
                this.f382n = y;
                return true;
            case 1:
                if (!m817b(this.f375g)) {
                    return true;
                }
                x = motionEvent.getX();
                y = motionEvent.getY();
                float f = x - this.f381m;
                float f2 = y - this.f382n;
                int d = this.f384p.m875d();
                if ((f * f) + (f2 * f2) >= ((float) (d * d)) || !this.f384p.m871b(this.f375g, (int) x, (int) y)) {
                    return true;
                }
                m809a(this.f375g, 0);
                return true;
            default:
                return true;
        }
    }

    private boolean m809a(View view, int i) {
        if (!this.f386r && !m815a(0.0f, i)) {
            return false;
        }
        this.f385q = false;
        return true;
    }

    private boolean m810b(View view, int i) {
        if (!this.f386r && !m815a(1.0f, i)) {
            return false;
        }
        this.f385q = true;
        return true;
    }

    public boolean m816b() {
        return m810b(this.f375g, 0);
    }

    public boolean m818c() {
        return m809a(this.f375g, 0);
    }

    public boolean m819d() {
        return !this.f374f || this.f376h == 1.0f;
    }

    public boolean m820e() {
        return this.f374f;
    }

    private void m808a(View view, float f, int i) {
        C0124y c0124y = (C0124y) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) (((float) ((-16777216 & i) >>> 24)) * f)) << 24) | (16777215 & i);
            if (c0124y.f447d == null) {
                c0124y.f447d = new Paint();
            }
            c0124y.f447d.setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_OVER));
            if (au.m588d(view) != 2) {
                au.m580a(view, 2, c0124y.f447d);
            }
            m812d(view);
        } else if (au.m588d(view) != 0) {
            if (c0124y.f447d != null) {
                c0124y.f447d.setColorFilter(null);
            }
            Runnable c0123x = new C0123x(this, view);
            this.f388t.add(c0123x);
            au.m583a((View) this, c0123x);
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild;
        C0124y c0124y = (C0124y) view.getLayoutParams();
        int save = canvas.save(2);
        if (!(!this.f374f || c0124y.f445b || this.f375g == null)) {
            canvas.getClipBounds(this.f387s);
            this.f387s.right = Math.min(this.f387s.right, this.f375g.getLeft());
            canvas.clipRect(this.f387s);
        }
        if (VERSION.SDK_INT >= 11) {
            drawChild = super.drawChild(canvas, view, j);
        } else if (!c0124y.f446c || this.f376h <= 0.0f) {
            if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
            drawChild = super.drawChild(canvas, view, j);
        } else {
            if (!view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(true);
            }
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                canvas.drawBitmap(drawingCache, (float) view.getLeft(), (float) view.getTop(), c0124y.f447d);
                drawChild = false;
            } else {
                Log.e("SlidingPaneLayout", "drawChild: child view " + view + " returned null drawing cache");
                drawChild = super.drawChild(canvas, view, j);
            }
        }
        canvas.restoreToCount(save);
        return drawChild;
    }

    private void m812d(View view) {
        f369a.mo124a(this, view);
    }

    boolean m815a(float f, int i) {
        if (!this.f374f) {
            return false;
        }
        C0124y c0124y = (C0124y) this.f375g.getLayoutParams();
        if (!this.f384p.m864a(this.f375g, (int) (((float) (c0124y.leftMargin + getPaddingLeft())) + (((float) this.f378j) * f)), this.f375g.getTop())) {
            return false;
        }
        m813a();
        au.m585b(this);
        return true;
    }

    public void computeScroll() {
        if (!this.f384p.m865a(true)) {
            return;
        }
        if (this.f374f) {
            au.m585b(this);
        } else {
            this.f384p.m878f();
        }
    }

    public void setShadowDrawable(Drawable drawable) {
        this.f372d = drawable;
    }

    public void setShadowResource(int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && this.f372d != null) {
            int intrinsicWidth = this.f372d.getIntrinsicWidth();
            int left = childAt.getLeft();
            this.f372d.setBounds(left - intrinsicWidth, childAt.getTop(), left, childAt.getBottom());
            this.f372d.draw(canvas);
        }
    }

    private void m806a(float f) {
        int i;
        int i2 = 0;
        C0124y c0124y = (C0124y) this.f375g.getLayoutParams();
        if (!c0124y.f446c || c0124y.leftMargin > 0) {
            i = 0;
        } else {
            i = 1;
        }
        int childCount = getChildCount();
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            if (childAt != this.f375g) {
                int i3 = (int) ((1.0f - this.f377i) * ((float) this.f380l));
                this.f377i = f;
                childAt.offsetLeftAndRight(i3 - ((int) ((1.0f - f) * ((float) this.f380l))));
                if (i != 0) {
                    m808a(childAt, 1.0f - this.f377i, this.f371c);
                }
            }
            i2++;
        }
    }

    boolean m817b(View view) {
        if (view == null) {
            return false;
        }
        boolean z = this.f374f && ((C0124y) view.getLayoutParams()).f446c && this.f376h > 0.0f;
        return z;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C0124y();
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new C0124y((MarginLayoutParams) layoutParams) : new C0124y(layoutParams);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0124y) && super.checkLayoutParams(layoutParams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0124y(getContext(), attributeSet);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f368a = m820e() ? m819d() : this.f385q;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f368a) {
            m816b();
        } else {
            m818c();
        }
        this.f385q = savedState.f368a;
    }
}
