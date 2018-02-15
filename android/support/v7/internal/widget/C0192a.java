package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.internal.view.menu.ActionMenuPresenter;
import android.support.v7.internal.view.menu.ActionMenuView;
import android.support.v7.p008b.C0148b;
import android.support.v7.p008b.C0149c;
import android.support.v7.p008b.C0150d;
import android.support.v7.p008b.C0157k;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/* compiled from: MyApp */
abstract class C0192a extends ViewGroup {
    protected ActionMenuView f788a;
    protected ActionMenuPresenter f789b;
    protected ActionBarContainer f790c;
    protected boolean f791d;
    protected boolean f792e;
    protected int f793f;

    C0192a(Context context) {
        super(context);
    }

    C0192a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    C0192a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, C0157k.ActionBar, C0149c.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(1, 0));
        obtainStyledAttributes.recycle();
        if (this.f792e) {
            setSplitActionBar(getContext().getResources().getBoolean(C0150d.abc_split_action_bar_is_narrow));
        }
        if (this.f789b != null) {
            this.f789b.m1233a(configuration);
        }
    }

    public void setSplitActionBar(boolean z) {
        this.f791d = z;
    }

    public void setSplitWhenNarrow(boolean z) {
        this.f792e = z;
    }

    public void setContentHeight(int i) {
        this.f793f = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.f793f;
    }

    public void setSplitView(ActionBarContainer actionBarContainer) {
        this.f790c = actionBarContainer;
    }

    public int getAnimatedVisibility() {
        return getVisibility();
    }

    public void mo245a(int i) {
        clearAnimation();
        if (i != getVisibility()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), i == 0 ? C0148b.abc_fade_in : C0148b.abc_fade_out);
            startAnimation(loadAnimation);
            setVisibility(i);
            if (this.f790c != null && this.f788a != null) {
                this.f788a.startAnimation(loadAnimation);
                this.f788a.setVisibility(i);
            }
        }
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            super.setVisibility(i);
        }
    }

    public boolean mo246a() {
        if (this.f789b != null) {
            return this.f789b.m1237a();
        }
        return false;
    }

    public void mo247b() {
        post(new C0195b(this));
    }

    public boolean mo248c() {
        if (this.f789b != null) {
            return this.f789b.m1242b();
        }
        return false;
    }

    public boolean mo249d() {
        if (this.f789b != null) {
            return this.f789b.m1246e();
        }
        return false;
    }

    public boolean mo250e() {
        return this.f789b != null && this.f789b.m1247f();
    }

    protected int m1455a(View view, int i, int i2, int i3) {
        view.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    protected int m1458b(View view, int i, int i2, int i3) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        return measuredWidth;
    }

    protected int m1460c(View view, int i, int i2, int i3) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        return measuredWidth;
    }
}
