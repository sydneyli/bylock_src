package android.support.v4.view;

import android.database.DataSetObserver;

/* compiled from: MyApp */
class by extends DataSetObserver {
    final /* synthetic */ ViewPager f332a;

    private by(ViewPager viewPager) {
        this.f332a = viewPager;
    }

    public void onChanged() {
        this.f332a.m358b();
    }

    public void onInvalidated() {
        this.f332a.m358b();
    }
}
