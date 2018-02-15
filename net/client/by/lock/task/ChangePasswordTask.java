package net.client.by.lock.task;

import android.content.Context;
import net.client.by.lock.gui.p018b.an;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p016f.C0371p;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class ChangePasswordTask extends C0448a {
    String oldPassword;

    public ChangePasswordTask(Context context, Object obj) {
        super(context, obj);
        this.oldPassword = (String) obj;
    }

    protected String getUrl() {
        return C0371p.m2520o();
    }

    protected Document getRequest() {
        return C0354c.m2437e();
    }

    protected void restart() {
        C0332j.m2148a().m2175c(this.oldPassword);
    }

    protected Object[] onException(Throwable th) {
        C0351r.m2359i().m2382f((String) this.startupParameter);
        C0351r.m2359i().m2394p().mo329c();
        return new Object[]{"onException", th};
    }

    protected void onPostExecute(Object[] objArr) {
        if (objArr[0].equals("onSuccess")) {
            an.m2728a(this.ctx, "Password has changed successfully.");
        }
    }

    protected Object[] onFailAtServer(String str) {
        C0351r.m2359i().m2382f((String) this.startupParameter);
        C0351r.m2359i().m2394p().mo329c();
        return new Object[]{"onFailAtServer", str};
    }
}
