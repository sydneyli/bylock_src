package group.pals.android.lib.ui.filechooser.utils.p010a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* compiled from: MyApp */
class C0264f implements OnCancelListener {
    final /* synthetic */ C0229e f1212a;

    C0264f(C0229e c0229e) {
        this.f1212a = c0229e;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f1212a.cancel(true);
    }
}
