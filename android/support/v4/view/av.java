package android.support.v4.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;

/* compiled from: MyApp */
class av implements bc {
    av() {
    }

    public boolean mo71a(View view, int i) {
        return false;
    }

    public int mo65a(View view) {
        return 2;
    }

    public void mo69a(View view, C0074a c0074a) {
    }

    public void mo72b(View view) {
        view.postInvalidateDelayed(mo78a());
    }

    public void mo66a(View view, int i, int i2, int i3, int i4) {
        view.postInvalidateDelayed(mo78a(), i, i2, i3, i4);
    }

    public void mo70a(View view, Runnable runnable) {
        view.postDelayed(runnable, mo78a());
    }

    long mo78a() {
        return 10;
    }

    public int mo74c(View view) {
        return 0;
    }

    public void mo73b(View view, int i) {
    }

    public void mo67a(View view, int i, Paint paint) {
    }

    public int mo75d(View view) {
        return 0;
    }

    public void mo68a(View view, Paint paint) {
    }

    public int mo76e(View view) {
        return 0;
    }

    public boolean mo77f(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }
}
