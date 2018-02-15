package android.support.v7.internal.view.menu;

/* compiled from: MyApp */
class C0182h implements ag {
    final /* synthetic */ ActionMenuPresenter f694a;

    private C0182h(ActionMenuPresenter actionMenuPresenter) {
        this.f694a = actionMenuPresenter;
    }

    public boolean mo179b(C0174q c0174q) {
        if (c0174q != null) {
            this.f694a.f570b = ((al) c0174q).getItem().getItemId();
        }
        return false;
    }

    public void mo169a(C0174q c0174q, boolean z) {
        if (c0174q instanceof al) {
            ((al) c0174q).mo238o().m1333a(false);
        }
    }
}
