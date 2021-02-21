package com.example.imoocmusicdemo.activities.music;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.imoocmusicdemo.R;
import com.example.imoocmusicdemo.activities.BaseActivity;
import com.example.imoocmusicdemo.views.PlayMusicView;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class PlayMusicActivity extends BaseActivity {

    private ImageView mIvBg;
    private PlayMusicView mPlayMusicView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        //隐藏statusBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        initView();
    }

    private void initView () {
        mIvBg = fd(R.id.iv_bg);
        //glide-transformations  图片虚化
        Glide.with(this)
                .load("https://pic4.zhimg.com/v2-9cffdce71e3732afcd0eaa8a61765fb6_xl.jpg")
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 10)))
                .into(mIvBg);


        mPlayMusicView = fd(R.id.play_music_view);
        mPlayMusicView.setMusicIcon("https://pic4.zhimg.com/v2-9cffdce71e3732afcd0eaa8a61765fb6_xl.jpg");
        //播放音乐
        mPlayMusicView.playMusic("http://www.0dutv.com/plug/down/up2.php/205127505.mp3");
    }

    /**
     * 后退按钮点击事件
     */
    public void onBackClick(View view) {
        onBackPressed();
    }
}
