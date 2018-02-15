package net.client.by.lock.task;

import android.content.Context;
import android.content.Intent;
import net.client.by.lock.C0322b;
import net.client.by.lock.gui.activity.PrngActivity;
import net.client.by.lock.gui.activity.RegisterActivity;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p015e.C0355d;
import net.client.by.lock.p016f.C0371p;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class RegisterTask extends C0448a {
    private static final String TAG = "RegisterTask";
    String[] parameter;

    public RegisterTask(Context context, Object obj) {
        super(context, obj);
        this.parameter = (String[]) obj;
    }

    protected String getUrl() {
        return C0371p.m2504G();
    }

    protected Document getRequest() {
        return C0354c.m2412a(this.parameter[0], this.parameter[1]);
    }

    protected void restart() {
        C0332j.m2148a().m2156a(this.parameter[0], this.parameter[1]);
    }

    protected Object[] onSuccess(Document document) {
        try {
            if (C0355d.m2451d(document)) {
                C0351r.m2359i().m2377d(this.parameter[0]);
                C0351r.m2359i().m2382f(this.parameter[1]);
                return new Object[]{"onSuccess"};
            }
            return new Object[]{"onFail"};
        } catch (Exception e) {
            Exception exception = e;
            return new Object[]{"onException", document, exception};
        }
    }

    protected void onPostExecute(Object[] objArr) {
        super.onPostExecute(objArr);
        if (this.ctx instanceof RegisterActivity) {
            RegisterActivity registerActivity = (RegisterActivity) this.ctx;
            registerActivity.f1697e.dismiss();
            if (objArr[0].equals("onSuccess")) {
                this.ctx.startActivity(new Intent(this.ctx, PrngActivity.class));
                registerActivity.finish();
                C0332j.m2148a().m2184f();
            } else if (objArr[0].equals("onException")) {
                C0322b.m2076e(TAG, "onException");
            } else if (objArr[0].equals("onFail")) {
                C0322b.m2076e(TAG, "onException");
            }
        }
    }
}
