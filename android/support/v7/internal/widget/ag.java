package android.support.v7.internal.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: MyApp */
final class ag implements Creator {
    ag() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1536a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1537a(i);
    }

    public SavedState m1536a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m1537a(int i) {
        return new SavedState[i];
    }
}
