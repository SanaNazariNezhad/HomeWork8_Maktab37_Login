package org.maktab.homework8_maktab37_login.Controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.maktab.homework8_maktab37_login.Model.Account;
import org.maktab.homework8_maktab37_login.R;

public class LoginActivity extends AppCompatActivity {
    public static final String EXTRA_USERNAME = "extraUsername";
    public static final String EXTRA_PASSWORD = "EXTRA_password";
    private Button mButtonLogin,mButtonSignUp;
    private EditText mEditTextUsername,mEditTextPassword;
    public static final int REQUEST_CODE_SIGN_UP = 0;
    private String user, pass;
    private Account mAccount = new Account();
    private ViewGroup mViewGroupRootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViews();
        listeners();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != Activity.RESULT_OK || data == null)
            return;
        if (requestCode == REQUEST_CODE_SIGN_UP) {
            mEditTextUsername.setText(data.getStringExtra(SignUpActivity.EXTRA_USERNAME_SIGN_UP));
            mEditTextPassword.setText(data.getStringExtra(SignUpActivity.EXTRA_PASSWORD_SIGN_UP));
            user = data.getStringExtra(SignUpActivity.EXTRA_USERNAME_SIGN_UP);
            pass = data.getStringExtra(SignUpActivity.EXTRA_PASSWORD_SIGN_UP);
        }
    }

    private void listeners() {
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditTextPassword.getText().toString().equals("") || mEditTextUsername.getText().toString().equals("")){
                    callToast(R.string.toast_sign_up);
                }
                else if (!mEditTextUsername.getText().toString().equals(user) ||
                        !mEditTextPassword.getText().toString().equals(pass)){
                    callToast(R.string.toast_login);
                }else {
                    Snackbar.make(mViewGroupRootLayout,R.string.login,Snackbar.LENGTH_SHORT).show();
                }

            }
        });
        mButtonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                if (!mEditTextPassword.getText().toString().equals("") && !mEditTextUsername.getText().toString().equals("")) {
                    intent.putExtra(EXTRA_USERNAME,mEditTextUsername.getText().toString());
                    intent.putExtra(EXTRA_PASSWORD,mEditTextPassword.getText().toString());
                }
                startActivityForResult(intent,REQUEST_CODE_SIGN_UP);
            }
        });
    }

    private void callToast(int p) {
        Toast toast = Toast.makeText(LoginActivity.this, p, Toast.LENGTH_SHORT);
        toast.show();
    }

    private void findViews() {
        mButtonLogin = findViewById(R.id.btnLogin_Login);
        mButtonSignUp = findViewById(R.id.btnSignUp_Login);
        mEditTextPassword = findViewById(R.id.editTextPasswordLogin);
        mEditTextUsername = findViewById(R.id.editTextUsernameLogin);
        mViewGroupRootLayout = findViewById(R.id.rootLayout);
    }
}