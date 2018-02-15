package group.pals.android.lib.ui.filechooser.utils.p010a;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import group.pals.android.lib.ui.filechooser.ba;
import group.pals.android.lib.ui.filechooser.bc;

/* compiled from: MyApp */
public class C0261a {
    public static void m1872a(Context context, int i, String str, Integer[] numArr, C0228c c0228c) {
        ListAdapter c0266h = new C0266h(context, numArr);
        View inflate = LayoutInflater.from(context).inflate(bc.afc_context_menu_view, null);
        ListView listView = (ListView) inflate.findViewById(ba.afc_context_menu_view_listview_menu);
        listView.setAdapter(c0266h);
        AlertDialog a = C0263d.m1873a(context);
        a.setButton(-2, null, null);
        a.setCanceledOnTouchOutside(true);
        if (i > 0) {
            a.setIcon(i);
        }
        a.setTitle(str);
        a.setView(inflate);
        if (c0228c != null) {
            listView.setOnItemClickListener(new C0262b(a, c0228c, numArr));
        }
        a.show();
    }

    public static void m1871a(Context context, int i, int i2, Integer[] numArr, C0228c c0228c) {
        C0261a.m1872a(context, i, i2 > 0 ? context.getString(i2) : null, numArr, c0228c);
    }
}
