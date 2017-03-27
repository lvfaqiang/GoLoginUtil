package com.lvfq.gologintest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * IntentUtil
 *
 * @author lvfq
 * @date 2017/3/27 下午12:39
 * @mainFunction :
 */

public class IntentUtil {

    public static boolean isLogin;  // 模拟获取当前用户登录状态。

    /**
     * 需要登录判断
     *
     * @param activity
     * @param clazz
     * @param bundle
     */
    public static void startToLogin(Activity activity, Class clazz, Bundle bundle) {
        Intent intent = new Intent(activity, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (isLogin) {
            activity.startActivity(intent);
        } else {
            GoLoginUtil.startActivity(activity, intent);
        }
    }

    /**
     * 登录成功会有回调
     * requestCode = Contants.CODE_LOGIN
     *
     * @param activity
     * @param bundle
     */
    public static void startToLoginResult(Activity activity, Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        GoLoginUtil.startActivityForResult(activity, intent);
    }
}
