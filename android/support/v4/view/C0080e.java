package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.p005a.C0059i;
import android.view.View;

/* compiled from: MyApp */
class C0080e extends C0077b {
    C0080e() {
    }

    public Object mo81a(C0074a c0074a) {
        return C0085k.m745a(new C0082f(this, c0074a));
    }

    public C0059i mo79a(Object obj, View view) {
        Object a = C0085k.m746a(obj, view);
        if (a != null) {
            return new C0059i(a);
        }
        return null;
    }

    public boolean mo84a(Object obj, View view, int i, Bundle bundle) {
        return C0085k.m747a(obj, view, i, bundle);
    }
}
