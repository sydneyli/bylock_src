package net.client.by.lock.gui.activity;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import net.client.by.lock.R;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p014c.C0323a;
import net.client.by.lock.p014c.C0331i;

/* compiled from: MyApp */
public class SplashActivity extends C0391a {
    private Intent f1709e = null;
    private boolean f1710f = false;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_splash);
        this.f1710f = false;
        ((NotificationManager) getSystemService("notification")).cancel(C0323a.f1404a);
    }

    protected void onResume() {
        super.onResume();
        int i = 1800;
        if (!C0351r.m2359i().m2396r()) {
            this.f1709e = new Intent(this, LoginActivity.class);
            this.f1709e.addFlags(268435456);
            this.f1709e.addFlags(67108864);
        } else if (C0351r.m2359i().m2399u() != null) {
            this.f1709e = new Intent(this, LoginActivity.class);
            this.f1709e.addFlags(131072);
        } else if (C0331i.m2124a().m2142f()) {
            this.f1709e = new Intent(this, PinActivity.class);
            i = 0;
        } else {
            this.f1709e = new Intent(this, MainActivity.class);
            this.f1709e.addFlags(131072);
            i = 0;
        }
        findViewById(R.id.imageView1).postDelayed(new bv(this), (long) i);
    }

    protected void onPause() {
        super.onPause();
        this.f1710f = true;
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
