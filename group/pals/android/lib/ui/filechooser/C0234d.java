package group.pals.android.lib.ui.filechooser;

import android.widget.ImageView;
import group.pals.android.lib.ui.filechooser.utils.history.C0233b;
import group.pals.android.lib.ui.filechooser.utils.history.History;

/* compiled from: MyApp */
class C0234d implements C0233b {
    final /* synthetic */ FileChooserActivity f1142a;

    C0234d(FileChooserActivity fileChooserActivity) {
        this.f1142a = fileChooserActivity;
    }

    public void mo296a(History history) {
        boolean z;
        boolean z2 = true;
        int d = history.mo285d(this.f1142a.m1741p());
        ImageView c = this.f1142a.f1069J;
        if (d > 0) {
            z = true;
        } else {
            z = false;
        }
        c.setEnabled(z);
        ImageView d2 = this.f1142a.f1070K;
        if (d < 0 || d >= history.mo277a() - 1) {
            z2 = false;
        }
        d2.setEnabled(z2);
    }
}
