package android.support.v4.p003c;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: MyApp */
class C0044b implements Creator {
    final C0045c f241a;

    public C0044b(C0045c c0045c) {
        this.f241a = c0045c;
    }

    public Object createFromParcel(Parcel parcel) {
        return this.f241a.mo94a(parcel, null);
    }

    public Object[] newArray(int i) {
        return this.f241a.mo95a(i);
    }
}
