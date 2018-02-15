package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import java.util.ArrayList;

/* compiled from: MyApp */
public class ap {
    Context f128a;
    CharSequence f129b;
    CharSequence f130c;
    PendingIntent f131d;
    PendingIntent f132e;
    RemoteViews f133f;
    Bitmap f134g;
    CharSequence f135h;
    int f136i;
    int f137j;
    boolean f138k;
    aw f139l;
    CharSequence f140m;
    int f141n;
    int f142o;
    boolean f143p;
    ArrayList f144q = new ArrayList();
    Notification f145r = new Notification();

    public ap(Context context) {
        this.f128a = context;
        this.f145r.when = System.currentTimeMillis();
        this.f145r.audioStreamType = -1;
        this.f137j = 0;
    }

    public ap m147a(int i) {
        this.f145r.icon = i;
        return this;
    }

    public ap m149a(CharSequence charSequence) {
        this.f129b = charSequence;
        return this;
    }

    public ap m151b(CharSequence charSequence) {
        this.f130c = charSequence;
        return this;
    }

    public ap m148a(PendingIntent pendingIntent) {
        this.f131d = pendingIntent;
        return this;
    }

    public ap m153c(CharSequence charSequence) {
        this.f145r.tickerText = charSequence;
        return this;
    }

    public ap m150a(boolean z) {
        m145a(2, z);
        return this;
    }

    public ap m152b(boolean z) {
        m145a(8, z);
        return this;
    }

    public ap m154c(boolean z) {
        m145a(16, z);
        return this;
    }

    private void m145a(int i, boolean z) {
        if (z) {
            Notification notification = this.f145r;
            notification.flags |= i;
            return;
        }
        notification = this.f145r;
        notification.flags &= i ^ -1;
    }

    public Notification m146a() {
        return al.f117a.mo7a(this);
    }
}
