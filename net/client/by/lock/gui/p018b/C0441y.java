package net.client.by.lock.gui.p018b;

import android.view.View;
import android.view.View.OnClickListener;
import net.client.by.lock.R;

/* compiled from: MyApp */
class C0441y implements OnClickListener {
    final /* synthetic */ C0440x f1928a;

    C0441y(C0440x c0440x) {
        this.f1928a = c0440x;
    }

    public void onClick(View view) {
        this.f1928a.f1926f.setVisibility(8);
        this.f1928a.f1927g.setVisibility(8);
        this.f1928a.f1922b.setText(R.string.fr_current);
        this.f1928a.f1921a.setVisibility(0);
        this.f1928a.f1924d.setVisibility(0);
        this.f1928a.f1923c = new aa(this.f1928a);
        this.f1928a.f1923c.execute(new Void[0]);
    }
}
