package android.support.v7.p006a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.C0014a;
import android.support.v4.app.C0024j;
import android.support.v4.app.af;
import android.support.v4.app.bb;
import android.support.v4.app.bc;
import android.support.v7.p007c.C0136b;
import android.support.v7.p007c.C0142a;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* compiled from: MyApp */
public class C0131f extends C0024j implements bc, C0127b {
    C0132g f449n;

    public C0126a m1020f() {
        return this.f449n.m1034b();
    }

    public MenuInflater getMenuInflater() {
        return this.f449n.m1037c();
    }

    public void setContentView(int i) {
        this.f449n.mo166a(i);
    }

    public void setContentView(View view) {
        this.f449n.mo170a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        this.f449n.mo171a(view, layoutParams);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        this.f449n.mo178b(view, layoutParams);
    }

    protected void onCreate(Bundle bundle) {
        this.f449n = C0132g.m1022a(this);
        super.onCreate(bundle);
        this.f449n.mo188a(bundle);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f449n.mo167a(configuration);
    }

    protected void onStop() {
        super.onStop();
        this.f449n.mo180d();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.f449n.mo181e();
    }

    public View onCreatePanelView(int i) {
        if (i == 0) {
            return this.f449n.mo177b(i);
        }
        return super.onCreatePanelView(i);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (this.f449n.mo174a(i, menuItem)) {
            return true;
        }
        C0126a f = m1020f();
        if (menuItem.getItemId() != 16908332 || f == null || (f.mo189a() & 4) == 0) {
            return false;
        }
        return m1021g();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        this.f449n.mo172a(charSequence);
    }

    public void mo155c() {
        if (VERSION.SDK_INT >= 14) {
            super.mo155c();
        }
        this.f449n.mo182f();
    }

    public void m1008a(C0142a c0142a) {
    }

    public void m1017b(C0142a c0142a) {
    }

    public C0142a m1005a(C0136b c0136b) {
        return this.f449n.mo165a(c0136b);
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.f449n.mo173a(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.f449n.mo175a(i, view, menu);
    }

    void m1006a(int i) {
        super.setContentView(i);
    }

    void mo154a(View view) {
        super.setContentView(view);
    }

    void m1010a(View view, LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
    }

    void m1018b(View view, LayoutParams layoutParams) {
        super.addContentView(view, layoutParams);
    }

    boolean m1011a(int i, Menu menu) {
        return super.onCreatePanelMenu(i, menu);
    }

    boolean m1013a(int i, View view, Menu menu) {
        return super.onPreparePanel(i, view, menu);
    }

    boolean m1012a(int i, MenuItem menuItem) {
        return super.onMenuItemSelected(i, menuItem);
    }

    public void onBackPressed() {
        if (!this.f449n.mo183g()) {
            super.onBackPressed();
        }
    }

    public void m1007a(bb bbVar) {
        bbVar.m169a((Activity) this);
    }

    public void m1016b(bb bbVar) {
    }

    public boolean m1021g() {
        Intent a = mo153a();
        if (a == null) {
            return false;
        }
        if (m1014a(a)) {
            bb a2 = bb.m168a((Context) this);
            m1007a(a2);
            m1016b(a2);
            a2.m172a();
            try {
                C0014a.m92a(this);
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            m1015b(a);
        }
        return true;
    }

    public Intent mo153a() {
        return af.m120a(this);
    }

    public boolean m1014a(Intent intent) {
        return af.m122a((Activity) this, intent);
    }

    public void m1015b(Intent intent) {
        af.m125b((Activity) this, intent);
    }
}
