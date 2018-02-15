package group.pals.android.lib.ui.filechooser.utils.p010a;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import group.pals.android.lib.ui.filechooser.be;

/* compiled from: MyApp */
public class C0263d {
    private static Toast f1211a;

    public static void m1876a(Context context, CharSequence charSequence, int i) {
        if (f1211a != null) {
            f1211a.cancel();
        }
        f1211a = Toast.makeText(context, charSequence, i);
        f1211a.show();
    }

    public static void m1874a(Context context, int i, int i2) {
        C0263d.m1876a(context, context.getString(i), i2);
    }

    public static void m1877a(Context context, CharSequence charSequence, OnCancelListener onCancelListener) {
        AlertDialog a = C0263d.m1873a(context);
        a.setIcon(17301543);
        a.setTitle(be.afc_title_error);
        a.setMessage(charSequence);
        a.setOnCancelListener(onCancelListener);
        a.show();
    }

    public static void m1875a(Context context, int i, OnCancelListener onCancelListener) {
        C0263d.m1877a(context, context.getString(i), onCancelListener);
    }

    public static void m1879a(Context context, CharSequence charSequence, OnClickListener onClickListener, OnCancelListener onCancelListener) {
        AlertDialog a = C0263d.m1873a(context);
        a.setIcon(17301543);
        a.setTitle(be.afc_title_confirmation);
        a.setMessage(charSequence);
        a.setButton(-1, context.getString(17039379), onClickListener);
        a.setOnCancelListener(onCancelListener);
        a.show();
    }

    public static void m1878a(Context context, CharSequence charSequence, OnClickListener onClickListener) {
        C0263d.m1879a(context, charSequence, onClickListener, null);
    }

    public static AlertDialog m1873a(Context context) {
        AlertDialog create = C0263d.m1880b(context).create();
        create.setCanceledOnTouchOutside(true);
        return create;
    }

    public static Builder m1880b(Context context) {
        return new Builder(context);
    }
}
