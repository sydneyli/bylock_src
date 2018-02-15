package net.client.by.lock.gui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import net.client.by.lock.C0322b;
import net.client.by.lock.R;
import net.client.by.lock.p014c.C0325c;
import net.client.by.lock.p014c.C0331i;

/* compiled from: MyApp */
public abstract class C0391a extends Activity {
    static AtomicBoolean f1605a = new AtomicBoolean(false);
    static AtomicBoolean f1606b = new AtomicBoolean(false);
    static AtomicInteger f1607c = new AtomicInteger(0);
    private static Activity f1608e;
    private static boolean f1609f = false;
    protected String f1610d = "ACTIVITY";

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1610d = getClass().getName();
        C0322b.m2077i(this.f1610d, "onCreate");
        C0325c.m2086a().m2087a(this);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        if (this instanceof CallActivity) {
            f1609f = true;
        }
    }

    protected void onResume() {
        super.onResume();
        f1608e = this;
        C0322b.m2077i(this.f1610d, "onResume");
        C0325c.m2086a().m2087a(this);
    }

    protected void onStart() {
        super.onStart();
        C0322b.m2077i(this.f1610d, "onStart");
        C0325c.m2086a().m2087a(this);
        if (f1607c.incrementAndGet() > 0) {
            f1605a.set(false);
        }
        if (f1607c.get() == 1 && (((this instanceof ValidateActivity) || (this instanceof PrngActivity)) && C0331i.m2124a().m2142f())) {
            f1606b.set(true);
        }
        if (f1606b.get()) {
            Intent intent = new Intent(this, PinActivity.class);
            intent.addFlags(131072);
            startActivity(intent);
        }
    }

    protected void onStop() {
        C0322b.m2077i(this.f1610d, "onStop");
        super.onStop();
        if (f1607c.decrementAndGet() < 1) {
            f1605a.set(true);
        }
    }

    protected void onPause() {
        C0322b.m2077i(this.f1610d, "onPause");
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        if (isFinishing()) {
            C0322b.m2077i(getClass().getName(), "onPause finishing");
            if (this instanceof CallActivity) {
                f1609f = false;
            }
        }
        super.onPause();
        f1608e = null;
    }

    protected void onDestroy() {
        super.onDestroy();
        C0322b.m2077i(this.f1610d, "onDestroy");
        if (this instanceof CallActivity) {
            f1609f = false;
        }
    }

    public static boolean m2577a() {
        return f1605a.get();
    }

    public static boolean m2578b() {
        return f1609f;
    }
}
