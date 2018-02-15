package android.support.v4.p003c;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

/* compiled from: MyApp */
class C0046d implements ClassLoaderCreator {
    private final C0045c f242a;

    public C0046d(C0045c c0045c) {
        this.f242a = c0045c;
    }

    public Object createFromParcel(Parcel parcel) {
        return this.f242a.mo94a(parcel, null);
    }

    public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f242a.mo94a(parcel, classLoader);
    }

    public Object[] newArray(int i) {
        return this.f242a.mo95a(i);
    }
}
