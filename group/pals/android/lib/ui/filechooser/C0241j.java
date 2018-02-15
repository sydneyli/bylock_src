package group.pals.android.lib.ui.filechooser;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* compiled from: MyApp */
class C0241j implements OnCancelListener {
    final /* synthetic */ FileChooserActivity f1151a;

    C0241j(FileChooserActivity fileChooserActivity) {
        this.f1151a = fileChooserActivity;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f1151a.setResult(0);
        this.f1151a.finish();
    }
}
