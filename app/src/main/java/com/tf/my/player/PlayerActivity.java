package com.tf.my.player;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.tf.my.R;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class PlayerActivity extends AppCompatActivity {

    private JzvdStd jzvdStd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        initView();
        initData();
    }

    private void initData() {
        jzvdStd.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4", "一直以为男友家真的很穷，今天来到一看，我承认我太羡慕了！", Jzvd.SCREEN_NORMAL);
        // 播放前页显示图片我简单的设置了一下。
        // 推荐同学们使用Glide加载网络图片或本地图片，Glide优点明显
        jzvdStd.posterImageView.setImageResource(R.mipmap.ic_launcher_round);
    }

    private void initView() {
        jzvdStd = (JzvdStd) findViewById(R.id.jz_video);
    }
    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()){
            return;
        }
        super.onBackPressed();
    }
}