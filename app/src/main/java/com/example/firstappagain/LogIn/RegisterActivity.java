package com.example.firstappagain.LogIn;
import  com.example.firstappagain.Uttils.firebaseMethods;
import android.os.Bundle;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "RegisterActivity";
    FirebaseDatabase database;
    DatabaseReference myRef ;

    EditText editTextEnteredUserName, editTextEnteredEMail,editTextReEnteredPassWord;
    ProgressBar progressBarRegin;
    TextView textViewPleaseWait;
    LinearLayout linearLayoutContent;
    Button btnRegister;
    firebaseMethods firebaseMethods;
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
        firebaseMethods=new firebaseMethods(RegisterActivity.this);


        database= FirebaseDatabase.getInstance();

        myRef = database.getReference();

        setupWidgetsComponent();
        setupFireBase();
        init();
    }

    private void init() {
        Log.e(TAG, "init: " );
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
                    Log.e(TAG, "onClick: true" );
                    linearLayoutContent.setVisibility(View.VISIBLE);
                }else {
                    Log.e(TAG, "onClick: false"  );

                    firebaseMethods.RegisterNewUser(username,password,email);
                }
            }
        });

    }

    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    FirebaseAuth.AuthStateListener listener;
    String email,password,username;

    String append;
    private void setupFireBase() {
        Log.e(TAG, "setupFireBase: " );
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();


        listener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged( FirebaseAuth firebaseAuth) {

                if (currentUser != null) {

                    Log.e(TAG, "onAuthStateChanged: signIn "+firebaseAuth.getUid());


                    myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange( DataSnapshot dataSnapshot) {

                            Log.e(TAG, "onDataChange: " );
                            if(firebaseMethods.checkUserNameExist(username,dataSnapshot)){

                                append=myRef.push().getKey().substring(3,10);

                                Log.e(TAG, "onDataChange:  user name already exist "+append+" "   );
                            }
                        }

                        @Override
                        public void onCancelled( DatabaseError databaseError) {


                        }
                    });

                }else {
                    Log.e(TAG, "onAuthStateChanged: signOut" );

                }
            }
        };

    }

    private void setupWidgetsComponent() {
        progressBarRegin.setVisibility(View.GONE);
        textViewPleaseWait.setVisibility(View.GONE);
        linearLayoutContent.setVisibility(View.VISIBLE);
    }
}
