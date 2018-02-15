package net.client.by.lock.gui.p018b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import net.client.by.lock.R;
import net.client.by.lock.p012d.C0334a;
import net.client.by.lock.p016f.C0365j;

/* compiled from: MyApp */
public class ai extends BaseAdapter {
    private Context f1853a;
    private ArrayList f1854b = new ArrayList();

    public ai(Context context) {
        this.f1853a = context;
    }

    public int getCount() {
        return this.f1854b.size();
    }

    public Object getItem(int i) {
        return this.f1854b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        aj ajVar;
        C0334a c0334a = (C0334a) this.f1854b.get(i);
        if (view == null) {
            view = View.inflate(this.f1853a, R.layout.item_mail_attachment, null);
            aj ajVar2 = new aj();
            view.findViewById(R.id.chat_bar).setVisibility(8);
            view.findViewById(R.id.cancel).setVisibility(8);
            ajVar2.f1855a = (TextView) view.findViewById(R.id.file_name);
            ajVar2.f1856b = (TextView) view.findViewById(R.id.size);
            view.setTag(ajVar2);
            ajVar = ajVar2;
        } else {
            ajVar = (aj) view.getTag();
        }
        ajVar.f1855a.setText(c0334a.mo325e());
        ajVar.f1856b.setText(C0365j.m2474a((long) c0334a.mo326f().intValue()));
        return view;
    }

    public boolean hasStableIds() {
        return true;
    }

    public void m2725a(ArrayList arrayList) {
        this.f1854b = arrayList;
        notifyDataSetChanged();
    }
}
