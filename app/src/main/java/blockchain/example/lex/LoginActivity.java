package blockchain.example.lex;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rey.material.widget.CheckBox;

import blockchain.example.lex.Model.User;
import blockchain.example.lex.Prevalent.Prevalent;
import io.paperdb.Paper;

public class LoginActivity extends AppCompatActivity  {

    private EditText InputPhoneNumber, InputPassword;
    private Button LoginButton;
    private ProgressDialog loadingBar;

    private String parentDbName = "User";
    private CheckBox chkBoxRememeberMe;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        // Google Sign In
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(getString(R.string.default_web_client_id))
//                .requestEmail()
//                .build();
//
//        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
//        mAuth = FirebaseAuth.getInstance();
//
//
//        // Regular Sign In / Sign Up
//        LoginButton = findViewById(R.id.login_btn);
//        InputPassword = findViewById(R.id.login_password_input);
//        InputPhoneNumber = findViewById(R.id.login_phone_number_input);
//        loadingBar= new ProgressDialog(this);
//
//        chkBoxRememeberMe = findViewById(R.id.remember_me_chkb);
//        Paper.init(this);
//
//
//
//        LoginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//
//                LoginUser();
//            }
//        });
//    }

    ////////////////////////////
    // Regular Sign In Section
    ////////////////////////////

    private void LoginUser()
    {

        String phone = InputPhoneNumber.getText().toString();
        String password = InputPassword.getText().toString();

            if (TextUtils.isEmpty(phone))
        {
            Toast.makeText(this, "Please write your phone number ", Toast.LENGTH_SHORT).show();

        }
        else if (TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Enter your password ", Toast.LENGTH_SHORT).show();

        }
        else
            {
                loadingBar.setTitle("Login Account");
                loadingBar.setMessage("Please wait, while we are checking the credentials");
                loadingBar.setCanceledOnTouchOutside(false);
                loadingBar.show();

                AllowAcceToAccount(phone,password);
            }
    }


    private void AllowAcceToAccount(final String phone, final String password)
    {
        if (chkBoxRememeberMe.isChecked())



        {
            Paper.book().write(Prevalent.UserPhoneKey, phone);
            Paper.book().write(Prevalent.UserPasswordKey, password);

        }



        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
               if (dataSnapshot.child(parentDbName).child(phone).exists())
               {
                   User userData = dataSnapshot.child(parentDbName).child(phone).getValue(User.class);
                   if  (userData != null && userData.getPhone().equals(phone))
                   {
                       if  (userData.getPassword().equals(password))
                       {
                           Toast.makeText(LoginActivity.this, "Logged in Successfully...", Toast.LENGTH_SHORT).show();
                           loadingBar.dismiss();

                           Intent intent = new Intent (LoginActivity.this, HomeActivity.class);

                           startActivity(intent);

                       }
                       else
                       {
                           loadingBar.dismiss();
                           Toast.makeText(LoginActivity.this, "Password is incorrect.", Toast.LENGTH_SHORT).show();
                       }
                   }
               }
               else
                   {
                       Toast.makeText(LoginActivity.this, "Account with this" + phone + "number do not exists.", Toast.LENGTH_SHORT).show();
                       loadingBar.dismiss();
                       Toast.makeText(LoginActivity.this, "you need to create a new Account.", Toast.LENGTH_SHORT).show();
                  }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
