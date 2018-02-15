package net.client.by.lock.task;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import net.client.by.lock.p012d.C0351r;
import net.client.by.lock.p013b.C0310b;
import net.client.by.lock.p013b.C0314g;
import net.client.by.lock.p013b.C0318j;
import net.client.by.lock.p013b.C0321n;
import net.client.by.lock.p015e.C0354c;
import net.client.by.lock.p016f.C0360e;
import net.client.by.lock.p016f.C0365j;
import net.client.by.lock.p016f.C0371p;
import org.apache.http.entity.BasicHttpEntity;
import org.w3c.dom.Document;

/* compiled from: MyApp */
public class ReceiveFileTask extends FileTask {
    C0314g fileTransfer;

    public ReceiveFileTask(Context context, Object obj) {
        super(context, obj);
        this.fileTransfer = (C0314g) obj;
    }

    protected String getUrl() {
        return C0371p.m2517l();
    }

    protected Document getRequest() {
        return C0354c.m2411a(this.fileTransfer.mo322b());
    }

    protected Document call() {
        OutputStream outputStream;
        Throwable e;
        InputStream inputStream;
        C0321n c0321n = new C0321n();
        HttpsURLConnection a;
        try {
            Document request = getRequest();
            a = C0360e.m2462a(getUrl(), this.ctx);
            try {
                outputStream = a.getOutputStream();
            } catch (Exception e2) {
                e = e2;
                inputStream = null;
                outputStream = null;
                try {
                    if (isCancelled()) {
                        if (this.ftis != null) {
                            this.ftis.close();
                        }
                        if (c0321n != null) {
                            c0321n.close();
                        }
                        if (a != null) {
                            a.disconnect();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        return null;
                    }
                    C0365j.m2476a("Error in sending file", e);
                    if (this.ftis != null) {
                        this.ftis.close();
                    }
                    if (c0321n != null) {
                        c0321n.close();
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (this.ftis != null) {
                        this.ftis.close();
                    }
                    if (c0321n != null) {
                        c0321n.close();
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                inputStream = null;
                outputStream = null;
                if (this.ftis != null) {
                    this.ftis.close();
                }
                if (c0321n != null) {
                    c0321n.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw e;
            }
            try {
                this.ftis = new C0310b(this.fileTransfer);
                this.ftis.m2008a().m2066a((C0318j) this);
                if (C0365j.m2478a(request, outputStream, null)) {
                    BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
                    inputStream = a.getInputStream();
                    try {
                        basicHttpEntity.setContent(inputStream);
                        this.ftis.m2009a(a.getContentLength());
                        request = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
                        Result dOMResult = new DOMResult(request);
                        initProgress();
                        this.ftis.mo320a(inputStream);
                        TransformerFactory.newInstance().newTransformer().transform(new StreamSource(this.ftis), dOMResult);
                        finalizeProgress();
                        a.disconnect();
                        if (this.ftis != null) {
                            this.ftis.close();
                        }
                        if (c0321n != null) {
                            c0321n.close();
                        }
                        if (a != null) {
                            a.disconnect();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream == null) {
                            return request;
                        }
                        inputStream.close();
                        return request;
                    } catch (Exception e3) {
                        e = e3;
                        if (isCancelled()) {
                            if (this.ftis != null) {
                                this.ftis.close();
                            }
                            if (c0321n != null) {
                                c0321n.close();
                            }
                            if (a != null) {
                                a.disconnect();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return null;
                        }
                        C0365j.m2476a("Error in sending file", e);
                        if (this.ftis != null) {
                            this.ftis.close();
                        }
                        if (c0321n != null) {
                            c0321n.close();
                        }
                        if (a != null) {
                            a.disconnect();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        return null;
                    }
                }
                throw new IOException("No http response.");
            } catch (Exception e4) {
                e = e4;
                inputStream = null;
                if (isCancelled()) {
                    C0365j.m2476a("Error in sending file", e);
                    if (this.ftis != null) {
                        this.ftis.close();
                    }
                    if (c0321n != null) {
                        c0321n.close();
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return null;
                }
                if (this.ftis != null) {
                    this.ftis.close();
                }
                if (c0321n != null) {
                    c0321n.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return null;
            } catch (Throwable th3) {
                e = th3;
                inputStream = null;
                if (this.ftis != null) {
                    this.ftis.close();
                }
                if (c0321n != null) {
                    c0321n.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw e;
            }
        } catch (Exception e5) {
            e = e5;
            inputStream = null;
            outputStream = null;
            a = null;
            if (isCancelled()) {
                if (this.ftis != null) {
                    this.ftis.close();
                }
                if (c0321n != null) {
                    c0321n.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return null;
            }
            C0365j.m2476a("Error in sending file", e);
            if (this.ftis != null) {
                this.ftis.close();
            }
            if (c0321n != null) {
                c0321n.close();
            }
            if (a != null) {
                a.disconnect();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return null;
        } catch (Throwable th4) {
            e = th4;
            inputStream = null;
            outputStream = null;
            a = null;
            if (this.ftis != null) {
                this.ftis.close();
            }
            if (c0321n != null) {
                c0321n.close();
            }
            if (a != null) {
                a.disconnect();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw e;
        }
    }

    protected Object[] onSuccess(Document document) {
        if (this.fileTransfer != null) {
            this.fileTransfer.m2039g();
            if (this.fileTransfer.m2041i() != null) {
                C0351r.m2359i().m2371b(this.fileTransfer.m2041i());
            }
        }
        return new Object[]{"onSuccess", document};
    }

    protected Object[] onException(Throwable th) {
        this.fileTransfer.m2029a(th);
        return new Object[]{"onException", th};
    }

    protected void restart() {
    }
}
