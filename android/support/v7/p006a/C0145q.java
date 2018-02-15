package android.support.v7.p006a;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;

/* compiled from: MyApp */
class C0145q implements Callback {
    final /* synthetic */ C0144p f503a;
    private final Callback f504b;

    C0145q(C0144p c0144p, Callback callback) {
        this.f503a = c0144p;
        this.f504b = callback;
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        boolean onCreateActionMode = this.f504b.onCreateActionMode(actionMode, menu);
        if (onCreateActionMode) {
            this.f503a.f502f = actionMode;
            this.f503a.m1129d();
        }
        return onCreateActionMode;
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.f504b.onPrepareActionMode(actionMode, menu);
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.f504b.onActionItemClicked(actionMode, menuItem);
    }

    public void onDestroyActionMode(ActionMode actionMode) {
        this.f504b.onDestroyActionMode(actionMode);
        this.f503a.m1131e();
        this.f503a.f502f = null;
    }
}
