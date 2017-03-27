package com.lvfq.gologintest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.lvfq.gologintest.GoLoginUtil.CODE_LOGIN;

public class MainActivity extends AppCompatActivity {

    private TextView tv_text;
    private TextView tv_login_status;
    private EditText et_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv_text = (TextView) findViewById(R.id.tv_text);
        tv_login_status = (TextView) findViewById(R.id.tv_login_status);
        et_content = (EditText) findViewById(R.id.et_content);
    }

    /**
     * 登录跳转
     *
     * @param view
     */
    public void onClick1(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("content", et_content.getText().toString());
        IntentUtil.startToLogin(this, LoginSuccessActivity.class, bundle);
    }

    /**
     * 登录回调
     *
     * @param view
     */
    public void onClick2(View view) {
        if (!IntentUtil.isLogin) {
            IntentUtil.startToLoginResult(this, null);
        } else {
            tv_text.setText("登录成功");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) {
            return;
        }
        if (requestCode == CODE_LOGIN) {
            tv_text.setText("登录成功");
        }
    }


    public void onLogined(View view) {
        IntentUtil.isLogin = !IntentUtil.isLogin;
        tv_text.setText("初始文本");
        if (IntentUtil.isLogin) {
            tv_login_status.setText("已登录");
        } else {
            tv_login_status.setText("未登录");
        }
    }

}
