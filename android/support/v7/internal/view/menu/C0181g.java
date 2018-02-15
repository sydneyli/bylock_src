package android.support.v7.internal.view.menu;

import android.content.Context;
import android.view.View;

/* compiled from: MyApp */
class C0181g extends ad {
    final /* synthetic */ ActionMenuPresenter f693a;

    public C0181g(ActionMenuPresenter actionMenuPresenter, Context context, C0174q c0174q, View view, boolean z) {
        this.f693a = actionMenuPresenter;
        super(context, c0174q, view, z);
        m1296a(actionMenuPresenter.f569a);
    }

    public void onDismiss() {
        super.onDismiss();
        this.f693a.e.close();
        this.f693a.f584v = null;
    }
}
