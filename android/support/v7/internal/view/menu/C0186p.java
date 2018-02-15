package android.support.v7.internal.view.menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* compiled from: MyApp */
class C0186p extends BaseAdapter {
    final /* synthetic */ C0185o f710a;
    private int f711b = -1;

    public /* synthetic */ Object getItem(int i) {
        return m1389a(i);
    }

    public C0186p(C0185o c0185o) {
        this.f710a = c0185o;
        m1390a();
    }

    public int getCount() {
        int size = this.f710a.f703c.m1353k().size() - this.f710a.f708h;
        return this.f711b < 0 ? size : size - 1;
    }

    public C0187u m1389a(int i) {
        ArrayList k = this.f710a.f703c.m1353k();
        int a = this.f710a.f708h + i;
        if (this.f711b >= 0 && a >= this.f711b) {
            a++;
        }
        return (C0187u) k.get(a);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        if (view == null) {
            inflate = this.f710a.f702b.inflate(this.f710a.f706f, viewGroup, false);
        } else {
            inflate = view;
        }
        ((ai) inflate).mo204a(m1389a(i), 0);
        return inflate;
    }

    void m1390a() {
        C0187u q = this.f710a.f703c.m1359q();
        if (q != null) {
            ArrayList k = this.f710a.f703c.m1353k();
            int size = k.size();
            for (int i = 0; i < size; i++) {
                if (((C0187u) k.get(i)) == q) {
                    this.f711b = i;
                    return;
                }
            }
        }
        this.f711b = -1;
    }

    public void notifyDataSetChanged() {
        m1390a();
        super.notifyDataSetChanged();
    }
}
