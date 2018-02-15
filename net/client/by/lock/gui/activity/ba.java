package net.client.by.lock.gui.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import java.util.Iterator;
import net.client.by.lock.p012d.C0337c;

/* compiled from: MyApp */
class ba implements OnClickListener {
    final /* synthetic */ aw f1774a;

    ba(aw awVar) {
        this.f1774a = awVar;
    }

    public void onClick(View view) {
        ArrayList arrayList = new ArrayList();
        Iterator it = aw.aa.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((C0337c) it.next()).m2237K()));
        }
        Intent intent = new Intent(this.f1774a.m47b(), SelectFriendsActivity.class);
        intent.putIntegerArrayListExtra("mSelectedFriends", arrayList);
        this.f1774a.m36a(intent, 14);
    }
}
