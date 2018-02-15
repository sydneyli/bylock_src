package group.pals.android.lib.ui.filechooser.io.localfile;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: MyApp */
class C0240a implements Creator {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1827a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1828a(i);
    }

    C0240a() {
    }

    public LocalFile m1827a(Parcel parcel) {
        return new LocalFile(parcel);
    }

    public LocalFile[] m1828a(int i) {
        return new LocalFile[i];
    }
}
