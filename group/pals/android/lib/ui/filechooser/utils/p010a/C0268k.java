package group.pals.android.lib.ui.filechooser.utils.p010a;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import group.pals.android.lib.ui.filechooser.an;

/* compiled from: MyApp */
class C0268k implements OnItemClickListener {
    private final /* synthetic */ C0226i f1218a;
    private final /* synthetic */ AlertDialog f1219b;
    private final /* synthetic */ an f1220c;

    C0268k(C0226i c0226i, AlertDialog alertDialog, an anVar) {
        this.f1218a = c0226i;
        this.f1219b = alertDialog;
        this.f1220c = anVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.f1218a != null) {
            this.f1219b.dismiss();
            this.f1218a.mo291a(true, this.f1220c.m1789a(i).m1810a());
        }
    }
}
