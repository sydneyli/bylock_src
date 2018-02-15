package group.pals.android.lib.ui.filechooser;

import android.view.View;
import android.view.View.OnClickListener;
import group.pals.android.lib.ui.filechooser.utils.C0278h;

/* compiled from: MyApp */
class aj implements OnClickListener {
    final /* synthetic */ FileChooserActivity f1103a;

    aj(FileChooserActivity fileChooserActivity) {
        this.f1103a = fileChooserActivity;
    }

    public void onClick(View view) {
        C0278h.m1893a(this.f1103a, this.f1103a.f1068I.getWindowToken());
        this.f1103a.m1703a(this.f1103a.f1068I.getText().toString().trim());
    }
}
