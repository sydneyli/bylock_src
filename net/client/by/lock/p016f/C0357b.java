package net.client.by.lock.p016f;

import java.io.FileOutputStream;

/* compiled from: MyApp */
public class C0357b {
    FileOutputStream f1549a;
    byte[] f1550b = new byte[4096];
    int f1551c = 0;

    public C0357b(FileOutputStream fileOutputStream) {
        this.f1549a = fileOutputStream;
    }

    public void m2456a(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        if (bArr.length + this.f1551c < 4096) {
            System.arraycopy(bArr, 0, this.f1550b, this.f1551c, bArr.length);
            this.f1551c += bArr.length;
            return;
        }
        System.arraycopy(bArr, 0, this.f1550b, this.f1551c, 4096 - this.f1551c);
        this.f1549a.write(this.f1550b);
        int i = 4096 - this.f1551c;
        int length = (bArr.length - i) % 4096;
        this.f1549a.write(bArr, i, (bArr.length - i) - length);
        System.arraycopy(bArr, bArr.length - length, this.f1550b, 0, length);
        this.f1551c = length;
    }

    public void m2455a() {
        this.f1549a.write(this.f1550b, 0, this.f1551c);
        this.f1549a.flush();
        this.f1549a.close();
    }
}
