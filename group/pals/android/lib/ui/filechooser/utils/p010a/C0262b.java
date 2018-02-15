package group.pals.android.lib.ui.filechooser.utils.p010a;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: MyApp */
class C0262b implements OnItemClickListener {
    private final /* synthetic */ AlertDialog f1208a;
    private final /* synthetic */ C0228c f1209b;
    private final /* synthetic */ Integer[] f1210c;

    C0262b(AlertDialog alertDialog, C0228c c0228c, Integer[] numArr) {
        this.f1208a = alertDialog;
        this.f1209b = c0228c;
        this.f1210c = numArr;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1208a.dismiss();
        this.f1209b.mo293a(this.f1210c[i].intValue());
    }
}
