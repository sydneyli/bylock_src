package android.support.v7.p006a;

import android.support.v7.internal.widget.NativeActionModeAwareLayout;
import android.support.v7.internal.widget.ad;
import android.support.v7.p008b.C0152f;
import android.view.ActionMode;
import android.view.ActionMode.Callback;

/* compiled from: MyApp */
class C0144p extends C0141n implements ad {
    final NativeActionModeAwareLayout f501e;
    private ActionMode f502f;

    public C0144p(C0131f c0131f, C0127b c0127b) {
        super(c0131f, c0127b);
        this.f501e = (NativeActionModeAwareLayout) c0131f.findViewById(C0152f.action_bar_root);
        if (this.f501e != null) {
            this.f501e.setActionModeForChildListener(this);
        }
    }

    public Callback mo202a(Callback callback) {
        return new C0145q(this, callback);
    }

    boolean mo203f() {
        return this.f502f == null && super.mo203f();
    }
}
