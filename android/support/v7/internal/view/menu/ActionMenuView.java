package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.internal.widget.LinearLayoutICS;
import android.support.v7.p008b.C0149c;
import android.support.v7.p008b.C0157k;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;

/* compiled from: MyApp */
public class ActionMenuView extends LinearLayoutICS implements ah, C0168s {
    private C0174q f592a;
    private boolean f593b;
    private ActionMenuPresenter f594c;
    private boolean f595d;
    private int f596e;
    private int f597f;
    private int f598g;
    private int f599h;
    private int f600i;

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m1258a();
    }

    protected /* synthetic */ LinearLayout.LayoutParams m2777generateDefaultLayoutParams() {
        return m1258a();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m1259a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m1260a(layoutParams);
    }

    public /* synthetic */ LinearLayout.LayoutParams m2778generateLayoutParams(AttributeSet attributeSet) {
        return m1259a(attributeSet);
    }

    protected /* synthetic */ LinearLayout.LayoutParams m2779generateLayoutParams(LayoutParams layoutParams) {
        return m1260a(layoutParams);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f597f = (int) (56.0f * f);
        this.f598g = (int) (f * 4.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0157k.ActionBar, C0149c.actionBarStyle, 0);
        this.f600i = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f594c = actionMenuPresenter;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.f594c.mo214c(false);
        if (this.f594c != null && this.f594c.m1246e()) {
            this.f594c.m1242b();
            this.f594c.m1237a();
        }
    }

    protected void onMeasure(int i, int i2) {
        boolean z = this.f595d;
        this.f595d = MeasureSpec.getMode(i) == 1073741824;
        if (z != this.f595d) {
            this.f596e = 0;
        }
        int mode = MeasureSpec.getMode(i);
        if (!(!this.f595d || this.f592a == null || mode == this.f596e)) {
            this.f596e = mode;
            this.f592a.m1340b(true);
        }
        if (this.f595d) {
            m1257a(i, i2);
            return;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            C0184k c0184k = (C0184k) getChildAt(i3).getLayoutParams();
            c0184k.rightMargin = 0;
            c0184k.leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    private void m1257a(int i, int i2) {
        int makeMeasureSpec;
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (mode == 1073741824) {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2 - paddingTop, 1073741824);
        } else {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(Math.min(this.f600i, size2 - paddingTop), Integer.MIN_VALUE);
        }
        int i3 = size - paddingRight;
        int i4 = i3 / this.f597f;
        int i5 = i3 % this.f597f;
        if (i4 == 0) {
            setMeasuredDimension(i3, 0);
            return;
        }
        int i6;
        C0184k c0184k;
        Object obj;
        Object obj2;
        int i7 = this.f597f + (i5 / i4);
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        size = 0;
        Object obj3 = null;
        long j = 0;
        int childCount = getChildCount();
        int i11 = 0;
        while (i11 < childCount) {
            long j2;
            int i12;
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 8) {
                paddingRight = size;
                i6 = i8;
                j2 = j;
                i12 = i4;
                i4 = i9;
            } else {
                int a;
                boolean z = childAt instanceof ActionMenuItemView;
                i6 = size + 1;
                if (z) {
                    childAt.setPadding(this.f598g, 0, this.f598g, 0);
                }
                c0184k = (C0184k) childAt.getLayoutParams();
                c0184k.f700f = false;
                c0184k.f697c = 0;
                c0184k.f696b = 0;
                c0184k.f698d = false;
                c0184k.leftMargin = 0;
                c0184k.rightMargin = 0;
                boolean z2 = z && ((ActionMenuItemView) childAt).m1198b();
                c0184k.f699e = z2;
                if (c0184k.f695a) {
                    size = 1;
                } else {
                    size = i4;
                }
                a = m1256a(childAt, i7, size, makeMeasureSpec, paddingTop);
                i9 = Math.max(i9, a);
                if (c0184k.f698d) {
                    size = i10 + 1;
                } else {
                    size = i10;
                }
                if (c0184k.f695a) {
                    obj = 1;
                } else {
                    obj = obj3;
                }
                int i13 = i4 - a;
                paddingRight = Math.max(i8, childAt.getMeasuredHeight());
                int i14;
                if (a == 1) {
                    long j3 = ((long) (1 << i11)) | j;
                    i12 = i13;
                    obj3 = obj;
                    i14 = i6;
                    i6 = paddingRight;
                    paddingRight = i14;
                    j2 = j3;
                    i4 = i9;
                    i10 = size;
                } else {
                    i10 = size;
                    i4 = i9;
                    i14 = i6;
                    i6 = paddingRight;
                    paddingRight = i14;
                    Object obj4 = obj;
                    j2 = j;
                    i12 = i13;
                    obj3 = obj4;
                }
            }
            i11++;
            i9 = i4;
            i8 = i6;
            i4 = i12;
            j = j2;
            size = paddingRight;
        }
        if (obj3 == null || size != 2) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        Object obj5 = null;
        long j4 = j;
        paddingTop = i4;
        while (i10 > 0 && paddingTop > 0) {
            i6 = Integer.MAX_VALUE;
            j = 0;
            i4 = 0;
            a = 0;
            while (a < childCount) {
                c0184k = (C0184k) getChildAt(a).getLayoutParams();
                if (!c0184k.f698d) {
                    i5 = i4;
                    i4 = i6;
                } else if (c0184k.f696b < i6) {
                    i4 = c0184k.f696b;
                    j = (long) (1 << a);
                    i5 = 1;
                } else if (c0184k.f696b == i6) {
                    j |= (long) (1 << a);
                    i5 = i4 + 1;
                    i4 = i6;
                } else {
                    i5 = i4;
                    i4 = i6;
                }
                a++;
                i6 = i4;
                i4 = i5;
            }
            j4 |= j;
            if (i4 > paddingTop) {
                j = j4;
                break;
            }
            a = i6 + 1;
            i6 = 0;
            i4 = paddingTop;
            long j5 = j4;
            while (i6 < childCount) {
                View childAt2 = getChildAt(i6);
                c0184k = (C0184k) childAt2.getLayoutParams();
                if ((((long) (1 << i6)) & j) != 0) {
                    if (obj2 != null && c0184k.f699e && i4 == 1) {
                        childAt2.setPadding(this.f598g + i7, 0, this.f598g, 0);
                    }
                    c0184k.f696b++;
                    c0184k.f700f = true;
                    i5 = i4 - 1;
                } else if (c0184k.f696b == a) {
                    j5 |= (long) (1 << i6);
                    i5 = i4;
                } else {
                    i5 = i4;
                }
                i6++;
                i4 = i5;
            }
            j4 = j5;
            i11 = 1;
            paddingTop = i4;
        }
        j = j4;
        obj = (obj3 == null && size == 1) ? 1 : null;
        if (paddingTop <= 0 || j == 0 || (paddingTop >= size - 1 && obj == null && i9 <= 1)) {
            obj2 = obj5;
            i4 = paddingTop;
        } else {
            float f;
            View childAt3;
            float bitCount = (float) Long.bitCount(j);
            if (obj == null) {
                if (!((1 & j) == 0 || ((C0184k) getChildAt(0).getLayoutParams()).f699e)) {
                    bitCount -= 0.5f;
                }
                if (!((((long) (1 << (childCount - 1))) & j) == 0 || ((C0184k) getChildAt(childCount - 1).getLayoutParams()).f699e)) {
                    f = bitCount - 0.5f;
                    size = f <= 0.0f ? (int) (((float) (paddingTop * i7)) / f) : 0;
                    i4 = 0;
                    obj2 = obj5;
                    while (i4 < childCount) {
                        if ((((long) (1 << i4)) & j) != 0) {
                            obj = obj2;
                        } else {
                            childAt3 = getChildAt(i4);
                            c0184k = (C0184k) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                c0184k.f697c = size;
                                c0184k.f700f = true;
                                if (i4 == 0 && !c0184k.f699e) {
                                    c0184k.leftMargin = (-size) / 2;
                                }
                                obj = 1;
                            } else if (c0184k.f695a) {
                                if (i4 != 0) {
                                    c0184k.leftMargin = size / 2;
                                }
                                if (i4 != childCount - 1) {
                                    c0184k.rightMargin = size / 2;
                                }
                                obj = obj2;
                            } else {
                                c0184k.f697c = size;
                                c0184k.f700f = true;
                                c0184k.rightMargin = (-size) / 2;
                                obj = 1;
                            }
                        }
                        i4++;
                        obj2 = obj;
                    }
                    i4 = 0;
                }
            }
            f = bitCount;
            if (f <= 0.0f) {
            }
            i4 = 0;
            obj2 = obj5;
            while (i4 < childCount) {
                if ((((long) (1 << i4)) & j) != 0) {
                    childAt3 = getChildAt(i4);
                    c0184k = (C0184k) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        c0184k.f697c = size;
                        c0184k.f700f = true;
                        c0184k.leftMargin = (-size) / 2;
                        obj = 1;
                    } else if (c0184k.f695a) {
                        if (i4 != 0) {
                            c0184k.leftMargin = size / 2;
                        }
                        if (i4 != childCount - 1) {
                            c0184k.rightMargin = size / 2;
                        }
                        obj = obj2;
                    } else {
                        c0184k.f697c = size;
                        c0184k.f700f = true;
                        c0184k.rightMargin = (-size) / 2;
                        obj = 1;
                    }
                } else {
                    obj = obj2;
                }
                i4++;
                obj2 = obj;
            }
            i4 = 0;
        }
        if (obj2 != null) {
            for (size = 0; size < childCount; size++) {
                childAt = getChildAt(size);
                c0184k = (C0184k) childAt.getLayoutParams();
                if (c0184k.f700f) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(c0184k.f697c + (c0184k.f696b * i7), 1073741824), makeMeasureSpec);
                }
            }
        }
        if (mode == 1073741824) {
            i8 = size2;
        }
        setMeasuredDimension(i3, i8);
        this.f599h = i4 * i7;
    }

    static int m1256a(View view, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        boolean z2 = false;
        C0184k c0184k = (C0184k) view.getLayoutParams();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        if (actionMenuItemView == null || !actionMenuItemView.m1198b()) {
            z = false;
        } else {
            z = true;
        }
        if (i2 <= 0 || (z && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z && r1 < 2) {
                i5 = 2;
            }
        }
        if (!c0184k.f695a && z) {
            z2 = true;
        }
        c0184k.f698d = z2;
        c0184k.f696b = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), makeMeasureSpec);
        return i5;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f595d) {
            int i5;
            C0184k c0184k;
            int width;
            int measuredWidth;
            int childCount = getChildCount();
            int i6 = (i2 + i4) / 2;
            int supportDividerWidth = getSupportDividerWidth();
            int i7 = 0;
            int i8 = 0;
            int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
            Object obj = null;
            int i9 = 0;
            while (i9 < childCount) {
                Object obj2;
                View childAt = getChildAt(i9);
                if (childAt.getVisibility() == 8) {
                    obj2 = obj;
                    i5 = paddingRight;
                    paddingRight = i8;
                    i8 = i7;
                } else {
                    c0184k = (C0184k) childAt.getLayoutParams();
                    if (c0184k.f695a) {
                        i5 = childAt.getMeasuredWidth();
                        if (mo222a(i9)) {
                            i5 += supportDividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        width = (getWidth() - getPaddingRight()) - c0184k.rightMargin;
                        int i10 = i6 - (measuredHeight / 2);
                        childAt.layout(width - i5, i10, width, measuredHeight + i10);
                        i5 = paddingRight - i5;
                        obj2 = 1;
                        paddingRight = i8;
                        i8 = i7;
                    } else {
                        measuredWidth = (childAt.getMeasuredWidth() + c0184k.leftMargin) + c0184k.rightMargin;
                        width = i7 + measuredWidth;
                        paddingRight -= measuredWidth;
                        if (mo222a(i9)) {
                            width += supportDividerWidth;
                        }
                        Object obj3 = obj;
                        i5 = paddingRight;
                        paddingRight = i8 + 1;
                        i8 = width;
                        obj2 = obj3;
                    }
                }
                i9++;
                i7 = i8;
                i8 = paddingRight;
                paddingRight = i5;
                obj = obj2;
            }
            if (childCount == 1 && obj == null) {
                View childAt2 = getChildAt(0);
                i5 = childAt2.getMeasuredWidth();
                paddingRight = childAt2.getMeasuredHeight();
                i8 = ((i3 - i) / 2) - (i5 / 2);
                i7 = i6 - (paddingRight / 2);
                childAt2.layout(i8, i7, i5 + i8, paddingRight + i7);
                return;
            }
            width = i8 - (obj != null ? 0 : 1);
            i8 = Math.max(0, width > 0 ? paddingRight / width : 0);
            i5 = getPaddingLeft();
            paddingRight = 0;
            while (paddingRight < childCount) {
                View childAt3 = getChildAt(paddingRight);
                c0184k = (C0184k) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8) {
                    width = i5;
                } else if (c0184k.f695a) {
                    width = i5;
                } else {
                    i5 += c0184k.leftMargin;
                    i9 = childAt3.getMeasuredWidth();
                    supportDividerWidth = childAt3.getMeasuredHeight();
                    measuredWidth = i6 - (supportDividerWidth / 2);
                    childAt3.layout(i5, measuredWidth, i5 + i9, supportDividerWidth + measuredWidth);
                    width = ((c0184k.rightMargin + i9) + i8) + i5;
                }
                paddingRight++;
                i5 = width;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f594c.m1244c();
    }

    public void setOverflowReserved(boolean z) {
        this.f593b = z;
    }

    protected C0184k m1258a() {
        C0184k c0184k = new C0184k(-2, -2);
        c0184k.gravity = 16;
        return c0184k;
    }

    public C0184k m1259a(AttributeSet attributeSet) {
        return new C0184k(getContext(), attributeSet);
    }

    protected C0184k m1260a(LayoutParams layoutParams) {
        if (!(layoutParams instanceof C0184k)) {
            return m1258a();
        }
        C0184k c0184k = new C0184k((C0184k) layoutParams);
        if (c0184k.gravity > 0) {
            return c0184k;
        }
        c0184k.gravity = 16;
        return c0184k;
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof C0184k);
    }

    public C0184k m1264b() {
        C0184k a = m1258a();
        a.f695a = true;
        return a;
    }

    public boolean mo223a(C0187u c0187u) {
        return this.f592a.m1336a((MenuItem) c0187u, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void mo221a(C0174q c0174q) {
        this.f592a = c0174q;
    }

    protected boolean mo222a(int i) {
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        boolean z = false;
        if (i < getChildCount() && (childAt instanceof C0166j)) {
            z = 0 | ((C0166j) childAt).mo207d();
        }
        if (i <= 0 || !(childAt2 instanceof C0166j)) {
            return z;
        }
        return ((C0166j) childAt2).mo206c() | z;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }
}
