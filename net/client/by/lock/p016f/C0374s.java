package net.client.by.lock.p016f;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import net.client.by.lock.C0322b;
import org.apache.http.HttpEntity;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class C0374s {
    public static Document m2547a(HttpEntity httpEntity) {
        Object newDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        TransformerFactory.newInstance().newTransformer().transform(new StreamSource(new InputStreamReader(httpEntity.getContent(), "UTF-8")), new DOMResult(newDocument));
        return newDocument;
    }

    public static void m2548a(String str, Document document) {
        OutputStream c0375t;
        Throwable e;
        try {
            C0322b.m2077i("XmlUtils", new StringBuilder(String.valueOf(str)).append(" printXml start").toString());
            StringBuilder stringBuilder = new StringBuilder();
            c0375t = new C0375t(stringBuilder);
            try {
                TransformerFactory.newInstance().newTransformer().transform(new DOMSource(document), new StreamResult(c0375t));
                String stringBuilder2 = stringBuilder.toString();
                for (String str2 : stringBuilder2.split("\n")) {
                    if (str2.length() > 800) {
                        int i = 0;
                        while (i < stringBuilder2.length()) {
                            C0322b.m2078v("XmlUtils", stringBuilder2.substring(i, i + 800 > stringBuilder2.length() ? stringBuilder2.length() : i + 800));
                            i += 800;
                        }
                    } else {
                        C0322b.m2078v("XmlUtils", str2);
                    }
                }
                C0322b.m2077i("XmlUtils", new StringBuilder(String.valueOf(str)).append(" printXml end").toString());
                if (c0375t != null) {
                    try {
                        c0375t.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (TransformerException e3) {
                e = e3;
            }
        } catch (TransformerException e4) {
            e = e4;
            c0375t = null;
            try {
                C0365j.m2476a("XmlUtils", e);
                if (c0375t != null) {
                    try {
                        c0375t.close();
                    } catch (IOException e22) {
                        e22.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                e = th;
                if (c0375t != null) {
                    try {
                        c0375t.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            c0375t = null;
            if (c0375t != null) {
                c0375t.close();
            }
            throw e;
        }
    }
}
