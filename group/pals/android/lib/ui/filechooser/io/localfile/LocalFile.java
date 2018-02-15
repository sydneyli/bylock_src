package group.pals.android.lib.ui.filechooser.io.localfile;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import group.pals.android.lib.ui.filechooser.io.IFile;
import java.io.File;

/* compiled from: MyApp */
public class LocalFile extends File implements IFile {
    public static final Creator CREATOR = new C0240a();

    public /* synthetic */ Object clone() {
        return mo299b();
    }

    public LocalFile(String str) {
        super(str);
    }

    public LocalFile(File file) {
        this(file.getAbsolutePath());
    }

    public IFile mo297a() {
        return getParent() == null ? null : new LocalFile(getParent());
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public boolean mo298a(IFile iFile) {
        return iFile == null ? false : getAbsolutePath().equals(iFile.getAbsolutePath());
    }

    public IFile mo299b() {
        return new LocalFile(getAbsolutePath());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getAbsolutePath());
    }

    private LocalFile(Parcel parcel) {
        this(parcel.readString());
    }
}
