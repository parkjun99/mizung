package com.example.signup;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class termsActivity extends AppCompatActivity {
    CheckBox termsagree;
    Button termbtnOK,termbtnNO;
    public void OnClickHandler(){           //메세지박스
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("오류").setMessage("개인정보 수집 동의하셔야 서비스를 이용하실 수 있습니다.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terms);
        termsagree = (CheckBox)findViewById(R.id.Termsagree);
        termbtnOK = (Button)findViewById(R.id.TermbtnOK);
        termbtnNO = (Button)findViewById(R.id.TermbtnNO);

        termbtnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(termsagree.isChecked() == true){
                    Intent newIntent = new Intent(getApplicationContext(),signupActivity.class);    //회원가입화면으로 이동
                    startActivity(newIntent);
                    finish();
                }else{
                    OnClickHandler();
                }
            }
        });
        termbtnNO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(termsagree.isChecked() == true){
                    Intent newIntent = new Intent(getApplicationContext(),MainActivity.class);    //메인화면으로 이동
                    startActivity(newIntent);
                    finish();
                }else{
                    OnClickHandler();
                }
            }
        });
    }

}
