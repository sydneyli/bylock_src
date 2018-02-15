package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;

/* compiled from: MyApp */
class ai extends ah {
    ai() {
    }

    public Intent mo3a(Activity activity) {
        Intent a = aj.m139a(activity);
        if (a == null) {
            return m137b(activity);
        }
        return a;
    }

    Intent m137b(Activity activity) {
        return super.mo3a(activity);
    }

    public boolean mo5a(Activity activity, Intent intent) {
        return aj.m141a(activity, intent);
    }

    public void mo6b(Activity activity, Intent intent) {
        aj.m142b(activity, intent);
    }

    public String mo4a(Context context, ActivityInfo activityInfo) {
        String a = aj.m140a(activityInfo);
        if (a == null) {
            return super.mo4a(context, activityInfo);
        }
        return a;
    }
}
