package group.pals.android.lib.ui.filechooser.utils.history;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: MyApp */
class C0279c implements Creator {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1894a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1895a(i);
    }

    C0279c() {
    }

    public HistoryStore m1894a(Parcel parcel) {
        return new HistoryStore(parcel);
    }

    public HistoryStore[] m1895a(int i) {
        return new HistoryStore[i];
    }
}
