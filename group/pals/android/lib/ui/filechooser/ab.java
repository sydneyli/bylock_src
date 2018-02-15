package group.pals.android.lib.ui.filechooser;

import android.graphics.Rect;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import group.pals.android.lib.ui.filechooser.services.C0254d;

/* compiled from: MyApp */
class ab extends SimpleOnGestureListener {
    final /* synthetic */ FileChooserActivity f1095a;

    ab(FileChooserActivity fileChooserActivity) {
        this.f1095a = fileChooserActivity;
    }

    private Object m1774a(float f, float f2) {
        int b = m1775b(f, f2);
        if (b >= 0) {
            return this.f1095a.f1065F.getItemAtPosition(b + this.f1095a.f1065F.getFirstVisiblePosition());
        }
        return null;
    }

    private av m1773a(MotionEvent motionEvent) {
        Object a = m1774a(motionEvent.getX(), motionEvent.getY());
        return a instanceof av ? (av) a : null;
    }

    private int m1775b(float f, float f2) {
        Rect rect = new Rect();
        for (int i = 0; i < this.f1095a.f1065F.getChildCount(); i++) {
            this.f1095a.f1065F.getChildAt(i).getHitRect(rect);
            if (rect.contains((int) f, (int) f2)) {
                return i;
            }
        }
        return -1;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (!this.f1095a.f1088x || this.f1095a.f1086v) {
            return false;
        }
        av a = m1773a(motionEvent);
        if (a == null) {
            return false;
        }
        if (a.m1810a().isDirectory() && C0254d.FilesOnly.equals(this.f1095a.f1083s.mo308c())) {
            return false;
        }
        if (!this.f1095a.f1087w) {
            this.f1095a.m1705a(a.m1810a());
        } else if (!a.m1810a().isFile()) {
            return false;
        } else {
            this.f1095a.f1068I.setText(a.m1810a().getName());
            this.f1095a.m1703a(a.m1810a().getName());
        }
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (Math.abs(motionEvent.getY() - motionEvent2.getY()) < 19.0f && Math.abs(motionEvent.getX() - motionEvent2.getX()) > 80.0f && Math.abs(f) > 200.0f) {
            Object a = m1774a(motionEvent.getX(), motionEvent.getY());
            if (a instanceof av) {
                ((av) a).m1812b(true);
                this.f1095a.f1060A.notifyDataSetChanged();
                this.f1095a.m1712b((av) a);
            }
        }
        return false;
    }
}
