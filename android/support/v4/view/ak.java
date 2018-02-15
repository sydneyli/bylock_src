package android.support.v4.view;

import android.view.MotionEvent;

/* compiled from: MyApp */
class ak implements am {
    ak() {
    }

    public int mo59a(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return 0;
        }
        return -1;
    }

    public int mo60b(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return 0;
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float mo61c(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getX();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float mo62d(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getY();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public int mo58a(MotionEvent motionEvent) {
        return 1;
    }
}
