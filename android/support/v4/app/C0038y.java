package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: MyApp */
final class C0038y implements Creator {
    C0038y() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m304a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m305a(i);
    }

    public SavedState m304a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m305a(int i) {
        return new SavedState[i];
    }
}
