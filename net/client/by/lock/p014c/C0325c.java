package net.client.by.lock.p014c;

import android.content.Context;
import net.client.by.lock.gui.activity.MainActivity;
import net.client.by.lock.service.BackgroundService;

/* compiled from: MyApp */
public class C0325c {
    private static C0325c f1416a = null;
    private Context f1417b;

    private C0325c() {
    }

    public static C0325c m2086a() {
        if (f1416a == null) {
            f1416a = new C0325c();
        }
        return f1416a;
    }

    public Context m2088b() {
        if (this.f1417b == null) {
            if (MainActivity.m2610h() == null) {
                return BackgroundService.m2756a();
            }
            this.f1417b = MainActivity.m2610h();
        }
        return this.f1417b;
    }

    public void m2087a(Context context) {
        this.f1417b = context;
    }
}
