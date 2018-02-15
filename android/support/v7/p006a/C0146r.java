package android.support.v7.p006a;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import java.util.ArrayList;

/* compiled from: MyApp */
class C0146r extends C0126a {
    final Activity f505a;
    final C0127b f506b;
    final ActionBar f507c;
    private ArrayList f508d = new ArrayList();

    public C0146r(Activity activity, C0127b c0127b) {
        this.f505a = activity;
        this.f506b = c0127b;
        this.f507c = activity.getActionBar();
    }

    public void mo191a(View view) {
        this.f507c.setCustomView(view);
    }

    public void mo190a(int i) {
        this.f507c.setLogo(i);
    }

    public void mo192a(CharSequence charSequence) {
        this.f507c.setTitle(charSequence);
    }

    public void mo195b(int i) {
        this.f507c.setDisplayOptions(i);
    }

    public void mo193a(boolean z) {
        this.f507c.setDisplayUseLogoEnabled(z);
    }

    public void mo196b(boolean z) {
        this.f507c.setDisplayShowHomeEnabled(z);
    }

    public void mo197c(boolean z) {
        this.f507c.setDisplayHomeAsUpEnabled(z);
    }

    public void mo198d(boolean z) {
        this.f507c.setDisplayShowTitleEnabled(z);
    }

    public int mo189a() {
        return this.f507c.getDisplayOptions();
    }

    public Context mo194b() {
        return this.f507c.getThemedContext();
    }
}
