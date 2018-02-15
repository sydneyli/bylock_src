package group.pals.android.lib.ui.filechooser;

import android.view.View;
import android.view.View.OnLongClickListener;
import group.pals.android.lib.ui.filechooser.utils.p010a.C0267j;

/* compiled from: MyApp */
class ae implements OnLongClickListener {
    final /* synthetic */ FileChooserActivity f1098a;

    ae(FileChooserActivity fileChooserActivity) {
        this.f1098a = fileChooserActivity;
    }

    public boolean onLongClick(View view) {
        C0267j.m1881a(this.f1098a, this.f1098a.f1083s, this.f1098a.f1090z, this.f1098a.m1741p(), new af(this));
        return false;
    }
}
