package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.view.C0159a;
import android.support.v7.p006a.C0130e;
import android.support.v7.p008b.C0149c;
import android.support.v7.p008b.C0154h;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: MyApp */
public class ScrollingTabContainerView extends HorizontalScrollView implements C0193o {
    Runnable f890a;
    int f891b;
    int f892c;
    private aj f893d;
    private LinearLayout f894e;
    private ak f895f;
    private boolean f896g;
    private final LayoutInflater f897h;
    private int f898i;
    private int f899j;

    /* compiled from: MyApp */
    public class TabView extends LinearLayout {
        private C0130e f885a;
        private TextView f886b;
        private ImageView f887c;
        private View f888d;
        private ScrollingTabContainerView f889e;

        public TabView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        void m1524a(ScrollingTabContainerView scrollingTabContainerView, C0130e c0130e, boolean z) {
            this.f889e = scrollingTabContainerView;
            this.f885a = c0130e;
            if (z) {
                setGravity(19);
            }
            m1522a();
        }

        public void m1523a(C0130e c0130e) {
            this.f885a = c0130e;
            m1522a();
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int i3 = this.f889e != null ? this.f889e.f891b : 0;
            if (i3 > 0 && getMeasuredWidth() > i3) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
            }
        }

        public void m1522a() {
            C0130e c0130e = this.f885a;
            View c = c0130e.m1001c();
            if (c != null) {
                TabView parent = c.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(c);
                    }
                    addView(c);
                }
                this.f888d = c;
                if (this.f886b != null) {
                    this.f886b.setVisibility(8);
                }
                if (this.f887c != null) {
                    this.f887c.setVisibility(8);
                    this.f887c.setImageDrawable(null);
                    return;
                }
                return;
            }
            if (this.f888d != null) {
                removeView(this.f888d);
                this.f888d = null;
            }
            Drawable a = c0130e.m999a();
            CharSequence b = c0130e.m1000b();
            if (a != null) {
                if (this.f887c == null) {
                    View imageView = new ImageView(getContext());
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    imageView.setLayoutParams(layoutParams);
                    addView(imageView, 0);
                    this.f887c = imageView;
                }
                this.f887c.setImageDrawable(a);
                this.f887c.setVisibility(0);
            } else if (this.f887c != null) {
                this.f887c.setVisibility(8);
                this.f887c.setImageDrawable(null);
            }
            if (b != null) {
                if (this.f886b == null) {
                    c = new C0165s(getContext(), null, C0149c.actionBarTabTextStyle);
                    c.setEllipsize(TruncateAt.END);
                    LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    c.setLayoutParams(layoutParams2);
                    addView(c);
                    this.f886b = c;
                }
                this.f886b.setText(b);
                this.f886b.setVisibility(0);
            } else if (this.f886b != null) {
                this.f886b.setVisibility(8);
                this.f886b.setText(null);
            }
            if (this.f887c != null) {
                this.f887c.setContentDescription(c0130e.m1003e());
            }
        }

        public C0130e getTab() {
            return this.f885a;
        }
    }

    public void onMeasure(int i, int i2) {
        int i3 = 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f894e.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f891b = -1;
        } else {
            if (childCount > 2) {
                this.f891b = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.f891b = MeasureSpec.getSize(i) / 2;
            }
            this.f891b = Math.min(this.f891b, this.f892c);
        }
        mode = MeasureSpec.makeMeasureSpec(this.f898i, 1073741824);
        if (z || !this.f896g) {
            i3 = 0;
        }
        if (i3 != 0) {
            this.f894e.measure(0, mode);
            if (this.f894e.getMeasuredWidth() > MeasureSpec.getSize(i)) {
                m1530b();
            } else {
                m1531c();
            }
        } else {
            m1531c();
        }
        i3 = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth = getMeasuredWidth();
        if (z && i3 != measuredWidth) {
            setTabSelected(this.f899j);
        }
    }

    private boolean m1529a() {
        return this.f895f != null && this.f895f.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.f896g = z;
    }

    private void m1530b() {
        if (!m1529a()) {
            if (this.f895f == null) {
                this.f895f = m1532d();
            }
            removeView(this.f894e);
            addView(this.f895f, new LayoutParams(-2, -1));
            if (this.f895f.m1453d() == null) {
                this.f895f.mo261a(new ai());
            }
            if (this.f890a != null) {
                removeCallbacks(this.f890a);
                this.f890a = null;
            }
            this.f895f.m1448a(this.f899j);
        }
    }

    private boolean m1531c() {
        if (m1529a()) {
            removeView(this.f895f);
            addView(this.f894e, new LayoutParams(-2, -1));
            setTabSelected(this.f895f.m1435f());
        }
        return false;
    }

    public void setTabSelected(int i) {
        this.f899j = i;
        int childCount = this.f894e.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            boolean z;
            View childAt = this.f894e.getChildAt(i2);
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
            if (z) {
                m1533a(i);
            }
        }
    }

    public void setContentHeight(int i) {
        this.f898i = i;
        requestLayout();
    }

    private ak m1532d() {
        ak akVar = new ak(getContext(), null, C0149c.actionDropDownStyle);
        akVar.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        akVar.m1545b(this);
        return akVar;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        C0159a a = C0159a.m1162a(getContext());
        setContentHeight(a.m1167e());
        this.f892c = a.m1169g();
    }

    public void m1533a(int i) {
        View childAt = this.f894e.getChildAt(i);
        if (this.f890a != null) {
            removeCallbacks(this.f890a);
        }
        this.f890a = new ah(this, childAt);
        post(this.f890a);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f890a != null) {
            post(this.f890a);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f890a != null) {
            removeCallbacks(this.f890a);
        }
    }

    private TabView m1526a(C0130e c0130e, boolean z) {
        TabView tabView = (TabView) this.f897h.inflate(C0154h.abc_action_bar_tab, this.f894e, false);
        tabView.m1524a(this, c0130e, z);
        if (z) {
            tabView.setBackgroundDrawable(null);
            tabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.f898i));
        } else {
            tabView.setFocusable(true);
            if (this.f893d == null) {
                this.f893d = new aj();
            }
            tabView.setOnClickListener(this.f893d);
        }
        return tabView;
    }

    public void mo259a(C0191l c0191l, View view, int i, long j) {
        ((TabView) view).getTab().m1002d();
    }
}
