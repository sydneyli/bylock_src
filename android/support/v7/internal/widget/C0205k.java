package android.support.v7.internal.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: MyApp */
final class C0205k implements Creator {
    C0205k() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1605a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1606a(i);
    }

    public SavedState m1605a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m1606a(int i) {
        return new SavedState[i];
    }
}
