package net.client.by.lock.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p014c.C0325c;
import net.client.by.lock.p014c.C0331i;
import net.client.by.lock.p014c.C0332j;

/* compiled from: MyApp */
public class C0443a extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (((Boolean) C0351r.m2359i().m2398t().m2467a()).booleanValue()) {
            C0332j.m2148a().m2178d();
        }
        if (C0325c.m2086a().m2088b() != null) {
            C0331i.m2124a().m2136c(C0325c.m2086a().m2088b());
        }
    }
}
