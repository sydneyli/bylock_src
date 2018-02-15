package net.client.by.lock.gui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import net.client.by.lock.C0307a;
import net.client.by.lock.p012d.C0337c;

/* compiled from: MyApp */
class ao implements OnChildClickListener {
    final /* synthetic */ am f1741a;

    ao(am amVar) {
        this.f1741a = amVar;
    }

    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        C0337c a = C0307a.f1342b.m2719a(i, i2);
        if (a != null) {
            Intent intent;
            if (a.m2285u() == null) {
                intent = new Intent(ad.f1720b, ContactActivity.class);
                intent.putExtra("id", a.m2237K());
                ad.f1720b.startActivityForResult(intent, 13);
            } else {
                intent = new Intent(ad.f1720b, ChatActivity.class);
                intent.putExtra("id", a.m2237K());
                ad.f1720b.startActivityForResult(intent, 3);
            }
        }
        return false;
    }
}
