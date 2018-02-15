package net.client.by.lock.gui.activity;

/* compiled from: MyApp */
class bv implements Runnable {
    final /* synthetic */ SplashActivity f1797a;

    bv(SplashActivity splashActivity) {
        this.f1797a = splashActivity;
    }

    public void run() {
        if (!this.f1797a.f1710f) {
            this.f1797a.startActivity(this.f1797a.f1709e);
        }
        this.f1797a.finish();
    }
}
