package net.client.by.lock.gui.p018b;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import net.client.by.lock.C0322b;
import net.client.by.lock.R;

/* compiled from: MyApp */
public class an {
    static String f1864a = "TOST";

    public static void m2729a(Context context, String str, Boolean bool) {
        try {
            Toast toast = new Toast(context);
            View inflate = View.inflate(context, R.layout.toast, null);
            ((TextView) inflate.findViewById(R.id.textView1)).setText(str);
            toast.setView(inflate);
            if (bool.booleanValue()) {
                toast.setDuration(1);
            } else {
                toast.setDuration(0);
            }
            toast.setGravity(17, 0, 0);
            toast.show();
        } catch (Exception e) {
            C0322b.m2076e(f1864a, e.toString());
        }
    }

    public static void m2728a(Context context, String str) {
        an.m2729a(context, str, Boolean.valueOf(true));
    }

    public static void m2730b(Context context, String str) {
        an.m2729a(context, str, Boolean.valueOf(false));
    }
}
