package net.client.by.lock.gui.p018b;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p016f.C0366k;
import net.client.by.lock.p016f.C0367l;

/* compiled from: MyApp */
class C0435s implements OnClickListener {
    private final /* synthetic */ EditText f1904a;
    private final /* synthetic */ EditText f1905b;
    private final /* synthetic */ EditText f1906c;
    private final /* synthetic */ String[] f1907d;
    private final /* synthetic */ Dialog f1908e;

    C0435s(EditText editText, EditText editText2, EditText editText3, String[] strArr, Dialog dialog) {
        this.f1904a = editText;
        this.f1905b = editText2;
        this.f1906c = editText3;
        this.f1907d = strArr;
        this.f1908e = dialog;
    }

    public void onClick(View view) {
        String editable = this.f1904a.getText().toString();
        Object editable2 = this.f1905b.getText().toString();
        String editable3 = this.f1906c.getText().toString();
        if (C0351r.m2359i().m2390l().equals(editable)) {
            C0367l a = C0366k.m2481a(editable2);
            if (a != C0367l.SECURE) {
                this.f1905b.setError(this.f1907d[a.ordinal()]);
                return;
            } else if (editable.equals(editable2)) {
                this.f1905b.setError("new password is same with previous");
                return;
            } else if (!editable2.equals(editable3) || TextUtils.isEmpty(editable2)) {
                this.f1906c.setError("password does not match");
                return;
            } else {
                C0351r.m2359i().m2379e(editable2);
                this.f1908e.dismiss();
                return;
            }
        }
        this.f1904a.setError("password incorrect");
    }
}
