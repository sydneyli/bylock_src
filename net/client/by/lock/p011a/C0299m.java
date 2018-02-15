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
public class C0299m extends AsyncTask {
    DatagramSocket f1290a;
    C0305s f1291b;
    SecretKeySpec f1292c;
    IvParameterSpec f1293d;
    byte[] f1294e;
    public C0300n f1295f;
    Speex f1296g;
    int f1297h;
    C0293g f1298i;
    MessageDigest f1299j = null;
    Cipher f1300k = null;

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m1984a((Void[]) objArr);
    }

    public C0299m(DatagramSocket datagramSocket, C0305s c0305s, SecretKeySpec secretKeySpec, IvParameterSpec ivParameterSpec, byte[] bArr) {
        this.f1290a = datagramSocket;
        this.f1291b = c0305s;
        this.f1292c = secretKeySpec;
        this.f1293d = ivParameterSpec;
        this.f1294e = bArr;
        this.f1296g = new Speex(true);
        this.f1298i = new C0293g(this.f1296g);
        this.f1297h = 332;
        try {
            this.f1299j = MessageDigest.getInstance("MD5");
            this.f1300k = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f1300k.init(2, secretKeySpec, ivParameterSpec);
        } catch (Throwable e) {
            C0365j.m2476a("Error in reciever of sender thread.", e);
        } catch (Throwable e2) {
            C0365j.m2476a("Error in reciever of sender thread.", e2);
        } catch (Throwable e22) {
            C0365j.m2476a("Error in reciever of sender thread.", e22);
        } catch (Throwable e222) {
            C0365j.m2476a("Error in reciever of sender thread.", e222);
        }
        this.f1295f = new C0300n(this);
    }

    public void m1985a() {
        C0322b.m2076e("RecieverThread", "start");
        if (VERSION.SDK_INT >= 11) {
            m1983c();
        } else {
            m1982b();
        }
    }

    private void m1982b() {
        super.execute(new Void[0]);
    }

    @TargetApi(11)
    private void m1983c() {
        executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    protected Void m1984a(Void... voidArr) {
        while (!C0324b.f1410a.get()) {
            DatagramPacket datagramPacket = new DatagramPacket(new byte[this.f1297h], this.f1297h);
            try {
                this.f1290a.receive(datagramPacket);
                this.f1299j.update(this.f1294e);
                this.f1299j.update(datagramPacket.getData(), datagramPacket.getOffset(), 8);
                if (C0365j.m2479a(this.f1299j.digest(), 0, datagramPacket.getData(), (datagramPacket.getOffset() + datagramPacket.getLength()) - 8, 8)) {
                    try {
                        byte[] doFinal = this.f1300k.doFinal(datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength() - 8);
                        this.f1298i.m1971a(new C0292f(doFinal, doFinal.length));
                    } catch (Throwable e) {
                        C0322b.m2076e("ReceiverThreadV2", "IllegalBlockSizeException");
                        C0365j.m2476a("ReceiverThreadV2 Error in decrypting audio.", e);
                        break;
                    } catch (Throwable e2) {
                        C0322b.m2076e("ReceiverThreadV2", "BadPaddingException");
                        C0365j.m2476a("ReceiverThreadV2 Error in decrypting audio.", e2);
                    }
                } else {
                    C0365j.m2476a("Possibly spoofed packet.", new StreamCorruptedException());
                }
            } catch (Throwable e22) {
                C0322b.m2076e("ReceiverThreadV2", "Possible isPaused: " + C0324b.f1410a.get());
                if (C0324b.f1410a.get()) {
                    break;
                }
                C0365j.m2476a("ReceiverThreadV2", e22);
                if (e22 instanceof SocketException) {
                    break;
                }
            }
        }
        this.f1291b.m1996b();
        try {
            this.f1295f.interrupt();
            this.f1295f.join();
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
        return null;
    }
}
