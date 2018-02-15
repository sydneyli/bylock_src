package net.client.by.lock.task;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.support.v4.app.ap;
import net.client.by.lock.gui.p017a.C0376a;
import net.client.by.lock.p013b.C0309e;
import net.client.by.lock.p013b.C0312d;
import net.client.by.lock.p013b.C0317i;
import net.client.by.lock.p013b.C0318j;
import net.client.by.lock.p016f.C0365j;
import net.client.by.lock.service.BackgroundService;

/* compiled from: MyApp */
public abstract class FileTask extends C0448a implements C0318j {
    private static final String TAG = "FileTask";
    private C0376a ftBubble;
    C0309e ftis;
    private ap mBuilder;
    private NotificationManager mNM;
    private int mNotificationId;

    public FileTask(Context context, Object obj) {
        super(context, obj);
        this.ftBubble = ((C0312d) obj).mo317A();
    }

    public C0317i getProgressController() {
        if (this.ftis == null) {
            return null;
        }
        return this.ftis.m2008a();
    }

    public boolean cancelTask(boolean z) {
        boolean cancelTask = super.cancelTask(z);
        if (z && this.ftis != null) {
            try {
                this.ftis.close();
            } catch (Throwable e) {
                C0365j.m2476a(TAG, e);
            }
        }
        return cancelTask;
    }

    protected void onCancel() {
        this.mNM.cancel(this.mNotificationId);
    }

    protected Object[] doInBackground(Object... objArr) {
        this.mNotificationId = (int) System.currentTimeMillis();
        this.mNM = (NotificationManager) BackgroundService.m2756a().getSystemService("notification");
        lock();
        if (!(this instanceof FileTask)) {
            Process.setThreadPriority(-8);
        }
        try {
            return genericOnSuccess(call());
        } catch (Throwable e) {
            if (isCancelled()) {
                return null;
            }
            return genericOnException(e);
        }
    }

    protected void onProgressUpdate(Integer... numArr) {
        this.ftBubble.m2558b(numArr[0].intValue());
    }

    public void updateProgress(int i) {
        publishProgress(new Integer[]{Integer.valueOf(i)});
    }

    public void initProgress() {
    }

    public void finalizeProgress() {
        this.ftis.m2008a().m2067b();
    }

    protected Object[] genericOnException(Throwable th) {
        this.state = 2;
        ((C0312d) this.startupParameter).m2029a(th);
        this.mBuilder = new ap(this.ctx).m150a(false).m154c(true).m147a(17301504).m149a(((C0312d) this.startupParameter).mo325e()).m148a(PendingIntent.getBroadcast(BackgroundService.m2756a(), 0, new Intent(), 134217728)).m151b((CharSequence) "Some kind of error occured").m153c((CharSequence) "Error");
        this.mNM.notify(this.mNotificationId, this.mBuilder.m146a());
        this.mNM.cancel(this.mNotificationId);
        return onException(th);
    }

    protected void onPostExecute(Object[] objArr) {
        int i;
        super.onPostExecute(objArr);
        ap c = new ap(this.ctx).m154c(true).m149a(((C0312d) this.startupParameter).mo325e()).m150a(false).m153c(new StringBuilder(String.valueOf(((C0312d) this.startupParameter).mo325e())).append(" is ").append(this instanceof SendFileTask ? "uploaded" : "downloaded").toString());
        if (this instanceof SendFileTask) {
            i = 17301641;
        } else {
            i = 17301634;
        }
        this.mBuilder = c.m147a(i).m151b(this instanceof SendFileTask ? "Uploaded" : "Downloaded").m148a(PendingIntent.getBroadcast(BackgroundService.m2756a(), 0, new Intent(), 134217728));
        this.mNM.notify(this.mNotificationId, this.mBuilder.m146a());
        this.mNM.cancel(this.mNotificationId);
        if (this.ftBubble != null) {
            this.ftBubble.m2553a(8);
        }
    }
}
