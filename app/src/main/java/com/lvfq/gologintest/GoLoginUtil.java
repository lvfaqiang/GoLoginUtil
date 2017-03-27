package com.lvfq.gologintest;

import android.app.Activity;
import android.content.Intent;

/**
 * --------------------------------------------
 * Create By :  Lvfq
 * Date ： 2016/11/17 0017 上午 9:10
 * -------------------------------------------
 * 登录跳转
 **/
public class GoLoginUtil {

    public static final String CLASSNAME = "className";

    public static final int CODE_LOGIN = 1; // 登录成功回调  用于onActivityForResult 判断


    /**
     * 登录成功之后，通过 activityResult 回调到当前界面
     *
     * @param activity
     * @param intent
     * @param requestCode
     */
    private static void startActivity(Activity activity, Intent intent, int requestCode) {
        if (requestCode == -1) {
            String targetClass = intent.getComponent().getClassName();  // 目标类
            intent.putExtra(CLASSNAME, targetClass);
        }
        intent.setClass(activity, LoginActivity.class); // 跳转重定向到登录界面
        activity.startActivityForResult(intent, requestCode);
    }


    /**
     * 登录成功之后，直接跳转目标 Activity
     *
     * @param activity
     * @param intent
     */
    public static void startActivity(Activity activity, Intent intent) {
        startActivity(activity, intent, -1);
    }

    /**
     * 登录成功回调到当前界面
     * 使用 onActivityResult 方法接收， requestCode  = CODE_LOGIN
     *
     * @param activity
     * @param intent
     */
    public static void startActivityForResult(Activity activity, Intent intent) {
        startActivity(activity, intent, CODE_LOGIN);
    }

}
