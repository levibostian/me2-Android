package co.me2app.me2.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import co.me2app.me2.R;

public class LogInActivity extends FragmentActivity {

    // Fields
    String email = "";
    String password = "";
    EditText passwordField;
    EditText userEmailField;
    Button signUpButton, logInButton;
    ProgressBar loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Reading secret ids for Parse from file
        String applicationId = "";
        String clientKey = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("parse-creds")));
            applicationId = reader.readLine();
            clientKey = reader.readLine();
        }// close try
        catch (Exception e) {
            e.printStackTrace();
        } // close catch

        // Initialize Parse
        Parse.initialize(this, applicationId, clientKey);

        // Reference Views
        userEmailField = (EditText) findViewById(R.id.emailField);
        passwordField = (EditText) findViewById(R.id.passwordField);
        signUpButton = (Button) findViewById(R.id.signUpButton);
        logInButton = (Button) findViewById(R.id.logInButton);
        loading = (ProgressBar) findViewById(R.id.progressBar);
        loading.setVisibility(View.INVISIBLE);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logInButton.setVisibility(View.INVISIBLE);
                signUpButton.setVisibility(View.INVISIBLE);

                if (email.equals("") || password.equals("")) {
                    logInButton.setVisibility(View.VISIBLE);
                    signUpButton.setVisibility(View.VISIBLE);

                    Toast.makeText(LogInActivity.this, "Please complete credentials", Toast.LENGTH_LONG).show();

                    return;
                }

                password = passwordField.getText().toString().trim();
                email = userEmailField.getText().toString().trim();
                Log.d("Tag", email);


                final ParseUser newUser = new ParseUser();
                newUser.setUsername(email);
                newUser.setPassword(password);

                newUser.signUpInBackground(new SignUpCallback() {

                    @Override
                    public void done(ParseException e) {
                        //loading.setVisibility(View.INVISIBLE);
                        ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar);
                        bar.setVisibility(View.VISIBLE);
                        if (e == null) {
                            bar.setVisibility(View.INVISIBLE);
                            Toast.makeText(LogInActivity.this, "To Main", Toast.LENGTH_LONG).show();

//                           Intent toMainActivity = new Intent(LogInActivity.this, MainActivity.class);
//                           startActivity(toMainActivity);
//                           finish();
                        } else {
                            bar.setVisibility(View.INVISIBLE);
                            Log.d("Tag2", newUser.getUsername());
                            Toast.makeText(LogInActivity.this, "whoops", Toast.LENGTH_LONG).show();
                        }
                    } // done(e)
                }); //newUser.signUpInBackground(new SignUpCallback(){})
            } // onClick(v)
        }); // setOnClickListener(new View.OnClickListener())

        // Sets action for user on clicking sign in button
        logInButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                logInButton.setVisibility(View.INVISIBLE);
                signUpButton.setVisibility(View.INVISIBLE);
                // loading.setVisibility(View.INVISIBLE);

                // Get text from views and eliminate whitespace
                password = passwordField.getText().toString().trim();
                email = userEmailField.getText().toString().trim();

                // Create new User
                ParseUser user = new ParseUser();
                user.setUsername(email);
                user.setPassword(password);

                // Check if user creds are empty. Report friendly message
                if (email.equals("") || password.equals("")) {
                    logInButton.setVisibility(View.VISIBLE);
                    signUpButton.setVisibility(View.VISIBLE);
                    Toast.makeText(LogInActivity.this, "Please complete credentials", Toast.LENGTH_LONG).show();
                    return;
                }

                // Sign User in
                ParseUser.logInInBackground(email, password, new LogInCallback() {
                    public void done(ParseUser user, ParseException e) {

                        // Check if user exists
                        if (user != null) {
                            //   loading.setVisibility(View.INVISIBLE);
//                            Intent toMainActivity = new Intent(LogInActivity.this, MainActivity.class);
//                            startActivity(toMainActivity);
//                            finish();
                            Toast.makeText(LogInActivity.this, "Signed In!", Toast.LENGTH_LONG).show();
                        }// closes if
                        else {
                            logInButton.setVisibility(View.VISIBLE);
                            signUpButton.setVisibility(View.VISIBLE);
                            Toast.makeText(LogInActivity.this, "Please check your credentials", Toast.LENGTH_LONG).show();
                        } // closes else

                        //TODO: Check error messages if e generates any errors and fix tests

//                        if (e.getMessage().equals(ParseException.EMAIL_NOT_FOUND)){
//                            Toast.makeText(LogInActivity.this, "E-mail not found. Please use an existing email", Toast.LENGTH_LONG).show();
//                        }
//                        if (e.getMessage().equals(ParseException.INVALID_EMAIL_ADDRESS)){
//                            Toast.makeText(LogInActivity.this, "Invalid Email. Please check and rectify error", Toast.LENGTH_LONG).show();
//                        }
//                        if (e.getMessage().equals(ParseException.EMAIL_MISSING)){
//                            Toast.makeText(LogInActivity.this, "Please complete your credentials", Toast.LENGTH_LONG).show();
//                        }
                    } // done(user, e)
                }); // user.logInInBackground(email, password, new LogInCallBack(){})
            }
        });
    } // onCreate(savedBundleState)

} // LogInActivity