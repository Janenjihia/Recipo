package com.moringaschool.recipo.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.moringaschool.recipo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
   private FirebaseAuth mAuth;
   private EditText email, password;
   private Button login;
   private TextView sign;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.login);
      mAuth = FirebaseAuth.getInstance();
      email = findViewById(R.id.email);
      password = findViewById(R.id.password);
      login  = findViewById(R.id.login);
      sign = findViewById(R.id.sign);

      login.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            login();
         }
      });


      sign.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            startActivity(new Intent(LoginActivity.this, SignupActivity.class));
         }        });    }


   private void login()
   {
      String user = email.getText().toString().trim();
      String pass = password.getText().toString().trim();
      if(user.isEmpty())
      {            email.setError("Email can not be empty");        }
      if(pass.isEmpty())
      {            password.setError("Password can not be empty");        }
      else
      {
         mAuth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
               if(task.isSuccessful())
               {
                  Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                  startActivity(new Intent(LoginActivity.this , SplashscreenActivity.class));
               }
               else
               {
                  Toast.makeText(LoginActivity.this, "Login Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
               }
            }
         });        }    }

   }