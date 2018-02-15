package android.support.v7.internal.view.menu;

import android.view.View;

/* compiled from: MyApp */
class C0179e implements Runnable {
    final /* synthetic */ ActionMenuPresenter f690a;
    private C0181g f691b;

    public C0179e(ActionMenuPresenter actionMenuPresenter, C0181g c0181g) {
        this.f690a = actionMenuPresenter;
        this.f691b = c0181g;
    }

    public void run() {
        this.f690a.e.m1347e();
        View view = (View) this.f690a.h;
        if (!(view == null || view.getWindowToken() == null || !this.f691b.m1299a())) {
            this.f690a.f584v = this.f691b;
        }
        this.f690a.f586x = null;
    }
}
