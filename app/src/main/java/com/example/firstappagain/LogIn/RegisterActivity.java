package com.example.firstappagain.LogIn;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstappagain.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "RegisterActivity";

    EditText editTextEnteredUserName, editTextEnteredEMail,editTextReEnteredPassWord;
    ProgressBar progressBarRegin;
    TextView textViewPleaseWait;
    LinearLayout linearLayoutContent;
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        editTextEnteredUserName = findViewById(R.id.idUserNameReg);
        editTextEnteredEMail = findViewById(R.id.idEmailReg);
        editTextReEnteredPassWord = findViewById(R.id.idPasswordReg);
        linearLayoutContent = findViewById(R.id.linearContent);
        textViewPleaseWait = findViewById(R.id.plsWaitTVid);
        progressBarRegin = findViewById(R.id.progressparRegId);

        btnRegister=findViewById(R.id.btnRegister);
        setupWidgetsComponent();
        setupFireBase();
        init();
    }

    private void init() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = editTextEnteredEMail.getText().toString().trim();
                password = editTextReEnteredPassWord.getText().toString().trim();
                username = editTextEnteredUserName.getText().toString().trim();
                progressBarRegin.setVisibility(View.VISIBLE);
                textViewPleaseWait.setVisibility(View.VISIBLE);
                linearLayoutContent.setVisibility(View.GONE);
                if(TextUtils.isEmpty(username)||TextUtils.isEmpty(password)||TextUtils.isEmpty(email)){
                    Toast.makeText(RegisterActivity.this, "error entered", Toast.LENGTH_SHORT).show();
                    progressBarRegin.setVisibility(View.GONE);
                    textViewPleaseWait.setVisibility(View.GONE);
                    linearLayoutContent.setVisibility(View.VISIBLE);
                }else {
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete( Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "createUserWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Toast.makeText(RegisterActivity.this, "Authentication succes."+user,
                                                Toast.LENGTH_SHORT).show();
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();

                                    }

                                    // ...
                                }
                            });
                }
            }
        });

    }

    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    FirebaseAuth.AuthStateListener listener;
    String email,password,username;
    private void setupFireBase() {

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        listener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged( FirebaseAuth firebaseAuth) {

            }
        };

    }

    private void setupWidgetsComponent() {
        progressBarRegin.setVisibility(View.GONE);
        textViewPleaseWait.setVisibility(View.GONE);
        linearLayoutContent.setVisibility(View.VISIBLE);
    }
}
