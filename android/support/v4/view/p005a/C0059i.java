package android.support.v4.view.p005a;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.List;

/* compiled from: MyApp */
public class C0059i {
    private static final C0060j f304a;
    private final Object f305b;

    static {
        if (VERSION.SDK_INT >= 16) {
            f304a = new C0062k();
        } else {
            f304a = new C0061m();
        }
    }

    public C0059i() {
        this.f305b = f304a.mo46a(this);
    }

    public C0059i(Object obj) {
        this.f305b = obj;
    }

    public Object m471a() {
        return this.f305b;
    }

    public C0051a m470a(int i) {
        return null;
    }

    public boolean m473a(int i, int i2, Bundle bundle) {
        return false;
    }

    public List m472a(String str, int i) {
        return null;
    }
}
