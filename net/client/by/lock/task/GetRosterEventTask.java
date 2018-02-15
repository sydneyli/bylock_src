package net.client.by.lock.task;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import javax.xml.transform.TransformerException;
import net.client.by.lock.C0322b;
import net.client.by.lock.gui.activity.MainActivity;
import net.client.by.lock.gui.p018b.an;
import net.client.by.lock.p012d.C0349o;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p014c.C0325c;
import net.client.by.lock.p014c.C0330h;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p015e.C0355d;
import net.client.by.lock.p016f.C0365j;
import net.client.by.lock.p016f.C0371p;
import org.w3c.dom.Document;
import org.xml.sax.SAXParseException;

/* compiled from: MyApp */
public class GetRosterEventTask extends C0448a {
    public static final String TAG = "GetRosterEventTask";
    public static int rosterEventErrorCount = 0;
    String[] fileTransferIds;
    Set lastChatIds;
    String[] mailIds;

    public GetRosterEventTask(Context context, Object obj) {
        super(context, obj);
        C0322b.m2078v(TAG, "roster create");
    }

    protected String getUrl() {
        return C0371p.m2511f();
    }

    protected Document getRequest() {
        this.mailIds = C0351r.m2359i().m2378d();
        this.fileTransferIds = C0351r.m2359i().m2380e();
        this.lastChatIds = C0351r.m2359i().m2373c();
        return C0354c.m2410a(C0351r.m2359i().m2397s(), this.mailIds, this.fileTransferIds, this.lastChatIds);
    }

    protected void restart() {
        C0332j.m2148a().m2184f();
    }

    protected Object[] onSuccess(Document document) {
        C0322b.m2078v(TAG, "roster success");
        rosterEventErrorCount = 0;
        try {
            ArrayList b = C0355d.m2448b(document);
            C0351r.m2359i().m2368a(this.mailIds, this.fileTransferIds, this.lastChatIds);
            Intent intent = new Intent(MainActivity.f1648t);
            intent.putExtra("caption", "");
            C0325c.m2086a().m2088b().sendBroadcast(intent);
            C0330h.m2111a().m2121d();
            if (!((Boolean) C0351r.m2359i().m2398t().m2467a()).booleanValue()) {
                C0351r.m2359i().m2398t().m2468a(Boolean.valueOf(true));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = b.iterator();
            while (it.hasNext()) {
                C0349o c0349o = (C0349o) it.next();
                if (c0349o.m2343a().equalsIgnoreCase("ANSWER CALL")) {
                    c0349o.m2346b();
                } else {
                    arrayList.add(c0349o);
                }
            }
            return new Object[]{"onSuccess", arrayList};
        } catch (Throwable e) {
            an.m2728a(this.ctx, "Some kind of error occured, unexpected behaviour may occur");
            C0322b.m2076e(TAG, "-=GET ROSTER EVENT LEAK=-");
            C0365j.m2476a(TAG, e);
            C0322b.m2076e(TAG, "-=GET ROSTER EVENT LEAK=-");
            Object[] objArr = new Object[]{"onFail", document};
            C0330h.m2111a().m2121d();
            if (!((Boolean) C0351r.m2359i().m2398t().m2467a()).booleanValue()) {
                C0351r.m2359i().m2398t().m2468a(Boolean.valueOf(true));
            }
            return objArr;
        } catch (Throwable e2) {
            Throwable th = e2;
            C0330h.m2111a().m2121d();
            if (!((Boolean) C0351r.m2359i().m2398t().m2467a()).booleanValue()) {
                C0351r.m2359i().m2398t().m2468a(Boolean.valueOf(true));
            }
        }
    }

    protected void onPostExecute(Object[] objArr) {
        super.onPostExecute(objArr);
        if (objArr[0].equals("onSuccess")) {
            Iterator it = ((ArrayList) objArr[1]).iterator();
            while (it.hasNext()) {
                ((C0349o) it.next()).m2346b();
            }
        }
    }

    protected Object[] onException(Throwable th) {
        rosterEventErrorCount++;
        if ((th instanceof TransformerException) || (th instanceof SAXParseException)) {
            C0330h.m2111a().m2122e();
        } else if (rosterEventErrorCount < 5) {
            C0330h.m2111a().m2121d();
        } else {
            if (((Boolean) C0351r.m2359i().m2398t().m2467a()).booleanValue()) {
                C0351r.m2359i().m2398t().m2468a(Boolean.valueOf(false));
            }
            C0330h.m2111a().m2122e();
        }
        return new Object[]{"onException", th};
    }

    protected Object[] onFailAtServer(String str) {
        if (str.contains("SessionClosedException") || str.contains("SessionExpiredException")) {
            if (((Boolean) C0351r.m2359i().m2398t().m2467a()).booleanValue()) {
                C0351r.m2359i().m2398t().m2468a(Boolean.valueOf(false));
            }
            C0330h.m2111a().m2122e();
            return new Object[]{"onFail", str};
        }
        rosterEventErrorCount++;
        if (rosterEventErrorCount < 5) {
            C0330h.m2111a().m2121d();
        } else {
            if (((Boolean) C0351r.m2359i().m2398t().m2467a()).booleanValue()) {
                C0351r.m2359i().m2398t().m2468a(Boolean.valueOf(false));
            }
            C0330h.m2111a().m2122e();
        }
        return new Object[]{"onFail", str};
    }
}
