package android.support.v4.view;

import android.view.View;
import java.util.Comparator;

/* compiled from: MyApp */
class cb implements Comparator {
    cb() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m714a((View) obj, (View) obj2);
    }

    public int m714a(View view, View view2) {
        bt btVar = (bt) view.getLayoutParams();
        bt btVar2 = (bt) view2.getLayoutParams();
        if (btVar.f325a != btVar2.f325a) {
            return btVar.f325a ? 1 : -1;
        } else {
            return btVar.f329e - btVar2.f329e;
        }
    }
}
