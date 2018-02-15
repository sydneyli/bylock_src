package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* compiled from: MyApp */
final class BackStackState implements Parcelable {
    public static final Creator CREATOR = new C0019f();
    final int[] f20a;
    final int f21b;
    final int f22c;
    final String f23d;
    final int f24e;
    final int f25f;
    final CharSequence f26g;
    final int f27h;
    final CharSequence f28i;

    public BackStackState(C0031r c0031r, C0017d c0017d) {
        int i = 0;
        for (C0018e c0018e = c0017d.f152b; c0018e != null; c0018e = c0018e.f170a) {
            if (c0018e.f178i != null) {
                i += c0018e.f178i.size();
            }
        }
        this.f20a = new int[(i + (c0017d.f154d * 7))];
        if (c0017d.f161k) {
            i = 0;
            for (C0018e c0018e2 = c0017d.f152b; c0018e2 != null; c0018e2 = c0018e2.f170a) {
                int i2 = i + 1;
                this.f20a[i] = c0018e2.f172c;
                int i3 = i2 + 1;
                this.f20a[i2] = c0018e2.f173d != null ? c0018e2.f173d.f51f : -1;
                int i4 = i3 + 1;
                this.f20a[i3] = c0018e2.f174e;
                i2 = i4 + 1;
                this.f20a[i4] = c0018e2.f175f;
                i4 = i2 + 1;
                this.f20a[i2] = c0018e2.f176g;
                i2 = i4 + 1;
                this.f20a[i4] = c0018e2.f177h;
                if (c0018e2.f178i != null) {
                    int size = c0018e2.f178i.size();
                    i4 = i2 + 1;
                    this.f20a[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.f20a[i4] = ((Fragment) c0018e2.f178i.get(i2)).f51f;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.f20a[i2] = 0;
                }
            }
            this.f21b = c0017d.f159i;
            this.f22c = c0017d.f160j;
            this.f23d = c0017d.f163m;
            this.f24e = c0017d.f165o;
            this.f25f = c0017d.f166p;
            this.f26g = c0017d.f167q;
            this.f27h = c0017d.f168r;
            this.f28i = c0017d.f169s;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel parcel) {
        this.f20a = parcel.createIntArray();
        this.f21b = parcel.readInt();
        this.f22c = parcel.readInt();
        this.f23d = parcel.readString();
        this.f24e = parcel.readInt();
        this.f25f = parcel.readInt();
        this.f26g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f27h = parcel.readInt();
        this.f28i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    public C0017d m26a(C0031r c0031r) {
        C0017d c0017d = new C0017d(c0031r);
        int i = 0;
        int i2 = 0;
        while (i2 < this.f20a.length) {
            C0018e c0018e = new C0018e();
            int i3 = i2 + 1;
            c0018e.f172c = this.f20a[i2];
            if (C0031r.f204a) {
                Log.v("FragmentManager", "Instantiate " + c0017d + " op #" + i + " base fragment #" + this.f20a[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.f20a[i3];
            if (i2 >= 0) {
                c0018e.f173d = (Fragment) c0031r.f210f.get(i2);
            } else {
                c0018e.f173d = null;
            }
            i3 = i4 + 1;
            c0018e.f174e = this.f20a[i4];
            i4 = i3 + 1;
            c0018e.f175f = this.f20a[i3];
            i3 = i4 + 1;
            c0018e.f176g = this.f20a[i4];
            int i5 = i3 + 1;
            c0018e.f177h = this.f20a[i3];
            i4 = i5 + 1;
            int i6 = this.f20a[i5];
            if (i6 > 0) {
                c0018e.f178i = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (C0031r.f204a) {
                        Log.v("FragmentManager", "Instantiate " + c0017d + " set remove fragment #" + this.f20a[i4]);
                    }
                    i5 = i4 + 1;
                    c0018e.f178i.add((Fragment) c0031r.f210f.get(this.f20a[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            c0017d.m182a(c0018e);
            i++;
            i2 = i4;
        }
        c0017d.f159i = this.f21b;
        c0017d.f160j = this.f22c;
        c0017d.f163m = this.f23d;
        c0017d.f165o = this.f24e;
        c0017d.f161k = true;
        c0017d.f166p = this.f25f;
        c0017d.f167q = this.f26g;
        c0017d.f168r = this.f27h;
        c0017d.f169s = this.f28i;
        c0017d.m181a(1);
        return c0017d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f20a);
        parcel.writeInt(this.f21b);
        parcel.writeInt(this.f22c);
        parcel.writeString(this.f23d);
        parcel.writeInt(this.f24e);
        parcel.writeInt(this.f25f);
        TextUtils.writeToParcel(this.f26g, parcel, 0);
        parcel.writeInt(this.f27h);
        TextUtils.writeToParcel(this.f28i, parcel, 0);
    }
}
