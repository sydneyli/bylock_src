package group.pals.android.lib.ui.filechooser.utils.history;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MyApp */
public class HistoryStore implements History {
    public static final Creator CREATOR = new C0279c();
    private final ArrayList f1035a;
    private final int f1036b;
    private final List f1037c;

    public HistoryStore(int i) {
        this.f1035a = new ArrayList();
        this.f1037c = new ArrayList();
        if (i <= 0) {
            i = 100;
        }
        this.f1036b = i;
    }

    public void mo290a(Parcelable parcelable) {
        if (parcelable != null) {
            if (this.f1035a.isEmpty() || this.f1035a.indexOf(parcelable) != this.f1035a.size() - 1) {
                this.f1035a.add(parcelable);
                mo288e();
            }
        }
    }

    public void m1676b(Parcelable parcelable) {
        if (parcelable != null) {
            int indexOf = this.f1035a.indexOf(parcelable);
            if (indexOf >= 0 && indexOf < this.f1035a.size() - 1) {
                this.f1035a.subList(indexOf + 1, this.f1035a.size()).clear();
                mo288e();
            }
        }
    }

    public void m1678c(Parcelable parcelable) {
        if (this.f1035a.remove(parcelable)) {
            mo288e();
        }
    }

    public void mo278a(C0227a c0227a) {
        Object obj = null;
        int size = this.f1035a.size() - 1;
        while (size >= 0) {
            Object obj2;
            if (c0227a.mo292a((Parcelable) this.f1035a.get(size))) {
                this.f1035a.remove(size);
                if (obj == null) {
                    obj2 = 1;
                    size--;
                    obj = obj2;
                }
            }
            obj2 = obj;
            size--;
            obj = obj2;
        }
        if (obj != null) {
            mo288e();
        }
    }

    public void mo288e() {
        for (C0233b a : this.f1037c) {
            a.mo296a(this);
        }
    }

    public int mo277a() {
        return this.f1035a.size();
    }

    public int m1681d(Parcelable parcelable) {
        return this.f1035a.indexOf(parcelable);
    }

    public Parcelable m1684e(Parcelable parcelable) {
        int indexOf = this.f1035a.indexOf(parcelable);
        if (indexOf > 0) {
            return (Parcelable) this.f1035a.get(indexOf - 1);
        }
        return null;
    }

    public Parcelable m1687f(Parcelable parcelable) {
        int indexOf = this.f1035a.indexOf(parcelable);
        if (indexOf < 0 || indexOf >= this.f1035a.size() - 1) {
            return null;
        }
        return (Parcelable) this.f1035a.get(indexOf + 1);
    }

    public ArrayList mo281b() {
        return (ArrayList) this.f1035a.clone();
    }

    public boolean mo284c() {
        return this.f1035a.isEmpty();
    }

    public void mo286d() {
        this.f1035a.clear();
        mo288e();
    }

    public void mo279a(C0233b c0233b) {
        this.f1037c.add(c0233b);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1036b);
        parcel.writeInt(mo277a());
        for (int i2 = 0; i2 < mo277a(); i2++) {
            parcel.writeParcelable((Parcelable) this.f1035a.get(i2), i);
        }
    }

    private HistoryStore(Parcel parcel) {
        this.f1035a = new ArrayList();
        this.f1037c = new ArrayList();
        this.f1036b = parcel.readInt();
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            this.f1035a.add(parcel.readParcelable(null));
        }
    }
}
