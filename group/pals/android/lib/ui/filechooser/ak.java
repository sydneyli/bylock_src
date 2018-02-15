package group.pals.android.lib.ui.filechooser;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MyApp */
class ak implements OnClickListener {
    final /* synthetic */ FileChooserActivity f1104a;

    ak(FileChooserActivity fileChooserActivity) {
        this.f1104a = fileChooserActivity;
    }

    public void onClick(View view) {
        List arrayList = new ArrayList();
        for (int i = 0; i < ((ListAdapter) this.f1104a.f1065F.getAdapter()).getCount(); i++) {
            Object item = ((ListAdapter) this.f1104a.f1065F.getAdapter()).getItem(i);
            if (item instanceof av) {
                av avVar = (av) item;
                if (avVar.m1813b()) {
                    arrayList.add(avVar.m1810a());
                }
            }
        }
        this.f1104a.m1704a((ArrayList) arrayList);
    }
}
