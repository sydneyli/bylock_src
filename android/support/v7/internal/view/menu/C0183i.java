package android.support.v7.internal.view.menu;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: MyApp */
final class C0183i implements Creator {
    C0183i() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1376a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1377a(i);
    }

    public SavedState m1376a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m1377a(int i) {
        return new SavedState[i];
    }
}
