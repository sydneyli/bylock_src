package group.pals.android.lib.ui.filechooser;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* compiled from: MyApp */
class C0250s implements OnCancelListener {
    final /* synthetic */ FileChooserActivity f1170a;
    private final /* synthetic */ av f1171b;

    C0250s(FileChooserActivity fileChooserActivity, av avVar) {
        this.f1170a = fileChooserActivity;
        this.f1171b = avVar;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f1170a.m1700a(this.f1171b);
    }
}
