package android.support.v7.internal.widget;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ListAdapter;

/* compiled from: MyApp */
class am implements OnClickListener, aq {
    final /* synthetic */ ak f916a;
    private AlertDialog f917b;
    private ListAdapter f918c;
    private CharSequence f919d;

    private am(ak akVar) {
        this.f916a = akVar;
    }

    public void mo268d() {
        this.f917b.dismiss();
        this.f917b = null;
    }

    public boolean mo269f() {
        return this.f917b != null ? this.f917b.isShowing() : false;
    }

    public void mo265a(ListAdapter listAdapter) {
        this.f918c = listAdapter;
    }

    public void mo266a(CharSequence charSequence) {
        this.f919d = charSequence;
    }

    public void mo267c() {
        Builder builder = new Builder(this.f916a.getContext());
        if (this.f919d != null) {
            builder.setTitle(this.f919d);
        }
        this.f917b = builder.setSingleChoiceItems(this.f918c, this.f916a.m1435f(), this).show();
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f916a.m1448a(i);
        if (this.f916a.t != null) {
            this.f916a.m1429a(null, i, this.f918c.getItemId(i));
        }
        mo268d();
    }
}
