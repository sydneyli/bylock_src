package net.client.by.lock.gui.p018b;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import net.client.by.lock.p012d.C0351r;

/* compiled from: MyApp */
class C0437u implements OnClickListener {
    private final /* synthetic */ EditText f1910a;
    private final /* synthetic */ EditText f1911b;
    private final /* synthetic */ Dialog f1912c;

    C0437u(EditText editText, EditText editText2, Dialog dialog) {
        this.f1910a = editText;
        this.f1911b = editText2;
        this.f1912c = dialog;
    }

    public void onClick(View view) {
        String editable = this.f1910a.getText().toString();
        if (editable.equals(this.f1911b.getText().toString())) {
            C0351r.m2359i().m2379e(editable);
            this.f1912c.dismiss();
            return;
        }
        this.f1911b.setError("Passwords does not match");
    }
}
