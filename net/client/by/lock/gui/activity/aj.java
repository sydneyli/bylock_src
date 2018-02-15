package net.client.by.lock.gui.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.TextView;
import java.io.File;
import net.client.by.lock.gui.p018b.C0418b;
import net.client.by.lock.p014c.C0331i;

/* compiled from: MyApp */
class aj implements OnItemLongClickListener {
    final /* synthetic */ ah f1734a;

    aj(ah ahVar) {
        this.f1734a = ahVar;
    }

    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        C0418b.m2736a(ad.f1720b, new File(new StringBuilder(String.valueOf(C0331i.m2124a().m2132b())).append("/").append(((TextView) view).getText()).toString())).show();
        return true;
    }
}
