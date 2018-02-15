package group.pals.android.lib.ui.filechooser.utils.p010a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import group.pals.android.lib.ui.filechooser.utils.history.History;

/* compiled from: MyApp */
class C0269l implements OnClickListener {
    private final /* synthetic */ History f1221a;

    C0269l(History history) {
        this.f1221a = history;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        this.f1221a.mo286d();
    }
}
