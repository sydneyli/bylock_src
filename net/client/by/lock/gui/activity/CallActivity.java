package net.client.by.lock.gui.activity;

import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.ViewAnimator;
import java.util.Observable;
import java.util.Observer;
import net.client.by.lock.R;
import net.client.by.lock.gui.p018b.ag;
import net.client.by.lock.gui.p018b.ah;
import net.client.by.lock.p011a.C0289c;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p014c.C0324b;
import net.client.by.lock.p014c.C0327e;
import net.client.by.lock.p014c.C0330h;
import net.client.by.lock.p016f.C0370o;

/* compiled from: MyApp */
public class CallActivity extends C0391a implements Observer, ah {
    AnimationListener f1611e = new C0393b(this);
    private C0289c f1612f;
    private C0337c f1613g;
    private ViewAnimator f1614h;
    private View[] f1615i;
    private Chronometer f1616j;
    private View f1617k;
    private String f1618l;
    private AudioManager f1619m;
    private WifiLock f1620n;
    private boolean f1621o = false;
    private ag f1622p;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(6291584);
        setContentView(R.layout.activity_call);
        this.f1614h = (ViewAnimator) findViewById(R.id.viewAnimator1);
        this.f1615i = new View[]{findViewById(R.id.call_0), findViewById(R.id.call_1), findViewById(R.id.call_2)};
        this.f1613g = C0327e.m2092c().m2094a(Integer.valueOf(getIntent().getExtras().getInt("id")));
        this.f1612f = this.f1613g.m2238L();
        this.f1616j = (Chronometer) this.f1615i[1].findViewById(R.id.textView1);
        this.f1622p = new ag(this);
        this.f1612f.m1914F().addObserver(this);
        this.f1612f.m1914F().m2468a((String) this.f1612f.m1914F().m2467a());
        this.f1618l = this.f1613g.m2233G();
        this.f1621o = C0391a.m2577a();
        if (this.f1612f.b_()) {
            m2582a(2, -1);
        } else if (!this.f1612f.b_()) {
            m2582a(0, -1);
        }
        this.f1619m = (AudioManager) getSystemService("audio");
        ((ToggleButton) this.f1615i[1].findViewById(R.id.toggleButton1)).setOnCheckedChangeListener(new C0403l(this.f1619m));
        this.f1615i[0].findViewById(R.id.imageView2).setOnClickListener(new C0402k(this.f1612f, this));
        this.f1615i[0].findViewById(R.id.imageView3).setOnClickListener(new C0394c(this));
        this.f1615i[1].findViewById(R.id.button1).setOnClickListener(new C0399h(this.f1612f, this.f1616j, this));
        this.f1615i[2].findViewById(R.id.button1).setOnClickListener(new C0395d(this));
        ((ToggleButton) this.f1615i[1].findViewById(R.id.toggleButton2)).setOnCheckedChangeListener(new C0401j(this.f1619m));
        this.f1617k = this.f1615i[1].findViewById(R.id.relativeLayout1);
        m2587c();
    }

    protected void onPause() {
        if (isFinishing()) {
            if (this.f1620n != null && this.f1620n.isHeld()) {
                this.f1620n.release();
            }
            this.f1619m.setSpeakerphoneOn(false);
            this.f1619m.setStreamMute(0, false);
            if (this.f1621o) {
                moveTaskToBack(true);
            }
        }
        super.onPause();
    }

    public void onBackPressed() {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 24 && (keyCode != 25 || !this.f1612f.m1937a("RINGING") || this.f1612f.b_())) {
            return super.dispatchKeyEvent(keyEvent);
        }
        C0330h.m2111a().m2112a(10);
        return true;
    }

    public void onAttachedToWindow() {
        getWindow().addFlags(6815872);
    }

    public void m2588a(Object obj) {
        if (obj.equals("ANSWERED")) {
            if (this.f1614h.getCurrentView() != this.f1615i[1]) {
                m2582a(1, -1);
            }
            this.f1616j.setBase(SystemClock.elapsedRealtime());
            this.f1616j.start();
            if (this.f1612f.b_()) {
                C0330h.m2111a().m2112a(11);
            } else {
                this.f1612f.b_();
            }
        } else if (obj.equals("CALLEE BUSY")) {
            C0330h.m2111a().m2112a(12);
            ((TextView) this.f1615i[2].findViewById(R.id.call_status)).setText(R.string.call_busy);
            this.f1612f.m1938b().m2468a((Object) "Busy");
            m2581a(2000);
        } else if (obj.equals("CALLER BUSY")) {
            this.f1612f.m1938b().m2468a((Object) "Busy");
            m2581a(0);
        } else if (!obj.equals("CALLING")) {
            if (obj.equals("CANCELED")) {
                if (this.f1612f.b_()) {
                    this.f1612f.m1938b().m2468a((Object) "Cancelled");
                } else {
                    C0330h.m2111a().m2116a(this.f1613g, 4);
                    this.f1612f.m1938b().m2468a((Object) "Missed Call");
                }
                C0330h.m2111a().m2112a(10);
                ((TextView) this.f1614h.getCurrentView().findViewById(R.id.call_status)).setText(R.string.call_cancelled);
                m2581a(1200);
            } else if (obj.equals("CLOSED")) {
                C0324b.f1410a.set(true);
                ((TextView) this.f1614h.getCurrentView().findViewById(R.id.call_status)).setText(R.string.call_ended);
                m2581a(1500);
                C0330h.m2111a().m2112a(11);
                this.f1616j.stop();
                this.f1612f.m1938b().m2468a(this.f1616j.getText().toString());
                this.f1622p.m2724a();
            } else if (obj.equals("SOME ERROR")) {
                ((TextView) this.f1614h.getCurrentView().findViewById(R.id.call_status)).setText(R.string.call_error);
                if (this.f1612f.b_()) {
                    C0330h.m2111a().m2112a(11);
                } else if (!this.f1612f.b_()) {
                    C0330h.m2111a().m2112a(10);
                }
                this.f1612f.m1938b().m2468a((Object) "Error");
                m2581a(2000);
                this.f1622p.m2724a();
            } else if (obj.equals("MISSED")) {
                ((TextView) this.f1614h.getCurrentView().findViewById(R.id.call_status)).setText(R.string.call_missed);
                C0330h.m2111a().m2120c(this.f1613g, 12);
                this.f1612f.m1938b().m2468a((Object) "Missed Call");
                m2581a(2000);
            } else if (obj.equals("REJECTED")) {
                this.f1612f.m1938b().m2468a((Object) "Rejected");
                C0330h.m2111a().m2120c(this.f1613g, 12);
                ((TextView) this.f1614h.getCurrentView().findViewById(R.id.call_status)).setText(R.string.call_rejected);
                m2581a(2000);
            } else if (!obj.equals("RINGING")) {
            } else {
                if (this.f1612f.b_()) {
                    C0330h.m2111a().m2120c(this.f1613g, 11);
                    this.f1615i[2].findViewById(R.id.button1).setEnabled(true);
                } else if (!this.f1612f.b_()) {
                    C0330h.m2111a().m2120c(this.f1613g, 10);
                }
            }
        }
    }

    private void m2582a(int i, int i2) {
        this.f1614h.setDisplayedChild(i);
        ((TextView) this.f1615i[i].findViewById(R.id.call_name)).setText(this.f1618l);
    }

    private void m2587c() {
        if (((ConnectivityManager) getSystemService("connectivity")).getNetworkInfo(1).isConnected()) {
            this.f1620n = ((WifiManager) getSystemService("wifi")).createWifiLock(C0370o.m2489a(), this.d);
            this.f1620n.acquire();
        }
    }

    private void m2581a(int i) {
        new Handler().postDelayed(new C0397f(this), (long) i);
    }

    public void update(Observable observable, Object obj) {
        if (((String) obj).equals("stateProperty")) {
            runOnUiThread(new C0398g(this, observable));
        }
    }

    public void mo333a(boolean z) {
        Animation translateAnimation;
        if (z) {
            translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) this.f1617k.getHeight());
            translateAnimation.setAnimationListener(this.f1611e);
        } else {
            this.f1617k.setVisibility(0);
            translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) this.f1617k.getHeight(), 0.0f);
        }
        translateAnimation.setDuration(300);
        translateAnimation.setInterpolator(new AccelerateInterpolator(1.0f));
        this.f1617k.startAnimation(translateAnimation);
    }
}
