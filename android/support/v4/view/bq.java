package android.support.v4.view;

/* compiled from: MyApp */
class bq implements Runnable {
    final /* synthetic */ ViewPager f319a;

    bq(ViewPager viewPager) {
        this.f319a = viewPager;
    }

    public void run() {
        this.f319a.setScrollState(0);
        this.f319a.m359c();
    }
}
