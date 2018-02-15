package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: MyApp */
final class C0019f implements Creator {
    C0019f() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m189a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m190a(i);
    }

    public BackStackState m189a(Parcel parcel) {
        return new BackStackState(parcel);
    }

    public BackStackState[] m190a(int i) {
        return new BackStackState[i];
    }
}
