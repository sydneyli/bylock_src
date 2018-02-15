package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.internal.widget.C0194u;
import android.support.v7.p008b.C0149c;
import android.support.v7.p008b.C0151e;
import android.support.v7.p008b.C0154h;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

/* compiled from: MyApp */
public class ad implements af, OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    static final int f641b = C0154h.abc_popup_menu_item_layout;
    private Context f642a;
    boolean f643c;
    private LayoutInflater f644d;
    private C0194u f645e;
    private C0174q f646f;
    private int f647g;
    private View f648h;
    private boolean f649i;
    private ViewTreeObserver f650j;
    private ae f651k;
    private ag f652l;
    private ViewGroup f653m;

    public ad(Context context, C0174q c0174q, View view, boolean z) {
        this.f642a = context;
        this.f644d = LayoutInflater.from(context);
        this.f646f = c0174q;
        this.f649i = z;
        Resources resources = context.getResources();
        this.f647g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0151e.abc_config_prefDialogWidth));
        this.f648h = view;
        c0174q.m1328a((af) this);
    }

    public void m1298a(boolean z) {
        this.f643c = z;
    }

    public boolean m1299a() {
        boolean z = false;
        this.f645e = new C0194u(this.f642a, null, C0149c.popupMenuStyle);
        this.f645e.m1569a((OnDismissListener) this);
        this.f645e.m1567a((OnItemClickListener) this);
        this.f651k = new ae(this, this.f646f);
        this.f645e.mo265a(this.f651k);
        this.f645e.m1570a(true);
        View view = this.f648h;
        if (view == null) {
            return false;
        }
        if (this.f650j == null) {
            z = true;
        }
        this.f650j = view.getViewTreeObserver();
        if (z) {
            this.f650j.addOnGlobalLayoutListener(this);
        }
        this.f645e.m1566a(view);
        this.f645e.m1578e(Math.min(m1291a(this.f651k), this.f647g));
        this.f645e.m1579f(2);
        this.f645e.mo267c();
        this.f645e.m1583h().setOnKeyListener(this);
        return true;
    }

    public void m1302b() {
        if (m1305c()) {
            this.f645e.m1575d();
        }
    }

    public void onDismiss() {
        this.f645e = null;
        this.f646f.close();
        if (this.f650j != null) {
            if (!this.f650j.isAlive()) {
                this.f650j = this.f648h.getViewTreeObserver();
            }
            this.f650j.removeGlobalOnLayoutListener(this);
            this.f650j = null;
        }
    }

    public boolean m1305c() {
        return this.f645e != null && this.f645e.m1580f();
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        ae aeVar = this.f651k;
        aeVar.f655b.m1336a(aeVar.m1308a(i), 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        m1302b();
        return true;
    }

    private int m1291a(ListAdapter listAdapter) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i = 0;
        int i2 = 0;
        View view = null;
        int i3 = 0;
        while (i < count) {
            View view2;
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                view2 = null;
            } else {
                itemViewType = i2;
                view2 = view;
            }
            if (this.f653m == null) {
                this.f653m = new FrameLayout(this.f642a);
            }
            view = listAdapter.getView(i, view2, this.f653m);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
            i++;
            i2 = itemViewType;
        }
        return i3;
    }

    public void onGlobalLayout() {
        if (m1305c()) {
            View view = this.f648h;
            if (view == null || !view.isShown()) {
                m1302b();
            } else if (m1305c()) {
                this.f645e.mo267c();
            }
        }
    }

    public void mo209a(Context context, C0174q c0174q) {
    }

    public void mo214c(boolean z) {
        if (this.f651k != null) {
            this.f651k.notifyDataSetChanged();
        }
    }

    public void m1296a(ag agVar) {
        this.f652l = agVar;
    }

    public boolean mo211a(al alVar) {
        if (alVar.hasVisibleItems()) {
            boolean z;
            ad adVar = new ad(this.f642a, alVar, this.f648h, false);
            adVar.m1296a(this.f652l);
            int size = alVar.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = alVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            z = false;
            adVar.m1298a(z);
            if (adVar.m1299a()) {
                if (this.f652l == null) {
                    return true;
                }
                this.f652l.mo179b(alVar);
                return true;
            }
        }
        return false;
    }

    public void mo210a(C0174q c0174q, boolean z) {
        if (c0174q == this.f646f) {
            m1302b();
            if (this.f652l != null) {
                this.f652l.mo169a(c0174q, z);
            }
        }
    }

    public boolean mo215g() {
        return false;
    }

    public boolean mo212a(C0174q c0174q, C0187u c0187u) {
        return false;
    }

    public boolean mo213b(C0174q c0174q, C0187u c0187u) {
        return false;
    }
}
