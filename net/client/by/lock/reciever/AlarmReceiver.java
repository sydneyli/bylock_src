package net.client.by.lock.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import net.client.by.lock.C0322b;
import net.client.by.lock.p014c.C0330h;
import net.client.by.lock.p014c.C0332j;

/* compiled from: MyApp */
public class AlarmReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            String string = intent.getExtras().getString("alarm_message");
            C0322b.m2078v("AlarmReceiver", "alarm:" + string);
            boolean booleanValue = NetworkStatusReciever.m2754a().booleanValue();
            if (string.equals("roster_event")) {
                if (booleanValue) {
                    C0332j.m2148a().m2184f();
                } else {
                    C0330h.m2111a().m2121d();
                }
            } else if (!string.equals("try_login")) {
            } else {
                if (booleanValue) {
                    C0332j.m2148a().m2166b();
                } else {
                    C0330h.m2111a().m2122e();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
