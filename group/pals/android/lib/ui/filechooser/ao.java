package group.pals.android.lib.ui.filechooser;

import android.view.View;
import android.view.View.OnLongClickListener;
import group.pals.android.lib.ui.filechooser.utils.p010a.C0261a;

/* compiled from: MyApp */
class ao implements OnLongClickListener {
    final /* synthetic */ an f1119a;

    ao(an anVar) {
        this.f1119a = anVar;
    }

    public boolean onLongClick(View view) {
        C0261a.m1871a(view.getContext(), 0, be.afc_title_advanced_selection, this.f1119a.f1111b, new ap(this, view));
        return true;
    }
}
