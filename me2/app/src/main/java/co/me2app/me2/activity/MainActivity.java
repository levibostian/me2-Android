package co.me2app.me2.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import co.me2app.me2.R;


public class MainActivity extends FragmentActivity {

    // Fields
    String email;
    String password;
    EditText passwordField;
    EditText userEmailField;
    Button signInButton;

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
        signInButton = (Button) findViewById(R.id.signInButton);

        // Sets action for user on clicking sign in button
        signInButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Get text from views and eliminate whitespace
                password = passwordField.getText().toString().trim();
                email = userEmailField.getText().toString().trim();

                // Create new User
                ParseUser user = new ParseUser();
                user.setEmail(email);
                user.setPassword(password);

                // Check if user creds are empty. Report friendly message
                if (email.equals("") || password.equals("")) {
                    Toast.makeText(MainActivity.this, "Please complete credentials", Toast.LENGTH_LONG).show();
                    return;
                }

                // Sign User in
                ParseUser.logInInBackground(email, password, new LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        // Check if user exists
                        if (user == null) {
                            Toast.makeText(MainActivity.this, "User does not exist", Toast.LENGTH_LONG).show();
                        }// closes if
                        else {
                            //TODO: Set intent to take user to main app feed and finish current activity
                            // Send user to main feed
                        } // closes else

                        //TODO: Check error messages if e generates any errors and fix tests

//                        if (e.getMessage().equals(ParseException.EMAIL_NOT_FOUND)){
//                            Toast.makeText(MainActivity.this, "E-mail not found. Please use an existing email", Toast.LENGTH_LONG).show();
//                        }
//                        if (e.getMessage().equals(ParseException.INVALID_EMAIL_ADDRESS)){
//                            Toast.makeText(MainActivity.this, "Invalid Email. Please check and rectify error", Toast.LENGTH_LONG).show();
//                        }
//                        if (e.getMessage().equals(ParseException.EMAIL_MISSING)){
//                            Toast.makeText(MainActivity.this, "Please complete your credentials", Toast.LENGTH_LONG).show();
//                        }
                    } // done(user, e)
                }); // user.logInInBackground(email, password, new LogInCallBack(){})
            }
        });
    } // onCreate(savedBundleState)

} // MainActivity