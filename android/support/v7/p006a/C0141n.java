package android.support.v7.p006a;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.support.v7.internal.view.C0159a;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.support.v7.internal.widget.ActionBarView;
import android.support.v7.internal.widget.ScrollingTabContainerView;
import android.support.v7.p007c.C0136b;
import android.support.v7.p007c.C0142a;
import android.support.v7.p008b.C0148b;
import android.support.v7.p008b.C0149c;
import android.support.v7.p008b.C0152f;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;

/* compiled from: MyApp */
class C0141n extends C0126a {
    private C0127b f471A;
    C0143o f472a;
    C0142a f473b;
    C0136b f474c;
    final Handler f475d = new Handler();
    private Context f476e;
    private Context f477f;
    private C0131f f478g;
    private ActionBarOverlayLayout f479h;
    private ActionBarContainer f480i;
    private ViewGroup f481j;
    private ActionBarView f482k;
    private ActionBarContextView f483l;
    private ActionBarContainer f484m;
    private ScrollingTabContainerView f485n;
    private ArrayList f486o = new ArrayList();
    private int f487p = -1;
    private boolean f488q;
    private ArrayList f489r = new ArrayList();
    private int f490s;
    private boolean f491t;
    private int f492u = 0;
    private boolean f493v;
    private boolean f494w;
    private boolean f495x;
    private boolean f496y = true;
    private boolean f497z;

    public C0141n(C0131f c0131f, C0127b c0127b) {
        this.f478g = c0131f;
        this.f476e = c0131f;
        this.f471A = c0127b;
        m1107a(this.f478g);
    }

    private void m1107a(C0131f c0131f) {
        boolean z = false;
        this.f479h = (ActionBarOverlayLayout) c0131f.findViewById(C0152f.action_bar_overlay_layout);
        if (this.f479h != null) {
            this.f479h.setActionBar(this);
        }
        this.f482k = (ActionBarView) c0131f.findViewById(C0152f.action_bar);
        this.f483l = (ActionBarContextView) c0131f.findViewById(C0152f.action_context_bar);
        this.f480i = (ActionBarContainer) c0131f.findViewById(C0152f.action_bar_container);
        this.f481j = (ViewGroup) c0131f.findViewById(C0152f.top_action_bar);
        if (this.f481j == null) {
            this.f481j = this.f480i;
        }
        this.f484m = (ActionBarContainer) c0131f.findViewById(C0152f.split_action_bar);
        if (this.f482k == null || this.f483l == null || this.f480i == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        boolean z2;
        this.f482k.setContextView(this.f483l);
        this.f490s = this.f482k.m1504h() ? 1 : 0;
        if ((this.f482k.getDisplayOptions() & 4) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.f488q = true;
        }
        C0159a a = C0159a.m1162a(this.f476e);
        if (a.m1168f() || z2) {
            z = true;
        }
        mo199e(z);
        m1114j(a.m1166d());
        mo192a(this.f478g.getTitle());
    }

    public void m1120a(Configuration configuration) {
        m1114j(C0159a.m1162a(this.f476e).m1166d());
    }

    private void m1114j(boolean z) {
        boolean z2;
        boolean z3 = true;
        this.f491t = z;
        if (this.f491t) {
            this.f480i.setTabContainer(null);
            this.f482k.setEmbeddedTabView(this.f485n);
        } else {
            this.f482k.setEmbeddedTabView(null);
            this.f480i.setTabContainer(this.f485n);
        }
        if (m1127c() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f485n != null) {
            if (z2) {
                this.f485n.setVisibility(0);
            } else {
                this.f485n.setVisibility(8);
            }
        }
        ActionBarView actionBarView = this.f482k;
        if (this.f491t || !z2) {
            z3 = false;
        }
        actionBarView.setCollapsable(z3);
    }

    public void mo191a(View view) {
        this.f482k.setCustomNavigationView(view);
    }

    public void mo190a(int i) {
        this.f482k.setLogo(i);
    }

    public void mo192a(CharSequence charSequence) {
        this.f482k.setTitle(charSequence);
    }

    public void mo195b(int i) {
        if ((i & 4) != 0) {
            this.f488q = true;
        }
        this.f482k.setDisplayOptions(i);
    }

    public void m1119a(int i, int i2) {
        int displayOptions = this.f482k.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.f488q = true;
        }
        this.f482k.setDisplayOptions((displayOptions & (i2 ^ -1)) | (i & i2));
    }

    public void mo193a(boolean z) {
        m1119a(z ? 1 : 0, 1);
    }

    public void mo196b(boolean z) {
        m1119a(z ? 2 : 0, 2);
    }

    public void mo197c(boolean z) {
        m1119a(z ? 4 : 0, 4);
    }

    public void mo198d(boolean z) {
        m1119a(z ? 8 : 0, 8);
    }

    public void mo199e(boolean z) {
        this.f482k.setHomeButtonEnabled(z);
    }

    public int m1127c() {
        return this.f482k.getNavigationMode();
    }

    public int mo189a() {
        return this.f482k.getDisplayOptions();
    }

    public Context mo194b() {
        if (this.f477f == null) {
            TypedValue typedValue = new TypedValue();
            this.f476e.getTheme().resolveAttribute(C0149c.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f477f = new ContextThemeWrapper(this.f476e, i);
            } else {
                this.f477f = this.f476e;
            }
        }
        return this.f477f;
    }

    void m1129d() {
        if (!this.f495x) {
            this.f495x = true;
            m1115k(false);
        }
    }

    void m1131e() {
        if (this.f495x) {
            this.f495x = false;
            m1115k(false);
        }
    }

    public C0142a m1117a(C0136b c0136b) {
        if (this.f472a != null) {
            this.f472a.mo201b();
        }
        this.f483l.m1473g();
        C0142a c0143o = new C0143o(this, c0136b);
        if (!c0143o.m1145d()) {
            return null;
        }
        c0143o.m1144c();
        this.f483l.m1466a(c0143o);
        m1133f(true);
        if (!(this.f484m == null || this.f490s != 1 || this.f484m.getVisibility() == 0)) {
            this.f484m.setVisibility(0);
        }
        this.f483l.sendAccessibilityEvent(32);
        this.f472a = c0143o;
        return c0143o;
    }

    void m1133f(boolean z) {
        int i;
        int i2 = 8;
        if (z) {
            m1129d();
        } else {
            m1131e();
        }
        ActionBarView actionBarView = this.f482k;
        if (z) {
            i = 4;
        } else {
            i = 0;
        }
        actionBarView.mo245a(i);
        ActionBarContextView actionBarContextView = this.f483l;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        actionBarContextView.mo245a(i);
        if (this.f485n != null && !this.f482k.m1505i() && this.f482k.m1508l()) {
            ScrollingTabContainerView scrollingTabContainerView = this.f485n;
            if (!z) {
                i2 = 0;
            }
            scrollingTabContainerView.setVisibility(i2);
        }
    }

    private static boolean m1111b(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return true;
    }

    private void m1115k(boolean z) {
        if (C0141n.m1111b(this.f493v, this.f494w, this.f495x)) {
            if (!this.f496y) {
                this.f496y = true;
                m1136h(z);
            }
        } else if (this.f496y) {
            this.f496y = false;
            m1137i(z);
        }
    }

    public void m1135g(boolean z) {
        this.f497z = z;
        if (!z) {
            this.f481j.clearAnimation();
            if (this.f484m != null) {
                this.f484m.clearAnimation();
            }
        }
    }

    public void m1136h(boolean z) {
        this.f481j.clearAnimation();
        if (this.f481j.getVisibility() != 0) {
            int i = (mo203f() || z) ? 1 : 0;
            if (i != 0) {
                this.f481j.startAnimation(AnimationUtils.loadAnimation(this.f476e, C0148b.abc_slide_in_top));
            }
            this.f481j.setVisibility(0);
            if (this.f484m != null && this.f484m.getVisibility() != 0) {
                if (i != 0) {
                    this.f484m.startAnimation(AnimationUtils.loadAnimation(this.f476e, C0148b.abc_slide_in_bottom));
                }
                this.f484m.setVisibility(0);
            }
        }
    }

    public void m1137i(boolean z) {
        this.f481j.clearAnimation();
        if (this.f481j.getVisibility() != 8) {
            Object obj = (mo203f() || z) ? 1 : null;
            if (obj != null) {
                this.f481j.startAnimation(AnimationUtils.loadAnimation(this.f476e, C0148b.abc_slide_out_top));
            }
            this.f481j.setVisibility(8);
            if (this.f484m != null && this.f484m.getVisibility() != 8) {
                if (obj != null) {
                    this.f484m.startAnimation(AnimationUtils.loadAnimation(this.f476e, C0148b.abc_slide_out_bottom));
                }
                this.f484m.setVisibility(8);
            }
        }
    }

    boolean mo203f() {
        return this.f497z;
    }
}
