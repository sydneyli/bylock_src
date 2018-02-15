package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: MyApp */
final class C0034u implements Creator {
    C0034u() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m271a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m272a(i);
    }

    public FragmentManagerState m271a(Parcel parcel) {
        return new FragmentManagerState(parcel);
    }

    public FragmentManagerState[] m272a(int i) {
        return new FragmentManagerState[i];
    }
}
