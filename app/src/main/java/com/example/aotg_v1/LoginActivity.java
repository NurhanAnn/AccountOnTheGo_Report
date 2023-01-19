package com.example.aotg_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aotg_v1.ui.home.HomeFragment;

public class LoginActivity extends AppCompatActivity {

    public int Gender;
    public RadioButton male;
    public RadioButton female;
    private Button move_login2main;
    private TextView move_login2register;
    private ImageView move_login2FAQ;
    private ImageView move_login2feedback;

    TextView forgot;
    DBHelper DB;
    EditText username, password;
    Button btnlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        btnlogin = (Button) findViewById(R.id.btnsignin1);
        DB = new DBHelper(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass){
                        Toast.makeText(LoginActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("username",user);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        forgot = (TextView) findViewById(R.id.btnforgot);
        DB = new DBHelper(this);

        //login to main page (profile)
//        move_login2main.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });

//        move_login2main.setOnClickListener(this::ClickedLogin);
        
        //login to register
        move_login2register = findViewById(R.id.registerText);
        move_login2register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Why did it go here?------------------------------------------");
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        //login to FAQ
        move_login2FAQ = findViewById(R.id.btnFAQ);
        move_login2FAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, FAQ_mainActivity.class);
                startActivity(intent);
            }
        });

        //login to feedback
        move_login2feedback = findViewById((R.id.feedback_Icon));
        move_login2feedback.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, FeedbackActivity.class);
                startActivity(intent);
            }

        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PasswordActivity.class);
                startActivity(intent);
            }
        });


    }
//    public DBHelper DB = new DBHelper(RegisterActivity);
//    public void ClickedLogin(View v) {
//        EditText username_value = findViewById(R.id.input_username);
//        String username_string;
//        System.out.println(username_value);
//        username_string = username_value.getText().toString();
//
//        System.out.println(username_string);
//        DB.displayAge();
//    }

}

