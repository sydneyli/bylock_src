package net.client.by.lock.gui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.p006a.C0131f;
import net.client.by.lock.C0322b;
import net.client.by.lock.R;
import net.client.by.lock.p014c.C0325c;
import net.client.by.lock.p014c.C0331i;

/* compiled from: MyApp */
public abstract class C0392q extends C0131f {
    private static Activity f1623o;
    protected String f1624q = "FRAGMENT_ACTIVITY";

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1624q = getClass().getName();
        C0322b.m2077i(this.f1624q, "onCreate");
        C0325c.m2086a().m2087a(this);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    protected void onResume() {
        super.onResume();
        f1623o = this;
        C0325c.m2086a().m2087a(this);
        C0322b.m2077i(this.f1624q, "onResume");
    }

    protected void onStart() {
        super.onStart();
        C0322b.m2077i(this.f1624q, "onStart");
        C0325c.m2086a().m2087a(this);
        if (C0391a.f1607c.incrementAndGet() > 0) {
            C0391a.f1605a.set(false);
        }
        if (C0391a.f1607c.get() == 1 && (((this instanceof SelectFilesActivity) || (this instanceof SelectFriendsActivity) || (this instanceof VirtualDriveActivity) || (this instanceof ContactActivity) || (this instanceof ChatActivity) || (this instanceof ReadOMailActivity) || (this instanceof SettingsActivity) || (this instanceof ReadIMailActivity) || (this instanceof MainActivity)) && C0331i.m2124a().m2142f())) {
            C0391a.f1606b.set(true);
        }
        if (C0391a.f1606b.get()) {
            Intent intent = new Intent(this, PinActivity.class);
            intent.addFlags(131072);
            startActivity(intent);
        }
    }

    protected void onStop() {
        super.onStop();
        C0322b.m2077i(this.f1624q, "onStop");
        if (C0391a.f1607c.decrementAndGet() < 1) {
            C0391a.f1605a.set(true);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        C0322b.m2077i(this.f1624q, "onDestroy");
    }

    protected void onPause() {
        C0322b.m2077i(this.f1624q, "onPause");
        if (isFinishing()) {
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
        super.onPause();
        f1623o = null;
    }
}
