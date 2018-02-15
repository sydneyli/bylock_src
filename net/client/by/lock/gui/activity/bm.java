package net.client.by.lock.gui.activity;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p016f.C0366k;
import net.client.by.lock.p016f.C0367l;

/* compiled from: MyApp */
class bm implements OnClickListener {
    final /* synthetic */ RegisterActivity f1787a;
    private final /* synthetic */ String[] f1788b;

    bm(RegisterActivity registerActivity, String[] strArr) {
        this.f1787a = registerActivity;
        this.f1788b = strArr;
    }

    public void onClick(View view) {
        String charSequence = this.f1787a.f1698f.getText().toString();
        String charSequence2 = this.f1787a.f1699g.getText().toString();
        String charSequence3 = this.f1787a.f1700h.getText().toString();
        if (TextUtils.isEmpty(charSequence)) {
            this.f1787a.f1698f.setError("field is required");
            return;
        }
        C0367l a = C0366k.m2481a(charSequence2);
        if (a != C0367l.SECURE) {
            this.f1787a.f1699g.setError(this.f1788b[a.ordinal()]);
        } else if (charSequence2.equals(charSequence3)) {
            this.f1787a.f1697e.show();
            C0332j.m2148a().m2156a(charSequence, charSequence2);
        } else {
            this.f1787a.f1700h.setError("passwords do not match");
        }
    }
}
