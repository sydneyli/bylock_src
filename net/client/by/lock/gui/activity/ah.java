package net.client.by.lock.gui.activity;

import android.os.Bundle;
import android.os.FileObserver;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import net.client.by.lock.R;
import net.client.by.lock.p014c.C0331i;

/* compiled from: MyApp */
public class ah extends Fragment {
    private static ViewGroup f1728P;
    private static ListView f1729Q;
    private static ArrayAdapter f1730R;
    private static FileObserver f1731S = new ak();
    private static ArrayList f1732T = new ArrayList();

    public void mo348c(Bundle bundle) {
        super.mo348c(bundle);
        ad.f1720b = m47b();
        m2651a((LayoutInflater) ad.f1720b.getSystemService("layout_inflater"));
    }

    public View mo347a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ad.f1720b = m47b();
        if (f1728P == null) {
            m2651a(layoutInflater);
        } else if (f1728P.getParent() != null && (f1728P.getParent() instanceof ViewGroup)) {
            ((ViewGroup) f1728P.getParent()).removeView(f1728P);
        }
        return f1728P;
    }

    private void m2651a(LayoutInflater layoutInflater) {
        f1728P = (ViewGroup) layoutInflater.inflate(R.layout.fragment_downloads, null);
        f1729Q = (ListView) f1728P.findViewById(R.id.listView1);
        File file = new File(C0331i.m2124a().m2132b());
        if (!file.exists()) {
            file.mkdirs();
        }
        f1732T.clear();
        String[] list = file.list();
        if (list != null) {
            f1732T.addAll(Arrays.asList(list));
        }
        f1730R = new ArrayAdapter(ad.f1720b, R.layout.item_downloads, f1732T);
        f1729Q.setAdapter(f1730R);
        f1731S.startWatching();
        f1729Q.setOnItemClickListener(new ai(this));
        f1729Q.setOnItemLongClickListener(new aj(this));
    }

    public void mo351l() {
        super.mo351l();
        f1728P = null;
        f1730R.notifyDataSetInvalidated();
        f1730R = null;
        f1729Q = null;
        f1731S.stopWatching();
    }
}
