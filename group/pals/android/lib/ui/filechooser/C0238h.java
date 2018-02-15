package group.pals.android.lib.ui.filechooser;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: MyApp */
class C0238h implements OnTouchListener {
    final /* synthetic */ FileChooserActivity f1149a;

    C0238h(FileChooserActivity fileChooserActivity) {
        this.f1149a = fileChooserActivity;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f1149a.f1079U.onTouchEvent(motionEvent);
    }
}
