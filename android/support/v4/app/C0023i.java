package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment.SavedState;

/* compiled from: MyApp */
final class C0023i implements Creator {
    C0023i() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m193a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m194a(i);
    }

    public SavedState m193a(Parcel parcel) {
        return new SavedState(parcel, null);
    }

    public SavedState[] m194a(int i) {
        return new SavedState[i];
    }
}
