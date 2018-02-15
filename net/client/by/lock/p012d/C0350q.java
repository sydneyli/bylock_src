package net.client.by.lock.p012d;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.spec.RSAKeyGenParameterSpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Iterator;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import net.client.by.lock.p011a.C0289c;
import net.client.by.lock.p013b.C0311c;
import net.client.by.lock.p016f.C0365j;

/* compiled from: MyApp */
public final class C0350q extends C0340f {
    private PrivateKey f1525e;
    private byte[] f1526f;

    public C0350q() {
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
            instance.initialize(new RSAKeyGenParameterSpec(2048, RSAKeyGenParameterSpec.F4), C0351r.m2359i().m2361a());
            KeyPair genKeyPair = instance.genKeyPair();
            this.f1525e = genKeyPair.getPrivate();
            this.a = genKeyPair.getPublic();
            mo329c();
        } catch (Throwable e) {
            C0365j.m2476a("SelfKey", e);
        } catch (Throwable e2) {
            C0365j.m2476a("SelfKey", e2);
        }
        m2350e();
    }

    public C0350q(byte[] bArr, byte[] bArr2) {
        byte[] digest;
        this.f1526f = bArr2;
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(C0351r.m2359i().m2390l().getBytes());
            digest = instance.digest();
            Cipher instance2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance2.init(2, new SecretKeySpec(digest, 0, 16, "AES"), new IvParameterSpec(digest, digest.length - 16, 16));
            digest = instance2.doFinal(bArr2);
        } catch (Throwable e) {
            C0365j.m2476a("Error in decrypting private key", e);
            digest = null;
        } catch (Throwable e2) {
            C0365j.m2476a("Error in decrypting private key", e2);
            digest = null;
        } catch (Throwable e22) {
            C0365j.m2476a("Error in decrypting private key", e22);
            digest = null;
        } catch (Throwable e222) {
            C0365j.m2476a("Error in decrypting private key", e222);
            digest = null;
        } catch (Throwable e2222) {
            C0365j.m2476a("Error in decrypting private key", e2222);
            digest = null;
        } catch (Throwable e22222) {
            C0365j.m2476a("Error in decrypting private key", e22222);
            digest = null;
        }
        if (!(digest == null || this.b == null)) {
            try {
                BigInteger bigInteger = new BigInteger(1, digest);
                BigInteger bigInteger2 = new BigInteger(1, bArr);
                this.a = this.b.generatePublic(new RSAPublicKeySpec(bigInteger2, RSAKeyGenParameterSpec.F4));
                this.f1525e = this.b.generatePrivate(new RSAPrivateKeySpec(bigInteger2, bigInteger));
            } catch (Throwable e222222) {
                C0365j.m2476a("Error in instantiating KeyPair.", e222222);
            }
        }
        m2350e();
    }

    private void m2350e() {
        if (this.f1525e != null) {
            if (this.d != null) {
                synchronized (this.d) {
                    try {
                        this.d.initSign(this.f1525e);
                    } catch (Throwable e) {
                        C0365j.m2476a("Error while initializing signature state.", e);
                    }
                }
            }
            if (this.c != null) {
                synchronized (this.c) {
                    try {
                        this.c.init(2, this.f1525e);
                    } catch (Throwable e2) {
                        C0365j.m2476a("Error while initializing cipher state.", e2);
                    }
                }
            }
        }
    }

    public void mo329c() {
        if (this.f1525e != null && C0351r.m2359i().m2390l() != null && this.b != null) {
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA-256");
                instance.update(C0351r.m2359i().m2390l().getBytes());
                byte[] digest = instance.digest();
                Cipher instance2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
                instance2.init(1, new SecretKeySpec(digest, 0, 16, "AES"), new IvParameterSpec(digest, digest.length - 16, 16));
                this.f1526f = instance2.doFinal(((RSAPrivateKeySpec) this.b.getKeySpec(this.f1525e, RSAPrivateKeySpec.class)).getPrivateExponent().toByteArray());
            } catch (Throwable e) {
                C0365j.m2476a("Error in encrypting private key", e);
            } catch (Throwable e2) {
                C0365j.m2476a("Error in encrypting private key", e2);
            } catch (Throwable e22) {
                C0365j.m2476a("Error in encrypting private key", e22);
            } catch (Throwable e222) {
                C0365j.m2476a("Error in encrypting private key", e222);
            } catch (Throwable e2222) {
                C0365j.m2476a("Error in encrypting private key", e2222);
            } catch (Throwable e22222) {
                C0365j.m2476a("Error in encrypting private key", e22222);
            } catch (Throwable e222222) {
                C0365j.m2476a("Error in encrypting private key", e222222);
            }
        }
    }

    public byte[] mo330d() {
        return this.f1526f;
    }

    public byte[] m2355b(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable e;
        Throwable th;
        byte[] bArr2 = null;
        if (this.c != null) {
            synchronized (this.c) {
                try {
                    byteArrayInputStream = new ByteArrayInputStream(bArr);
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr3 = new byte[256];
                            for (int read = byteArrayInputStream.read() + 1; read > 0; read = byteArrayInputStream.read() + 1) {
                                if (byteArrayInputStream.read(bArr3, 0, read) < read) {
                                    byteArrayOutputStream.reset();
                                    break;
                                }
                                byteArrayOutputStream.write(this.c.doFinal(bArr3, 0, read));
                            }
                            bArr2 = byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayInputStream.close();
                                byteArrayOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        } catch (IllegalBlockSizeException e3) {
                            e = e3;
                        } catch (BadPaddingException e4) {
                            e = e4;
                        } catch (IOException e5) {
                            e = e5;
                        }
                    } catch (IllegalBlockSizeException e6) {
                        e = e6;
                        byteArrayOutputStream = null;
                        try {
                            C0365j.m2476a("Error during decryption.", e);
                            try {
                                byteArrayInputStream.close();
                                byteArrayOutputStream.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                            return bArr2;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                byteArrayInputStream.close();
                                byteArrayOutputStream.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (BadPaddingException e7) {
                        e = e7;
                        byteArrayOutputStream = null;
                        C0365j.m2476a("Error during decryption.", e);
                        try {
                            byteArrayInputStream.close();
                            byteArrayOutputStream.close();
                        } catch (IOException e2222) {
                            e2222.printStackTrace();
                        }
                        return bArr2;
                    } catch (IOException e8) {
                        e = e8;
                        byteArrayOutputStream = null;
                        C0365j.m2476a("Error during decryption.", e);
                        try {
                            byteArrayInputStream.close();
                            byteArrayOutputStream.close();
                        } catch (IOException e22222) {
                            e22222.printStackTrace();
                        }
                        return bArr2;
                    } catch (Throwable e9) {
                        byteArrayOutputStream = null;
                        th = e9;
                        byteArrayInputStream.close();
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } catch (IllegalBlockSizeException e10) {
                    e9 = e10;
                    byteArrayOutputStream = null;
                    byteArrayInputStream = null;
                    C0365j.m2476a("Error during decryption.", e9);
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    return bArr2;
                } catch (BadPaddingException e11) {
                    e9 = e11;
                    byteArrayOutputStream = null;
                    byteArrayInputStream = null;
                    C0365j.m2476a("Error during decryption.", e9);
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    return bArr2;
                } catch (IOException e12) {
                    e9 = e12;
                    byteArrayOutputStream = null;
                    byteArrayInputStream = null;
                    C0365j.m2476a("Error during decryption.", e9);
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    return bArr2;
                } catch (Throwable e92) {
                    byteArrayOutputStream = null;
                    byteArrayInputStream = null;
                    th = e92;
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    throw th;
                }
            }
        }
        return bArr2;
    }

    public boolean m2354b(C0335b c0335b) {
        if (!(this.d == null || c0335b == null || c0335b.m2214e() == null)) {
            synchronized (this.d) {
                try {
                    this.d.update(c0335b.m2214e());
                    c0335b.m2210a(this.d.sign());
                } catch (Throwable e) {
                    C0365j.m2476a("Error while signing chat.", e);
                }
            }
            return true;
        }
        return false;
    }

    public boolean m2351a(C0311c c0311c) {
        if (!(this.d == null || c0311c == null || c0311c.m2017a() == null || c0311c.m2019b() == null || c0311c.m2021c() == null)) {
            synchronized (this.d) {
                try {
                    this.d.update(c0311c.m2017a());
                    this.d.update(c0311c.m2019b());
                    this.d.update(c0311c.m2021c());
                    c0311c.m2022d(this.d.sign());
                } catch (Throwable e) {
                    C0365j.m2476a("Error in signing file recipient.", e);
                }
            }
            return true;
        }
        return false;
    }

    public boolean m2353b(C0289c c0289c) {
        if (!(this.d == null || c0289c == null || c0289c.m1944f() == null || c0289c.m1945g() == null)) {
            synchronized (this.d) {
                try {
                    this.d.update(c0289c.m1944f());
                    this.d.update(c0289c.m1945g());
                    c0289c.m1940b(this.d.sign());
                } catch (Throwable e) {
                    C0365j.m2476a("Error in signing file recipient.", e);
                }
            }
            return true;
        }
        return false;
    }

    public boolean m2352a(C0348n c0348n) {
        if (c0348n.m2340d()) {
            return true;
        }
        Iterator it;
        if (c0348n.m2339c() == null) {
            if (!(this.d == null || c0348n == null || c0348n.m2322k() == null || c0348n.m2323l() == null || c0348n.m2325n() == null)) {
                synchronized (this.d) {
                    it = c0348n.m2324m().iterator();
                    while (it.hasNext()) {
                        try {
                            if (!m2349a((C0334a) it.next())) {
                                c0348n.m2338b(false);
                                return false;
                            }
                        } catch (Throwable e) {
                            C0365j.m2476a("Error in signing mail.", e);
                        }
                    }
                    this.d.update(c0348n.m2322k());
                    this.d.update(c0348n.m2323l());
                    this.d.update(c0348n.m2325n());
                    for (int i = 0; i < c0348n.m2324m().size(); i++) {
                        this.d.update(((C0334a) c0348n.m2324m().get(i)).m2206j());
                    }
                    c0348n.m2316a(this.d.sign());
                    c0348n.m2338b(true);
                    return true;
                }
            }
            return false;
        }
        it = c0348n.m2339c().iterator();
        while (it.hasNext()) {
            if (!m2352a((C0348n) it.next())) {
                return false;
            }
        }
        c0348n.m2338b(true);
        return true;
    }

    private boolean m2349a(C0334a c0334a) {
        if (!(this.d == null || c0334a == null || c0334a.m2203g() == null || c0334a.m2204h() == null || c0334a.m2205i() == null)) {
            synchronized (this.d) {
                try {
                    this.d.update(c0334a.m2203g());
                    this.d.update(c0334a.m2204h());
                    this.d.update(c0334a.m2205i());
                    c0334a.m2196a(this.d.sign());
                } catch (SignatureException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }
        return false;
    }
}
