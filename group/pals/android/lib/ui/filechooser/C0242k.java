package group.pals.android.lib.ui.filechooser;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import group.pals.android.lib.ui.filechooser.p009a.C0223a;
import group.pals.android.lib.ui.filechooser.services.C0256f;

/* compiled from: MyApp */
class C0242k implements OnClickListener {
    final /* synthetic */ FileChooserActivity f1152a;
    private final /* synthetic */ AlertDialog f1153b;

    C0242k(FileChooserActivity fileChooserActivity, AlertDialog alertDialog) {
        this.f1152a = fileChooserActivity;
        this.f1153b = alertDialog;
    }

    public void onClick(View view) {
        this.f1153b.dismiss();
        Context context = this.f1152a;
        if (view.getId() == ba.afc_settings_sort_view_button_sort_by_name_asc) {
            C0223a.m1759a(context, C0256f.SortByName);
            C0223a.m1760a(context, Boolean.valueOf(true));
        } else if (view.getId() == ba.afc_settings_sort_view_button_sort_by_name_desc) {
            C0223a.m1759a(context, C0256f.SortByName);
            C0223a.m1760a(context, Boolean.valueOf(false));
        } else if (view.getId() == ba.afc_settings_sort_view_button_sort_by_size_asc) {
            C0223a.m1759a(context, C0256f.SortBySize);
            C0223a.m1760a(context, Boolean.valueOf(true));
        } else if (view.getId() == ba.afc_settings_sort_view_button_sort_by_size_desc) {
            C0223a.m1759a(context, C0256f.SortBySize);
            C0223a.m1760a(context, Boolean.valueOf(false));
        } else if (view.getId() == ba.afc_settings_sort_view_button_sort_by_date_asc) {
            C0223a.m1759a(context, C0256f.SortByDate);
            C0223a.m1760a(context, Boolean.valueOf(true));
        } else if (view.getId() == ba.afc_settings_sort_view_button_sort_by_date_desc) {
            C0223a.m1759a(context, C0256f.SortByDate);
            C0223a.m1760a(context, Boolean.valueOf(false));
        }
        this.f1152a.m1735m();
    }
}
