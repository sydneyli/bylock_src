package android.support.v7.internal.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: MyApp */
class ab implements OnTouchListener {
    final /* synthetic */ C0194u f901a;

    private ab(C0194u c0194u) {
        this.f901a = c0194u;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0 && this.f901a.f925c != null && this.f901a.f925c.isShowing() && x >= 0 && x < this.f901a.f925c.getWidth() && y >= 0 && y < this.f901a.f925c.getHeight()) {
            this.f901a.f947y.postDelayed(this.f901a.f942t, 250);
        } else if (action == 1) {
            this.f901a.f947y.removeCallbacks(this.f901a.f942t);
        }
        return false;
    }
}
