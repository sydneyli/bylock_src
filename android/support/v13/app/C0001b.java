package android.support.v13.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: MyApp */
final class C0001b implements Creator {
    C0001b() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m2a(i);
    }

    public SavedState m1a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m2a(int i) {
        return new SavedState[i];
    }
}
