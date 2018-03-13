package com.myapplication.mymvpdemo.present;

import com.myapplication.mymvpdemo.view.IMainView;

/**
 * Created by Administrator on 2018/3/13.
 * 业务逻辑
 */

public class MainPresent {

    private IMainView iMainView;

    public MainPresent(IMainView iMainView) {
        this.iMainView = iMainView;
    }

    /**
     * 登录逻辑处理
     */
    public void onLogin(String userName,String userPassword){
        if (userName.isEmpty()) {
            iMainView.onLoginFail("用户名不能为空");
            return;
        }
        if (userPassword.isEmpty()) {
            iMainView.onLoginFail("密码不能为空");
            return;
        }
        if (userName.equals("123") & userPassword.equals("123")) {
            iMainView.onLoginSuccess(userName, userPassword);
        } else {
            iMainView.onLoginFail("用户名或密码错误");
        }
    }
}
