package com.example.kpn.register;

import android.media.MediaCodec;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextInputLayout name_input;
    EditText name_text;
    TextInputLayout mail_input;
    EditText mail_text;
    TextInputLayout phone_input;
    EditText phone_text;
    TextInputLayout college_input;
    EditText college_text;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });


    }

    public void validate()
    {
        boolean isvalid = true;
        name_input=(TextInputLayout)findViewById(R.id.name_input);
        name_text=(EditText)findViewById(R.id.name_text);
        phone_input=(TextInputLayout)findViewById(R.id.phone_input);
        phone_text=(EditText)findViewById(R.id.phone_text);
        mail_input=(TextInputLayout)findViewById(R.id.mail_input);
        mail_text=(EditText)findViewById(R.id.mail_text);
        college_input=(TextInputLayout)findViewById(R.id.college_input);
        college_text=(EditText)findViewById(R.id.college_text);

        if(name_text.getText().toString().length()>25)
        {
            isvalid = false;
            name_input.setError("Enter within 25 charchters");
        }
        else if(name_text.getText().toString().length()==0) {
            isvalid = false;
            name_input.setError("Enter your name");
        }

        else name_input.setErrorEnabled(false);

        int len = phone_text.getText().toString().length();
        if(len==0)
        {
            isvalid = false;
            phone_input.setError("Enter phone number");
        }

        else if(len<6 || len>13)
        {
            isvalid = false;
            phone_input.setError("Enter a valid phone number");
        }
        else phone_input.setErrorEnabled(false);


        if(mail_text.getText().toString().isEmpty())
        {
            isvalid = false;
            mail_input.setError("Enter mail id");
        }

        else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(mail_text.getText().toString()).matches())
        {
            isvalid = false;
            mail_input.setError("Enter valid email id");
        }

        else mail_input.setErrorEnabled(false);

        if(college_text.getText().toString().isEmpty())
        {
            isvalid = false;
            college_input.setError("Enter school/college");
        }

        else college_input.setErrorEnabled(false);


        if(isvalid)
        {
            Toast.makeText(this,"Registered",Toast.LENGTH_SHORT).show();
        }

    }
}
