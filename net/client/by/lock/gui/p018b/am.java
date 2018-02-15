package net.client.by.lock.gui.p018b;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/* compiled from: MyApp */
public class am extends BaseAdapter {
    private Context f1861a;
    private ArrayList f1862b = new ArrayList();
    private Typeface f1863c;

    public am(Context context) {
        this.f1861a = context;
    }

    public boolean hasStableIds() {
        return true;
    }

    public void m2727a(ArrayList arrayList) {
        this.f1862b = arrayList;
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.f1862b.size();
    }

    public Object getItem(int i) {
        return this.f1862b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new TextView(this.f1861a);
            view.setLayoutParams(new LayoutParams(-1, -2));
            view.setTypeface(this.f1863c);
        } else {
            TextView textView = (TextView) view;
        }
        view.setText((CharSequence) this.f1862b.get(i));
        return view;
    }
}
