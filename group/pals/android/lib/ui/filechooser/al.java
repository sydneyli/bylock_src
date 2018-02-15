package group.pals.android.lib.ui.filechooser;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: MyApp */
class al implements OnItemClickListener {
    final /* synthetic */ FileChooserActivity f1105a;

    al(FileChooserActivity fileChooserActivity) {
        this.f1105a = fileChooserActivity;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        av a = this.f1105a.f1060A.m1789a(i);
        if (a.m1810a().isDirectory()) {
            this.f1105a.m1707a(a.m1810a());
            return;
        }
        if (this.f1105a.f1087w) {
            this.f1105a.f1068I.setText(a.m1810a().getName());
        }
        if (!this.f1105a.f1088x && !this.f1105a.f1086v) {
            if (this.f1105a.f1087w) {
                this.f1105a.m1703a(a.m1810a().getName());
                return;
            }
            this.f1105a.m1705a(a.m1810a());
        }
    }
}
