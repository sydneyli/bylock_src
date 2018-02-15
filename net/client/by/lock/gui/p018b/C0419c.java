package net.client.by.lock.gui.p018b;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import net.client.by.lock.p012d.C0351r;

/* compiled from: MyApp */
class C0419c implements OnClickListener {
    private final /* synthetic */ EditText f1871a;
    private final /* synthetic */ Dialog f1872b;

    C0419c(EditText editText, Dialog dialog) {
        this.f1871a = editText;
        this.f1872b = dialog;
    }

    public void onClick(View view) {
        C0351r.m2359i().m2385h(this.f1871a.getText().toString());
        this.f1872b.dismiss();
    }
}
