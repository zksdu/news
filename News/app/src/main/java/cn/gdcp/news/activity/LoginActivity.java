package cn.gdcp.news.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.QueryListener;
import cn.gdcp.news.R;

public class LoginActivity extends AppCompatActivity {
    private EditText edtPhone;
    private EditText edtCode;
    private Button btnGetcode;
    private Button btnLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ininViews();
    }

    private void ininViews() {
        edtPhone = (EditText) findViewById(R.id.edt_phone);
        edtCode = (EditText) findViewById(R.id.edt_code);
        btnGetcode = (Button) findViewById(R.id.btn_getcode);
        btnLog = (Button) findViewById(R.id.btn_log);

        final String phone = edtPhone.getText().toString();

        btnGetcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobSMS.requestSMSCode(phone, "bombtest", new QueryListener<Integer>() {
                    @Override
                    public void done(Integer integer, BmobException e) {

                    }
                });
            }
        });

        final String code = edtCode.getText().toString();
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobUser.loginBySMSCode(phone, code, new LogInListener<BmobUser>() {
                    @Override
                    public void done(BmobUser bmobUser, BmobException e) {
                        if(e == null){
                            Log.e("AAA", "log success " +  BmobUser.getCurrentUser().getMobilePhoneNumber());
                        }
                    }
                });
            }
        });
    }


}
