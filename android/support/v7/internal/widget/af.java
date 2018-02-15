package android.support.v7.internal.widget;

/* compiled from: MyApp */
class af implements Runnable {
    final /* synthetic */ ProgressBarICS f903a;
    private int f904b;
    private int f905c;
    private boolean f906d;

    af(ProgressBarICS progressBarICS, int i, int i2, boolean z) {
        this.f903a = progressBarICS;
        this.f904b = i;
        this.f905c = i2;
        this.f906d = z;
    }

    public void run() {
        this.f903a.m1514a(this.f904b, this.f905c, this.f906d, true);
        this.f903a.f880u = this;
    }

    public void m1535a(int i, int i2, boolean z) {
        this.f904b = i;
        this.f905c = i2;
        this.f906d = z;
    }
}
