package net.client.by.lock.gui.p018b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import net.client.by.lock.gui.activity.ChatActivity;
import net.client.by.lock.gui.p017a.C0379d;
import net.client.by.lock.p012d.C0288k;
import net.client.by.lock.p016f.C0362g;
import net.client.by.lock.p016f.C0370o;

/* compiled from: MyApp */
public class C0417a extends BaseAdapter implements Observer, C0379d {
    private ChatActivity f1831a;
    private C0362g f1832b;
    private boolean f1833c = false;
    private boolean f1834d = false;

    public C0417a(C0362g c0362g) {
        this.f1832b = c0362g;
        this.f1832b.addObserver(this);
    }

    public void m2707a(ChatActivity chatActivity) {
        this.f1831a = chatActivity;
    }

    public int getCount() {
        return this.f1832b.size();
    }

    public Object getItem(int i) {
        return this.f1832b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        boolean z;
        C0288k c0288k = (C0288k) this.f1832b.get(i);
        if (i > 0) {
            String B = ((C0288k) this.f1832b.get(i - 1)).m1910B();
            String B2 = c0288k.m1910B();
            z = (B.startsWith(B2.substring(0, 15)) || "01.01.2970 00:00".startsWith(B2.substring(0, 15))) ? false : true;
        } else {
            z = true;
        }
        c0288k.mo317A().m2556a((C0379d) this);
        return c0288k.mo317A().m2551a(this.f1831a, z);
    }

    public void update(Observable observable, Object obj) {
        if (obj != null && (obj instanceof C0288k)) {
            ((C0288k) obj).mo317A().m2557a(this.f1834d);
        }
        notifyDataSetChanged();
    }

    public void mo357a(boolean z) {
        this.f1834d = z;
        if (z) {
            this.f1831a.m2604j();
        }
        Iterator it = this.f1832b.iterator();
        while (it.hasNext()) {
            ((C0288k) it.next()).mo317A().m2557a(z);
        }
    }

    public void m2706a() {
        boolean z = false;
        Iterator it = this.f1832b.iterator();
        while (it.hasNext()) {
            ((C0288k) it.next()).mo317A().setChecked(!this.f1833c);
        }
        if (!this.f1833c) {
            z = true;
        }
        this.f1833c = z;
    }

    public void m2710b(boolean z) {
        Iterator it = this.f1832b.iterator();
        while (it.hasNext()) {
            C0288k c0288k = (C0288k) it.next();
            if (z || c0288k.mo317A().isChecked()) {
                c0288k.mo319z();
                it.remove();
            }
        }
        notifyDataSetChanged();
    }

    public void m2709b() {
        Iterator it = this.f1832b.iterator();
        String str = "";
        while (it.hasNext()) {
            C0288k c0288k = (C0288k) it.next();
            if (c0288k.mo317A().isChecked()) {
                str = new StringBuilder(String.valueOf(str)).append(c0288k.toString()).append(System.getProperty("line.separator")).toString();
            }
        }
        C0370o.m2491a(this.f1831a.getSystemService("clipboard"), str, str);
    }

    public int getItemViewType(int i) {
        return -1;
    }
}
