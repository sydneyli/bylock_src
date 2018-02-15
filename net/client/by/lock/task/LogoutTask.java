package net.client.by.lock.task;

import android.app.Activity;
import android.content.Context;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p014c.C0325c;
import net.client.by.lock.p014c.C0330h;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p016f.C0371p;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class LogoutTask extends C0448a {
    public LogoutTask(Context context, Object obj) {
        super(context, obj);
    }

    protected String getUrl() {
        return C0371p.m2507b();
    }

    protected Document getRequest() {
        return C0354c.m2421b();
    }

    protected void onPostExecute(Object[] objArr) {
        super.onPostExecute(objArr);
        exit();
    }

    protected void onCancel() {
        exit();
    }

    protected void restart() {
        exit();
    }

    protected Object[] onFailAtServer(String str) {
        exit();
        return new Object[]{"onFail", str};
    }

    void exit() {
        C0351r.m2358a(true);
        if (this.ctx instanceof Activity) {
            ((Activity) this.ctx).finish();
        }
        Context b = C0325c.m2086a().m2088b();
        if (b instanceof Activity) {
            ((Activity) b).finish();
        }
        C0330h.m2111a().m2119c();
    }
}
