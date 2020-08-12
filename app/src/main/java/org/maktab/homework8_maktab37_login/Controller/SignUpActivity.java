package org.maktab.homework8_maktab37_login.Controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.maktab.homework8_maktab37_login.Model.Account;
import org.maktab.homework8_maktab37_login.R;

public class SignUpActivity extends AppCompatActivity {
    public static final String EXTRA_USERNAME_SIGN_UP = "extraUsername";
    public static final String EXTRA_PASSWORD_SIGN_UP = "EXTRA_password";
    public static final int REQUEST_CODE_LOGIN = 1;
    private Button mBtnSignUp;
    private EditText mEditTextUser, mEditTextPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        findViews();
        mEditTextUser.setText(getIntent().getStringExtra(LoginActivity.EXTRA_USERNAME));
        mEditTextPass.setText(getIntent().getStringExtra(LoginActivity.EXTRA_PASSWORD));
        listener();
    }

    private void listener() {
        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditTextPass.getText().toString().equals("") || mEditTextUser.getText().toString().equals("")) {
                    Toast toast = Toast.makeText(SignUpActivity.this, R.string.toast_sign_up, Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    setUserPassResult();
                    finish();
                }

            }
        });
    }

    private void setUserPassResult() {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_USERNAME_SIGN_UP, mEditTextUser.getText().toString());
        intent.putExtra(EXTRA_PASSWORD_SIGN_UP, mEditTextPass.getText().toString());
        setResult(RESULT_OK,intent);
    }

    private void findViews() {
        mBtnSignUp = findViewById(R.id.btnSignUp_SignUP);
        mEditTextUser = findViewById(R.id.editTextUsernameSignUP);
        mEditTextPass = findViewById(R.id.editTextPasswordSignUp);
    }
}