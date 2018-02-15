package android.support.v7.internal.view.menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* compiled from: MyApp */
class ae extends BaseAdapter {
    final /* synthetic */ ad f654a;
    private C0174q f655b;
    private int f656c = -1;

    public /* synthetic */ Object getItem(int i) {
        return m1308a(i);
    }

    public ae(ad adVar, C0174q c0174q) {
        this.f654a = adVar;
        this.f655b = c0174q;
        m1309a();
    }

    public int getCount() {
        ArrayList k = this.f654a.f649i ? this.f655b.m1353k() : this.f655b.m1350h();
        if (this.f656c < 0) {
            return k.size();
        }
        return k.size() - 1;
    }

    public C0187u m1308a(int i) {
        ArrayList k = this.f654a.f649i ? this.f655b.m1353k() : this.f655b.m1350h();
        if (this.f656c >= 0 && i >= this.f656c) {
            i++;
        }
        return (C0187u) k.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        if (view == null) {
            inflate = this.f654a.f644d.inflate(ad.f641b, viewGroup, false);
        } else {
            inflate = view;
        }
        ai aiVar = (ai) inflate;
        if (this.f654a.f643c) {
            ((ListMenuItemView) inflate).setForceShowIcon(true);
        }
        aiVar.mo204a(m1308a(i), 0);
        return inflate;
    }

    void m1309a() {
        C0187u q = this.f654a.f646f.m1359q();
        if (q != null) {
            ArrayList k = this.f654a.f646f.m1353k();
            int size = k.size();
            for (int i = 0; i < size; i++) {
                if (((C0187u) k.get(i)) == q) {
                    this.f656c = i;
                    return;
                }
            }
        }
        this.f656c = -1;
    }

    public void notifyDataSetChanged() {
        m1309a();
        super.notifyDataSetChanged();
    }
}
