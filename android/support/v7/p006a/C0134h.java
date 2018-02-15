package android.support.v7.p006a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v7.internal.view.menu.C0133r;
import android.support.v7.internal.view.menu.C0174q;
import android.support.v7.internal.view.menu.C0185o;
import android.support.v7.internal.view.menu.ag;
import android.support.v7.internal.view.menu.ah;
import android.support.v7.internal.view.menu.aj;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarView;
import android.support.v7.p007c.C0136b;
import android.support.v7.p007c.C0142a;
import android.support.v7.p008b.C0149c;
import android.support.v7.p008b.C0150d;
import android.support.v7.p008b.C0152f;
import android.support.v7.p008b.C0154h;
import android.support.v7.p008b.C0156j;
import android.support.v7.p008b.C0157k;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

/* compiled from: MyApp */
class C0134h extends C0132g implements ag, C0133r {
    private static final int[] f455d = new int[]{C0149c.homeAsUpIndicator};
    private ActionBarView f456e;
    private C0185o f457f;
    private C0174q f458g;
    private C0142a f459h;
    private boolean f460i;
    private boolean f461j;
    private boolean f462k;
    private boolean f463l;
    private final Runnable f464m = new C0135i(this);

    C0134h(C0131f c0131f) {
        super(c0131f);
    }

    public C0126a mo164a() {
        m1076j();
        return new C0141n(this.a, this.a);
    }

    public void mo167a(Configuration configuration) {
        if (this.b && this.f460i) {
            ((C0141n) m1034b()).m1120a(configuration);
        }
    }

    public void mo180d() {
        C0141n c0141n = (C0141n) m1034b();
        if (c0141n != null) {
            c0141n.m1135g(false);
        }
    }

    public void mo181e() {
        C0141n c0141n = (C0141n) m1034b();
        if (c0141n != null) {
            c0141n.m1135g(true);
        }
    }

    public void mo170a(View view) {
        m1076j();
        if (this.b) {
            ViewGroup viewGroup = (ViewGroup) this.a.findViewById(C0152f.action_bar_activity_content);
            viewGroup.removeAllViews();
            viewGroup.addView(view);
            return;
        }
        this.a.mo154a(view);
    }

    public void mo166a(int i) {
        m1076j();
        if (this.b) {
            ViewGroup viewGroup = (ViewGroup) this.a.findViewById(C0152f.action_bar_activity_content);
            viewGroup.removeAllViews();
            this.a.getLayoutInflater().inflate(i, viewGroup);
            return;
        }
        this.a.m1006a(i);
    }

    public void mo171a(View view, LayoutParams layoutParams) {
        m1076j();
        if (this.b) {
            ViewGroup viewGroup = (ViewGroup) this.a.findViewById(C0152f.action_bar_activity_content);
            viewGroup.removeAllViews();
            viewGroup.addView(view, layoutParams);
            return;
        }
        this.a.m1010a(view, layoutParams);
    }

    public void mo178b(View view, LayoutParams layoutParams) {
        m1076j();
        if (this.b) {
            ((ViewGroup) this.a.findViewById(C0152f.action_bar_activity_content)).addView(view, layoutParams);
        } else {
            this.a.m1010a(view, layoutParams);
        }
    }

    final void m1076j() {
        if (this.b && !this.f460i) {
            boolean z;
            if (this.c) {
                this.a.m1006a(C0154h.abc_action_bar_decor_overlay);
            } else {
                this.a.m1006a(C0154h.abc_action_bar_decor);
            }
            this.f456e = (ActionBarView) this.a.findViewById(C0152f.action_bar);
            this.f456e.setWindowCallback(this.a);
            if (this.f461j) {
                this.f456e.m1502f();
            }
            if (this.f462k) {
                this.f456e.m1503g();
            }
            boolean equals = "splitActionBarWhenNarrow".equals(m1042h());
            if (equals) {
                z = this.a.getResources().getBoolean(C0150d.abc_split_action_bar_is_narrow);
            } else {
                TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(C0157k.ActionBarWindow);
                boolean z2 = obtainStyledAttributes.getBoolean(2, false);
                obtainStyledAttributes.recycle();
                z = z2;
            }
            ActionBarContainer actionBarContainer = (ActionBarContainer) this.a.findViewById(C0152f.split_action_bar);
            if (actionBarContainer != null) {
                this.f456e.setSplitView(actionBarContainer);
                this.f456e.setSplitActionBar(z);
                this.f456e.setSplitWhenNarrow(equals);
                ActionBarContextView actionBarContextView = (ActionBarContextView) this.a.findViewById(C0152f.action_context_bar);
                actionBarContextView.setSplitView(actionBarContainer);
                actionBarContextView.setSplitActionBar(z);
                actionBarContextView.setSplitWhenNarrow(equals);
            }
            this.f460i = true;
            mo182f();
        }
    }

    public void mo172a(CharSequence charSequence) {
        if (this.f456e != null) {
            this.f456e.setWindowTitle(charSequence);
        }
    }

    public View mo177b(int i) {
        if (i != 0) {
            return null;
        }
        boolean z = true;
        C0174q c0174q = this.f458g;
        if (this.f459h == null) {
            if (c0174q == null) {
                c0174q = m1055k();
                m1054c(c0174q);
                c0174q.m1348f();
                z = this.a.m1011a(0, (Menu) c0174q);
            }
            if (z) {
                c0174q.m1348f();
                z = this.a.m1013a(0, null, c0174q);
            }
        }
        if (z) {
            View view = (View) m1049a(this.a, (ag) this);
            c0174q.m1349g();
            return view;
        }
        m1054c(null);
        return null;
    }

    public boolean mo173a(int i, Menu menu) {
        if (i != 0) {
            return this.a.m1011a(i, menu);
        }
        return false;
    }

    public boolean mo175a(int i, View view, Menu menu) {
        if (i != 0) {
            return this.a.m1013a(i, view, menu);
        }
        return false;
    }

    public boolean mo174a(int i, MenuItem menuItem) {
        if (i == 0) {
            menuItem = aj.m1312a(menuItem);
        }
        return this.a.m1012a(i, menuItem);
    }

    public boolean mo176a(C0174q c0174q, MenuItem menuItem) {
        return this.a.onMenuItemSelected(0, menuItem);
    }

    public void mo168a(C0174q c0174q) {
        m1053b(c0174q, true);
    }

    public void mo169a(C0174q c0174q, boolean z) {
        this.a.closeOptionsMenu();
    }

    public boolean mo179b(C0174q c0174q) {
        return false;
    }

    public C0142a mo165a(C0136b c0136b) {
        if (c0136b == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.f459h != null) {
            this.f459h.mo201b();
        }
        C0136b c0137j = new C0137j(this, c0136b);
        C0141n c0141n = (C0141n) m1034b();
        if (c0141n != null) {
            this.f459h = c0141n.m1117a(c0137j);
        }
        if (this.f459h != null) {
            this.a.m1008a(this.f459h);
        }
        return this.f459h;
    }

    public void mo182f() {
        if (!this.f463l) {
            this.f463l = true;
            this.a.getWindow().getDecorView().post(this.f464m);
        }
    }

    private C0174q m1055k() {
        C0174q c0174q = new C0174q(m1043i());
        c0174q.mo231a((C0133r) this);
        return c0174q;
    }

    private void m1053b(C0174q c0174q, boolean z) {
        if (this.f456e == null || !this.f456e.mo250e()) {
            c0174q.close();
        } else if (this.f456e.mo249d() && z) {
            this.f456e.mo248c();
        } else if (this.f456e.getVisibility() == 0) {
            this.f456e.mo246a();
        }
    }

    private ah m1049a(Context context, ag agVar) {
        if (this.f458g == null) {
            return null;
        }
        if (this.f457f == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(C0157k.Theme);
            int resourceId = obtainStyledAttributes.getResourceId(4, C0156j.Theme_AppCompat_CompactMenu);
            obtainStyledAttributes.recycle();
            this.f457f = new C0185o(C0154h.abc_list_menu_item_layout, resourceId);
            this.f457f.m1382a(agVar);
            this.f458g.m1328a(this.f457f);
        } else {
            this.f457f.mo214c(false);
        }
        return this.f457f.m1379a(new FrameLayout(context));
    }

    private void m1054c(C0174q c0174q) {
        if (c0174q != this.f458g) {
            if (this.f458g != null) {
                this.f458g.m1338b(this.f457f);
            }
            this.f458g = c0174q;
            if (!(c0174q == null || this.f457f == null)) {
                c0174q.m1328a(this.f457f);
            }
            if (this.f456e != null) {
                this.f456e.m1496a(c0174q, this);
            }
        }
    }

    public boolean mo183g() {
        if (this.f459h != null) {
            this.f459h.mo201b();
            return true;
        } else if (this.f456e == null || !this.f456e.m1506j()) {
            return false;
        } else {
            this.f456e.m1507k();
            return true;
        }
    }
}
