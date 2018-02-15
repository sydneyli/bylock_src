package group.pals.android.lib.ui.filechooser.utils.p010a;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ListView;
import group.pals.android.lib.ui.filechooser.an;
import group.pals.android.lib.ui.filechooser.av;
import group.pals.android.lib.ui.filechooser.bc;
import group.pals.android.lib.ui.filechooser.be;
import group.pals.android.lib.ui.filechooser.io.IFile;
import group.pals.android.lib.ui.filechooser.services.C0251c;
import group.pals.android.lib.ui.filechooser.services.C0254d;
import group.pals.android.lib.ui.filechooser.utils.history.History;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MyApp */
public class C0267j {
    public static void m1881a(Context context, C0251c c0251c, History history, IFile iFile, C0226i c0226i) {
        if (!history.mo284c()) {
            AlertDialog a = C0263d.m1873a(context);
            a.setButton(-2, null, null);
            a.setIcon(17301659);
            a.setTitle(be.afc_title_history);
            List arrayList = new ArrayList();
            ArrayList b = history.mo281b();
            for (int size = b.size() - 1; size >= 0; size--) {
                IFile iFile2 = (IFile) b.get(size);
                if (iFile2 != iFile) {
                    boolean z;
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (iFile2.mo298a(((av) arrayList.get(i)).m1810a())) {
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    if (!z) {
                        arrayList.add(new av(iFile2));
                    }
                }
            }
            Object anVar = new an(context, arrayList, C0254d.DirectoriesOnly, false);
            ListView listView = (ListView) LayoutInflater.from(context).inflate(bc.afc_listview_files, null);
            listView.setBackgroundResource(0);
            listView.setFastScrollEnabled(true);
            listView.setAdapter(anVar);
            listView.setOnItemClickListener(new C0268k(c0226i, a, anVar));
            a.setView(listView);
            a.setButton(-1, context.getString(be.afc_cmd_clear), new C0269l(history));
            a.setOnCancelListener(new C0270m(c0226i));
            a.show();
        }
    }
}
