package com.tf.my.heart;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tf.my.R;

public class HeartActivity extends AppCompatActivity {

    private PeriscopeLayout heart;
    private TextView member_send_good;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart);
        initView();
        initEvent();
    }

    private void initEvent() {
        member_send_good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                heart.addFavor();
            }
        });
    }

    private void initView() {
        heart = (PeriscopeLayout) findViewById(R.id.heart_layout);
        member_send_good = (TextView) findViewById(R.id.member_send_good);
    }
}