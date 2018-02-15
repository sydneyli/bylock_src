package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: MyApp */
final class aa implements Creator {
    aa() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m835a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m836a(i);
    }

    public SavedState m835a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m836a(int i) {
        return new SavedState[i];
    }
}
