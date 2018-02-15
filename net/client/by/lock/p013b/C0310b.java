package net.client.by.lock.p013b;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import net.client.by.lock.p015e.C0353b;
import net.client.by.lock.p016f.C0357b;
import net.client.by.lock.p016f.C0365j;

/* compiled from: MyApp */
public class C0310b extends C0309e {
    byte[] f1349a;
    int f1350b;
    int f1351c;
    int f1352d = 15;
    Cipher f1353e;
    C0357b f1354f;
    private boolean f1355l;

    public C0310b(C0314g c0314g) {
        this.f1354f = new C0357b(new FileOutputStream(c0314g.m2042j()));
        this.f1355l = false;
        try {
            this.f1353e = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f1353e.init(2, c0314g.mo323c(), c0314g.mo324d());
        } catch (Throwable e) {
            C0365j.m2476a("Error in initializing FileDownloadInputStream", e);
            this.f1353e = null;
        } catch (Throwable e2) {
            C0365j.m2476a("Error in initializing FileDownloadInputStream", e2);
            this.f1353e = null;
        } catch (Throwable e22) {
            C0365j.m2476a("Error in initializing FileDownloadInputStream", e22);
            this.f1353e = null;
        } catch (Throwable e222) {
            C0365j.m2476a("Error in initializing FileDownloadInputStream", e222);
            this.f1353e = null;
        }
        this.f1351c = 0;
        this.f1350b = 0;
    }

    public void mo320a(InputStream inputStream) {
        this.j = new C0320l(inputStream, this.h);
        this.i = false;
    }

    public int read() {
        if (this.g) {
            return -1;
        }
        if (this.f1352d == 15) {
            if (this.f1351c - this.f1350b < "<fileContent>".length() && !m2014e()) {
                close();
                return -1;
            } else if (Arrays.equals(Arrays.copyOfRange(this.f1349a, this.f1350b, this.f1350b + "<fileContent>".getBytes().length), "<fileContent>".getBytes())) {
                if (this.f1353e != null) {
                    try {
                        m2012c();
                    } catch (Throwable e) {
                        C0365j.m2476a("Error in handling file content", e);
                    } catch (Throwable e2) {
                        C0365j.m2476a("Error in handling file content", e2);
                    }
                }
                this.f1352d = 35;
                this.f1350b++;
                return this.f1349a[this.f1350b - 1];
            } else {
                this.f1350b++;
                return this.f1349a[this.f1350b - 1];
            }
        } else if (this.f1350b < this.f1351c) {
            this.f1350b++;
            return this.f1349a[this.f1350b - 1];
        } else if (this.i) {
            close();
            return -1;
        } else if (m2014e()) {
            this.f1350b = 1;
            return this.f1349a[0];
        } else {
            close();
            return -1;
        }
    }

    private void m2012c() {
        Object obj = null;
        this.f1350b += "<fileContent>".getBytes().length;
        while (obj == null) {
            if (this.f1350b == this.f1351c && !m2014e()) {
                close();
                throw new IOException("Error in filling buffer.");
            } else if (this.f1349a[this.f1350b] == (byte) 60) {
                if (this.f1351c - this.f1350b > "</fileContent>".getBytes().length || m2014e()) {
                    this.f1350b += "</fileContent>".getBytes().length;
                    obj = 1;
                    try {
                        this.f1354f.m2456a(this.f1353e.doFinal());
                        m2013d();
                    } catch (IllegalBlockSizeException e) {
                        close();
                        throw e;
                    }
                }
                close();
                throw new IOException("Error in filling buffer.");
            } else if (this.f1351c - this.f1350b >= 4 || m2014e()) {
                try {
                    this.f1354f.m2456a(this.f1353e.update(C0353b.m2406a(new String(this.f1349a, this.f1350b, 4))));
                    this.f1350b += 4;
                } catch (IOException e2) {
                    close();
                    throw e2;
                }
            } else {
                close();
                throw new IOException("Error in filling buffer.");
            }
        }
    }

    private void m2013d() {
        if (!this.f1355l) {
            if (this.f1354f != null) {
                try {
                    this.f1354f.m2455a();
                } catch (Throwable e) {
                    C0365j.m2476a("", e);
                }
                this.f1354f = null;
            }
            this.f1355l = true;
        }
    }

    private boolean m2014e() {
        Object obj = new byte[0];
        if (this.f1350b < this.f1351c) {
            obj = Arrays.copyOfRange(this.f1349a, this.f1350b, this.f1351c);
        }
        this.f1349a = new byte[(obj.length + 4096)];
        System.arraycopy(obj, 0, this.f1349a, 0, obj.length);
        try {
            int read = this.j.read(this.f1349a, obj.length, 4096);
            if (read == -1) {
                this.f1351c = obj.length;
                return false;
            }
            this.f1351c = obj.length + read;
            this.f1350b = 0;
            return true;
        } catch (Throwable e) {
            C0365j.m2476a("Error in fillBuffer", e);
            return false;
        }
    }

    public void close() {
        super.close();
        this.g = true;
        m2011b();
        m2013d();
    }
}
