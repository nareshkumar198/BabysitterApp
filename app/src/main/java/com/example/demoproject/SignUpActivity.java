package com.example.demoproject;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.demoproject.ApiClient.ConfigApiClient;
import com.example.demoproject.ApiClient.Md5;
import com.example.demoproject.data.UserContract;
import com.example.demoproject.model.AuthResponse;
import com.example.demoproject.model.User;
import com.example.demoproject.model.UserDetails;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class SignUpActivity extends AppCompatActivity {
//private  static final Pattern PASSWORD_PATTERN = Pattern.compile("^"+
//        "(?=.*[0-9])"+    //at least 1 digit
//        "(?=.*[a-z])"+   // at least 1 lower case letter
//        "(?=.*[A-Z])"+   // at least 1 upper case latter
////        "(?=.*[a-zA-Z])"+// any letter
////        "(?=.*[!@#$%^&*+=])"+
//        "(?=\\s+$)"+      // no white space
//        ".{6,12}"+          //at least 6 character
//        "$");

        String[] categoryDrop = {"Text/Message", "Email"};
        private TextView login, termsService, privacyPolicy ;
        private EditText  emailId, reEmailId, password, rePassword, firstName, lastName, phoneNo;
        Spinner communication;
        private Button signUp;
        private CheckBox checkBox;
        private int mcomMode = UserContract.UserEntry.COMM_MODE_TEXT;
        UserDetails user = new UserDetails();

        protected void onCreate(Bundle savedInstanceState) {

                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_sign_up);
                login = findViewById(R.id.sign_login);
                emailId = findViewById(R.id.signUp_Email);
                reEmailId = findViewById(R.id.signUp_reEmail);
                password = findViewById(R.id.signUp_Password);
                rePassword = findViewById(R.id.re_enterpassword);
                firstName = findViewById(R.id.first_name);
                lastName = findViewById(R.id.last_name);
                phoneNo = findViewById(R.id.phone_No);
                signUp = findViewById(R.id.signUp);
                communication = (Spinner) findViewById(R.id.communicationMode);
                checkBox = findViewById(R.id.checkBoxPolicy);
                termsService = findViewById(R.id.termsServiceup);
                privacyPolicy = findViewById(R.id.privacyPolicy);
                setupSpinner();

                /**
                 * Login TextView go to Login Activity
                 */
                login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        Intent loginIntent = new Intent(SignUpActivity.this, MainActivity.class);
                        startActivity(loginIntent);
                        }
                });

                /**
                 * SignUp Button
                 */
                signUp.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                userSignUp();
                                saveUsers(user);
                        }
                });
        }

        private void setupSpinner() {
                // Create adapter for spinner. The list options are from the String array it will use
                // the spinner will use the default layout
                ArrayAdapter commodeSpinnerAdapter = ArrayAdapter.createFromResource(this,
                        R.array.array_commode_options, android.R.layout.simple_spinner_item);
                // Specify dropdown layout style - simple list view with 1 item per line
                commodeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                // Apply the adapter to the spinner
                communication.setAdapter(commodeSpinnerAdapter);
                // Set the integer mSelected to the constant values
                communication.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                //communication.setSelection(position);
                                String selection = (String) parent.getItemAtPosition(position);
                                if (!TextUtils.isEmpty(selection)) {
                                        if (selection.equals(getString(R.string.commode_text))) {
                                        mcomMode = UserContract.UserEntry.COMM_MODE_TEXT ;
                                        } else {
                                        mcomMode = UserContract.UserEntry.COMM_MODE_EMAIL;
                                        }
                                }
                        }
                        // Because AdapterView is an abstract class, onNothingSelected must be defined
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                                mcomMode = UserContract.UserEntry.COMM_MODE_TEXT;
                        }
                });

                termsService.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                startActivity(new Intent(SignUpActivity.this, TermsService.class));
                        }
                });

                privacyPolicy.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                startActivity(new Intent(SignUpActivity.this, PrivacyPolicy.class));
                        }
                });
        }

        public void userSignUp() {
                user.setCommunicationMode(communication.getSelectedItemPosition());
                user.setEmail(emailId.getText().toString());
                user.setPassword(password.getText().toString());
                user.setFirstName(firstName.getText().toString());
                user.setLastName(lastName.getText().toString());
                user.setPhone(phoneNo.getText().toString());
                user.setEula(checkBox.callOnClick());
                if (checkBox.isChecked()){

                }
                // validation
                if (user.getEmail().isEmpty()) {
                emailId.setError("Please Enter Your Email");
                emailId.requestFocus();
                return;
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(user.getEmail()).matches()){
                        emailId.setError("Please Enter Valid Email Address");
                }
                if (user.getEmail().isEmpty()) {
                reEmailId.setError("Please Enter Your Email Again");
                reEmailId.requestFocus();
                return;
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(user.getEmail()).matches()){
                        reEmailId.setError("Please Enter Valid Email Address");
                }
                if (user.getPassword().isEmpty() || password.length()< 6) {
                password.setError("Enter Your Password your Password Should we 6 character long");
                password.requestFocus();
                return;
                }
                //        if(!PASSWORD_PATTERN.matcher(user.getPassword()).matches()){
                //                password.setError("Password To week");
                //        }
                if (user.getPassword().isEmpty() || rePassword.length()< 6) {
                rePassword.setError("Please Enter Your Password");
                rePassword.requestFocus();
                return;
                }
                //        if(!PASSWORD_PATTERN.matcher(user.getPassword()).matches()){
                //                password.setError("Password To week");
                //        }
                if (user.getFirstName().isEmpty()) {
                firstName.setError("Please Enter Your FirstName");
                firstName.requestFocus();
                return;
                }
                if (user.getLastName().isEmpty()) {
                lastName.setError("Please Enter Your LastName");
                lastName.requestFocus();
                return;
                }
                if (user.getPhone().isEmpty()) {
                phoneNo.setError("Please Enter Your Phone No");
                phoneNo.requestFocus();
                return;
                }

                Md5 md5 = new Md5(password.getText().toString());
                String a = md5.getMd5();
                user.setPassword(a);
                password.setText(user.getPassword());
                //        UserDbHelper mDbHelper = new UserDbHelper(this);
                //        SQLiteDatabase db = mDbHelper.getWritableDatabase();
                //        ContentValues values = new ContentValues();
                //        values.put(UserContract.UserEntry.COLUMN_USER_EMAIL, String.valueOf(emailId.getText().toString()));
                //        values.put(UserContract.UserEntry.COLUMN_USER_PASSWORD, String.valueOf(password.getText().toString()));
                //        values.put(UserContract.UserEntry.COLUMN_USER_FIRSTNAME, String.valueOf(firstName.getText().toString()));
                //        values.put(UserContract.UserEntry.COLUMN_USER_LASTNAME, String.valueOf(lastName.getText().toString()));
                //        values.put(UserContract.UserEntry.COLUMN_USER_PHONENO, String.valueOf(phoneNo.getText().toString()));
                //        values.put(UserContract.UserEntry.COLUMN_USER_COMM_MODE, String.valueOf(mcomMode));
                //        long newRowId = db.insert(UserContract.UserEntry.TABLE_NAME, null, values);
                ////Show a toast message depending on whether or not the insertion was successful
                //        if (newRowId == -1) {
                //        // If the row ID is -1, then there was an error with insertion.
                //        Toast.makeText(this, "Error with saving pet", Toast.LENGTH_SHORT).show();
                //        }else {
                //        // Otherwise, the insertion was successful and we can display a toast with the row ID.
                //        Toast.makeText(this, "User saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
                //        }
        }

        /**
         * Call API
         * @param user
         */
        public void saveUsers(UserDetails user) {
                Call<AuthResponse> authResponseCall = ConfigApiClient.getService().saveUsers(user);
                authResponseCall.enqueue(new Callback<AuthResponse>() {
                        @Override
                        public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                                if (response.isSuccessful()){
                                AuthResponse sineUpResponse = response.body();
                                startActivity(new Intent(SignUpActivity.this, Verifyemail.class));
                                finish();
                                }
                                else {
                                String message = "User already exists but not confirmed";
                                Toast.makeText(SignUpActivity.this, message, Toast.LENGTH_LONG).show();
                                }
                        }
                        @Override
                        public void onFailure(Call<AuthResponse> call, Throwable t) {
                                String message = t.getLocalizedMessage();
                                Toast.makeText(SignUpActivity.this,message, Toast.LENGTH_LONG).show();
                        }
                });
        }
}