package android.support.v7.internal.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: MyApp */
final class C0198e implements Creator {
    C0198e() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1592a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1593a(i);
    }

    public SavedState m1592a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m1593a(int i) {
        return new SavedState[i];
    }
}
