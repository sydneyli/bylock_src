package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: MyApp */
final class FragmentManagerState implements Parcelable {
    public static final Creator CREATOR = new C0034u();
    FragmentState[] f72a;
    int[] f73b;
    BackStackState[] f74c;

    public FragmentManagerState(Parcel parcel) {
        this.f72a = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.f73b = parcel.createIntArray();
        this.f74c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f72a, i);
        parcel.writeIntArray(this.f73b);
        parcel.writeTypedArray(this.f74c, i);
    }
}
