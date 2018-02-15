package android.support.v7.internal.view;

import android.content.Context;
import android.support.v7.internal.view.menu.aj;
import android.support.v7.p007c.C0136b;
import android.support.v7.p007c.C0142a;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;

/* compiled from: MyApp */
public class C0161c implements Callback {
    final C0136b f512a;
    final Context f513b;
    private C0160b f514c;

    public C0161c(Context context, C0136b c0136b) {
        this.f513b = context;
        this.f512a = c0136b;
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.f512a.mo185a(m1172a(actionMode), aj.m1311a(menu));
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.f512a.mo187b(m1172a(actionMode), aj.m1311a(menu));
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.f512a.mo186a(m1172a(actionMode), aj.m1312a(menuItem));
    }

    public void onDestroyActionMode(ActionMode actionMode) {
        this.f512a.mo184a(m1172a(actionMode));
    }

    public void m1173a(C0160b c0160b) {
        this.f514c = c0160b;
    }

    private C0142a m1172a(ActionMode actionMode) {
        if (this.f514c == null || this.f514c.f511b != actionMode) {
            return new C0160b(this.f513b, actionMode);
        }
        return this.f514c;
    }
}
