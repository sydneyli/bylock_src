package net.client.by.lock.task;

import android.content.Context;
import net.client.by.lock.gui.activity.aw;
import net.client.by.lock.gui.p018b.an;
import net.client.by.lock.p012d.C0348n;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p015e.C0355d;
import net.client.by.lock.p016f.C0371p;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class SendMailTask extends C0448a {
    C0348n mail = ((C0348n) this.parameter[0]);
    Object[] parameter;

    public SendMailTask(Context context, Object obj) {
        super(context, obj);
        this.parameter = (Object[]) obj;
    }

    protected String getUrl() {
        return C0371p.m2530y();
    }

    protected Object[] onException(Throwable th) {
        this.mail.m1921f(th.getMessage());
        return new Object[]{"onException", th};
    }

    protected Object[] onFailAtServer(String str) {
        this.mail.m1921f(str);
        return new Object[]{"onFail", str};
    }

    protected Document getRequest() {
        if (this.mail.m2341e() && C0351r.m2359i().m2394p().m2352a(this.mail)) {
            return C0354c.m2418a(this.mail);
        }
        return null;
    }

    protected Object[] onSuccess(Document document) {
        this.mail.m1919d(C0355d.m2453f(document));
        this.mail.m1920e("COMPLETED");
        return new String[]{"onSuccess"};
    }

    protected void onPostExecute(Object[] objArr) {
        super.onPostExecute(objArr);
        aw awVar;
        if (objArr[0].equals("onSuccess")) {
            this.mail.mo317A().m2552a();
            this.mail.mo317A().m2553a(8);
            an.m2728a(this.ctx, "Mail Sent!!");
            if (this.parameter.length > 1 && this.parameter[1] != null && (this.parameter[1] instanceof aw)) {
                awVar = (aw) this.parameter[1];
                if (awVar.f1769P != null) {
                    awVar.f1769P.dismiss();
                }
                awVar.m2684A();
            }
        } else if (this.parameter.length > 1 && this.parameter[1] != null && (this.parameter[1] instanceof aw)) {
            awVar = (aw) this.parameter[1];
            if (awVar.f1769P != null) {
                awVar.f1769P.dismiss();
            }
        }
    }

    protected void restart() {
    }
}
