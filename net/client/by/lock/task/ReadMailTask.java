package net.client.by.lock.task;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import net.client.by.lock.gui.activity.ReadIMailActivity;
import net.client.by.lock.p012d.C0347l;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p015e.C0355d;
import net.client.by.lock.p016f.C0368m;
import net.client.by.lock.p016f.C0371p;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class ReadMailTask extends C0448a {
    C0347l mail = ((C0347l) this.startupParameter);

    public ReadMailTask(Context context, Object obj) {
        super(context, obj);
    }

    protected String getUrl() {
        return C0371p.m2531z();
    }

    protected Document getRequest() {
        return C0354c.m2434d(this.mail.m2321j());
    }

    protected void restart() {
        C0332j.m2148a().m2164a(this.mail);
    }

    protected Object[] onSuccess(Document document) {
        C0355d.m2445a(document, this.mail);
        if (((String) this.mail.m1914F().m2467a()).equals("COMPLETED")) {
            this.mail.m2329b();
        }
        return new Object[]{"onSuccess", Html.fromHtml(C0368m.m2484a(this.mail.m2318g(), this.mail.m2332e()))};
    }

    protected Object[] onException(Throwable th) {
        this.mail.m1921f(th.getMessage());
        return new Object[]{"onException", th};
    }

    protected Object[] onFailAtServer(String str) {
        this.mail.m1921f(str);
        return new Object[]{"onFail", str};
    }

    protected void onPostExecute(Object[] objArr) {
        super.onPostExecute(objArr);
        if (objArr[0].equals("onSuccess") && (this.ctx instanceof ReadIMailActivity)) {
            ReadIMailActivity readIMailActivity = (ReadIMailActivity) this.ctx;
            readIMailActivity.f1673o.setText((Spanned) objArr[1]);
            readIMailActivity.f1678u.m2725a(this.mail.m2324m());
            readIMailActivity.m2619h();
            readIMailActivity.m2618b(0);
        }
    }
}
