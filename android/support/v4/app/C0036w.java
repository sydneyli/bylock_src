package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: MyApp */
final class C0036w implements Creator {
    C0036w() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m302a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m303a(i);
    }

    public FragmentState m302a(Parcel parcel) {
        return new FragmentState(parcel);
    }

    public FragmentState[] m303a(int i) {
        return new FragmentState[i];
    }
}
