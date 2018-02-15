package android.support.v4.widget;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: MyApp */
class C0103c extends ContentObserver {
    final /* synthetic */ C0101a f423a;

    public C0103c(C0101a c0101a) {
        this.f423a = c0101a;
        super(new Handler());
    }

    public boolean deliverSelfNotifications() {
        return true;
    }

    public void onChange(boolean z) {
        this.f423a.m833b();
    }
}
