package co.me2app.me2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getActionBar().hide();

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

        if (ParseUser.getCurrentUser() != null) {
            Intent toMainApp = new Intent(LogInActivity.this, MainActivity.class);
            startActivity(toMainApp);
            finish();

        } else {
            super.onResume();
        }

        // Reference Views
        userEmailField = (EditText) findViewById(R.id.emailField);
        passwordField = (EditText) findViewById(R.id.passwordField);
        signUpButton = (Button) findViewById(R.id.signUpButton);
        logInButton = (Button) findViewById(R.id.logInButton);


        signUpButton.setOnClickListener(new View.OnClickListener() {
            // Email Validator
            public final boolean isValidEmail(CharSequence target) {
                if (target == null) {
                    return false;
                } else {
                    return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
                }
            }

            @Override
            public void onClick(View v) {
                // eliminate whitespace and store details
                password = passwordField.getText().toString().trim();
                email = userEmailField.getText().toString().trim();
                Log.d("Tag", email);


                // Check for empty fields
                if (email.equals("") || password.equals("")) {
                    Toast.makeText(LogInActivity.this, "Please fill in all credentials", Toast.LENGTH_LONG).show();
                    return;
                } // ends if


                // Use user details to create a new Parse User
                ParseUser newUser = new ParseUser();
                newUser.setUsername(email);
                newUser.setPassword(password);


                // Test for input values
                Log.d("Username", newUser.getUsername());

                // Sign Up user in the background
                newUser.signUpInBackground(new SignUpCallback() {

                    @Override
                    public void done(ParseException e) {


                        if (isValidEmail(email) == true) {
                            if (e == null) {
                                Toast.makeText(LogInActivity.this, "Welcome!", Toast.LENGTH_LONG).show();
                                Intent toMainActivity = new Intent(LogInActivity.this, MainActivity.class);
                                startActivity(toMainActivity);
                                finish();
                            } else {
                                Log.d("error", e.getMessage());
                                Toast.makeText(LogInActivity.this, e.getMessage() + "." + " " + "Please use a different email as your username", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(LogInActivity.this, "Invalid Email Address", Toast.LENGTH_LONG).show();
                        } // done(e)

                    }
                });

            } // onClick(v)
        }); // setOnClickListener(new View.OnClickListener())


        // Sets action for user on clicking sign in button
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get text from views and eliminate whitespace
                password = passwordField.getText().toString().trim();
                email = userEmailField.getText().toString().trim();

                // Create new User
                ParseUser user = new ParseUser();
                user.setUsername(email);
                user.setPassword(password);

                // Check if user creds are empty. Report friendly message
                if (email.equals("") || password.equals("")) {
                    Toast.makeText(LogInActivity.this, "Please complete credentials", Toast.LENGTH_LONG).show();
                    return;
                }

                // Sign User in
                ParseUser.logInInBackground(email, password, new LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        // Check if user exists
                        if (user != null) {

                            Toast.makeText(LogInActivity.this, "Signed In!", Toast.LENGTH_LONG).show();
                            Intent toMainActivity = new Intent(LogInActivity.this, MainActivity.class);
                            startActivity(toMainActivity);
                            finish();

                        }// closes if
                        else {
                            Toast.makeText(LogInActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        } // closes else

                        //TODO: Check error messages if e generates any errors and fix tests

                    } // done(user, e)
                }); // user.logInInBackground(email, password, new LogInCallBack(){})
            }
        });
    } // onCreate(savedBundleState)
} // LogInActivity