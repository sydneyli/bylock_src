package group.pals.android.lib.ui.filechooser.io;

import android.os.Parcelable;

/* compiled from: MyApp */
public interface IFile extends Parcelable {
    IFile mo297a();

    boolean mo298a(IFile iFile);

    IFile mo299b();

    boolean canRead();

    boolean delete();

    boolean exists();

    String getAbsolutePath();

    String getName();

    boolean isDirectory();

    boolean isFile();

    long lastModified();

    long length();

    boolean mkdir();
}
