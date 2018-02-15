package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.p008b.C0157k;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

/* compiled from: MyApp */
public class LinearLayoutICS extends LinearLayout {
    private final Drawable f587a;
    private final int f588b;
    private final int f589c;
    private final int f590d;
    private final int f591e;

    public LinearLayoutICS(Context context, AttributeSet attributeSet) {
        boolean z = true;
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0157k.LinearLayoutICS);
        this.f587a = obtainStyledAttributes.getDrawable(0);
        if (this.f587a != null) {
            this.f588b = this.f587a.getIntrinsicWidth();
            this.f589c = this.f587a.getIntrinsicHeight();
        } else {
            this.f588b = 0;
            this.f589c = 0;
        }
        this.f590d = obtainStyledAttributes.getInt(1, 0);
        this.f591e = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        obtainStyledAttributes.recycle();
        if (this.f587a != null) {
            z = false;
        }
        setWillNotDraw(z);
    }

    public int getSupportDividerWidth() {
        return this.f588b;
    }

    protected void onDraw(Canvas canvas) {
        if (this.f587a != null) {
            if (getOrientation() == 1) {
                m1249a(canvas);
            } else {
                m1252b(canvas);
            }
        }
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        if (this.f587a != null) {
            int indexOfChild = indexOfChild(view);
            int childCount = getChildCount();
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (getOrientation() == 1) {
                if (mo222a(indexOfChild)) {
                    layoutParams.topMargin = this.f589c;
                } else if (indexOfChild == childCount - 1 && mo222a(childCount)) {
                    layoutParams.bottomMargin = this.f589c;
                }
            } else if (mo222a(indexOfChild)) {
                layoutParams.leftMargin = this.f588b;
            } else if (indexOfChild == childCount - 1 && mo222a(childCount)) {
                layoutParams.rightMargin = this.f588b;
            }
        }
        super.measureChildWithMargins(view, i, i2, i3, i4);
    }

    void m1249a(Canvas canvas) {
        int childCount = getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (!(childAt == null || childAt.getVisibility() == 8 || !mo222a(i))) {
                m1250a(canvas, childAt.getTop() - ((LayoutParams) childAt.getLayoutParams()).topMargin);
            }
            i++;
        }
        if (mo222a(childCount)) {
            int height;
            View childAt2 = getChildAt(childCount - 1);
            if (childAt2 == null) {
                height = (getHeight() - getPaddingBottom()) - this.f589c;
            } else {
                height = childAt2.getBottom();
            }
            m1250a(canvas, height);
        }
    }

    void m1252b(Canvas canvas) {
        int childCount = getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (!(childAt == null || childAt.getVisibility() == 8 || !mo222a(i))) {
                m1253b(canvas, childAt.getLeft() - ((LayoutParams) childAt.getLayoutParams()).leftMargin);
            }
            i++;
        }
        if (mo222a(childCount)) {
            int width;
            View childAt2 = getChildAt(childCount - 1);
            if (childAt2 == null) {
                width = (getWidth() - getPaddingRight()) - this.f588b;
            } else {
                width = childAt2.getRight();
            }
            m1253b(canvas, width);
        }
    }

    void m1250a(Canvas canvas, int i) {
        this.f587a.setBounds(getPaddingLeft() + this.f591e, i, (getWidth() - getPaddingRight()) - this.f591e, this.f589c + i);
        this.f587a.draw(canvas);
    }

    void m1253b(Canvas canvas, int i) {
        this.f587a.setBounds(i, getPaddingTop() + this.f591e, this.f588b + i, (getHeight() - getPaddingBottom()) - this.f591e);
        this.f587a.draw(canvas);
    }

    protected boolean mo222a(int i) {
        if (i == 0) {
            if ((this.f590d & 1) != 0) {
                return true;
            }
            return false;
        } else if (i == getChildCount()) {
            if ((this.f590d & 4) == 0) {
                return false;
            }
            return true;
        } else if ((this.f590d & 2) == 0) {
            return false;
        } else {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }
}
