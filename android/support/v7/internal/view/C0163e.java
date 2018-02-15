package android.support.v7.internal.view;

import android.view.InflateException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import java.lang.reflect.Method;

/* compiled from: MyApp */
class C0163e implements OnMenuItemClickListener {
    private static final Class[] f521a = new Class[]{MenuItem.class};
    private Object f522b;
    private Method f523c;

    public C0163e(Object obj, String str) {
        this.f522b = obj;
        Class cls = obj.getClass();
        try {
            this.f523c = cls.getMethod(str, f521a);
        } catch (Throwable e) {
            InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
            inflateException.initCause(e);
            throw inflateException;
        }
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        try {
            if (this.f523c.getReturnType() == Boolean.TYPE) {
                return ((Boolean) this.f523c.invoke(this.f522b, new Object[]{menuItem})).booleanValue();
            }
            this.f523c.invoke(this.f522b, new Object[]{menuItem});
            return true;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
