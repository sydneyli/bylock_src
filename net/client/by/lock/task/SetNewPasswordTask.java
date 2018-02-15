package net.client.by.lock.task;

import android.content.Context;
import net.client.by.lock.C0333c;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p014c.C0327e;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p016f.C0371p;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class SetNewPasswordTask extends C0448a {
    public SetNewPasswordTask(Context context, Object obj) {
        super(context, obj);
    }

    protected String getUrl() {
        return C0371p.m2529x();
    }

    protected Document getRequest() {
        return C0354c.m2439f();
    }

    protected void onPostExecute(Object[] objArr) {
        super.onPostExecute(objArr);
        if (!objArr[0].equals("onSuccess") && !objArr[0].equals("onFail") && objArr[0].equals("onException") && !C0351r.m2359i().m2386h()) {
        }
    }

    protected void restart() {
        C0332j.m2148a().m2181e();
    }

    protected Object[] onSuccess(Document document) {
        C0333c.m2187c().m2191b();
        C0327e.m2092c().m2107g();
        return new Object[]{"onSuccess", document};
    }
}
