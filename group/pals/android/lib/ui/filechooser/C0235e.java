package group.pals.android.lib.ui.filechooser;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import group.pals.android.lib.ui.filechooser.services.C0253b;

/* compiled from: MyApp */
class C0235e implements ServiceConnection {
    final /* synthetic */ FileChooserActivity f1143a;

    C0235e(FileChooserActivity fileChooserActivity) {
        this.f1143a = fileChooserActivity;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f1143a.f1083s = ((C0253b) iBinder).m1867a();
        } catch (Throwable th) {
            Log.e(FileChooserActivity.f1043a, "mServiceConnection.onServiceConnected() -> " + th);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.f1143a.f1083s = null;
    }
}
