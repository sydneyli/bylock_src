package android.support.v7.internal.widget;

/* compiled from: MyApp */
class C0209r implements Runnable {
    final /* synthetic */ C0191l f969a;

    private C0209r(C0191l c0191l) {
        this.f969a = c0191l;
    }

    public void run() {
        if (!this.f969a.f763u) {
            this.f969a.mo242a();
        } else if (this.f969a.mo244e() != null) {
            this.f969a.post(this);
        }
    }
}
