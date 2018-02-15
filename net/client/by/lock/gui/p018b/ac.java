package net.client.by.lock.gui.p018b;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import net.client.by.lock.R;
import net.client.by.lock.gui.activity.MainActivity;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p012d.C0341g;
import net.client.by.lock.p012d.C0342s;
import net.client.by.lock.p012d.C0343h;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p014c.C0326d;
import net.client.by.lock.p014c.C0327e;
import net.client.by.lock.p016f.C0362g;
import net.client.by.lock.p016f.C0363h;
import net.client.by.lock.p016f.C0365j;
import net.client.by.lock.p016f.C0370o;

/* compiled from: MyApp */
public class ac extends BaseExpandableListAdapter implements Observer {
    public final int f1837a = -100000;
    private LayoutInflater f1838b = null;
    private MainActivity f1839c;
    private int f1840d = -1;

    public /* synthetic */ Object getChild(int i, int i2) {
        return m2719a(i, i2);
    }

    public /* synthetic */ Object getGroup(int i) {
        return m2720a(i);
    }

    private C0362g m2718d() {
        return C0327e.m2092c().m2095a().m2306e();
    }

    public ac(Context context) {
        this.f1839c = (MainActivity) context;
        this.f1838b = (LayoutInflater) context.getSystemService("layout_inflater");
        m2717a(true);
        notifyDataSetChanged();
    }

    void m2721a() {
        if (this.f1839c != null) {
            this.f1839c.runOnUiThread(new ad(this));
        }
    }

    public void m2722b() {
        m2717a(true);
        m2721a();
    }

    public void update(Observable observable, Object obj) {
        if (obj instanceof String) {
            if (((String) obj).equals("isConnected")) {
                Boolean bool = (Boolean) C0351r.m2359i().m2398t().m2470b();
                if (((Boolean) ((C0363h) observable).m2467a()).booleanValue() && bool != null && !bool.booleanValue()) {
                    m2717a(false);
                    m2717a(true);
                } else if (!(((Boolean) ((C0363h) observable).m2467a()).booleanValue() || bool == null || bool.booleanValue())) {
                    this.f1839c.runOnUiThread(new ae(this));
                    m2717a(false);
                }
            }
        } else if ((observable instanceof C0327e) && (obj instanceof C0337c)) {
            m2716a((C0337c) obj);
        }
        m2721a();
    }

    public C0337c m2719a(int i, int i2) {
        try {
            return (C0337c) ((C0342s) ((C0342s) m2718d().get(i)).m2306e().get(i2)).m2305d();
        } catch (Throwable e) {
            C0365j.m2476a("FriendAdapter", e);
            return null;
        }
    }

    public long getChildId(int i, int i2) {
        return (long) i2;
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        C0337c a = m2719a(i, i2);
        if (a != null) {
            af afVar;
            if (view == null) {
                view = this.f1838b.inflate(R.layout.flist_child_view, null);
                afVar = new af();
                afVar.f1849g = (ImageView) view.findViewById(R.id.item_count);
                afVar.f1843a = (TextView) view.findViewById(R.id.item_name);
                afVar.f1844b = (TextView) view.findViewById(R.id.item_message);
                afVar.f1845c = (ImageView) view.findViewById(R.id.missed_chat_i);
                afVar.f1846d = (ImageView) view.findViewById(R.id.missed_call_i);
                afVar.f1848f = (ImageView) view.findViewById(R.id.missed_mail_i);
                afVar.f1847e = (ImageView) view.findViewById(R.id.missed_file_i);
                view.setTag(afVar);
            } else {
                afVar = (af) view.getTag();
            }
            afVar.f1843a.setText(a.m2233G());
            afVar.f1844b.setText(a.m2283s());
            if (a.m2279o() > 0) {
                afVar.f1845c.setVisibility(0);
            } else {
                afVar.f1845c.setVisibility(4);
            }
            if (((Boolean) a.m2227A().m2467a()).booleanValue()) {
                afVar.f1846d.setVisibility(0);
            } else {
                afVar.f1846d.setVisibility(4);
            }
            if (((Boolean) a.m2289y().m2467a()).booleanValue()) {
                afVar.f1847e.setVisibility(0);
            } else {
                afVar.f1847e.setVisibility(4);
            }
            if (((Boolean) a.m2290z().m2467a()).booleanValue()) {
                afVar.f1848f.setVisibility(0);
            } else {
                afVar.f1848f.setVisibility(4);
            }
            if (((Integer) a.m2282r().m2467a()).intValue() == 0) {
                afVar.f1843a.setTextColor(this.f1839c.getResources().getColor(R.color.Gray));
            } else {
                afVar.f1843a.setTextColor(this.f1839c.getResources().getColor(R.color.LightSlateGray));
            }
            switch (((Integer) a.m2282r().m2467a()).intValue()) {
                case 0:
                    afVar.f1849g.setImageResource(R.drawable.online_0);
                    break;
                case 1:
                    afVar.f1849g.setImageResource(R.drawable.online_1);
                    break;
                case 2:
                    afVar.f1849g.setImageResource(R.drawable.online_2);
                    break;
                case 3:
                    afVar.f1849g.setImageResource(R.drawable.online_3);
                    break;
            }
            view.setTag(R.string.drag_tag_int, Integer.valueOf(i));
        }
        return view;
    }

    public int getChildrenCount(int i) {
        return ((C0342s) m2718d().get(i)).m2306e().size();
    }

    public C0342s m2720a(int i) {
        try {
            return (C0342s) m2718d().get(i);
        } catch (Throwable e) {
            C0365j.m2476a("FriendAdapter", e);
            return null;
        }
    }

    public int getGroupCount() {
        return m2718d().size();
    }

    public long getGroupId(int i) {
        return (long) i;
    }

    @TargetApi(11)
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        View view2;
        View view3 = (TextView) view;
        if (view == null) {
            view2 = (TextView) this.f1838b.inflate(R.layout.item_group_title, null);
        } else {
            view2 = view3;
        }
        C0342s a = m2720a(i);
        if (a == null) {
            return view;
        }
        view2.setText(new StringBuilder(String.valueOf((String) ((C0341g) a.m2305d()).m2303b().m2467a())).append(" (").append(((C0343h) a).m2313c().m2467a()).append("/").append(a.m2306e().size()).append(")").toString());
        view2.setSingleLine(true);
        view2.setTag(R.string.drag_tag_int, Integer.valueOf(i));
        if (C0370o.m2492a(11)) {
            m2715a(view2, i);
        }
        return view2;
    }

    @TargetApi(11)
    private void m2715a(View view, int i) {
        if (this.f1840d == i) {
            view.setScaleY(1.2f);
            view.setScaleX(1.2f);
            view.setTranslationX(40.0f);
            return;
        }
        view.setScaleY(1.0f);
        view.setScaleX(1.0f);
        view.setTranslationX(0.0f);
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    private void m2717a(boolean z) {
        int i = 0;
        C0362g d = m2718d();
        Iterator it;
        if (z) {
            C0327e.m2092c().addObserver(this);
            C0326d.m2089a().m2091b().addObserver(this);
            it = C0327e.m2092c().m2106f().iterator();
            while (it.hasNext()) {
                m2716a((C0337c) it.next());
            }
            while (i < d.size()) {
                ((C0343h) d.get(i)).m2313c().addObserver(this);
                ((C0343h) d.get(i)).m2312b().addObserver(this);
                i++;
            }
            C0351r.m2359i().m2398t().addObserver(this);
            return;
        }
        C0327e.m2092c().deleteObserver(this);
        C0326d.m2089a().m2091b().deleteObserver(this);
        it = C0327e.m2092c().m2106f().iterator();
        while (it.hasNext()) {
            C0337c c0337c = (C0337c) it.next();
            c0337c.m2280p().deleteObserver(this);
            c0337c.m2232F().deleteObserver(this);
            c0337c.m2282r().deleteObserver(this);
            c0337c.m2289y().deleteObserver(this);
            c0337c.m2290z().deleteObserver(this);
            c0337c.m2227A().deleteObserver(this);
            c0337c.m2284t().deleteObserver(this);
        }
        while (i < d.size()) {
            ((C0343h) d.get(i)).m2313c().deleteObserver(this);
            ((C0343h) d.get(i)).m2312b().deleteObserver(this);
            i++;
        }
        C0351r.m2359i().m2398t().deleteObserver(this);
    }

    private void m2716a(C0337c c0337c) {
        c0337c.m2280p().addObserver(this);
        c0337c.m2289y().addObserver(this);
        c0337c.m2290z().addObserver(this);
        c0337c.m2232F().addObserver(this);
        c0337c.m2227A().addObserver(this);
        c0337c.m2282r().addObserver(this);
        c0337c.m2284t().addObserver(this);
    }

    public void m2723c() {
        m2717a(false);
        m2721a();
    }
}
