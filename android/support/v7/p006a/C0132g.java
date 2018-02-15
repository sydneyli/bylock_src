package android.support.v7.p006a;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.internal.view.C0162d;
import android.support.v7.p007c.C0136b;
import android.support.v7.p007c.C0142a;
import android.support.v7.p008b.C0157k;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* compiled from: MyApp */
abstract class C0132g {
    final C0131f f450a;
    boolean f451b;
    boolean f452c;
    private C0126a f453d;
    private MenuInflater f454e;

    abstract C0126a mo164a();

    abstract C0142a mo165a(C0136b c0136b);

    abstract void mo166a(int i);

    abstract void mo167a(Configuration configuration);

    abstract void mo170a(View view);

    abstract void mo171a(View view, LayoutParams layoutParams);

    abstract void mo172a(CharSequence charSequence);

    abstract boolean mo173a(int i, Menu menu);

    abstract boolean mo174a(int i, MenuItem menuItem);

    abstract boolean mo175a(int i, View view, Menu menu);

    abstract View mo177b(int i);

    abstract void mo178b(View view, LayoutParams layoutParams);

    abstract void mo180d();

    abstract void mo181e();

    abstract void mo182f();

    abstract boolean mo183g();

    static C0132g m1022a(C0131f c0131f) {
        int i = VERSION.SDK_INT;
        if (i >= 14) {
            return new C0139l(c0131f);
        }
        if (i >= 11) {
            return new C0138k(c0131f);
        }
        return new C0134h(c0131f);
    }

    C0132g(C0131f c0131f) {
        this.f450a = c0131f;
    }

    final C0126a m1034b() {
        if (!this.f451b && !this.f452c) {
            this.f453d = null;
        } else if (this.f453d == null) {
            this.f453d = mo164a();
        }
        return this.f453d;
    }

    MenuInflater m1037c() {
        if (this.f454e == null) {
            C0126a b = m1034b();
            if (b != null) {
                this.f454e = new C0162d(b.mo194b());
            } else {
                this.f454e = new C0162d(this.f450a);
            }
        }
        return this.f454e;
    }

    void mo188a(Bundle bundle) {
        TypedArray obtainStyledAttributes = this.f450a.obtainStyledAttributes(C0157k.ActionBarWindow);
        if (obtainStyledAttributes.hasValue(0)) {
            this.f451b = obtainStyledAttributes.getBoolean(0, false);
            this.f452c = obtainStyledAttributes.getBoolean(1, false);
            obtainStyledAttributes.recycle();
            return;
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    protected final String m1042h() {
        String str = null;
        try {
            ActivityInfo activityInfo = this.f450a.getPackageManager().getActivityInfo(this.f450a.getComponentName(), 128);
            if (activityInfo.metaData != null) {
                str = activityInfo.metaData.getString("android.support.UI_OPTIONS");
            }
        } catch (NameNotFoundException e) {
            Log.e("ActionBarActivityDelegate", "getUiOptionsFromMetadata: Activity '" + this.f450a.getClass().getSimpleName() + "' not in manifest");
        }
        return str;
    }

    protected final Context m1043i() {
        Context context = this.f450a;
        C0126a b = m1034b();
        if (b != null) {
            return b.mo194b();
        }
        return context;
    }
}
