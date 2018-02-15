package group.pals.android.lib.ui.filechooser;

import android.view.View;
import android.view.View.OnClickListener;
import group.pals.android.lib.ui.filechooser.io.IFile;

/* compiled from: MyApp */
class ac implements OnClickListener {
    final /* synthetic */ FileChooserActivity f1096a;

    ac(FileChooserActivity fileChooserActivity) {
        this.f1096a = fileChooserActivity;
    }

    public void onClick(View view) {
        IFile a = this.f1096a.m1741p();
        while (true) {
            IFile iFile = (IFile) this.f1096a.f1089y.mo289f(a);
            if (!a.mo298a(iFile)) {
                break;
            }
            this.f1096a.f1089y.mo283c(iFile);
        }
        if (iFile != null) {
            this.f1096a.m1701a(iFile, new ad(this));
        } else {
            this.f1096a.f1070K.setEnabled(false);
        }
    }
}
