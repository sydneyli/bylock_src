package group.pals.android.lib.ui.filechooser;

import android.view.View;
import group.pals.android.lib.ui.filechooser.utils.p010a.C0228c;

/* compiled from: MyApp */
class ap implements C0228c {
    final /* synthetic */ ao f1120a;
    private final /* synthetic */ View f1121b;

    ap(ao aoVar, View view) {
        this.f1120a = aoVar;
        this.f1121b = view;
    }

    public void mo293a(int i) {
        new aq(this, this.f1121b.getContext(), be.afc_msg_loading, false, i).execute(new Void[0]);
    }
}
