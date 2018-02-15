package group.pals.android.lib.ui.filechooser;

/* compiled from: MyApp */
class C0282w implements Runnable {
    final /* synthetic */ C0260u f1231a;

    C0282w(C0260u c0260u) {
        this.f1231a = c0260u;
    }

    public void run() {
        if (this.f1231a.f1202c >= 0 && this.f1231a.f1202c < this.f1231a.f1204e.f1060A.getCount()) {
            this.f1231a.f1204e.f1065F.setSelection(this.f1231a.f1202c);
        } else if (!this.f1231a.f1204e.f1060A.isEmpty()) {
            this.f1231a.f1204e.f1065F.setSelection(0);
        }
    }
}
