package net.client.by.lock.gui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.p008b.C0157k;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewAnimator;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import net.client.by.lock.R;
import net.client.by.lock.gui.p018b.C0418b;
import net.client.by.lock.gui.p018b.an;
import net.client.by.lock.p012d.C0334a;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p012d.C0346m;
import net.client.by.lock.p012d.C0347l;
import net.client.by.lock.p012d.C0348n;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p013b.C0312d;
import net.client.by.lock.p013b.C0315h;
import net.client.by.lock.p013b.C0319k;
import net.client.by.lock.p014c.C0327e;
import net.client.by.lock.p016f.C0365j;

/* compiled from: MyApp */
public class aw extends Fragment {
    private static ViewGroup f1759Q;
    private static LinearLayout f1760R;
    private static EditText f1761S;
    private static EditText f1762T;
    private static EditText f1763U;
    private static Button f1764V;
    private static Button f1765W;
    private static ViewAnimator f1766X;
    private static View f1767Y;
    private static ArrayList f1768Z = new ArrayList();
    private static ArrayList aa = new ArrayList();
    private static ArrayList ab = new ArrayList();
    public Dialog f1769P;

    public void mo348c(Bundle bundle) {
        super.mo348c(bundle);
        ad.f1720b = m47b();
        m2677a((LayoutInflater) ad.f1720b.getSystemService("layout_inflater"));
        m51b(true);
    }

    public View mo347a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ad.f1720b = m47b();
        if (f1759Q == null) {
            m2677a(layoutInflater);
        } else if (f1759Q.getParent() != null && (f1759Q.getParent() instanceof ViewGroup)) {
            ((ViewGroup) f1759Q.getParent()).removeView(f1759Q);
        }
        return f1759Q;
    }

    public void mo352a(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.action_mail_send, menu);
        super.mo352a(menu, menuInflater);
    }

    public boolean mo353a(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_attach:
                m36a(new Intent(m47b(), SelectFilesActivity.class), 17);
                return true;
            case R.id.menu_send:
                m2676D();
                return true;
            default:
                return super.mo353a(menuItem);
        }
    }

    private void m2676D() {
        Object obj;
        Object obj2 = null;
        Spanned editableText = f1761S.getEditableText();
        if (aa.size() == 0) {
            an.m2730b(m47b(), "You need to add some recipients.");
            obj = null;
        } else {
            int i = 1;
        }
        Iterator it = ab.iterator();
        while (it.hasNext()) {
            C0334a c0334a = (C0334a) it.next();
            if (c0334a.m2194a() != null && ((String) c0334a.m2194a().m1914F().m2467a()).equals("IN PROGRESS")) {
                an.m2730b(m47b(), "There are files to be uplaoded.");
                break;
            }
        }
        obj2 = obj;
        if (obj2 != null) {
            String str = "<html><body>" + Html.toHtml(editableText) + "</body></html>";
            String editable = f1762T.getText().toString();
            if (editable.length() == 0) {
                editable = "No Subject";
            }
            if (this.f1769P == null) {
                this.f1769P = C0418b.m2735a(ad.f1720b, (int) R.string.sending);
            }
            this.f1769P.show();
            new C0348n(aa, editable, str, ab).m2336a(this);
        }
    }

    public void mo356a(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 14:
                    ArrayList integerArrayListExtra = intent.getIntegerArrayListExtra("selected");
                    ArrayList arrayList = new ArrayList();
                    Iterator it = integerArrayListExtra.iterator();
                    while (it.hasNext()) {
                        C0337c a = C0327e.m2092c().m2094a(Integer.valueOf(((Integer) it.next()).intValue()));
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                    m2694z();
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        m2688a((C0337c) it2.next());
                    }
                    return;
                case C0157k.ActionBar_progressBarPadding /*17*/:
                    m2679b(intent);
                    return;
                default:
                    super.mo356a(i, i2, intent);
                    return;
            }
        }
    }

    private void m2679b(Intent intent) {
        Iterator it;
        ArrayList stringArrayListExtra = intent.getStringArrayListExtra("files");
        if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
            it = stringArrayListExtra.iterator();
            while (it.hasNext()) {
                C0312d c0315h = new C0315h(new File((String) it.next()));
                C0334a c0334a = new C0334a(c0315h);
                c0334a.m2195a(c0315h);
                m2680b(c0334a);
                c0315h.m2061m();
            }
        }
        stringArrayListExtra = intent.getStringArrayListExtra("virtual");
        if (stringArrayListExtra != null) {
            it = stringArrayListExtra.iterator();
            while (it.hasNext()) {
                m2680b(new C0334a(C0319k.m2069b().m2073b((String) it.next())));
            }
        }
    }

    private void m2677a(LayoutInflater layoutInflater) {
        f1759Q = (ViewGroup) layoutInflater.inflate(R.layout.fragment_sendmail, null);
        f1760R = (LinearLayout) f1759Q.findViewById(R.id.mail_attachs);
        f1761S = (EditText) f1759Q.findViewById(R.id.mail_body);
        f1762T = (EditText) f1759Q.findViewById(R.id.mail_subject);
        f1763U = (EditText) f1759Q.findViewById(R.id.mail_to);
        f1764V = (Button) f1759Q.findViewById(R.id.button1);
        f1765W = (Button) f1759Q.findViewById(R.id.button2);
        f1766X = (ViewAnimator) f1759Q.findViewById(R.id.viewAnimator1);
        f1767Y = f1759Q.findViewById(R.id.linearLayout1);
        f1759Q.setOnTouchListener(new ax(this));
        f1764V.setOnClickListener(new ay(this));
        f1765W.setOnClickListener(new az(this));
        f1763U.setOnClickListener(new ba(this));
        m2683f(true);
    }

    private static void m2683f(boolean z) {
        boolean z2;
        int i = R.color.aaa_blue_text_over_white_button;
        int i2 = 0;
        int i3 = R.color.White;
        if (ab.isEmpty()) {
            f1767Y.setVisibility(8);
        } else {
            f1767Y.setVisibility(0);
        }
        Button button = f1764V;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        button.setEnabled(z2);
        f1765W.setEnabled(z);
        f1764V.setTextColor(ad.f1720b.getResources().getColor(z ? R.color.White : R.color.aaa_blue_text_over_white_button));
        f1764V.setBackgroundColor(ad.f1720b.getResources().getColor(z ? R.color.aaa_blue_button_background : R.color.White));
        Button button2 = f1765W;
        Resources resources = ad.f1720b.getResources();
        if (!z) {
            i = R.color.White;
        }
        button2.setTextColor(resources.getColor(i));
        button2 = f1765W;
        Resources resources2 = ad.f1720b.getResources();
        if (!z) {
            i3 = R.color.aaa_blue_button_background;
        }
        button2.setBackgroundColor(resources2.getColor(i3));
        ViewAnimator viewAnimator = f1766X;
        if (!z) {
            i2 = 1;
        }
        viewAnimator.setDisplayedChild(i2);
    }

    public synchronized void m2688a(C0337c c0337c) {
        if (!aa.contains(c0337c)) {
            if (aa.add(c0337c)) {
                StringBuilder stringBuilder = new StringBuilder();
                Iterator it = aa.iterator();
                while (it.hasNext()) {
                    stringBuilder.append(((C0337c) it.next()).m2233G()).append(", ");
                }
                if (stringBuilder.length() > 2) {
                    f1763U.setText(stringBuilder.subSequence(0, stringBuilder.length() - 2));
                } else {
                    f1763U.setText("");
                }
            }
        }
    }

    public synchronized void m2694z() {
        aa.clear();
        f1763U.setText("");
    }

    private synchronized void m2680b(C0334a c0334a) {
        if (!ab.contains(c0334a)) {
            View a = c0334a.m2194a().mo317A().m2551a(m47b(), true);
            Button button = (Button) a.findViewById(R.id.cancel);
            button.setVisibility(0);
            ProgressBar progressBar = (ProgressBar) a.findViewById(R.id.chat_bar);
            button.setOnClickListener(new bb(c0334a));
            TextView textView = (TextView) a.findViewById(R.id.size);
            ((TextView) a.findViewById(R.id.file_name)).setText(c0334a.mo325e());
            textView.setText(C0365j.m2474a((long) c0334a.mo326f().intValue()));
            if (c0334a.m2194a() == null || ((String) c0334a.m2194a().m1914F().m2467a()).equals("COMPLETED")) {
                progressBar.setVisibility(8);
            } else {
                progressBar.setVisibility(0);
            }
            ab.add(c0334a);
            f1768Z.add(a);
            f1760R.addView(a);
            m2683f(false);
        }
    }

    private static synchronized void m2681c(C0334a c0334a) {
        synchronized (aw.class) {
            int indexOf = ab.indexOf(c0334a);
            f1768Z.remove(indexOf);
            ab.remove(indexOf);
            f1760R.removeViewAt(indexOf);
            m2683f(ab.isEmpty());
        }
    }

    public void m2684A() {
        f1761S.setText("");
        f1762T.setText("");
        f1763U.setText("");
        f1768Z.clear();
        aa.clear();
        ab.clear();
        f1760R.removeAllViews();
        m2683f(true);
    }

    public void m2689a(C0337c c0337c, C0346m c0346m) {
        m2690a(c0346m);
        f1762T.setText("Re: " + c0346m.m2319h());
        m2688a(c0337c);
    }

    public void m2690a(C0346m c0346m) {
        m2684A();
        f1762T.setText("Fw: " + c0346m.m2319h());
        String str = "";
        if (c0346m instanceof C0347l) {
            if (c0346m.m1913E().m2231E() == null || c0346m.m1913E().m2231E().length() == 0) {
                str = c0346m.m1913E().m2229C();
            } else {
                str = new StringBuilder(String.valueOf(c0346m.m1913E().m2231E())).append(" (").append(c0346m.m1913E().m2229C()).append(")").toString();
            }
        } else if (C0351r.m2359i().m2392n().m2467a() == null || ((String) C0351r.m2359i().m2392n().m2467a()).length() == 0) {
            str = C0351r.m2359i().m2389k();
        } else {
            str = new StringBuilder(String.valueOf((String) C0351r.m2359i().m2392n().m2467a())).append(" (").append(C0351r.m2359i().m2389k()).append(")").toString();
        }
        f1761S.setText(Html.fromHtml(c0346m.m2318g().replaceAll("<body>", "<body><p><br></p><p>" + c0346m.m1910B() + ", " + str + "  yazdý:</p><blockquote style=\"border-left: 1px solid #CCCCCC; margin: 0 0 0 0.8ex; padding-left: 1ex; color: #222222;\">").replaceAll("</body>", "</blockquote></body>")));
        Iterator it = c0346m.m2324m().iterator();
        while (it.hasNext()) {
            m2680b((C0334a) it.next());
        }
    }

    public void mo351l() {
        super.mo351l();
        f1764V = null;
        f1765W = null;
        f1759Q = null;
        f1760R = null;
        f1761S = null;
        f1762T = null;
        f1768Z.clear();
    }
}
