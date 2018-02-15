package net.client.by.lock.gui.p018b;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p014c.C0332j;

/* compiled from: MyApp */
class C0433q implements OnClickListener {
    private final /* synthetic */ EditText f1901a;
    private final /* synthetic */ Dialog f1902b;

    C0433q(EditText editText, Dialog dialog) {
        this.f1901a = editText;
        this.f1902b = dialog;
    }

    public void onClick(View view) {
        C0351r.m2359i().m2387i(this.f1901a.getText().toString());
        C0332j.m2148a().m2173c();
        this.f1902b.dismiss();
    }
}
