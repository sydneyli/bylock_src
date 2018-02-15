package net.client.by.lock.gui.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import net.client.by.lock.R;

/* compiled from: MyApp */
public class ae extends Fragment {
    public static TextView f1721P;
    public static TextView f1722Q;
    public static Button f1723R;
    private static ViewGroup f1724T;
    public Dialog f1725S;

    public void mo348c(Bundle bundle) {
        super.mo348c(bundle);
        ad.f1720b = m47b();
        m2642a((LayoutInflater) ad.f1720b.getSystemService("layout_inflater"));
    }

    public void mo350j() {
        super.mo350j();
    }

    public void mo349i() {
        super.mo349i();
    }

    public View mo347a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ad.f1720b = m47b();
        if (f1724T == null) {
            m2642a(layoutInflater);
        } else if (f1724T.getParent() != null && (f1724T.getParent() instanceof ViewGroup)) {
            ((ViewGroup) f1724T.getParent()).removeView(f1724T);
        }
        return f1724T;
    }

    private void m2642a(LayoutInflater layoutInflater) {
        f1724T = (ViewGroup) layoutInflater.inflate(R.layout.fragment_addfriend, null);
        f1721P = (TextView) f1724T.findViewById(R.id.editText1);
        f1722Q = (TextView) f1724T.findViewById(R.id.editText2);
        f1723R = (Button) f1724T.findViewById(R.id.button1);
        f1723R.setOnClickListener(new af(this));
        f1724T.setOnTouchListener(new ag(this));
    }

    public void mo351l() {
        super.mo351l();
        f1724T = null;
        f1721P = null;
        f1722Q = null;
        f1723R = null;
    }
}
