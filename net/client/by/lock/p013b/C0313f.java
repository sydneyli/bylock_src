package net.client.by.lock.p013b;

import java.io.FileInputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Iterator;
import javax.crypto.Cipher;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import net.client.by.lock.p015e.C0353b;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p016f.C0365j;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/* compiled from: MyApp */
public class C0313f extends C0309e {
    Document f1370a = C0354c.m2433d();
    byte[] f1371b;
    int f1372c;
    int f1373d;
    int f1374e;
    byte[] f1375f;
    int f1376l;
    byte[] f1377m;
    int f1378n;
    int f1379o = 0;
    Cipher f1380p;
    private boolean f1381q;

    public C0313f(C0315h c0315h) {
        boolean z = true;
        if (c0315h.mo322b() == null) {
            z = false;
        }
        this.f1381q = z;
        Node createElement;
        if (!this.f1381q) {
            this.j = new FileInputStream(c0315h.m2042j());
            this.i = false;
            try {
                this.f1380p = Cipher.getInstance("AES/CBC/PKCS5Padding");
                this.f1380p.init(1, c0315h.mo323c(), c0315h.mo324d());
                this.f1377m = new byte[12352];
                this.f1378n = 0;
            } catch (Throwable e) {
                C0365j.m2476a("Error in initializing FileUploadStream.", e);
                this.f1380p = null;
            } catch (Throwable e2) {
                C0365j.m2476a("Error in initializing FileUploadStream.", e2);
                this.f1380p = null;
            } catch (Throwable e22) {
                C0365j.m2476a("Error in initializing FileUploadStream.", e22);
                this.f1380p = null;
            } catch (Throwable e222) {
                C0365j.m2476a("Error in initializing FileUploadStream.", e222);
                this.f1380p = null;
            }
            createElement = this.f1370a.createElement("fileContent");
            createElement.setTextContent("MY SPECIAL STRING");
            this.f1370a.getDocumentElement().appendChild(createElement);
            this.f1373d = ((int) Math.ceil(((double) ((int) ((c0315h.m2042j().length() + 16) - (c0315h.m2042j().length() % 16)))) / 3.0d)) * 4;
            this.f1376l = 0;
            this.f1375f = null;
        } else if (c0315h.m2060l() == null) {
            throw new IllegalArgumentException("No recipient and no file content!");
        } else if (c0315h.m2060l().isEmpty()) {
            throw new IllegalArgumentException("No recipient and no file content!");
        } else {
            createElement = this.f1370a.createElement("fileId");
            createElement.setTextContent(c0315h.mo322b());
            this.f1370a.getDocumentElement().appendChild(createElement);
        }
        Iterator it = c0315h.m2060l().iterator();
        while (it.hasNext()) {
            C0311c c0311c = (C0311c) it.next();
            Node createElement2 = this.f1370a.createElement("recipient");
            Node createElement3 = this.f1370a.createElement("userId");
            createElement3.setTextContent(c0311c.m2024e());
            Node createElement4 = this.f1370a.createElement("filename");
            createElement4.setTextContent(C0353b.m2405a(c0311c.m2017a()));
            Node createElement5 = this.f1370a.createElement("key");
            createElement5.setTextContent(C0353b.m2405a(c0311c.m2019b()));
            Node createElement6 = this.f1370a.createElement("iv");
            createElement6.setTextContent(C0353b.m2405a(c0311c.m2021c()));
            Node createElement7 = this.f1370a.createElement("signature");
            createElement7.setTextContent(C0353b.m2405a(c0311c.m2023d()));
            createElement2.appendChild(createElement3);
            createElement2.appendChild(createElement4);
            createElement2.appendChild(createElement5);
            createElement2.appendChild(createElement6);
            createElement2.appendChild(createElement7);
            this.f1370a.getDocumentElement().appendChild(createElement2);
        }
        Writer stringWriter = new StringWriter();
        try {
            TransformerFactory.newInstance().newTransformer().transform(new DOMSource(this.f1370a), new StreamResult(stringWriter));
            try {
                this.f1371b = stringWriter.toString().getBytes("UTF-8");
            } catch (Throwable e2222) {
                C0365j.m2476a("", e2222);
            }
            if (this.f1381q) {
                m2009a(this.f1371b.length);
            } else {
                this.f1372c = C0365j.m2471a(this.f1371b, "<fileContent>MY SPECIAL STRING</fileContent>".getBytes()) + 13;
                m2009a((this.f1371b.length - "MY SPECIAL STRING".length()) + this.f1373d);
            }
            this.f1374e = 0;
        } catch (Throwable e22222) {
            this.f1371b = new byte[0];
            this.f1372c = 0;
            this.k = 0;
            this.f1374e = 0;
            C0365j.m2476a("Error in creating xml for sending file", e22222);
        }
    }

    public int read() {
        if (this.g) {
            return -1;
        }
        int c = m2045c();
        if (c != -1) {
            this.h.m2064a();
        }
        return c;
    }

    public int m2045c() {
        int i = -1;
        if (!this.g) {
            if (this.f1374e >= this.k) {
                this.g = true;
            } else {
                if (this.f1381q) {
                    i = this.f1371b[this.f1374e];
                } else if (this.f1374e < this.f1372c) {
                    i = this.f1371b[this.f1374e];
                } else if (this.f1374e < this.f1372c + this.f1373d) {
                    if (this.f1375f != null && this.f1376l != this.f1375f.length) {
                        i = this.f1375f[this.f1376l];
                        this.f1376l++;
                    } else if (m2044d()) {
                        i = this.f1375f[0];
                        this.f1376l = 1;
                    } else {
                        this.f1374e = this.f1372c + this.f1373d;
                        i = this.f1371b[(this.f1374e - this.f1373d) + "MY SPECIAL STRING".length()];
                    }
                } else if (this.f1374e < this.k) {
                    i = this.f1371b[(this.f1374e - this.f1373d) + "MY SPECIAL STRING".length()];
                }
                this.f1374e++;
            }
        }
        return i;
    }

    private boolean m2044d() {
        int i = 0;
        if (this.i) {
            return false;
        }
        if (this.f1380p == null) {
            m2011b();
            return false;
        }
        byte[] bArr = new byte[12288];
        int read = this.j.read(bArr);
        this.h.m2064a();
        if (read == -1) {
            m2011b();
            try {
                this.f1378n += this.f1380p.doFinal(this.f1377m, this.f1378n);
                this.f1375f = C0353b.m2405a(Arrays.copyOf(this.f1377m, this.f1378n)).getBytes();
                return this.f1375f.length > 0;
            } catch (Throwable e) {
                C0365j.m2476a("Error in encrypting file content for sending file", e);
                return false;
            } catch (Throwable e2) {
                C0365j.m2476a("Error in encrypting file content for sending file", e2);
                return false;
            } catch (Throwable e22) {
                C0365j.m2476a("Error in encrypting file content for sending file", e22);
                return false;
            }
        }
        this.f1379o += read;
        try {
            this.f1378n = this.f1380p.update(bArr, 0, read, this.f1377m, this.f1378n) + this.f1378n;
            int i2 = this.f1378n % 3;
            bArr = Arrays.copyOf(this.f1377m, this.f1378n - i2);
            while (i < i2) {
                this.f1377m[i] = this.f1377m[(this.f1378n - i2) + i];
                i++;
            }
            this.f1378n = i2;
            this.f1375f = C0353b.m2405a(bArr).getBytes();
            if (this.f1375f.length > 0) {
                return true;
            }
            return m2044d();
        } catch (Throwable e222) {
            C0365j.m2476a("Error in encrypting file content for sending file", e222);
            return false;
        }
    }
}
