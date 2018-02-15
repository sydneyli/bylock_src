package net.client.by.lock.gui.p018b;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import java.util.ArrayList;
import java.util.Iterator;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p012d.C0341g;
import net.client.by.lock.p014c.C0327e;
import net.client.by.lock.p014c.C0332j;

/* compiled from: MyApp */
class C0431o implements OnClickListener {
    private final /* synthetic */ AutoCompleteTextView f1896a;
    private final /* synthetic */ Dialog f1897b;
    private final /* synthetic */ ArrayList f1898c;
    private final /* synthetic */ C0337c f1899d;

    C0431o(AutoCompleteTextView autoCompleteTextView, Dialog dialog, ArrayList arrayList, C0337c c0337c) {
        this.f1896a = autoCompleteTextView;
        this.f1897b = dialog;
        this.f1898c = arrayList;
        this.f1899d = c0337c;
    }

    public void onClick(View view) {
        String editable = this.f1896a.getText().toString();
        if (TextUtils.isEmpty(editable)) {
            this.f1897b.dismiss();
            return;
        }
        int a;
        Iterator it = this.f1898c.iterator();
        while (it.hasNext()) {
            C0341g c0341g = (C0341g) it.next();
            if (c0341g.toString().equals(editable)) {
                a = c0341g.m2301a();
                break;
            }
        }
        a = -1;
        if (a < 0) {
            C0332j.m2148a().m2162a(this.f1899d, editable);
        } else {
            C0327e.m2092c().m2097a(Integer.valueOf(this.f1899d.m2237K()), Integer.valueOf(a));
            C0332j.m2148a().m2154a(Integer.valueOf(this.f1899d.m2237K()), Integer.valueOf(a));
        }
        this.f1897b.dismiss();
    }
}
