package net.client.by.lock.task;

import android.content.Context;
import android.content.Intent;
import javax.net.ssl.SSLPeerUnverifiedException;
import net.client.by.lock.C0322b;
import net.client.by.lock.gui.activity.LoginActivity;
import net.client.by.lock.gui.activity.MainActivity;
import net.client.by.lock.gui.activity.PrngActivity;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p014c.C0323a;
import net.client.by.lock.p014c.C0325c;
import net.client.by.lock.p014c.C0327e;
import net.client.by.lock.p014c.C0330h;
import net.client.by.lock.p014c.C0331i;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p015e.C0355d;
import net.client.by.lock.p016f.C0371p;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class LoginTask extends C0448a {
    public LoginTask(Context context, Object obj) {
        super(context, obj);
    }

    protected String getUrl() {
        return C0371p.m2506a();
    }

    protected void onPreExecute() {
        super.onPreExecute();
        C0351r.m2358a(false);
        Intent intent = new Intent(MainActivity.f1648t);
        intent.putExtra("caption", "Connecting");
        C0325c.m2086a().m2088b().sendBroadcast(intent);
    }

    protected Document getRequest() {
        return C0354c.m2407a();
    }

    protected void onCancel() {
        if (this.ctx instanceof LoginActivity) {
            ((LoginActivity) this.ctx).f1641f.setEnabled(true);
            ((LoginActivity) this.ctx).m2607a(false);
        }
    }

    protected void restart() {
        C0332j.m2148a().m2166b();
    }

    protected Object[] onSuccess(Document document) {
        try {
            C0327e.m2093d();
            C0355d.m2450c(document);
            C0351r.m2359i().m2398t().m2468a(Boolean.valueOf(true));
            C0331i.m2124a().m2133b(this.ctx);
            Intent intent = new Intent(MainActivity.f1648t);
            intent.putExtra("caption", "");
            C0325c.m2086a().m2088b().sendBroadcast(intent);
            return new Object[]{"onSuccess"};
        } catch (Exception e) {
            Exception exception = e;
            return new Object[]{"onException", document, exception};
        }
    }

    protected void onPostExecute(Object[] objArr) {
        super.onPostExecute(objArr);
        if (this.ctx instanceof LoginActivity) {
            ((LoginActivity) this.ctx).f1641f.setEnabled(true);
        }
        if (!C0351r.m2359i().m2386h()) {
            LoginActivity loginActivity;
            if (objArr[0].equals("onSuccess")) {
                if (this.ctx instanceof LoginActivity) {
                    loginActivity = (LoginActivity) this.ctx;
                    if (C0351r.m2359i().m2395q()) {
                        C0323a.m2081a(this.ctx);
                        loginActivity.m2607a(false);
                        this.ctx.startActivity(new Intent(this.ctx, PrngActivity.class));
                        loginActivity.finish();
                        C0332j.m2148a().m2184f();
                        return;
                    }
                    C0322b.m2076e("Logintask", "session is not logged in");
                } else if (C0351r.m2359i().m2395q()) {
                    C0323a.m2081a(this.ctx);
                    C0332j.m2148a().m2184f();
                }
            } else if (objArr[0].equals("onFail")) {
                if (this.ctx instanceof LoginActivity) {
                    loginActivity = (LoginActivity) this.ctx;
                    loginActivity.m2607a(false);
                    loginActivity.f1640e.setError((String) objArr[1]);
                    loginActivity.f1640e.requestFocus();
                    return;
                }
                C0330h.m2111a().m2122e();
            } else if (!objArr[0].equals("onException")) {
                C0330h.m2111a().m2122e();
            } else if (this.ctx instanceof LoginActivity) {
                ((LoginActivity) this.ctx).m2607a(false);
            } else {
                C0330h.m2111a().m2122e();
            }
        }
    }

    protected Object[] onException(Throwable th) {
        if (C0351r.m2359i().m2386h()) {
            return new Object[]{"onException", th};
        }
        if (th instanceof SSLPeerUnverifiedException) {
            C0330h.m2111a().m2114a("Certification error: Check your internet settings!");
        } else {
            C0330h.m2111a().m2114a(th.getMessage());
        }
        return new Object[]{"onException", th};
    }

    protected Object[] onFailAtServer(String str) {
        if (C0351r.m2359i().m2386h()) {
            return new Object[]{"onFail", str};
        }
        C0330h.m2111a().m2114a(str);
        return new Object[]{"onFail", str};
    }
}
