package android.support.v7.internal.view.menu;

import android.content.DialogInterface;

/* compiled from: MyApp */
class C0178d extends C0177t {
    final /* synthetic */ ActionMenuPresenter f689a;

    public C0178d(ActionMenuPresenter actionMenuPresenter, al alVar) {
        this.f689a = actionMenuPresenter;
        super(alVar);
        actionMenuPresenter.m1211a(actionMenuPresenter.f569a);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.f689a.f585w = null;
        this.f689a.f570b = 0;
    }
}
