package com.mindscape.aayu;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class AppLogin extends AppCompatActivity {
    //login btn
    GoogleSignInClient mGoogleSignInClient;
    //google login
    private static int RC_SIGN_IN=100;
    ImageView loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_login2);

        //getByBtnId
        loginBtn = findViewById(R.id.loginBtn);

        //google sign in - request details
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

      //google client - gso
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        //function to check pre signed in - google
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);





        //run login function
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signIn();

            }
        });
    }



    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //logic - sign in
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
            if (acct != null) {

                //get details from the google account
                //name
                String personName = acct.getDisplayName();

                //person name of the user
                String personGivenName = acct.getGivenName();

                //family name
                String personFamilyName = acct.getFamilyName();

                //email of the user
                String personEmail = acct.getEmail();

                //id of account
                String personId = acct.getId();

                // image of the user
                Uri personPhoto = acct.getPhotoUrl();

                Toast.makeText(this, "Name: "+personFamilyName, Toast.LENGTH_SHORT).show();
                Global.loggedName=personName;


            }

            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);

            //exception
        } catch (ApiException e) {
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            Log.d("Message" , e.toString());
        }

    }
}