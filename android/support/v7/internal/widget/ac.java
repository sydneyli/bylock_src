package android.support.v7.internal.widget;

/* compiled from: MyApp */
class ac implements Runnable {
    final /* synthetic */ C0194u f902a;

    private ac(C0194u c0194u) {
        this.f902a = c0194u;
    }

    public void run() {
        if (this.f902a.f927e != null && this.f902a.f927e.getCount() > this.f902a.f927e.getChildCount() && this.f902a.f927e.getChildCount() <= this.f902a.f923a) {
            this.f902a.f925c.setInputMethodMode(2);
            this.f902a.mo267c();
        }
    }
}
