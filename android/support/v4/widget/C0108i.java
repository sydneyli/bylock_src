package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.widget.DrawerLayout.SavedState;

/* compiled from: MyApp */
final class C0108i implements Creator {
    C0108i() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m896a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m897a(i);
    }

    public SavedState m896a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m897a(int i) {
        return new SavedState[i];
    }
}
