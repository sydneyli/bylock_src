package android.support.v4.widget;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: MyApp */
class ad extends ac {
    private Method f398a;
    private Field f399b;

    ad() {
        try {
            this.f398a = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
        } catch (Throwable e) {
            Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e);
        }
        try {
            this.f399b = View.class.getDeclaredField("mRecreateDisplayList");
            this.f399b.setAccessible(true);
        } catch (Throwable e2) {
            Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
        }
    }

    public void mo124a(SlidingPaneLayout slidingPaneLayout, View view) {
        if (this.f398a == null || this.f399b == null) {
            view.invalidate();
            return;
        }
        try {
            this.f399b.setBoolean(view, true);
            this.f398a.invoke(view, (Object[]) null);
        } catch (Throwable e) {
            Log.e("SlidingPaneLayout", "Error refreshing display list state", e);
        }
        super.mo124a(slidingPaneLayout, view);
    }
}
