package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v7.p008b.C0154h;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;

/* compiled from: MyApp */
public class C0185o implements af, OnItemClickListener {
    Context f701a;
    LayoutInflater f702b;
    C0174q f703c;
    ExpandedMenuView f704d;
    int f705e;
    int f706f;
    C0186p f707g;
    private int f708h;
    private ag f709i;

    public C0185o(int i, int i2) {
        this.f706f = i;
        this.f705e = i2;
    }

    public void mo209a(Context context, C0174q c0174q) {
        if (this.f705e != 0) {
            this.f701a = new ContextThemeWrapper(context, this.f705e);
            this.f702b = LayoutInflater.from(this.f701a);
        } else if (this.f701a != null) {
            this.f701a = context;
            if (this.f702b == null) {
                this.f702b = LayoutInflater.from(this.f701a);
            }
        }
        this.f703c = c0174q;
        if (this.f707g != null) {
            this.f707g.notifyDataSetChanged();
        }
    }

    public ah m1379a(ViewGroup viewGroup) {
        if (this.f707g == null) {
            this.f707g = new C0186p(this);
        }
        if (this.f707g.isEmpty()) {
            return null;
        }
        if (this.f704d == null) {
            this.f704d = (ExpandedMenuView) this.f702b.inflate(C0154h.abc_expanded_menu_layout, viewGroup, false);
            this.f704d.setAdapter(this.f707g);
            this.f704d.setOnItemClickListener(this);
        }
        return this.f704d;
    }

    public ListAdapter m1380a() {
        if (this.f707g == null) {
            this.f707g = new C0186p(this);
        }
        return this.f707g;
    }

    public void mo214c(boolean z) {
        if (this.f707g != null) {
            this.f707g.notifyDataSetChanged();
        }
    }

    public void m1382a(ag agVar) {
        this.f709i = agVar;
    }

    public boolean mo211a(al alVar) {
        if (!alVar.hasVisibleItems()) {
            return false;
        }
        new C0177t(alVar).m1369a(null);
        if (this.f709i != null) {
            this.f709i.mo179b(alVar);
        }
        return true;
    }

    public void mo210a(C0174q c0174q, boolean z) {
        if (this.f709i != null) {
            this.f709i.mo169a(c0174q, z);
        }
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f703c.m1336a(this.f707g.m1389a(i), 0);
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
