package net.client.by.lock.gui.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ExpandableListView;
import net.client.by.lock.C0307a;
import net.client.by.lock.gui.p018b.C0418b;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p012d.C0341g;

/* compiled from: MyApp */
class an implements OnItemLongClickListener {
    final /* synthetic */ am f1740a;

    an(am amVar) {
        this.f1740a = amVar;
    }

    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        if (ExpandableListView.getPackedPositionType(j) != 1) {
            return false;
        }
        int packedPositionGroup = ExpandableListView.getPackedPositionGroup(j);
        C0337c a = C0307a.f1342b.m2719a(packedPositionGroup, ExpandableListView.getPackedPositionChild(j));
        C0341g c0341g = (C0341g) C0307a.f1342b.m2720a(packedPositionGroup).m2305d();
        if (c0341g == null || a == null) {
            return false;
        }
        C0418b.m2738a(ad.f1720b, a, c0341g).show();
        return true;
    }
}
