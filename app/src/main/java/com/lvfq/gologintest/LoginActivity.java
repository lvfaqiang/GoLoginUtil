package com.lvfq.gologintest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;

/**
 * LoginActivity
 *
 * @author lvfq
 * @date 2017/3/27 下午12:35
 * @mainFunction :
 */

public class LoginActivity extends FragmentActivity {

    private String targetClass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        targetClass = getIntent().getStringExtra(GoLoginUtil.CLASSNAME);  // 目标跳转类


    }

    public void onLoginClick(View view) {
        // 模拟登录成功操作
        if (!TextUtils.isEmpty(targetClass)) {
            // 这里就是执行继续跳转操作
            try {
                Class clazz = Class.forName(targetClass);
                getIntent().setClass(this, clazz);
                startActivity(getIntent());
                finish();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            // 这里是登录成功，回调到之前界面 onActivityForResult()中 方法可根据自己需求处理。。
            setResult(RESULT_OK);
            finish();
        }
    }
}
