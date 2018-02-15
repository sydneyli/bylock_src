package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.view.menu.ActionMenuPresenter;
import android.support.v7.internal.view.menu.ActionMenuView;
import android.support.v7.internal.view.menu.C0174q;
import android.support.v7.p007c.C0142a;
import android.support.v7.p008b.C0149c;
import android.support.v7.p008b.C0152f;
import android.support.v7.p008b.C0154h;
import android.support.v7.p008b.C0157k;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: MyApp */
public class ActionBarContextView extends C0192a {
    private CharSequence f794g;
    private CharSequence f795h;
    private View f796i;
    private View f797j;
    private LinearLayout f798k;
    private TextView f799l;
    private TextView f800m;
    private int f801n;
    private int f802o;
    private Drawable f803p;
    private boolean f804q;

    public /* bridge */ /* synthetic */ void mo247b() {
        super.mo247b();
    }

    public /* bridge */ /* synthetic */ boolean mo250e() {
        return super.mo250e();
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public /* bridge */ /* synthetic */ void setSplitView(ActionBarContainer actionBarContainer) {
        super.setSplitView(actionBarContainer);
    }

    public /* bridge */ /* synthetic */ void setSplitWhenNarrow(boolean z) {
        super.setSplitWhenNarrow(z);
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0149c.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0157k.ActionMode, i, 0);
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(3));
        this.f801n = obtainStyledAttributes.getResourceId(1, 0);
        this.f802o = obtainStyledAttributes.getResourceId(2, 0);
        this.f = obtainStyledAttributes.getLayoutDimension(0, 0);
        this.f803p = obtainStyledAttributes.getDrawable(4);
        obtainStyledAttributes.recycle();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.b != null) {
            this.b.m1242b();
            this.b.m1245d();
        }
    }

    public void setSplitActionBar(boolean z) {
        if (this.d != z) {
            if (this.b != null) {
                LayoutParams layoutParams = new LayoutParams(-2, -1);
                ViewGroup viewGroup;
                if (z) {
                    this.b.m1231a(getContext().getResources().getDisplayMetrics().widthPixels, true);
                    this.b.m1230a(Integer.MAX_VALUE);
                    layoutParams.width = -1;
                    layoutParams.height = this.f;
                    this.a = (ActionMenuView) this.b.mo216a((ViewGroup) this);
                    this.a.setBackgroundDrawable(this.f803p);
                    viewGroup = (ViewGroup) this.a.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.a);
                    }
                    this.c.addView(this.a, layoutParams);
                } else {
                    this.a = (ActionMenuView) this.b.mo216a((ViewGroup) this);
                    this.a.setBackgroundDrawable(null);
                    viewGroup = (ViewGroup) this.a.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.a);
                    }
                    addView(this.a, layoutParams);
                }
            }
            super.setSplitActionBar(z);
        }
    }

    public void setContentHeight(int i) {
        this.f = i;
    }

    public void setCustomView(View view) {
        if (this.f797j != null) {
            removeView(this.f797j);
        }
        this.f797j = view;
        if (this.f798k != null) {
            removeView(this.f798k);
            this.f798k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.f794g = charSequence;
        m1464h();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f795h = charSequence;
        m1464h();
    }

    public CharSequence getTitle() {
        return this.f794g;
    }

    public CharSequence getSubtitle() {
        return this.f795h;
    }

    private void m1464h() {
        int i;
        int i2 = 8;
        Object obj = 1;
        if (this.f798k == null) {
            LayoutInflater.from(getContext()).inflate(C0154h.abc_action_bar_title_item, this);
            this.f798k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f799l = (TextView) this.f798k.findViewById(C0152f.action_bar_title);
            this.f800m = (TextView) this.f798k.findViewById(C0152f.action_bar_subtitle);
            if (this.f801n != 0) {
                this.f799l.setTextAppearance(getContext(), this.f801n);
            }
            if (this.f802o != 0) {
                this.f800m.setTextAppearance(getContext(), this.f802o);
            }
        }
        this.f799l.setText(this.f794g);
        this.f800m.setText(this.f795h);
        Object obj2 = !TextUtils.isEmpty(this.f794g) ? 1 : null;
        if (TextUtils.isEmpty(this.f795h)) {
            obj = null;
        }
        TextView textView = this.f800m;
        if (obj != null) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        LinearLayout linearLayout = this.f798k;
        if (!(obj2 == null && obj == null)) {
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
        if (this.f798k.getParent() == null) {
            addView(this.f798k);
        }
    }

    public void m1466a(C0142a c0142a) {
        if (this.f796i == null) {
            this.f796i = LayoutInflater.from(getContext()).inflate(C0154h.abc_action_mode_close_item, this, false);
            addView(this.f796i);
        } else if (this.f796i.getParent() == null) {
            addView(this.f796i);
        }
        this.f796i.findViewById(C0152f.action_mode_close_button).setOnClickListener(new C0199f(this, c0142a));
        C0174q c0174q = (C0174q) c0142a.mo200a();
        if (this.b != null) {
            this.b.m1244c();
        }
        this.b = new ActionMenuPresenter(getContext());
        this.b.m1236a(true);
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        if (this.d) {
            this.b.m1231a(getContext().getResources().getDisplayMetrics().widthPixels, true);
            this.b.m1230a(Integer.MAX_VALUE);
            layoutParams.width = -1;
            layoutParams.height = this.f;
            c0174q.m1328a(this.b);
            this.a = (ActionMenuView) this.b.mo216a((ViewGroup) this);
            this.a.setBackgroundDrawable(this.f803p);
            this.c.addView(this.a, layoutParams);
            return;
        }
        c0174q.m1328a(this.b);
        this.a = (ActionMenuView) this.b.mo216a((ViewGroup) this);
        this.a.setBackgroundDrawable(null);
        addView(this.a, layoutParams);
    }

    public void m1472f() {
        if (this.f796i == null) {
            m1473g();
        }
    }

    public void m1473g() {
        removeAllViews();
        if (this.c != null) {
            this.c.removeView(this.a);
        }
        this.f797j = null;
        this.a = null;
    }

    public boolean mo246a() {
        if (this.b != null) {
            return this.b.m1237a();
        }
        return false;
    }

    public boolean mo248c() {
        if (this.b != null) {
            return this.b.m1242b();
        }
        return false;
    }

    public boolean mo249d() {
        if (this.b != null) {
            return this.b.m1246e();
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        int i4 = 0;
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"FILL_PARENT\" (or fill_parent)");
        } else if (MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
        } else {
            int a;
            int size = MeasureSpec.getSize(i);
            int size2 = this.f > 0 ? this.f : MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = size2 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            if (this.f796i != null) {
                a = m1455a(this.f796i, paddingLeft, makeMeasureSpec, 0);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f796i.getLayoutParams();
                paddingLeft = a - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.a != null && this.a.getParent() == this) {
                paddingLeft = m1455a(this.a, paddingLeft, makeMeasureSpec, 0);
            }
            if (this.f798k != null && this.f797j == null) {
                if (this.f804q) {
                    this.f798k.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    a = this.f798k.getMeasuredWidth();
                    makeMeasureSpec = a <= paddingLeft ? 1 : 0;
                    if (makeMeasureSpec != 0) {
                        paddingLeft -= a;
                    }
                    this.f798k.setVisibility(makeMeasureSpec != 0 ? 0 : 8);
                } else {
                    paddingLeft = m1455a(this.f798k, paddingLeft, makeMeasureSpec, 0);
                }
            }
            if (this.f797j != null) {
                int min;
                LayoutParams layoutParams = this.f797j.getLayoutParams();
                if (layoutParams.width != -2) {
                    makeMeasureSpec = 1073741824;
                } else {
                    makeMeasureSpec = Integer.MIN_VALUE;
                }
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                if (layoutParams.height >= 0) {
                    min = Math.min(layoutParams.height, i5);
                } else {
                    min = i5;
                }
                this.f797j.measure(MeasureSpec.makeMeasureSpec(paddingLeft, makeMeasureSpec), MeasureSpec.makeMeasureSpec(min, i3));
            }
            if (this.f <= 0) {
                makeMeasureSpec = getChildCount();
                size2 = 0;
                while (i4 < makeMeasureSpec) {
                    paddingLeft = getChildAt(i4).getMeasuredHeight() + paddingTop;
                    if (paddingLeft <= size2) {
                        paddingLeft = size2;
                    }
                    i4++;
                    size2 = paddingLeft;
                }
                setMeasuredDimension(size, size2);
                return;
            }
            setMeasuredDimension(size, size2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.f796i == null || this.f796i.getVisibility() == 8) {
            i5 = paddingLeft;
        } else {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f796i.getLayoutParams();
            paddingLeft += marginLayoutParams.leftMargin;
            i5 = marginLayoutParams.rightMargin + (paddingLeft + m1458b(this.f796i, paddingLeft, paddingTop, paddingTop2));
        }
        if (!(this.f798k == null || this.f797j != null || this.f798k.getVisibility() == 8)) {
            i5 += m1458b(this.f798k, i5, paddingTop, paddingTop2);
        }
        if (this.f797j != null) {
            i5 += m1458b(this.f797j, i5, paddingTop, paddingTop2);
        }
        i5 = (i3 - i) - getPaddingRight();
        if (this.a != null) {
            i5 -= m1460c(this.a, i5, paddingTop, paddingTop2);
        }
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f804q) {
            requestLayout();
        }
        this.f804q = z;
    }
}
