package net.client.by.lock.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import net.client.by.lock.p012d.C0351r;

/* compiled from: MyApp */
public class ScreenReciever extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (!C0351r.m2359i().m2395q()) {
            return;
        }
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            C0351r.m2359i().m2376c(true);
        } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
            C0351r.m2359i().m2376c(false);
        }
    }
}
