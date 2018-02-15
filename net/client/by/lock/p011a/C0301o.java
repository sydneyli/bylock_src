package net.client.by.lock.p011a;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
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
public class C0301o extends AsyncTask {
    DatagramSocket f1302a;
    C0306t f1303b;
    SecretKeySpec f1304c;
    IvParameterSpec f1305d;
    byte[] f1306e;
    byte[] f1307f;
    final int f1308g = 1600;
    long f1309h;
    int f1310i;
    int f1311j;
    Speex f1312k;
    byte[] f1313l;
    byte[] f1314m;
    ArrayBlockingQueue f1315n;
    public C0302p f1316o;
    MessageDigest f1317p = null;
    Cipher f1318q = null;
    C0296j f1319r = null;

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m1988a((Void[]) objArr);
    }

    public C0301o(DatagramSocket datagramSocket, C0306t c0306t, SecretKeySpec secretKeySpec, IvParameterSpec ivParameterSpec, byte[] bArr, byte[] bArr2) {
        this.f1302a = datagramSocket;
        this.f1303b = c0306t;
        this.f1304c = secretKeySpec;
        this.f1305d = ivParameterSpec;
        this.f1306e = bArr;
        this.f1307f = bArr2;
        this.f1310i = 0;
        this.f1311j = 0;
        this.f1312k = new Speex();
        this.f1313l = new byte[3200];
        this.f1314m = new byte[4];
        this.f1315n = new ArrayBlockingQueue(10, true);
        try {
            this.f1317p = MessageDigest.getInstance("MD5");
            this.f1318q = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f1318q.init(1, secretKeySpec, ivParameterSpec, C0351r.m2359i().m2361a());
            this.f1319r = new C0296j();
        } catch (Throwable e) {
            C0365j.m2476a("Error in startup of sender thread.", e);
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
        } catch (InvalidAlgorithmParameterException e4) {
            e4.printStackTrace();
        }
        this.f1316o = new C0302p(this);
    }

    public void m1989a() {
        C0322b.m2076e("SenderThread", "start");
        if (VERSION.SDK_INT >= 11) {
            m1987c();
        } else {
            m1986b();
        }
    }

    private void m1986b() {
        super.execute(new Void[0]);
    }

    @TargetApi(11)
    private void m1987c() {
        executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    protected Void m1988a(Void... voidArr) {
        this.f1309h = System.currentTimeMillis();
        while (!C0324b.f1410a.get()) {
            C0286a c0286a;
            try {
                C0286a c0286a2 = (C0286a) this.f1315n.poll(200, TimeUnit.MILLISECONDS);
                if (c0286a2 != null) {
                    c0286a = c0286a2;
                    if (c0286a.f1238b != 1600) {
                        C0322b.m2076e("SenderThread", "Unexpected size: " + c0286a.f1238b);
                        if (!this.f1303b.m2002c()) {
                            break;
                        }
                    } else {
                        try {
                            int i;
                            byte[] doFinal = this.f1318q.doFinal(this.f1313l, 0, this.f1312k.encode(c0286a.f1237a, 0, c0286a.f1238b, this.f1313l, 0));
                            C0351r.m2359i().m2361a().nextBytes(this.f1314m);
                            this.f1319r.m1977a(this.f1306e, this.f1314m);
                            this.f1317p.update(this.f1306e);
                            this.f1317p.update(doFinal, 0, 8);
                            byte[] digest = this.f1317p.digest();
                            Object obj = new byte[(((this.f1307f.length + this.f1314m.length) + doFinal.length) + 8)];
                            System.arraycopy(this.f1307f, 0, obj, 0, this.f1307f.length);
                            System.arraycopy(this.f1314m, 0, obj, this.f1307f.length, this.f1314m.length);
                            int length = this.f1314m.length + this.f1307f.length;
                            for (i = 0; i < doFinal.length; i++) {
                                obj[length + i] = (byte) (doFinal[i] ^ this.f1319r.m1976a());
                            }
                            length += doFinal.length;
                            for (i = 0; i < 8; i++) {
                                obj[length + i] = (byte) (digest[i] ^ this.f1319r.m1976a());
                            }
                            try {
                                this.f1302a.send(new DatagramPacket(obj, obj.length, this.f1302a.getInetAddress(), this.f1302a.getPort()));
                                this.f1310i++;
                                this.f1311j += doFinal.length;
                            } catch (Throwable e) {
                                if (C0324b.f1410a.get()) {
                                    break;
                                }
                                C0365j.m2476a("SenderThread", e);
                                if (e instanceof SocketException) {
                                    break;
                                }
                            }
                        } catch (Throwable e2) {
                            C0365j.m2476a("SenderThread Error in encrypting encoded audio.1", e2);
                        } catch (Throwable e22) {
                            C0365j.m2476a("SenderThreadError in encrypting encoded audio.2", e22);
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
        double currentTimeMillis = ((double) (System.currentTimeMillis() - this.f1309h)) / 1000.0d;
        System.out.println("SAverage packet size: " + (((double) this.f1311j) / ((double) this.f1310i)));
        System.out.println("SAverage bwd: " + (((double) this.f1311j) / currentTimeMillis));
        System.out.println("SAverage packet count: " + (((double) this.f1310i) / currentTimeMillis));
        this.f1303b.m2001b();
        try {
            this.f1316o.join();
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
        this.f1315n.clear();
        return null;
    }
}
