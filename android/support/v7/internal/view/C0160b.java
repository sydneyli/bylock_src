package android.support.v7.internal.view;

import android.content.Context;
import android.support.v7.internal.view.menu.aj;
import android.support.v7.p007c.C0142a;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;

/* compiled from: MyApp */
public class C0160b extends C0142a {
    final MenuInflater f510a;
    final ActionMode f511b;

    public C0160b(Context context, ActionMode actionMode) {
        this.f511b = actionMode;
        this.f510a = new C0162d(context);
    }

    public void mo201b() {
        this.f511b.finish();
    }

    public Menu mo200a() {
        return aj.m1311a(this.f511b.getMenu());
    }
}
