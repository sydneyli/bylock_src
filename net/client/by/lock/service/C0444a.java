package net.client.by.lock.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import net.client.by.lock.C0322b;
import net.client.by.lock.R;
import net.client.by.lock.gui.activity.CallActivity;
import net.client.by.lock.gui.p018b.an;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p014c.C0323a;
import net.client.by.lock.p014c.C0327e;

/* compiled from: MyApp */
class C0444a extends BroadcastReceiver {
    final /* synthetic */ BackgroundService f1954a;

    C0444a(BackgroundService backgroundService) {
        this.f1954a = backgroundService;
    }

    public void onReceive(Context context, Intent intent) {
        boolean z = true;
        switch (intent.getIntExtra("what", -1)) {
            case 4:
                try {
                    Intent intent2 = new Intent(BackgroundService.f1938i, CallActivity.class);
                    intent2.putExtra("id", intent.getIntExtra("id", -1));
                    BackgroundService.f1938i.startActivity(intent2.setFlags(268435456));
                    return;
                } catch (Exception e) {
                    C0322b.m2076e("BackgroundService", e.toString());
                }
            case 5:
                C0322b.m2077i("BackgroundService", "MSG_GET_ROSTER_EVENT");
                C0323a.m2082b(BackgroundService.f1938i);
                return;
            case 6:
                if (intent.getIntExtra("arg1", -1) == 1) {
                    BackgroundService.f1932c.acquire();
                    return;
                } else {
                    BackgroundService.f1932c.release();
                    return;
                }
            case 7:
                C0322b.m2077i("BackgroundService", "MSG_TRY_LOGIN");
                C0323a.m2083c(BackgroundService.f1938i);
                return;
            case 8:
                an.m2728a(BackgroundService.f1938i, intent.getStringExtra("error"));
                return;
            case 9:
                BackgroundService.f1943q = intent.getIntExtra("arg1", -1);
                BackgroundService.f1944r = intent.getIntExtra("arg2", -1);
                C0337c a = C0327e.m2092c().m2094a(Integer.valueOf(intent.getIntExtra("friendUserId", -1)));
                if (BackgroundService.f1944r == 1) {
                    BackgroundService.m2762b(a, BackgroundService.f1943q);
                    return;
                }
                int hashCode = a.m2229C().hashCode();
                switch (BackgroundService.f1943q) {
                    case 1:
                        hashCode += R.drawable.noti_chat_white;
                        break;
                    case 2:
                        hashCode += R.drawable.noti_file_white;
                        break;
                    case 3:
                        hashCode += R.drawable.noti_mail_white;
                        break;
                    case 4:
                        hashCode += R.drawable.noti_call_white;
                        break;
                }
                BackgroundService.f1938i.f1951o.cancel(hashCode);
                if (BackgroundService.f1939j.contains(Integer.valueOf(hashCode))) {
                    BackgroundService.f1939j.remove(BackgroundService.f1939j.indexOf(Integer.valueOf(hashCode)));
                    return;
                }
                return;
            case 10:
                C0337c a2 = C0327e.m2092c().m2094a(Integer.valueOf(intent.getIntExtra("friendUserId", -1)));
                if (intent.getIntExtra("arg1", -1) != 1) {
                    z = false;
                }
                BackgroundService.m2763b(a2, z);
                return;
            case 11:
                if (intent.getIntExtra("arg1", -1) != 1) {
                    z = false;
                }
                BackgroundService.m2765c(z);
                return;
            case 12:
                BackgroundService.m2773k();
                return;
            case 13:
                C0322b.m2077i("BackgroundService", "MSG_SAVE_PASSWORD");
                C0323a.m2081a(BackgroundService.f1938i);
                return;
            default:
                return;
        }
        C0322b.m2076e("BackgroundService", e.toString());
    }
}
