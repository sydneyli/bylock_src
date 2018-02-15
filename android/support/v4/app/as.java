package android.support.v4.app;

import android.app.Notification;

/* compiled from: MyApp */
class as implements ar {
    as() {
    }

    public Notification mo7a(ap apVar) {
        Notification notification = apVar.f145r;
        notification.setLatestEventInfo(apVar.f128a, apVar.f129b, apVar.f130c, apVar.f131d);
        if (apVar.f137j > 0) {
            notification.flags |= 128;
        }
        return notification;
    }
}
