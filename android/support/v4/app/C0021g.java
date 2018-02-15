package android.support.v4.app;

import android.view.View;

/* compiled from: MyApp */
class C0021g implements C0020o {
    final /* synthetic */ Fragment f179a;

    C0021g(Fragment fragment) {
        this.f179a = fragment;
    }

    public View mo13a(int i) {
        if (this.f179a.f39I != null) {
            return this.f179a.f39I.findViewById(i);
        }
        throw new IllegalStateException("Fragment does not have a view");
    }
}
