package net.client.by.lock.service;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

/* compiled from: MyApp */
class C0447d implements OnErrorListener {
    private C0447d() {
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        mediaPlayer.reset();
        return true;
    }
}
