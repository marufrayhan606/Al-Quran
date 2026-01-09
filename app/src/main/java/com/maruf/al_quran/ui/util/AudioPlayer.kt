package com.maruf.al_quran.ui.util

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer

class AudioPlayer(context: Context) {
    private val player = ExoPlayer.Builder(context).build()

    fun playAudio(url: String) {
        if (url.isNotEmpty()) {
            player.stop()
            player.clearMediaItems()

            val mediaItem = MediaItem.fromUri(url)
            player.setMediaItem(mediaItem)
            player.prepare()
            player.play()

        }
    }

    fun stopAudio() {
        player.stop()
    }

    fun releaseAudio() {
        player.release()
    }
}