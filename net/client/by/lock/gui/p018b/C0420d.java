package net.client.by.lock.gui.p018b;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import net.client.by.lock.p014c.C0331i;

/* compiled from: MyApp */
class C0420d implements OnClickListener {
    private final /* synthetic */ EditText f1873a;
    private final /* synthetic */ EditText f1874b;
    private final /* synthetic */ EditText f1875c;
    private final /* synthetic */ Dialog f1876d;

    C0420d(EditText editText, EditText editText2, EditText editText3, Dialog dialog) {
        this.f1873a = editText;
        this.f1874b = editText2;
        this.f1875c = editText3;
        this.f1876d = dialog;
    }

    public void onClick(View view) {
        String editable = this.f1873a.getText().toString();
        String editable2 = this.f1874b.getText().toString();
        String editable3 = this.f1875c.getText().toString();
        if (!C0331i.m2124a().m2144g().equals(editable)) {
            this.f1873a.setError("pin incorrect");
        } else if (editable.equals(editable2)) {
            this.f1874b.setError("new ping is same with previous");
        } else if (!editable2.equals(editable3) || TextUtils.isEmpty(editable2)) {
            this.f1875c.setError("pin does not match");
        } else {
            C0331i.m2124a().m2134b(editable2);
            this.f1876d.dismiss();
        }
    }
}
