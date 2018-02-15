package net.client.by.lock.p011a;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import net.client.by.lock.C0322b;
import net.client.by.lock.codec.Speex;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p014c.C0324b;
import net.client.by.lock.p016f.C0365j;

/* compiled from: MyApp */
public class C0303q extends AsyncTask {
    DatagramSocket f1321a;
    C0306t f1322b;
    SecretKeySpec f1323c;
    IvParameterSpec f1324d;
    byte[] f1325e;
    byte[] f1326f;
    final int f1327g = 160;
    Speex f1328h;
    byte[] f1329i;
    byte[] f1330j;
    ArrayBlockingQueue f1331k;
    public C0304r f1332l;
    MessageDigest f1333m = null;
    Cipher f1334n = null;
    C0296j f1335o = null;

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m1992a((Void[]) objArr);
    }

    public C0303q(DatagramSocket datagramSocket, C0306t c0306t, SecretKeySpec secretKeySpec, IvParameterSpec ivParameterSpec, byte[] bArr, byte[] bArr2) {
        this.f1321a = datagramSocket;
        this.f1322b = c0306t;
        this.f1323c = secretKeySpec;
        this.f1324d = ivParameterSpec;
        this.f1325e = bArr;
        this.f1326f = bArr2;
        this.f1328h = new Speex(true);
        this.f1329i = new byte[324];
        this.f1330j = new byte[4];
        this.f1331k = new ArrayBlockingQueue(10, true);
        try {
            this.f1333m = MessageDigest.getInstance("MD5");
            this.f1334n = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f1334n.init(1, secretKeySpec, ivParameterSpec, C0351r.m2359i().m2361a());
            this.f1335o = new C0296j();
        } catch (Throwable e) {
            C0365j.m2476a("Error in startup of sender thread.", e);
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
        } catch (InvalidAlgorithmParameterException e4) {
            e4.printStackTrace();
        }
        this.f1332l = new C0304r(this);
    }

    public void m1993a() {
        C0322b.m2076e("SenderThread", "start");
        if (VERSION.SDK_INT >= 11) {
            m1991c();
        } else {
            m1990b();
        }
    }

    private void m1990b() {
        super.execute(new Void[0]);
    }

    @TargetApi(11)
    private void m1991c() {
        executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    protected Void m1992a(Void... voidArr) {
        int nextInt = 536870912 + C0351r.m2359i().m2361a().nextInt(536870912);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(4);
        int i = nextInt;
        while (!C0324b.f1410a.get()) {
            C0286a c0286a;
            try {
                C0286a c0286a2 = (C0286a) this.f1331k.poll(20, TimeUnit.MILLISECONDS);
                if (c0286a2 != null) {
                    c0286a = c0286a2;
                    if (c0286a.f1238b != 160) {
                        C0322b.m2076e("SenderThreadV2", "Unexpected size: " + c0286a.f1238b);
                        if (!this.f1322b.m2002c()) {
                            break;
                        }
                    } else {
                        allocateDirect.clear();
                        allocateDirect.putInt(i);
                        allocateDirect.rewind();
                        allocateDirect.get(this.f1329i, 0, 4);
                        nextInt = i + 1;
                        try {
                            int i2;
                            byte[] doFinal = this.f1334n.doFinal(this.f1329i, 0, this.f1328h.encode(c0286a.f1237a, 0, c0286a.f1238b, this.f1329i, 4) + 4);
                            C0351r.m2359i().m2361a().nextBytes(this.f1330j);
                            this.f1335o.m1977a(this.f1325e, this.f1330j);
                            this.f1333m.update(this.f1325e);
                            this.f1333m.update(doFinal, 0, 8);
                            byte[] digest = this.f1333m.digest();
                            Object obj = new byte[(((this.f1326f.length + this.f1330j.length) + doFinal.length) + 8)];
                            System.arraycopy(this.f1326f, 0, obj, 0, this.f1326f.length);
                            System.arraycopy(this.f1330j, 0, obj, this.f1326f.length, this.f1330j.length);
                            int length = this.f1330j.length + this.f1326f.length;
                            for (i2 = 0; i2 < doFinal.length; i2++) {
                                obj[length + i2] = (byte) (doFinal[i2] ^ this.f1335o.m1976a());
                            }
                            int length2 = length + doFinal.length;
                            for (i2 = 0; i2 < 8; i2++) {
                                obj[length2 + i2] = (byte) (digest[i2] ^ this.f1335o.m1976a());
                            }
                            try {
                                this.f1321a.send(new DatagramPacket(obj, obj.length, this.f1321a.getInetAddress(), this.f1321a.getPort()));
                                i = nextInt;
                            } catch (Throwable e) {
                                if (!C0324b.f1410a.get()) {
                                    C0365j.m2476a("SenderThreadV2", e);
                                    if (e instanceof SocketException) {
                                        break;
                                    }
                                    i = nextInt;
                                } else {
                                    break;
                                }
                            }
                        } catch (Throwable e2) {
                            C0365j.m2476a("SenderThreadV2 Error in encrypting encoded audio.1", e2);
                        } catch (Throwable e22) {
                            C0365j.m2476a("SenderThreadV2Error in encrypting encoded audio.2", e22);
                        }
                    }
                } else {
                    continue;
                }
            } catch (InterruptedException e3) {
                if (C0324b.f1410a.get()) {
                    break;
                }
                c0286a = null;
            }
        }
        this.f1322b.m2001b();
        try {
            this.f1332l.join();
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
        this.f1331k.clear();
        return null;
    }
}
