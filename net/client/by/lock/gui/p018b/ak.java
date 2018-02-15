package net.client.by.lock.gui.p018b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import net.client.by.lock.R;
import net.client.by.lock.p012d.C0337c;

/* compiled from: MyApp */
public class ak extends BaseAdapter {
    private Context f1857a;
    private ArrayList f1858b = new ArrayList();

    public ak(Context context) {
        this.f1857a = context;
    }

    public boolean hasStableIds() {
        return true;
    }

    public void m2726a(ArrayList arrayList) {
        this.f1858b = arrayList;
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.f1858b.size();
    }

    public Object getItem(int i) {
        return this.f1858b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        al alVar;
        C0337c c0337c = (C0337c) this.f1858b.get(i);
        if (view == null) {
            view = View.inflate(this.f1857a, R.layout.item_mail_attachment, null);
            al alVar2 = new al();
            view.findViewById(R.id.chat_bar).setVisibility(8);
            view.findViewById(R.id.cancel).setVisibility(8);
            alVar2.f1859a = (TextView) view.findViewById(R.id.file_name);
            alVar2.f1860b = (TextView) view.findViewById(R.id.size);
            view.setTag(alVar2);
            alVar = alVar2;
        } else {
            alVar = (al) view.getTag();
        }
        alVar.f1859a.setText(c0337c.m2233G());
        alVar.f1860b.setText(c0337c.m2229C());
        return view;
    }
}
