package net.client.by.lock.gui.p018b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import net.client.by.lock.R;
import net.client.by.lock.p013b.C0308a;
import net.client.by.lock.p013b.C0319k;
import net.client.by.lock.p016f.C0362g;

/* compiled from: MyApp */
public class ao extends BaseAdapter implements Observer {
    private Context f1865a;
    private ArrayList f1866b = new ArrayList();
    private C0362g f1867c = C0319k.m2069b().m2070a();

    public ao(Context context) {
        this.f1865a = context;
        this.f1867c.addObserver(this);
    }

    public int getCount() {
        return this.f1867c.size();
    }

    public Object getItem(int i) {
        return this.f1867c.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ap apVar;
        C0308a c0308a = (C0308a) this.f1867c.get(i);
        if (view == null) {
            View view2 = (CheckedTextView) View.inflate(this.f1865a, R.layout.select_item, null);
            ap apVar2 = new ap();
            apVar2.f1868a = new aq();
            view2.setOnClickListener(apVar2.f1868a);
            view2.setTag(apVar2);
            view = view2;
            apVar = apVar2;
        } else {
            CheckedTextView checkedTextView = (CheckedTextView) view;
            apVar = (ap) checkedTextView.getTag();
        }
        apVar.f1868a.m2733a(c0308a);
        view.setText(c0308a.mo325e());
        view.setChecked(this.f1866b.contains(c0308a.mo322b()));
        return view;
    }

    public ArrayList m2732a() {
        this.f1867c.deleteObserver(this);
        return this.f1866b;
    }

    public void update(Observable observable, Object obj) {
        notifyDataSetChanged();
    }
}
