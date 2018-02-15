package android.support.v7.internal.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.p008b.C0157k;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.SpinnerAdapter;

/* compiled from: MyApp */
class ak extends AbsSpinnerICS implements OnClickListener {
    int f911E;
    private aq f912F;
    private an f913G;
    private int f914H;
    private Rect f915I;

    ak(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    ak(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.f915I = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0157k.Spinner, i, 0);
        if (i2 == -1) {
            i2 = obtainStyledAttributes.getInt(7, 0);
        }
        switch (i2) {
            case 0:
                this.f912F = new am();
                break;
            case 1:
                aq aoVar = new ao(this, context, attributeSet, i);
                this.f911E = obtainStyledAttributes.getLayoutDimension(3, -2);
                aoVar.m1565a(obtainStyledAttributes.getDrawable(2));
                int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(5, 0);
                if (dimensionPixelOffset != 0) {
                    aoVar.m1574c(dimensionPixelOffset);
                }
                dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(4, 0);
                if (dimensionPixelOffset != 0) {
                    aoVar.m1572b(dimensionPixelOffset);
                }
                this.f912F = aoVar;
                break;
        }
        this.f914H = obtainStyledAttributes.getInt(0, 17);
        this.f912F.mo266a(obtainStyledAttributes.getString(6));
        obtainStyledAttributes.recycle();
        if (this.f913G != null) {
            this.f912F.mo265a(this.f913G);
            this.f913G = null;
        }
    }

    public void mo261a(SpinnerAdapter spinnerAdapter) {
        super.mo261a(spinnerAdapter);
        if (this.f912F != null) {
            this.f912F.mo265a(new an(spinnerAdapter));
        } else {
            this.f913G = new an(spinnerAdapter);
        }
    }

    public int getBaseline() {
        View view = null;
        if (getChildCount() > 0) {
            view = getChildAt(0);
        } else if (this.a != null && this.a.getCount() > 0) {
            view = m1540e(0);
            this.j.m1591a(0, view);
            removeAllViewsInLayout();
        }
        if (view == null) {
            return -1;
        }
        int baseline = view.getBaseline();
        if (baseline >= 0) {
            return view.getTop() + baseline;
        }
        return -1;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f912F != null && this.f912F.mo269f()) {
            this.f912F.mo268d();
        }
    }

    public void mo260a(C0193o c0193o) {
        throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }

    void m1545b(C0193o c0193o) {
        super.mo260a(c0193o);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f912F != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m1541a(m1453d(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.r = true;
        m1544b(0, false);
        this.r = false;
    }

    void m1544b(int i, boolean z) {
        int i2 = this.i.left;
        int right = ((getRight() - getLeft()) - this.i.left) - this.i.right;
        if (this.u) {
            m1440k();
        }
        if (this.z == 0) {
            mo242a();
            return;
        }
        if (this.v >= 0) {
            m1432c(this.v);
        }
        m1451b();
        removeAllViewsInLayout();
        this.k = this.x;
        View e = m1540e(this.x);
        int measuredWidth = e.getMeasuredWidth();
        switch (this.f914H & 7) {
            case 1:
                i2 = (i2 + (right / 2)) - (measuredWidth / 2);
                break;
            case 5:
                i2 = (i2 + right) - measuredWidth;
                break;
        }
        e.offsetLeftAndRight(i2);
        this.j.m1590a();
        invalidate();
        m1441l();
        this.u = false;
        this.p = false;
        m1433d(this.x);
    }

    private View m1540e(int i) {
        View a;
        if (!this.u) {
            a = this.j.m1589a(i);
            if (a != null) {
                m1539c(a);
                return a;
            }
        }
        a = this.a.getView(i, null, this);
        m1539c(a);
        return a;
    }

    private void m1539c(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        addViewInLayout(view, 0, layoutParams);
        view.setSelected(hasFocus());
        view.measure(ViewGroup.getChildMeasureSpec(this.c, this.i.left + this.i.right, layoutParams.width), ViewGroup.getChildMeasureSpec(this.b, this.i.top + this.i.bottom, layoutParams.height));
        int measuredHeight = this.i.top + ((((getMeasuredHeight() - this.i.bottom) - this.i.top) - view.getMeasuredHeight()) / 2);
        view.layout(0, measuredHeight, view.getMeasuredWidth() + 0, view.getMeasuredHeight() + measuredHeight);
    }

    public boolean performClick() {
        boolean performClick = super.performClick();
        if (!performClick) {
            performClick = true;
            if (!this.f912F.mo269f()) {
                this.f912F.mo267c();
            }
        }
        return performClick;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        m1448a(i);
        dialogInterface.dismiss();
    }

    int m1541a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int max = Math.max(0, m1435f());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int i = 0;
        max = 0;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.f915I);
        return (this.f915I.left + this.f915I.right) + i;
    }
}
