package net.client.by.lock.gui.activity;

import android.view.View;
import android.view.View.OnClickListener;
import net.client.by.lock.R;
import net.client.by.lock.gui.p018b.C0418b;
import net.client.by.lock.p014c.C0332j;

/* compiled from: MyApp */
class af implements OnClickListener {
    final /* synthetic */ ae f1726a;

    af(ae aeVar) {
        this.f1726a = aeVar;
    }

    public void onClick(View view) {
        String charSequence = ae.f1721P.getText().toString();
        String charSequence2 = ae.f1722Q.getText().toString();
        if (charSequence.length() > 0) {
            if (this.f1726a.f1725S == null) {
                this.f1726a.f1725S = C0418b.m2735a(ad.f1720b, (int) R.string.adding);
            }
            this.f1726a.f1725S.show();
            C0332j.m2148a().m2157a(charSequence, charSequence2, this.f1726a);
        }
    }
}
