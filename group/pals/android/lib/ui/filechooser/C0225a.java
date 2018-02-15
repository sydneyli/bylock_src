package group.pals.android.lib.ui.filechooser;

import android.view.View;
import android.view.View.OnClickListener;
import group.pals.android.lib.ui.filechooser.io.IFile;

/* compiled from: MyApp */
class C0225a implements OnClickListener {
    final /* synthetic */ FileChooserActivity f1093a;

    C0225a(FileChooserActivity fileChooserActivity) {
        this.f1093a = fileChooserActivity;
    }

    public void onClick(View view) {
        IFile a = this.f1093a.m1741p();
        while (true) {
            IFile iFile = (IFile) this.f1093a.f1089y.mo287e(a);
            if (!a.mo298a(iFile)) {
                break;
            }
            this.f1093a.f1089y.mo283c(iFile);
        }
        if (iFile != null) {
            this.f1093a.m1701a(iFile, new C0231b(this));
        } else {
            this.f1093a.f1069J.setEnabled(false);
        }
    }
}
