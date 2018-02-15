package net.client.by.lock.p011a;

import java.security.MessageDigest;

/* compiled from: MyApp */
public class C0296j {
    private byte[] f1272a;
    private int f1273b;
    private MessageDigest f1274c = MessageDigest.getInstance("MD5");

    public void m1977a(byte[] bArr, byte[] bArr2) {
        this.f1274c.update(bArr2);
        this.f1272a = this.f1274c.digest(bArr);
        this.f1273b = 0;
    }

    public byte m1976a() {
        if (this.f1273b < this.f1272a.length) {
            byte b = this.f1272a[this.f1273b];
            this.f1273b++;
            return b;
        }
        this.f1272a = this.f1274c.digest(this.f1272a);
        this.f1273b = 1;
        return this.f1272a[0];
    }
}
