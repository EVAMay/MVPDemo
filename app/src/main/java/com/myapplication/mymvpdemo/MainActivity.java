package com.myapplication.mymvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.myapplication.mymvpdemo.mode.UserInfo;
import com.myapplication.mymvpdemo.present.MainPresent;
import com.myapplication.mymvpdemo.view.IMainView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, IMainView {

    private EditText user_name_edit,user_password_edit;
    private Button login_btn;
    private MainPresent mainPresent;
    private UserInfo userInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mainPresent=new MainPresent(this);
        login_btn.setOnClickListener(this);
    }

    private void initView() {
        user_name_edit= (EditText) findViewById(R.id.user_name_edit);
        user_password_edit= (EditText) findViewById(R.id.user_password_edit);
        login_btn= (Button) findViewById(R.id.login_btn);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn:
                String userName=user_name_edit.getText().toString();
                String userPassword=user_password_edit.getText().toString();
                mainPresent.onLogin(userName,userPassword);
                break;
        }
    }

    @Override
    public void onLoginSuccess(String userName,String userPassword) {
        userInfo=new UserInfo(userName,userPassword);
        Toast.makeText(getBaseContext(),"登录成功,欢迎"+userInfo.getUserName(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFail(String str) {
        Toast.makeText(getBaseContext(),str,Toast.LENGTH_SHORT).show();
    }
}
