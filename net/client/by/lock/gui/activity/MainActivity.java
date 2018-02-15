package net.client.by.lock.gui.activity;

import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import net.client.by.lock.C0322b;
import net.client.by.lock.R;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p014c.C0323a;
import net.client.by.lock.p014c.C0327e;
import net.client.by.lock.p016f.C0370o;

/* compiled from: MyApp */
public class MainActivity extends C0392q {
    public static String f1648t = "bylock.mainactivity";
    static String f1649u = null;
    private static MainActivity f1650w;
    ad f1651o;
    ViewPager f1652p;
    View[] f1653r;
    String[] f1654s;
    private InputMethodManager f1655v;
    private BroadcastReceiver f1656x = new C0414x(this);

    protected void onCreate(Bundle bundle) {
        f1650w = this;
        if (!C0370o.m2492a(10)) {
            requestWindowFeature(7);
        }
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main);
        this.f1652p = (ViewPager) findViewById(R.id.viewFlipper1);
        this.f1651o = new ad(m205e(), (InputMethodManager) getSystemService("input_method"));
        this.f1653r = new View[5];
        this.f1653r[0] = findViewById(R.id.button1);
        this.f1653r[1] = findViewById(R.id.button2);
        this.f1653r[2] = findViewById(R.id.button3);
        this.f1653r[3] = findViewById(R.id.button4);
        this.f1653r[4] = findViewById(R.id.button5);
        this.f1654s = getResources().getStringArray(R.array.pages);
        for (int i = 0; i < 5; i++) {
            this.f1653r[i].setOnClickListener(new ac(this, i));
        }
        this.f1652p.setAdapter(this.f1651o);
        this.f1652p.setCurrentItem(2);
        this.f1653r[2].setEnabled(false);
        this.f1655v = (InputMethodManager) getSystemService("input_method");
        this.f1652p.setOnPageChangeListener(new C0415y(this));
        m1020f().mo192a(this.f1654s[this.f1652p.getCurrentItem()]);
        m1020f().mo193a(false);
        m1020f().mo196b(false);
        m1020f().mo197c(false);
        m1020f().mo198d(true);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C0322b.m2076e(this.q, "new intent");
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                C0337c a = C0327e.m2092c().m2094a(Integer.valueOf(extras.getInt("id", -1)));
                if (a == null) {
                    C0322b.m2076e(this.q, "no friend is associated");
                }
                if (intent.hasExtra("mail") && intent.getBooleanExtra("mail", false)) {
                    this.f1652p.setCurrentItem(1);
                    ((aw) this.f1651o.mo345a(1)).m2688a(a);
                } else if (intent.hasExtra("forward") && intent.getBooleanExtra("forward", false)) {
                    this.f1652p.setCurrentItem(1);
                    ((aw) this.f1651o.mo345a(1)).m2690a(a.m2270g(intent.getStringExtra("mailId")));
                } else if (intent.hasExtra("reply") && intent.getBooleanExtra("reply", false)) {
                    this.f1652p.setCurrentItem(1);
                    ((aw) this.f1651o.mo345a(1)).m2689a(a, a.m2270g(intent.getStringExtra("mailId")));
                }
            }
        }
    }

    protected void onResume() {
        super.onResume();
        registerReceiver(this.f1656x, new IntentFilter(f1648t));
    }

    protected void onPause() {
        unregisterReceiver(this.f1656x);
        super.onPause();
    }

    public void onBackPressed() {
        if (!C0351r.m2359i().m2386h()) {
            new Builder(this).setMessage(R.string.are_you_leaving).setPositiveButton(R.string.yes, new aa(this)).setNegativeButton(R.string.cancel, new ab(this)).show();
        }
    }

    public static MainActivity m2610h() {
        return f1650w;
    }

    protected void onDestroy() {
        C0322b.m2078v(this.q, "main activity destroy " + C0351r.m2359i().m2396r());
        if (C0351r.m2359i().m2395q() && C0351r.m2359i().m2396r()) {
            C0323a.m2081a(f1650w);
        }
        super.onDestroy();
    }
}
