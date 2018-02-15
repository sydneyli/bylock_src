package net.client.by.lock.task;

import android.content.Context;
import java.util.ArrayList;
import net.client.by.lock.p012d.C0337c;
import net.client.by.lock.p014c.C0332j;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p015e.C0355d;
import net.client.by.lock.p016f.C0371p;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class CreateGroupWithFriendTask extends C0448a {
    C0337c friend;
    String groupName;

    public CreateGroupWithFriendTask(Context context, Object obj) {
        super(context, obj);
        this.groupName = (String) ((ArrayList) obj).get(0);
        this.friend = (C0337c) ((ArrayList) obj).get(1);
    }

    protected String getUrl() {
        return C0371p.m2526u();
    }

    protected Document getRequest() {
        return C0354c.m2416a(this.friend, this.groupName);
    }

    protected void restart() {
        C0332j.m2148a().m2162a(this.friend, this.groupName);
    }

    protected void onPostExecute(Object[] objArr) {
        super.onPostExecute(objArr);
        if (objArr[0].equals("onSuccess")) {
            C0355d.m2444a((Document) objArr[1], this.startupParameter);
        }
    }
}
