package com.example.aotg_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aotg_v1.ui.profile.ProfileFragment;

public class RegisterActivity extends AppCompatActivity {

    EditText username,password,repassword,fullname,age,edubackground;
    Button signup;
    DBHelper DB;
    private TextView move_register2login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        fullname = (EditText) findViewById(R.id.fullname);
        age = (EditText) findViewById(R.id.age);
        edubackground = (EditText) findViewById(R.id.edubackground);
        signup = (Button) findViewById(R.id.btnsignup);
        DB = new DBHelper(this);
        //System.out.println("CREATEDDDD");
        //signup.setOnClickListener(this::ClickedLogin);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                String fullnameValue = fullname.getText().toString();
                Integer ageValue = Integer.parseInt(String.valueOf(age.getText()));
                String edubackgroundValue = edubackground.getText().toString();


                if (user.equals("")||pass.equals("")||repass.equals("")||fullnameValue.equals("")||ageValue.equals("")||edubackgroundValue.equals(""))
                    Toast.makeText(RegisterActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser==false){
                            Boolean insert = DB.insertData(user, pass,fullnameValue, ageValue, edubackgroundValue);
                            if (insert==true){
                                Toast.makeText(RegisterActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                /*Dont mind this next block of codes
                                EditText username_value = findViewById(R.id.username);
                                String username_string;
                                System.out.println(username_value);
                                username_string = username_value.getText().toString();

                                System.out.println(username_string);
                                DB.displayAge();
                                end*/
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                                Intent i = new Intent(getApplicationContext(), SettingsActivity.class);
                                intent.putExtra("username", user);
//                                i.putExtra("username",user);
//                                startActivity(i);
                                startActivity(intent);
                            }else {
                                Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(RegisterActivity.this, "User already exists! Please sign in", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(RegisterActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        move_register2login = findViewById(R.id.TVLogIn);
        move_register2login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    /*

    public void ClickedLogin(View v) {
        System.out.println("WENT INSIDE CLICKED LOGIN");
        DB = new DBHelper(this);
        EditText username_value = findViewById(R.id.username);
        String username_string;
        System.out.println(username_value);
        username_string = username_value.getText().toString();

        System.out.println(username_string);
        DB.displayAge();
    }

     */
}