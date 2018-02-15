package net.client.by.lock.p012d;

import java.util.Collections;
import java.util.Observable;
import java.util.Observer;

/* compiled from: MyApp */
class C0345j implements Observer {
    final /* synthetic */ C0343h f1505a;

    private C0345j(C0343h c0343h) {
        this.f1505a = c0343h;
    }

    public void update(Observable observable, Object obj) {
        Collections.sort(this.f1505a.m2306e(), this.f1505a.f1503e);
    }
}
