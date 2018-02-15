package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.p000a.C0006d;

/* compiled from: MyApp */
public class af {
    private static final ag f116a;

    static {
        if (VERSION.SDK_INT >= 16) {
            f116a = new ai();
        } else {
            f116a = new ah();
        }
    }

    public static boolean m122a(Activity activity, Intent intent) {
        return f116a.mo5a(activity, intent);
    }

    public static void m125b(Activity activity, Intent intent) {
        f116a.mo6b(activity, intent);
    }

    public static Intent m120a(Activity activity) {
        return f116a.mo3a(activity);
    }

    public static Intent m121a(Context context, ComponentName componentName) {
        String b = m124b(context, componentName);
        if (b == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), b);
        return m124b(context, componentName2) == null ? C0006d.m11a(componentName2) : new Intent().setComponent(componentName2);
    }

    public static String m123b(Activity activity) {
        try {
            return m124b((Context) activity, activity.getComponentName());
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String m124b(Context context, ComponentName componentName) {
        return f116a.mo4a(context, context.getPackageManager().getActivityInfo(componentName, 128));
    }
}
