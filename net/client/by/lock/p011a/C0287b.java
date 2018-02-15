package net.client.by.lock.p011a;

/* compiled from: MyApp */
public class C0287b {
    private short[] f1240a;
    private byte[] f1241b;
    private int f1242c;
    private int f1243d;

    public C0287b(short[] sArr, int i, int i2) {
        m1904a(sArr, i, i2);
    }

    protected final void m1904a(short[] sArr, int i, int i2) {
        this.f1240a = sArr;
        this.f1242c = i;
        this.f1243d = i2;
    }

    protected final void m1903a(byte[] bArr, int i, int i2) {
        this.f1241b = bArr;
        this.f1242c = i;
        this.f1243d = i2;
    }

    public byte[] m1905a() {
        return this.f1241b;
    }

    public short[] m1906b() {
        return this.f1240a;
    }

    public int m1907c() {
        return this.f1242c;
    }

    public int m1908d() {
        return this.f1243d;
    }
}
