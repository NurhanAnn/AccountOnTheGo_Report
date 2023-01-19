package com.example.aotg_v1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aotg_v1.ui.home.HomeFragment;

public class SettingsActivity extends AppCompatActivity {
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        DB = new DBHelper(this);
    }


    //sign out
    public void showAlertDialogsignout(View v){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Log Out");
        alert.setMessage("Are you sure want to log out?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent r = new Intent(SettingsActivity.this, LoginActivity.class);
                startActivity(r);
                Toast.makeText(SettingsActivity.this,"You have successfully logged out", Toast.LENGTH_SHORT).show();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(SettingsActivity.this,"You did not log out", Toast.LENGTH_SHORT).show();
            }
        });
        alert.create().show();
    }

    //delete acc
    public void showAlertDialogdeleteacc(View v){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Delete Account");
        alert.setMessage("Are you sure you want to delete this account?");


        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


//                Intent r = new Intent(SettingsActivity.this, RegisterActivity.class);
//                startActivity(r);
                Intent intent = getIntent();
                String user = intent.getStringExtra("username");
                Boolean checkdeletedata = DB.deletedata(user);
                if (checkdeletedata)
                    Toast.makeText(SettingsActivity.this,"You have successfully deleted your account", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(SettingsActivity.this, "Account deletion is not successful", Toast.LENGTH_SHORT).show();
            }
        });


        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(SettingsActivity.this,"You did not delete your account", Toast.LENGTH_SHORT).show();
            }
        });
        alert.create().show();
    }
}
