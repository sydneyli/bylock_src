package net.client.by.lock.gui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGestureListener;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ProgressBar;
import java.util.concurrent.atomic.AtomicBoolean;
import net.client.by.lock.R;
import net.client.by.lock.gui.p018b.C0418b;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p016f.C0366k;
import net.client.by.lock.p016f.C0367l;

/* compiled from: MyApp */
public class PrngActivity extends C0391a implements OnGestureListener {
    ProgressBar f1661e;
    GestureOverlayView f1662f;
    double f1663g = -1.0d;
    double f1664h = -1.0d;
    Dialog f1665i = null;
    private byte[] f1666j;
    private int f1667k;
    private int f1668l;
    private AtomicBoolean f1669m = new AtomicBoolean(false);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_prng);
        this.f1661e = (ProgressBar) findViewById(R.id.progressBar1);
        this.f1662f = (GestureOverlayView) findViewById(R.id.gestureOverlayView1);
        this.f1662f.addOnGestureListener(this);
        this.f1666j = new byte[64];
        for (int i = 0; i < 64; i++) {
            this.f1666j[i] = (byte) 0;
        }
        this.f1667k = 0;
        this.f1668l = 0;
    }

    public void onBackPressed() {
        moveTaskToBack(true);
        C0351r.m2359i().m2383g();
        C0332j.m2148a().m2178d();
    }

    private void m2616a(boolean z) {
        if (this.f1667k < 64) {
            if (z) {
                byte[] bArr = this.f1666j;
                int i = this.f1667k;
                bArr[i] = (byte) (bArr[i] | (1 << this.f1668l));
            }
            this.f1668l++;
            if (this.f1668l == 8) {
                this.f1668l = 0;
                this.f1667k++;
            }
            this.f1661e.setProgress((int) (100.0d * (((double) ((this.f1667k * 8) + this.f1668l)) / 512.0d)));
            return;
        }
        this.f1662f.removeAllOnGestureListeners();
        C0351r.m2359i().m2367a(this.f1666j);
        if (!this.f1669m.get()) {
            this.f1669m.set(true);
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    public void onGesture(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
        double x = (double) motionEvent.getX();
        double y = (double) motionEvent.getY();
        if (!(this.f1663g == -1.0d || this.f1664h == -1.0d)) {
            boolean z;
            m2616a(x > this.f1663g);
            if (y > this.f1664h) {
                z = true;
            } else {
                z = false;
            }
            m2616a(z);
        }
        this.f1663g = x;
        this.f1664h = y;
        for (int i = 0; i < motionEvent.getHistorySize(); i++) {
            x = (double) motionEvent.getHistoricalX(i);
            y = (double) motionEvent.getHistoricalY(i);
            if (!(this.f1663g == -1.0d || this.f1664h == -1.0d)) {
                boolean z2;
                if (x > this.f1663g) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                m2616a(z2);
                if (y > this.f1664h) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                m2616a(z2);
            }
            this.f1663g = x;
            this.f1664h = y;
        }
    }

    public void onGestureCancelled(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
    }

    public void onGestureEnded(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
    }

    public void onGestureStarted(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
    }

    protected void onResume() {
        super.onResume();
        if (C0366k.m2481a(C0351r.m2359i().m2390l()) != C0367l.SECURE) {
            if (this.f1665i == null) {
                this.f1665i = C0418b.m2742d(this);
            }
            this.f1665i.show();
        }
    }
}
