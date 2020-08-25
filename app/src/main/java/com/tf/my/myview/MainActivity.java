package com.tf.my.myview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.tf.my.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private PayAnimatorView payView;
    private Button success;
    private Button fail;
    private Button loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        payView = (PayAnimatorView) findViewById(R.id.payView);
        success = (Button) findViewById(R.id.success);
        success.setOnClickListener(this);
        fail = (Button) findViewById(R.id.fail);
        fail.setOnClickListener(this);
        loading = (Button) findViewById(R.id.loading);
        loading.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.success:
                payView.setStatus(2);
                break;
            case R.id.fail:
                payView.setStatus(3);
                break;
            case R.id.loading:
                payView.setStatus(1);
                break;
        }
    }
}