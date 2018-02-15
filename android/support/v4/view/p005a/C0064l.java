package android.support.v4.view.p005a;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MyApp */
class C0064l implements C0063p {
    final /* synthetic */ C0059i f306a;
    final /* synthetic */ C0062k f307b;

    C0064l(C0062k c0062k, C0059i c0059i) {
        this.f307b = c0062k;
        this.f306a = c0059i;
    }

    public boolean mo49a(int i, int i2, Bundle bundle) {
        return this.f306a.m473a(i, i2, bundle);
    }

    public List mo48a(String str, int i) {
        List a = this.f306a.m472a(str, i);
        List arrayList = new ArrayList();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((C0051a) a.get(i2)).m364a());
        }
        return arrayList;
    }

    public Object mo47a(int i) {
        C0051a a = this.f306a.m470a(i);
        if (a == null) {
            return null;
        }
        return a.m364a();
    }
}
