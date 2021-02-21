package com.example.imoocmusicdemo.helps;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.IOException;
import java.net.ContentHandler;

public class MediaPlayerHelp {

    private static MediaPlayerHelp instance;

    private Context mContext;
    private MediaPlayer mMediaPlayer;

    // 播放音乐路径
    private String mPath;
    private OnMediaPlayerHelperListener onMediaPlayerHelperListener;

    public void setOnMediaPlayerHelperListener(OnMediaPlayerHelperListener onMediaPlayerHelperListener) {
        this.onMediaPlayerHelperListener = onMediaPlayerHelperListener;
    }

    public static MediaPlayerHelp getInstance(Context context) {

        //空->同步  还是空->new
        if (instance == null) {
            synchronized (MediaPlayerHelp.class) {
                if(instance == null) {
                    instance = new MediaPlayerHelp(context);
                }
            }
        }

        return instance;
    }

    //构造方法
    private MediaPlayerHelp (Context context) {
        mContext = context;
        mMediaPlayer = new MediaPlayer();
    }

    /**
     * 1、setPath: 当前需要播放的音乐
     * 2、start: 播放音乐
     * 3、pause: 暂停播放
     */


    //当前需要播放的音乐
    public void setPath (String path) {
        /**
         * 1 音乐正在播放，重置音乐播放状态
         * 2 设置播放音乐路径
         * 3 准备播放
         */

        mPath = path;

        //1 音乐正在播放，重置音乐播放状态
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.reset();
        }

        //2 设置播放音乐路径
        try {
            mMediaPlayer.setDataSource(mContext, Uri.parse(path));
        } catch (IOException e) {
            e.printStackTrace();
        }


        //3 准备播放
        mMediaPlayer.prepareAsync();//异步加载
        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                if (onMediaPlayerHelperListener != null) {
                    onMediaPlayerHelperListener.onPrepared(mp);
                }
            }
        });

    }

    //返回正在播放的音乐路径
    public String getPath () {
        return mPath;
    }

    //start: 播放音乐
    public void start () {
        if (mMediaPlayer.isPlaying())
            return;
        mMediaPlayer.start();
    }

    //pause: 暂停播放
    public void pause() {
        mMediaPlayer.pause();
    }


    public interface OnMediaPlayerHelperListener {
        void onPrepared(MediaPlayer mp);
    }
}
