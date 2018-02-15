package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

/* compiled from: MyApp */
final class FragmentState implements Parcelable {
    public static final Creator CREATOR = new C0036w();
    final String f75a;
    final int f76b;
    final boolean f77c;
    final int f78d;
    final int f79e;
    final String f80f;
    final boolean f81g;
    final boolean f82h;
    final Bundle f83i;
    Bundle f84j;
    Fragment f85k;

    public FragmentState(Fragment fragment) {
        this.f75a = fragment.getClass().getName();
        this.f76b = fragment.f51f;
        this.f77c = fragment.f60o;
        this.f78d = fragment.f68w;
        this.f79e = fragment.f69x;
        this.f80f = fragment.f70y;
        this.f81g = fragment.f32B;
        this.f82h = fragment.f31A;
        this.f83i = fragment.f53h;
    }

    public FragmentState(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f75a = parcel.readString();
        this.f76b = parcel.readInt();
        this.f77c = parcel.readInt() != 0;
        this.f78d = parcel.readInt();
        this.f79e = parcel.readInt();
        this.f80f = parcel.readString();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f81g = z;
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.f82h = z2;
        this.f83i = parcel.readBundle();
        this.f84j = parcel.readBundle();
    }

    public Fragment m90a(C0024j c0024j, Fragment fragment) {
        if (this.f85k != null) {
            return this.f85k;
        }
        if (this.f83i != null) {
            this.f83i.setClassLoader(c0024j.getClassLoader());
        }
        this.f85k = Fragment.m28a((Context) c0024j, this.f75a, this.f83i);
        if (this.f84j != null) {
            this.f84j.setClassLoader(c0024j.getClassLoader());
            this.f85k.f49d = this.f84j;
        }
        this.f85k.m32a(this.f76b, fragment);
        this.f85k.f60o = this.f77c;
        this.f85k.f62q = true;
        this.f85k.f68w = this.f78d;
        this.f85k.f69x = this.f79e;
        this.f85k.f70y = this.f80f;
        this.f85k.f32B = this.f81g;
        this.f85k.f31A = this.f82h;
        this.f85k.f64s = c0024j.f181b;
        if (C0031r.f204a) {
            Log.v("FragmentManager", "Instantiated fragment " + this.f85k);
        }
        return this.f85k;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f75a);
        parcel.writeInt(this.f76b);
        parcel.writeInt(this.f77c ? 1 : 0);
        parcel.writeInt(this.f78d);
        parcel.writeInt(this.f79e);
        parcel.writeString(this.f80f);
        if (this.f81g) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f82h) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeBundle(this.f83i);
        parcel.writeBundle(this.f84j);
    }
}
