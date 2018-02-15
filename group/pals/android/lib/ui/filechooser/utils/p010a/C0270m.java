package group.pals.android.lib.ui.filechooser.utils.p010a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* compiled from: MyApp */
class C0270m implements OnCancelListener {
    private final /* synthetic */ C0226i f1222a;

    C0270m(C0226i c0226i) {
        this.f1222a = c0226i;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f1222a != null) {
            this.f1222a.mo291a(true, null);
        }
    }
}
