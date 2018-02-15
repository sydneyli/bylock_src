package net.client.by.lock.gui.p018b;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p014c.C0332j;

/* compiled from: MyApp */
class C0428l implements OnClickListener {
    private final /* synthetic */ C0337c f1891a;
    private final /* synthetic */ EditText f1892b;
    private final /* synthetic */ Dialog f1893c;

    C0428l(C0337c c0337c, EditText editText, Dialog dialog) {
        this.f1891a = c0337c;
        this.f1892b = editText;
        this.f1893c = dialog;
    }

    public void onClick(View view) {
        this.f1891a.m2265d(this.f1892b.getText().toString());
        C0332j.m2148a().m2161a(this.f1891a);
        this.f1893c.dismiss();
    }
}
