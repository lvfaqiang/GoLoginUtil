package com.lvfq.gologintest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

/**
 * LoginSuccessActivity
 *
 * @author lvfq
 * @date 2017/3/27 下午12:43
 * @mainFunction :
 */

public class LoginSuccessActivity extends FragmentActivity {

    private TextView tv_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_suc);
        String content = getIntent().getStringExtra("content");
        tv_content = (TextView) findViewById(R.id.tv_content);
        tv_content.setText(content);
    }
}
