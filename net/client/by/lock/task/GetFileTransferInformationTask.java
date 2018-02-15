package net.client.by.lock.task;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import net.client.by.lock.p013b.C0314g;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p015e.C0355d;
import net.client.by.lock.p016f.C0371p;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class GetFileTransferInformationTask extends C0448a {
    String fileId;
    ArrayList fileList;

    public GetFileTransferInformationTask(Context context, Object obj) {
        super(context, obj);
        this.fileId = (String) obj;
    }

    protected String getUrl() {
        return C0371p.m2519n();
    }

    protected Document getRequest() {
        return C0354c.m2430c(this.fileId);
    }

    protected Object[] onSuccess(Document document) {
        this.fileList = C0355d.m2441a(document);
        return new String[]{"onSuccess"};
    }

    protected void onPostExecute(Object[] objArr) {
        super.onPostExecute(objArr);
        if (objArr[0].equals("onSuccess")) {
            Iterator it = this.fileList.iterator();
            while (it.hasNext()) {
                C0314g c0314g = (C0314g) it.next();
                if (!c0314g.m1913E().m2254a(c0314g)) {
                    C0332j.m2148a().m2179d(c0314g.m2041i());
                }
            }
        }
    }

    protected void restart() {
        C0332j.m2148a().m2169b(this.fileId);
    }
}
