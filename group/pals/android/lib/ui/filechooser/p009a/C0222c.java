package group.pals.android.lib.ui.filechooser.p009a;

import android.content.Context;
import android.content.SharedPreferences;
import group.pals.android.lib.ui.filechooser.be;

/* compiled from: MyApp */
public class C0222c {
    public static final String m1755h(Context context) {
        return String.format("%s_%s", new Object[]{context.getString(be.afc_lib_name), "9795e88b-2ab4-4b81-a548-409091a1e0c6"});
    }

    public static SharedPreferences m1756i(Context context) {
        return context.getApplicationContext().getSharedPreferences(C0222c.m1755h(context), 4);
    }
}
