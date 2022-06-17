package com.moringaschool.recipo.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.secure.foodycookbook.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = SignupActivity.class.getSimpleName();

    @BindView(R.id.register) Button mRegisterButton;
    @BindView(R.id.register_email) EditText mRegister_email;
    @BindView(R.id.register_password) EditText mRegister_password;
    @BindView(R.id.confirm_password) EditText mConfirm_Password;
    @BindView(R.id.onboard) TextView mOnboard;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();

        mOnboard.setOnClickListener(this);
        mRegisterButton.setOnClickListener(this);
    }

    private void register() {
        final String email = mRegister_email.getText().toString().trim();
        String password = mRegister_password.getText().toString().trim();
        String confirm_password = mConfirm_Password.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "Authentication successful");
                    } else {
                        Toast.makeText(SignupActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onClick(View view) {

        if (view == mOnboard) {
            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        if (view == mRegisterButton) {
            register();
        }

    }

}



//    private FirebaseAuth mAuth;
//    private EditText email, password,confirm_password;
//    private Button register;
//    private TextView textOnboard;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.signup);
//        mAuth = FirebaseAuth.getInstance();
//        email = findViewById(R.id.register_email);
//        password = findViewById(R.id.register_password);
//        confirm_password = findViewById(R.id.confirm_password);
//        register  = findViewById(R.id.register);
//        textOnboard = findViewById(R.id.onboard);
//
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Register();
//            }
//        });
//
//        textOnboard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
//            }
//        });    }
//
//
//    private void Register()
//    {
//        String user = email.getText().toString().trim();
//        String pass = password.getText().toString().trim();
//        if(user.isEmpty())
//        {
//            email.setError("Email can not be empty");
//        }
//        if(pass.isEmpty())
//        {
//            password.setError("Password can not be empty");
//        }
//        else
//        {
//            mAuth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                    if(task.isSuccessful())
//                    {
//                        Toast.makeText(SignupActivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(SignupActivity.this, HomeActivity.class));
//                    }
//                    else
//                    {
//                        Toast.makeText(SignupActivity.this, "Registration Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//        }
//    }
//}

