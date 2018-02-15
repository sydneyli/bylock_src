package net.client.by.lock.task;

import android.content.Context;
import net.client.by.lock.gui.activity.ae;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p015e.C0355d;
import net.client.by.lock.p016f.C0371p;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class AddFriendToRosterTask extends C0448a {
    Object[] parameter;

    public AddFriendToRosterTask(Context context, Object obj) {
        super(context, obj);
        this.parameter = (Object[]) obj;
    }

    protected String getUrl() {
        return C0371p.m2512g();
    }

    protected Document getRequest() {
        return C0354c.m2420a(new String[]{(String) this.parameter[0], (String) this.parameter[1]});
    }

    protected void restart() {
    }

    protected void onPostExecute(Object[] objArr) {
        super.onPostExecute(objArr);
        ae aeVar;
        if (objArr[0].equals("onSuccess")) {
            C0355d.m2443a((Document) objArr[1], Boolean.valueOf(false));
            if (this.parameter.length > 2 && this.parameter[2] != null && (this.parameter[2] instanceof ae)) {
                aeVar = (ae) this.parameter[2];
                if (aeVar.f1725S != null) {
                    aeVar.f1725S.dismiss();
                }
                ae.f1721P.setText("");
                ae.f1722Q.setText("");
            }
        } else if (this.parameter.length > 2 && this.parameter[2] != null && (this.parameter[2] instanceof ae)) {
            aeVar = (ae) this.parameter[2];
            if (aeVar.f1725S != null) {
                aeVar.f1725S.dismiss();
            }
        }
    }
}
