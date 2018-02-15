package android.support.v4.app;

import android.os.Handler;
import android.os.Message;

/* compiled from: MyApp */
class C0025k extends Handler {
    final /* synthetic */ C0024j f193a;

    C0025k(C0024j c0024j) {
        this.f193a = c0024j;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.f193a.f185f) {
                    this.f193a.m201a(false);
                    return;
                }
                return;
            case 2:
                this.f193a.a_();
                this.f193a.f181b.m255e();
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
