package com.example.tuan2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.abhinav.passwordgenerator.PasswordGenerator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        2a
//        setContentView(R.layout.layout1);

//        2b
//        setContentView(R.layout.activity_2b);

//        2c
//        setContentView(R.layout.activity_2c);

//        2d
        createPassword();
    }



    public void createPassword(){
        EditText txtPassLength;
        CheckBox cbkLowerCase;
        CheckBox cbkUpperCase;
        CheckBox cbkNumber;
        CheckBox cbkSpecialSymbol;
        TextView txtPassword;
        Button btnGenerate;
        setContentView(R.layout.activity_2d);

        txtPassLength=findViewById(R.id.txtPassLong);
        cbkLowerCase= findViewById(R.id.chkLowcase);
        cbkUpperCase= findViewById(R.id.chkUpcase);
        cbkNumber = findViewById(R.id.chkNumber);
        cbkSpecialSymbol=  findViewById(R.id.chkSymbol);
        txtPassword= findViewById(R.id.txtPassword);
        btnGenerate= findViewById(R.id.btnGenerate);



        btnGenerate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int length;
                try {
                    length= Integer.parseInt(txtPassLength.getText().toString());
                    boolean isUpperCase= cbkUpperCase.isChecked();
                    boolean isLowerCase= cbkLowerCase.isChecked();
                    boolean isSymbol= cbkSpecialSymbol.isChecked();
                    boolean isNumber= cbkNumber.isChecked();

                    PasswordGenerator generator = new PasswordGenerator(length, isUpperCase, isLowerCase, isSymbol, isNumber);
                    txtPassword.setText(generator.generatePassword());
                    Toast.makeText(MainActivity.this, "fdsfsd",Toast.LENGTH_SHORT);

                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Password length must be a digit", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}