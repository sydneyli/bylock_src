package net.client.by.lock.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import net.client.by.lock.gui.activity.LoginActivity;
import net.client.by.lock.gui.activity.MainActivity;
import net.client.by.lock.p014c.C0325c;
import net.client.by.lock.p014c.C0330h;

/* compiled from: MyApp */
public class NetworkStatusReciever extends BroadcastReceiver {
    static Boolean f1930a = Boolean.valueOf(true);

    public static Boolean m2754a() {
        boolean z;
        for (NetworkInfo networkInfo : ((ConnectivityManager) C0325c.m2086a().m2088b().getSystemService("connectivity")).getAllNetworkInfo()) {
            if (networkInfo != null && networkInfo.isConnected()) {
                z = true;
                break;
            }
        }
        z = false;
        return Boolean.valueOf(z);
    }

    public void onReceive(Context context, Intent intent) {
        boolean booleanValue = m2754a().booleanValue();
        if (!(f1930a.booleanValue() == booleanValue || (context instanceof LoginActivity))) {
            if (booleanValue) {
                C0330h.m2111a().m2122e();
            } else {
                Intent intent2 = new Intent(MainActivity.f1648t);
                intent2.putExtra("caption", "No Network!");
                C0325c.m2086a().m2088b().sendBroadcast(intent2);
            }
        }
        f1930a = Boolean.valueOf(booleanValue);
    }
}
