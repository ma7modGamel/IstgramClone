package com.example.firstappagain.Uttils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.firstappagain.LogIn.RegisterActivity;
import com.example.firstappagain.Models.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class firebaseMethods {
    private Context mcontext;
    private static final String TAG = "firebaseMethods";

    public firebaseMethods(Context context) {
        mcontext = context;


    }


    public boolean checkUserNameExist(String username, DataSnapshot dataSnapshot) {
        UserModel userModel = new UserModel();
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            Log.e(TAG, "checkUserNameExist: "+dataSnapshot );
            Toast.makeText(mcontext, ""+dataSnapshot, Toast.LENGTH_SHORT).show();
            String name = snapshot.getValue(UserModel.class).getName();
            userModel.setName(name);
            if(userModel.getName().trim().equals(username)){
                return true;
            }
        }

        return false;
    }

FirebaseAuth mAuth;
    public void RegisterNewUser(String username, String password, String email) {
        Log.e(TAG, "RegisterNewUser: "+email+password+username );
        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete( Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(mcontext, "doneCreate", Toast.LENGTH_SHORT).show();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());

                            Toast.makeText(mcontext, "FaildCreat", Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });



    }
}
