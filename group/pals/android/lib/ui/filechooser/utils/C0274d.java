package group.pals.android.lib.ui.filechooser.utils;

import android.app.AlertDialog;
import android.content.Context;
import group.pals.android.lib.ui.filechooser.utils.p010a.C0263d;

/* compiled from: MyApp */
public class C0274d {
    public static void m1886a(Context context) {
        CharSequence format;
        try {
            format = String.format("Hi  :-)\n\n%s v%s\nâ€¦by Hai Bison Apps\n\nhttp://www.haibison.com\n\nHope you enjoy this library.", new Object[]{"android-filechooser", "5.0"});
        } catch (Exception e) {
            format = "Oopsâ€¦ You've found a broken Easter egg, try again later  :-(";
        }
        AlertDialog a = C0263d.m1873a(context);
        a.setButton(-2, null, null);
        a.setTitle("â€¦");
        a.setMessage(format);
        a.show();
    }
}
