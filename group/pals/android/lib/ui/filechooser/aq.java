package group.pals.android.lib.ui.filechooser;

import android.content.Context;
import group.pals.android.lib.ui.filechooser.utils.p010a.C0229e;

/* compiled from: MyApp */
class aq extends C0229e {
    final /* synthetic */ ap f1127a;
    private final /* synthetic */ int f1128b;

    aq(ap apVar, Context context, int i, boolean z, int i2) {
        this.f1127a = apVar;
        this.f1128b = i2;
        super(context, i, z);
    }

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m1806a((Void[]) objArr);
    }

    protected Object m1806a(Void... voidArr) {
        if (this.f1128b == be.afc_cmd_advanced_selection_all) {
            this.f1127a.f1120a.f1119a.m1793a(false, null);
        } else if (this.f1128b == be.afc_cmd_advanced_selection_none) {
            this.f1127a.f1120a.f1119a.m1792a(false);
        } else if (this.f1128b == be.afc_cmd_advanced_selection_invert) {
            this.f1127a.f1120a.f1119a.m1796b(false);
        } else if (this.f1128b == be.afc_cmd_select_all_files) {
            this.f1127a.f1120a.f1119a.m1793a(false, new ar(this));
        } else if (this.f1128b == be.afc_cmd_select_all_folders) {
            this.f1127a.f1120a.f1119a.m1793a(false, new as(this));
        }
        return null;
    }

    protected void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        this.f1127a.f1120a.f1119a.notifyDataSetChanged();
    }
}
