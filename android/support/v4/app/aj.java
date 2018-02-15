package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

/* compiled from: MyApp */
class aj {
    public static Intent m139a(Activity activity) {
        return activity.getParentActivityIntent();
    }

    public static boolean m141a(Activity activity, Intent intent) {
        return activity.shouldUpRecreateTask(intent);
    }

    public static void m142b(Activity activity, Intent intent) {
        activity.navigateUpTo(intent);
    }

    public static String m140a(ActivityInfo activityInfo) {
        return activityInfo.parentActivityName;
    }
}
