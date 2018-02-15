package net.client.by.lock.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.support.v4.app.ap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import net.client.by.lock.C0322b;
import net.client.by.lock.R;
import net.client.by.lock.gui.activity.ChatActivity;
import net.client.by.lock.gui.activity.SplashActivity;
import net.client.by.lock.gui.p018b.an;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p014c.C0323a;
import net.client.by.lock.p014c.C0327e;
import net.client.by.lock.p014c.C0330h;
import net.client.by.lock.p014c.C0331i;
import net.client.by.lock.reciever.C0443a;
import net.client.by.lock.reciever.NetworkStatusReciever;
import net.client.by.lock.reciever.ScreenReciever;

/* compiled from: MyApp */
public class BackgroundService extends Service {
    private static WifiManager f1931b;
    private static WifiLock f1932c;
    private static PowerManager f1933d;
    private static WakeLock f1934e;
    private static NetworkStatusReciever f1935f;
    private static C0443a f1936g;
    private static ScreenReciever f1937h;
    private static BackgroundService f1938i;
    private static ArrayList f1939j;
    private static int f1940k = 0;
    private static int f1941l = 0;
    private static boolean f1942m = false;
    private static int f1943q = 0;
    private static int f1944r = 0;
    private static MediaPlayer f1945s;
    private static MediaPlayer f1946t;
    private static MediaPlayer f1947u;
    private static long f1948w = 0;
    C0327e f1949a;
    private OnErrorListener f1950n;
    private NotificationManager f1951o;
    private int f1952p;
    private BroadcastReceiver f1953v = new C0444a(this);

    public static BackgroundService m2756a() {
        return f1938i;
    }

    public void onCreate() {
    }

    private static synchronized void m2762b(C0337c c0337c, int i) {
        int i2 = 0;
        synchronized (BackgroundService.class) {
            Intent intent = new Intent(f1938i, ChatActivity.class);
            intent.putExtra("id", c0337c.m2237K());
            intent.addFlags(67108864);
            switch (i) {
                case 1:
                    m2758a(C0331i.m2124a().m2146i(f1938i), 1);
                    i2 = c0337c.m2229C().hashCode() + R.drawable.noti_chat_white;
                    f1938i.f1951o.cancel(i2);
                    f1938i.f1951o.notify(i2, new ap(f1938i).m150a(false).m147a((int) R.drawable.noti_chat_white).m149a((CharSequence) "byLock").m153c("New message from " + c0337c.m2233G()).m152b(true).m148a(PendingIntent.getActivity(f1938i, i2, intent, 268435456)).m151b(c0337c.m2233G()).m146a());
                    break;
                case 2:
                    m2758a(C0331i.m2124a().m2145h(f1938i), 2);
                    i2 = R.drawable.noti_file_white + c0337c.m2229C().hashCode();
                    f1938i.f1951o.cancel(i2);
                    f1938i.f1951o.notify(i2, new ap(f1938i).m150a(false).m147a((int) R.drawable.noti_file_white).m149a((CharSequence) "byLock").m153c("New file from " + c0337c.m2233G()).m152b(true).m148a(PendingIntent.getActivity(f1938i, i2, intent, 134217728)).m151b(c0337c.m2233G()).m146a());
                    break;
                case 3:
                    m2758a(C0331i.m2124a().m2146i(f1938i), 3);
                    i2 = R.drawable.noti_mail_white + c0337c.m2229C().hashCode();
                    f1938i.f1951o.cancel(i2);
                    f1938i.f1951o.notify(i2, new ap(f1938i).m150a(false).m147a((int) R.drawable.noti_mail_white).m149a((CharSequence) "byLock").m153c("New mail from " + c0337c.m2233G()).m152b(true).m148a(PendingIntent.getActivity(f1938i, i2, intent, 268435456)).m151b(c0337c.m2233G()).m146a());
                    break;
                case 4:
                    i2 = c0337c.m2229C().hashCode() + R.drawable.noti_call_white;
                    f1938i.f1951o.cancel(i2);
                    f1938i.f1951o.notify(i2, new ap(f1938i).m150a(false).m147a((int) R.drawable.noti_call_white).m149a((CharSequence) "byLock").m153c("Missed call from " + c0337c.m2233G()).m152b(true).m148a(PendingIntent.getActivity(f1938i, i2, intent, 268435456)).m151b(c0337c.m2233G()).m146a());
                    break;
            }
            if (!f1939j.contains(Integer.valueOf(i2))) {
                f1939j.add(Integer.valueOf(i2));
            }
        }
    }

    public static synchronized void m2758a(Uri uri, int i) {
        synchronized (BackgroundService.class) {
            long currentTimeMillis;
            Ringtone ringtone = null;
            if (uri != null) {
                if (!uri.equals(Uri.EMPTY)) {
                    ringtone = RingtoneManager.getRingtone(f1938i, uri);
                    currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - f1948w > 2800) {
                        f1948w = currentTimeMillis;
                        ringtone.play();
                    }
                }
            }
            switch (i) {
                case 1:
                    ringtone = RingtoneManager.getRingtone(f1938i, C0331i.m2124a().m2146i(f1938i));
                    break;
                case 2:
                    ringtone = RingtoneManager.getRingtone(f1938i, C0331i.m2124a().m2145h(f1938i));
                    break;
                case 3:
                    ringtone = RingtoneManager.getRingtone(f1938i, C0331i.m2124a().m2147j(f1938i));
                    break;
            }
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f1948w > 2800) {
                f1948w = currentTimeMillis;
                ringtone.play();
            }
        }
    }

    public void onDestroy() {
        m2775b();
        C0322b.m2078v("BackgroundService", "destroy " + C0351r.m2359i().m2396r());
        C0331i.m2124a().m2141f(this);
        unregisterReceiver(this.f1953v);
        unregisterReceiver(f1935f);
        unregisterReceiver(f1936g);
        unregisterReceiver(f1937h);
        C0323a.m2080a();
        this.f1951o.cancel(this.f1952p);
        if (f1932c.isHeld()) {
            f1932c.release();
        }
        if (f1934e.isHeld()) {
            f1934e.release();
        }
        f1945s.release();
        f1945s = null;
        f1946t.release();
        f1946t = null;
        f1947u.release();
        f1947u = null;
        C0322b.m2077i("BackgroundService", "onDestroy");
        System.gc();
        Process.killProcess(Process.myPid());
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        f1938i = this;
        f1939j = new ArrayList();
        this.f1951o = (NotificationManager) getSystemService("notification");
        this.f1952p = R.id.cancel;
        f1933d = (PowerManager) getSystemService("power");
        f1934e = f1933d.newWakeLock(1, "BackgroundService");
        f1934e.acquire();
        f1931b = (WifiManager) getSystemService("wifi");
        f1932c = f1931b.createWifiLock(1, "ByLock_BackgroundService");
        f1932c.setReferenceCounted(false);
        f1932c.acquire();
        f1935f = new NetworkStatusReciever();
        f1936g = new C0443a();
        f1937h = new ScreenReciever();
        m2772j();
        f1939j.add(Integer.valueOf(this.f1952p));
        this.f1949a = C0327e.m2092c();
        C0331i.m2124a().m2127a((Context) this);
        f1946t = new MediaPlayer();
        f1945s = new MediaPlayer();
        f1947u = new MediaPlayer();
        this.f1950n = new C0447d();
        f1947u.setOnErrorListener(this.f1950n);
        f1945s.setOnErrorListener(this.f1950n);
        f1946t.setOnErrorListener(this.f1950n);
        try {
            f1946t.setDataSource(this, Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.outgoing));
            f1946t.setAudioStreamType(0);
            f1946t.setLooping(true);
            f1947u.setDataSource(this, Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.busy));
            f1947u.setAudioStreamType(0);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e2) {
            e2.printStackTrace();
        } catch (IllegalStateException e3) {
            e3.printStackTrace();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        f1947u.prepareAsync();
        f1946t.prepareAsync();
        f1938i.registerReceiver(f1935f, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        f1938i.registerReceiver(f1936g, new IntentFilter("android.intent.action.ACTION_SHUTDOWN"));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        f1938i.registerReceiver(f1937h, intentFilter);
        f1938i.registerReceiver(this.f1953v, new IntentFilter("by.lock.BackgroundService"));
        C0322b.m2078v("BackgroundService", "onStartCommand");
        if (intent == null) {
            C0322b.m2078v("BackgroundService", "login");
            if (C0351r.m2359i().m2395q()) {
                C0322b.m2078v("BackgroundService", "already login");
            }
            C0330h.m2111a().m2122e();
        }
        return 1;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    private void m2772j() {
        Intent intent = new Intent(this, SplashActivity.class);
        intent.addFlags(268435456);
        this.f1951o.notify(this.f1952p, new ap(this).m150a(true).m147a((int) R.drawable.noti_app).m149a((CharSequence) "by Lock").m148a(PendingIntent.getActivity(getApplicationContext(), 0, intent, 0)).m151b((CharSequence) "The Most Secure Messaging!").m146a());
    }

    public synchronized void m2775b() {
        Iterator it = f1939j.iterator();
        while (it.hasNext()) {
            this.f1951o.cancel(((Integer) it.next()).intValue());
        }
        f1939j.clear();
    }

    public boolean m2776c() {
        return f1942m;
    }

    public void m2774a(boolean z) {
        C0322b.m2076e("BackgroundService", "connectionTypeChanged: " + f1942m + " -> " + z);
        f1942m = z;
    }

    private static void m2763b(C0337c c0337c, boolean z) {
        if (z) {
            Uri g = C0331i.m2124a().m2143g(f1938i);
            try {
                f1945s.setDataSource(f1938i, g);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (SecurityException e2) {
                e2.printStackTrace();
            } catch (IllegalStateException e3) {
                f1945s.reset();
                try {
                    f1945s.setDataSource(f1938i, g);
                    e3.printStackTrace();
                } catch (Exception e4) {
                    an.m2728a(f1938i, "Some kind error(0) happened while playing: " + g.getPath());
                    return;
                }
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            f1945s.setAudioStreamType(2);
            f1945s.setLooping(true);
            try {
                f1945s.prepareAsync();
                f1945s.setOnPreparedListener(new C0445b());
                return;
            } catch (IllegalStateException e6) {
                an.m2728a(f1938i, "Some kind error(1) happened while playing: " + g.getPath());
                return;
            }
        }
        if (f1945s.isPlaying()) {
            f1945s.pause();
            f1945s.release();
        }
        f1945s = new MediaPlayer();
    }

    private static void m2765c(boolean z) {
        if (z) {
            f1946t.start();
        } else if (f1946t.isPlaying()) {
            f1946t.pause();
            f1946t.seekTo(0);
        }
    }

    private static void m2773k() {
        if (f1946t.isPlaying()) {
            f1946t.pause();
            f1946t.seekTo(0);
        }
        f1947u.start();
    }
}
