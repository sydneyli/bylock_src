package group.pals.android.lib.ui.filechooser;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import group.pals.android.lib.ui.filechooser.services.C0254d;

/* compiled from: MyApp */
class C0232c implements OnItemLongClickListener {
    final /* synthetic */ FileChooserActivity f1141a;

    C0232c(FileChooserActivity fileChooserActivity) {
        this.f1141a = fileChooserActivity;
    }

    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        av a = this.f1141a.f1060A.m1789a(i);
        if (!(this.f1141a.f1088x || this.f1141a.f1087w || this.f1141a.f1086v || !a.m1810a().isDirectory() || (!C0254d.DirectoriesOnly.equals(this.f1141a.f1083s.mo308c()) && !C0254d.FilesAndDirectories.equals(this.f1141a.f1083s.mo308c())))) {
            this.f1141a.m1705a(a.m1810a());
        }
        return true;
    }
}
