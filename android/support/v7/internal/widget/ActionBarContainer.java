package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.p008b.C0152f;
import android.support.v7.p008b.C0157k;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

/* compiled from: MyApp */
public class ActionBarContainer extends FrameLayout {
    private boolean f780a;
    private View f781b;
    private ActionBarView f782c;
    private Drawable f783d;
    private Drawable f784e;
    private Drawable f785f;
    private boolean f786g;
    private boolean f787h;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        boolean z = true;
        super(context, attributeSet);
        setBackgroundDrawable(null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0157k.ActionBar);
        this.f783d = obtainStyledAttributes.getDrawable(10);
        this.f784e = obtainStyledAttributes.getDrawable(11);
        if (getId() == C0152f.split_action_bar) {
            this.f786g = true;
            this.f785f = obtainStyledAttributes.getDrawable(12);
        }
        obtainStyledAttributes.recycle();
        if (this.f786g) {
            if (this.f785f != null) {
                z = false;
            }
        } else if (!(this.f783d == null && this.f784e == null)) {
            z = false;
        }
        setWillNotDraw(z);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f782c = (ActionBarView) findViewById(C0152f.action_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.f783d != null) {
            this.f783d.setCallback(null);
            unscheduleDrawable(this.f783d);
        }
        this.f783d = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        if (this.f786g) {
            if (this.f785f != null) {
                z = false;
            }
        } else if (!(this.f783d == null && this.f784e == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.f784e != null) {
            this.f784e.setCallback(null);
            unscheduleDrawable(this.f784e);
        }
        this.f784e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        if (this.f786g) {
            if (this.f785f != null) {
                z = false;
            }
        } else if (!(this.f783d == null && this.f784e == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.f785f != null) {
            this.f785f.setCallback(null);
            unscheduleDrawable(this.f785f);
        }
        this.f785f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        if (this.f786g) {
            if (this.f785f != null) {
                z = false;
            }
        } else if (!(this.f783d == null && this.f784e == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f783d != null) {
            this.f783d.setVisible(z, false);
        }
        if (this.f784e != null) {
            this.f784e.setVisible(z, false);
        }
        if (this.f785f != null) {
            this.f785f.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f783d && !this.f786g) || ((drawable == this.f784e && this.f787h) || ((drawable == this.f785f && this.f786g) || super.verifyDrawable(drawable)));
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f783d != null && this.f783d.isStateful()) {
            this.f783d.setState(getDrawableState());
        }
        if (this.f784e != null && this.f784e.isStateful()) {
            this.f784e.setState(getDrawableState());
        }
        if (this.f785f != null && this.f785f.isStateful()) {
            this.f785f.setState(getDrawableState());
        }
    }

    public void setTransitioning(boolean z) {
        this.f780a = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f780a || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.f781b != null) {
            removeView(this.f781b);
        }
        this.f781b = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.f781b;
    }

    public void onDraw(Canvas canvas) {
        if (getWidth() != 0 && getHeight() != 0) {
            if (!this.f786g) {
                if (this.f783d != null) {
                    this.f783d.draw(canvas);
                }
                if (this.f784e != null && this.f787h) {
                    this.f784e.draw(canvas);
                }
            } else if (this.f785f != null) {
                this.f785f.draw(canvas);
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f782c != null) {
            int i3;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f782c.getLayoutParams();
            if (this.f782c.m1508l()) {
                i3 = 0;
            } else {
                i3 = layoutParams.bottomMargin + (this.f782c.getMeasuredHeight() + layoutParams.topMargin);
            }
            if (this.f781b != null && this.f781b.getVisibility() != 8 && MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
                setMeasuredDimension(getMeasuredWidth(), Math.min(i3 + this.f781b.getMeasuredHeight(), MeasureSpec.getSize(i2)));
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2 = true;
        boolean z3 = false;
        super.onLayout(z, i, i2, i3, i4);
        boolean z4 = (this.f781b == null || this.f781b.getVisibility() == 8) ? false : true;
        if (!(this.f781b == null || this.f781b.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            int measuredHeight2 = this.f781b.getMeasuredHeight();
            if ((this.f782c.getDisplayOptions() & 2) == 0) {
                int childCount = getChildCount();
                for (measuredHeight = 0; measuredHeight < childCount; measuredHeight++) {
                    View childAt = getChildAt(measuredHeight);
                    if (!(childAt == this.f781b || this.f782c.m1508l())) {
                        childAt.offsetTopAndBottom(measuredHeight2);
                    }
                }
                this.f781b.layout(i, 0, i3, measuredHeight2);
            } else {
                this.f781b.layout(i, measuredHeight - measuredHeight2, i3, measuredHeight);
            }
        }
        if (!this.f786g) {
            boolean z5;
            if (this.f783d != null) {
                this.f783d.setBounds(this.f782c.getLeft(), this.f782c.getTop(), this.f782c.getRight(), this.f782c.getBottom());
                z5 = true;
            } else {
                z5 = false;
            }
            if (z4 && this.f784e != null) {
                z3 = true;
            }
            this.f787h = z3;
            if (z3) {
                this.f784e.setBounds(this.f781b.getLeft(), this.f781b.getTop(), this.f781b.getRight(), this.f781b.getBottom());
            } else {
                z2 = z5;
            }
        } else if (this.f785f != null) {
            this.f785f.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            z2 = false;
        }
        if (z2) {
            invalidate();
        }
    }
}
