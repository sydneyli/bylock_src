package android.support.v4.p000a;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;

/* compiled from: MyApp */
public class C0003a {
    public static boolean m8a(Context context, Intent[] intentArr, Bundle bundle) {
        int i = VERSION.SDK_INT;
        if (i >= 16) {
            C0005c.m10a(context, intentArr, bundle);
            return true;
        } else if (i < 11) {
            return false;
        } else {
            C0004b.m9a(context, intentArr);
            return true;
        }
    }
}
