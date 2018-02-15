package android.support.v4.app;

import android.app.Notification;
import java.util.Iterator;

/* compiled from: MyApp */
class av implements ar {
    av() {
    }

    public Notification mo7a(ap apVar) {
        az azVar = new az(apVar.f128a, apVar.f145r, apVar.f129b, apVar.f130c, apVar.f135h, apVar.f133f, apVar.f136i, apVar.f131d, apVar.f132e, apVar.f134g, apVar.f141n, apVar.f142o, apVar.f143p, apVar.f138k, apVar.f137j, apVar.f140m);
        Iterator it = apVar.f144q.iterator();
        while (it.hasNext()) {
            am amVar = (am) it.next();
            azVar.m163a(amVar.f118a, amVar.f119b, amVar.f120c);
        }
        if (apVar.f139l != null) {
            if (apVar.f139l instanceof ao) {
                ao aoVar = (ao) apVar.f139l;
                azVar.m165a(aoVar.d, aoVar.f, aoVar.e, aoVar.f127a);
            } else if (apVar.f139l instanceof aq) {
                aq aqVar = (aq) apVar.f139l;
                azVar.m166a(aqVar.d, aqVar.f, aqVar.e, aqVar.f146a);
            } else if (apVar.f139l instanceof an) {
                an anVar = (an) apVar.f139l;
                azVar.m164a(anVar.d, anVar.f, anVar.e, anVar.f124a, anVar.f125b, anVar.f126c);
            }
        }
        return azVar.m162a();
    }
}
