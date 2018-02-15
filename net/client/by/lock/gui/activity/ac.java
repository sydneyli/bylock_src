package net.client.by.lock.gui.activity;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MyApp */
class ac implements OnClickListener {
    int f1717a;
    final /* synthetic */ MainActivity f1718b;

    public ac(MainActivity mainActivity, int i) {
        this.f1718b = mainActivity;
        this.f1717a = i;
    }

    public void onClick(View view) {
        this.f1718b.f1652p.m351a(this.f1717a, true);
        for (int i = 0; i < 5; i++) {
            boolean z;
            View view2 = this.f1718b.f1653r[i];
            if (i != this.f1717a) {
                z = true;
            } else {
                z = false;
            }
            view2.setEnabled(z);
        }
    }
}
