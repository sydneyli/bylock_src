package net.client.by.lock.p012d;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.RSAKeyGenParameterSpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Iterator;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import net.client.by.lock.p011a.C0289c;
import net.client.by.lock.p013b.C0314g;
import net.client.by.lock.p016f.C0365j;

/* compiled from: MyApp */
public class C0340f {
    protected PublicKey f1490a;
    protected KeyFactory f1491b;
    protected Cipher f1492c;
    protected Signature f1493d;

    public C0340f() {
        mo329c();
    }

    public C0340f(byte[] bArr) {
        mo329c();
        try {
            this.f1490a = this.f1491b.generatePublic(new RSAPublicKeySpec(new BigInteger(bArr), RSAKeyGenParameterSpec.F4));
        } catch (Throwable e) {
            C0365j.m2476a("Error in instantiating PublicKey.", e);
        }
        mo330d();
    }

    private void mo329c() {
        if (this.f1491b == null || this.f1493d == null || this.f1492c == null) {
            try {
                this.f1491b = KeyFactory.getInstance("RSA");
                this.f1493d = Signature.getInstance("SHA1withRSA");
                this.f1492c = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
            } catch (Throwable e) {
                C0365j.m2476a("Error in initializing byLockKeyPair", e);
                this.f1491b = null;
                this.f1493d = null;
                this.f1492c = null;
            } catch (Throwable e2) {
                C0365j.m2476a("Error in initializing byLockKeyPair", e2);
                this.f1491b = null;
                this.f1493d = null;
                this.f1492c = null;
            }
        }
    }

    private void mo330d() {
        if (this.f1490a != null) {
            if (this.f1493d != null) {
                synchronized (this.f1493d) {
                    try {
                        this.f1493d.initVerify(this.f1490a);
                    } catch (Throwable e) {
                        C0365j.m2476a("Error while initializing signature state.", e);
                    }
                }
            }
            if (this.f1492c != null) {
                synchronized (this.f1492c) {
                    try {
                        this.f1492c.init(1, this.f1490a);
                    } catch (Throwable e2) {
                        C0365j.m2476a("Error while initializing cipher state.", e2);
                    }
                }
            }
        }
    }

    public byte[] m2298a() {
        if (this.f1490a == null || this.f1491b == null) {
            return null;
        }
        try {
            return ((RSAPublicKeySpec) this.f1491b.getKeySpec(this.f1490a, RSAPublicKeySpec.class)).getModulus().toByteArray();
        } catch (Throwable e) {
            C0365j.m2476a("", e);
            return null;
        }
    }

    public BigInteger m2300b() {
        if (this.f1490a == null || this.f1491b == null) {
            return null;
        }
        try {
            return ((RSAPublicKeySpec) this.f1491b.getKeySpec(this.f1490a, RSAPublicKeySpec.class)).getModulus();
        } catch (Throwable e) {
            C0365j.m2476a("", e);
            return null;
        }
    }

    public boolean m2296a(C0335b c0335b) {
        if (this.f1493d != null) {
            boolean verify;
            synchronized (this.f1493d) {
                try {
                    this.f1493d.update(c0335b.m2214e());
                    verify = this.f1493d.verify(c0335b.m2215f());
                } catch (Throwable e) {
                    C0365j.m2476a("Error while verifying chat.", e);
                }
            }
            return verify;
        }
        return false;
    }

    public byte[] m2299a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable e;
        Throwable th;
        byte[] bArr2 = null;
        if (this.f1492c != null) {
            synchronized (this.f1492c) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    int i = 0;
                    while (i < bArr.length) {
                        try {
                            byte[] doFinal = this.f1492c.doFinal(bArr, i, Math.min(214, bArr.length - i));
                            if (doFinal.length > 256) {
                                System.err.println("Length of a chunk exceeded 256!");
                                byteArrayOutputStream.reset();
                                break;
                            }
                            byteArrayOutputStream.write(doFinal.length - 1);
                            byteArrayOutputStream.write(doFinal);
                            i += Math.min(214, bArr.length - i);
                        } catch (IllegalBlockSizeException e2) {
                            e = e2;
                        } catch (IOException e3) {
                            e = e3;
                        } catch (BadPaddingException e4) {
                            e = e4;
                        }
                    }
                    bArr2 = byteArrayOutputStream.toByteArray();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                } catch (IllegalBlockSizeException e6) {
                    e = e6;
                    byteArrayOutputStream = null;
                    try {
                        C0365j.m2476a("Error during encryption.", e);
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e52) {
                                e52.printStackTrace();
                            }
                        }
                        return bArr2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e522) {
                                e522.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e7) {
                    e = e7;
                    byteArrayOutputStream = null;
                    C0365j.m2476a("Error during encryption.", e);
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e5222) {
                            e5222.printStackTrace();
                        }
                    }
                    return bArr2;
                } catch (BadPaddingException e8) {
                    e = e8;
                    byteArrayOutputStream = null;
                    C0365j.m2476a("Error during encryption.", e);
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e52222) {
                            e52222.printStackTrace();
                        }
                    }
                    return bArr2;
                } catch (Throwable e9) {
                    byteArrayOutputStream = null;
                    th = e9;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            }
        }
        return bArr2;
    }

    public boolean m2295a(C0314g c0314g) {
        if (this.f1493d != null) {
            boolean verify;
            synchronized (this.f1493d) {
                try {
                    this.f1493d.update(c0314g.m2052m());
                    this.f1493d.update(c0314g.m2053n());
                    this.f1493d.update(c0314g.m2054o());
                    verify = this.f1493d.verify(c0314g.m2055p());
                } catch (Throwable e) {
                    C0365j.m2476a("Error while verifying chat.", e);
                }
            }
            return verify;
        }
        return false;
    }

    public boolean m2294a(C0289c c0289c) {
        if (this.f1493d != null) {
            boolean verify;
            synchronized (this.f1493d) {
                try {
                    this.f1493d.update(c0289c.m1944f());
                    this.f1493d.update(c0289c.m1945g());
                    verify = this.f1493d.verify(c0289c.m1946h());
                } catch (Throwable e) {
                    C0365j.m2476a("Error while verifying chat.", e);
                }
            }
            return verify;
        }
        return false;
    }

    public boolean m2297a(C0347l c0347l) {
        if (this.f1493d != null) {
            synchronized (this.f1493d) {
                try {
                    this.f1493d.update(c0347l.m2322k());
                    this.f1493d.update(c0347l.m2323l());
                    this.f1493d.update(c0347l.m2325n());
                    for (int i = 0; i < c0347l.m2324m().size(); i++) {
                        this.f1493d.update(((C0334a) c0347l.m2324m().get(i)).m2206j());
                    }
                    if (this.f1493d.verify(c0347l.m2320i())) {
                        Iterator it = c0347l.m2324m().iterator();
                        do {
                            if (!it.hasNext()) {
                                return true;
                            }
                        } while (m2291a((C0334a) it.next()));
                        return false;
                    }
                } catch (Throwable e) {
                    C0365j.m2476a("Error while verifying mail.", e);
                }
            }
        }
        return false;
        return false;
    }

    private boolean m2291a(C0334a c0334a) {
        if (!(this.f1493d == null || c0334a == null || c0334a.m2203g() == null || c0334a.m2204h() == null || c0334a.m2205i() == null || c0334a.m2206j() == null)) {
            try {
                this.f1493d.update(c0334a.m2203g());
                this.f1493d.update(c0334a.m2204h());
                this.f1493d.update(c0334a.m2205i());
                return this.f1493d.verify(c0334a.m2206j());
            } catch (SignatureException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
