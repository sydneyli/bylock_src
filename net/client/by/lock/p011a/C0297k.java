package net.client.by.lock.p011a;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import java.io.StreamCorruptedException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import net.client.by.lock.C0322b;
import net.client.by.lock.codec.Speex;
import net.client.by.lock.p014c.C0324b;
import net.client.by.lock.p016f.C0365j;

/* compiled from: MyApp */
public class C0297k extends AsyncTask {
    DatagramSocket f1275a;
    C0305s f1276b;
    SecretKeySpec f1277c;
    IvParameterSpec f1278d;
    byte[] f1279e;
    public C0298l f1280f;
    Speex f1281g;
    int f1282h;
    int f1283i;
    int f1284j;
    long f1285k;
    C0295i f1286l;
    MessageDigest f1287m = null;
    Cipher f1288n = null;

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m1980a((Void[]) objArr);
    }

    public C0297k(DatagramSocket datagramSocket, C0305s c0305s, SecretKeySpec secretKeySpec, IvParameterSpec ivParameterSpec, byte[] bArr) {
        this.f1275a = datagramSocket;
        this.f1276b = c0305s;
        this.f1277c = secretKeySpec;
        this.f1278d = ivParameterSpec;
        this.f1279e = bArr;
        this.f1281g = new Speex();
        this.f1282h = 3212;
        this.f1283i = 0;
        this.f1284j = 0;
        this.f1286l = new C0295i();
        try {
            this.f1287m = MessageDigest.getInstance("MD5");
            this.f1288n = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f1288n.init(2, secretKeySpec, ivParameterSpec);
        } catch (Throwable e) {
            C0365j.m2476a("Error in reciever of sender thread.", e);
        } catch (Throwable e2) {
            C0365j.m2476a("Error in reciever of sender thread.", e2);
        } catch (Throwable e22) {
            C0365j.m2476a("Error in reciever of sender thread.", e22);
        } catch (Throwable e222) {
            C0365j.m2476a("Error in reciever of sender thread.", e222);
        }
        this.f1280f = new C0298l(this);
    }

    public void m1981a() {
        C0322b.m2076e("RecieverThread", "start");
        if (VERSION.SDK_INT >= 11) {
            m1979c();
        } else {
            m1978b();
        }
    }

    private void m1978b() {
        super.execute(new Void[0]);
    }

    @TargetApi(11)
    private void m1979c() {
        executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    protected Void m1980a(Void... voidArr) {
        this.f1285k = System.currentTimeMillis();
        while (!C0324b.f1410a.get()) {
            DatagramPacket datagramPacket = new DatagramPacket(new byte[this.f1282h], this.f1282h);
            try {
                this.f1275a.receive(datagramPacket);
                this.f1287m.reset();
                this.f1287m.update(this.f1279e);
                this.f1287m.update(datagramPacket.getData(), datagramPacket.getOffset(), 8);
                if (C0365j.m2479a(this.f1287m.digest(), 0, datagramPacket.getData(), (datagramPacket.getOffset() + datagramPacket.getLength()) - 8, 8)) {
                    this.f1283i++;
                    this.f1284j += datagramPacket.getLength();
                    try {
                        byte[] doFinal = this.f1288n.doFinal(datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength() - 8);
                        short[] sArr = new short[1600];
                        this.f1286l.m1975a(new C0286a(sArr, this.f1281g.decode(doFinal, 0, doFinal.length, sArr, 0)));
                    } catch (Throwable e) {
                        C0322b.m2076e("ReceiverThread", "IllegalBlockSizeException");
                        C0365j.m2476a("ReceiverThread Error in decrypting audio.", e);
                        break;
                    } catch (Throwable e2) {
                        C0322b.m2076e("ReceiverThread", "BadPaddingException");
                        C0365j.m2476a("ReceiverThread Error in decrypting audio.", e2);
                    }
                } else {
                    C0365j.m2476a("Possibly spoofed packet.", new StreamCorruptedException());
                }
            } catch (Throwable e22) {
                C0322b.m2076e("ReceiverThread", "Possible isPaused: " + C0324b.f1410a.get());
                if (C0324b.f1410a.get()) {
                    break;
                }
                C0365j.m2476a("ReceiverThread", e22);
                if (e22 instanceof SocketException) {
                    break;
                }
            }
        }
        double currentTimeMillis = ((double) (System.currentTimeMillis() - this.f1285k)) / 1000.0d;
        System.out.println("RAverage packet size: " + (((double) this.f1284j) / ((double) this.f1283i)));
        System.out.println("RAverage bwd: " + (((double) this.f1284j) / currentTimeMillis));
        System.out.println("RAverage packet count: " + (((double) this.f1283i) / currentTimeMillis));
        this.f1276b.m1996b();
        try {
            this.f1280f.interrupt();
            this.f1280f.join();
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
        this.f1286l.clear();
        return null;
    }
}
