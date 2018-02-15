package group.pals.android.lib.ui.filechooser.utils;

import android.content.Context;

/* compiled from: MyApp */
public class C0280i {
    public static boolean m1896a(Context context, String... strArr) {
        for (String checkCallingOrSelfPermission : strArr) {
            if (context.checkCallingOrSelfPermission(checkCallingOrSelfPermission) == -1) {
                return false;
            }
        }
        return true;
    }
}
