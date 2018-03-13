package com.myapplication.mymvpdemo.view;

/**
 * Created by Administrator on 2018/3/13.
 * 定义接口
 */

public interface IMainView {
    void onLoginSuccess(String userName,String userPassword);//登录成功
    void onLoginFail(String str);//登录失败

}
