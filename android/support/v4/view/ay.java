package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

/* compiled from: MyApp */
class ay extends ax {
    ay() {
    }

    long mo78a() {
        return bf.m667a();
    }

    public void mo67a(View view, int i, Paint paint) {
        bf.m668a(view, i, paint);
    }

    public int mo75d(View view) {
        return bf.m666a(view);
    }

    public void mo68a(View view, Paint paint) {
        mo67a(view, mo75d(view), paint);
        view.invalidate();
    }
}
