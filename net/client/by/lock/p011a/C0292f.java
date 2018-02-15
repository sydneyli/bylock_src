package net.client.by.lock.p011a;

/* compiled from: MyApp */
public class C0292f extends C0287b implements Comparable {
    private int f1262a;

    public /* synthetic */ int compareTo(Object obj) {
        return m1966a((C0292f) obj);
    }

    public C0292f(byte[] bArr, int i) {
        super(null, 0, 0);
        m1903a(bArr, 4, i - 4);
        this.f1262a = C0292f.m1965a(bArr);
    }

    public int m1967e() {
        return this.f1262a;
    }

    private static int m1965a(byte[] bArr) {
        return (((bArr[0] << 24) | ((bArr[1] & 255) << 16)) | ((bArr[2] & 255) << 8)) | (bArr[3] & 255);
    }

    public int m1966a(C0292f c0292f) {
        if (this.f1262a > c0292f.f1262a) {
            return 1;
        }
        if (this.f1262a < c0292f.f1262a) {
            return -1;
        }
        return 0;
    }
}
