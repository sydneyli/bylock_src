package android.support.v7.internal.widget;

import android.support.v7.internal.view.menu.C0187u;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MyApp */
class C0202h implements OnClickListener {
    final /* synthetic */ ActionBarView f960a;

    C0202h(ActionBarView actionBarView) {
        this.f960a = actionBarView;
    }

    public void onClick(View view) {
        C0187u c0187u = this.f960a.f833R.f963b;
        if (c0187u != null) {
            c0187u.collapseActionView();
        }
    }
}
