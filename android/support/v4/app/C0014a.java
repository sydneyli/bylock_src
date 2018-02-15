package android.support.v4.app;

import android.app.Activity;
import android.os.Build.VERSION;
import android.support.v4.p000a.C0003a;

/* compiled from: MyApp */
public class C0014a extends C0003a {
    public static void m92a(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            C0016c.m175a(activity);
        } else {
            activity.finish();
        }
    }
}
