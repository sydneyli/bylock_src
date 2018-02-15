package net.client.by.lock.gui.activity;

import android.view.View;
import android.view.View.OnClickListener;
import net.client.by.lock.C0333c;

/* compiled from: MyApp */
class bx implements OnClickListener {
    final /* synthetic */ ValidateActivity f1799a;

    bx(ValidateActivity validateActivity) {
        this.f1799a = validateActivity;
    }

    public void onClick(View view) {
        if (((String) this.f1799a.f1711e.m2288x().m2467a()).equals("KWIS")) {
            C0333c.m2187c().m2189a(Integer.valueOf(this.f1799a.f1711e.m2237K()), this.f1799a.f1711e.m2229C());
            this.f1799a.f1711e.m2287w();
            return;
        }
        this.f1799a.f1711e.m2234H();
    }
}
