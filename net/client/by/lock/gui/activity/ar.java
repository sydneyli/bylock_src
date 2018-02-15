package net.client.by.lock.gui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Observable;
import java.util.Observer;
import net.client.by.lock.R;
import net.client.by.lock.p012d.C0351r;

/* compiled from: MyApp */
public class ar extends Fragment implements Observer {
    private static ViewGroup f1746P;
    private static TextView f1747Q;
    private static TextView f1748R;
    private static TextView f1749S;
    private static TextView f1750T;
    private static ImageView f1751U;
    private static View f1752V;
    private static View f1753W;
    private static View f1754X;

    public void mo348c(Bundle bundle) {
        super.mo348c(bundle);
        ad.f1720b = m47b();
        m51b(true);
        m2665a((LayoutInflater) ad.f1720b.getSystemService("layout_inflater"));
    }

    public void mo349i() {
        super.mo349i();
        C0351r.m2359i().m2369b().addObserver(this);
        C0351r.m2359i().m2393o().addObserver(this);
        C0351r.m2359i().m2392n().addObserver(this);
    }

    public void mo350j() {
        C0351r.m2359i().m2369b().deleteObserver(this);
        C0351r.m2359i().m2393o().deleteObserver(this);
        C0351r.m2359i().m2392n().deleteObserver(this);
        super.mo350j();
    }

    public View mo347a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ad.f1720b = m47b();
        if (f1746P == null) {
            m2665a(layoutInflater);
        } else if (f1746P.getParent() != null && (f1746P.getParent() instanceof ViewGroup)) {
            ((ViewGroup) f1746P.getParent()).removeView(f1746P);
        }
        m2666z();
        return f1746P;
    }

    public void mo352a(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.action_profile, menu);
        super.mo352a(menu, menuInflater);
    }

    public boolean mo353a(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_logout:
                ad.f1720b.onBackPressed();
                return true;
            default:
                return super.mo353a(menuItem);
        }
    }

    private void m2665a(LayoutInflater layoutInflater) {
        f1746P = (ViewGroup) layoutInflater.inflate(R.layout.fragment_profile, null);
        f1747Q = (TextView) f1746P.findViewById(R.id.name);
        f1748R = (TextView) f1746P.findViewById(R.id.public_message);
        f1752V = f1746P.findViewById(R.id.edit_name);
        f1753W = f1746P.findViewById(R.id.edit_password);
        f1754X = f1746P.findViewById(R.id.edit_public_message);
        f1749S = (TextView) f1746P.findViewById(R.id.username);
        f1751U = (ImageView) f1746P.findViewById(R.id.status_img);
        f1750T = (TextView) f1746P.findViewById(R.id.status_text);
        f1749S.setText(C0351r.m2359i().m2389k());
        f1747Q.setText((CharSequence) C0351r.m2359i().m2392n().m2467a());
        f1748R.setText((CharSequence) C0351r.m2359i().m2393o().m2467a());
        f1752V.setOnClickListener(new as(this));
        f1753W.setOnClickListener(new at(this));
        f1754X.setOnClickListener(new au(this));
        OnClickListener avVar = new av(this);
        f1751U.setOnClickListener(avVar);
        f1750T.setOnClickListener(avVar);
    }

    private void m2666z() {
        switch (((Integer) C0351r.m2359i().m2369b().m2467a()).intValue()) {
            case 0:
                f1750T.setText(R.string.status_offline);
                f1751U.setImageResource(R.drawable.big_online_0);
                return;
            case 1:
                f1750T.setText(R.string.status_busy);
                f1751U.setImageResource(R.drawable.big_online_1);
                return;
            case 2:
                f1750T.setText(R.string.status_away);
                f1751U.setImageResource(R.drawable.big_online_2);
                return;
            case 3:
                f1750T.setText(R.string.status_available);
                f1751U.setImageResource(R.drawable.big_online_3);
                return;
            default:
                return;
        }
    }

    public void update(Observable observable, Object obj) {
        if (obj == null) {
            return;
        }
        if (obj.equals("status")) {
            m2666z();
        } else if (obj.equals("publicMessage")) {
            f1748R.setText((CharSequence) C0351r.m2359i().m2393o().m2467a());
        } else if (obj.equals("name")) {
            f1747Q.setText((CharSequence) C0351r.m2359i().m2392n().m2467a());
        }
    }

    public void mo351l() {
        super.mo351l();
        f1746P = null;
        f1747Q = null;
        f1752V = null;
        f1753W = null;
        f1754X = null;
        f1748R = null;
        f1749S = null;
        f1750T = null;
        f1751U = null;
    }
}
