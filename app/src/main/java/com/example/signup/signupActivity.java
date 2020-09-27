package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class signupActivity extends AppCompatActivity {
    //xml변수 선언 목록
    CheckBox businesscheck; char business_state ='N';
    RadioButton hospitalcheck,petshopcheck,petburycheck,petbeautycheck,petcafecheck,pethotelcheck;
    RadioGroup companygroup1,companygroup2;
    LinearLayout businessview1;
    RelativeLayout Hospital,Petshop,Petbury,Petbeauty,Petcafe,Pethotel;
    EditText id,pw,pwconfirm,email,nickname;
    EditText businessnumber, businessaddress,businesstime,company,businessphone;
    String companyvariety;
    EditText hospitalanimal,specialcure,department,convenience_hospital;
    EditText sellpets,sellgoods,convenience_shop;
    EditText burypets,buryprocess,menu_bury,convenience_bury;
    EditText beautypet,menu_beauty,convenience_beauty;
    EditText cafepet,menu_cafe,convenience_cafe;
    EditText hotelpet,roomhotel,facility_hotel,goods_hotel;
    Button btnregister;

    //listener1,listener2는 업체종류 라디오버튼 디자인 설계부분
    private RadioGroup.OnCheckedChangeListener listener1 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            switch(checkedId){
                case R.id.Hospitalcheck:            //병원체크하면 병원에 대한 정보 입력만 표시 나머지 업체에 대한 입력은 숨긴다.
                    Hospital.setVisibility(View.VISIBLE);
                    Petshop.setVisibility(View.GONE);
                    Petbury.setVisibility(View.GONE);
                    Petbeauty.setVisibility(View.GONE);
                    Petcafe.setVisibility(View.GONE);
                    Pethotel.setVisibility(View.GONE);
                    companygroup2.setOnCheckedChangeListener(null);
                    companygroup2.clearCheck();
                    companygroup2.setOnCheckedChangeListener(listener2);
                    companyvariety = "동물병원";
                    break;
                case R.id.Petshopcheck:
                    Petshop.setVisibility(View.VISIBLE);
                    Hospital.setVisibility(View.GONE);
                    Petbury.setVisibility(View.GONE);
                    Petbeauty.setVisibility(View.GONE);
                    Petcafe.setVisibility(View.GONE);
                    Pethotel.setVisibility(View.GONE);
                    companygroup2.setOnCheckedChangeListener(null);
                    companygroup2.clearCheck();
                    companygroup2.setOnCheckedChangeListener(listener2);
                    companyvariety = "펫샵";
                    break;
                case R.id.Petburycheck:
                    Petbury.setVisibility(View.VISIBLE);
                    Hospital.setVisibility(View.GONE);
                    Petshop.setVisibility(View.GONE);
                    Petbeauty.setVisibility(View.GONE);
                    Petcafe.setVisibility(View.GONE);
                    Pethotel.setVisibility(View.GONE);
                    companygroup2.setOnCheckedChangeListener(null);
                    companygroup2.clearCheck();
                    companygroup2.setOnCheckedChangeListener(listener2);
                    companyvariety = "동물장례업체";
                    break;
            }

        }
    };
    private RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            switch(checkedId){
                case R.id.Petbeautycheck:               //미용실체크하면 미용실에 대한 정보 입력만 표시 나머지 업체에 대한 입력은 숨긴다.
                    Hospital.setVisibility(View.GONE);
                    Petshop.setVisibility(View.GONE);
                    Petbury.setVisibility(View.GONE);
                    Petbeauty.setVisibility(View.VISIBLE);
                    Petcafe.setVisibility(View.GONE);
                    Pethotel.setVisibility(View.GONE);
                    companygroup1.setOnCheckedChangeListener(null);
                    companygroup1.clearCheck();
                    companygroup1.setOnCheckedChangeListener(listener1);
                    companyvariety = "동물미용업체";
                    break;
                case R.id.Petcafecheck:
                    Petshop.setVisibility(View.GONE);
                    Hospital.setVisibility(View.GONE);
                    Petbury.setVisibility(View.GONE);
                    Petbeauty.setVisibility(View.GONE);
                    Petcafe.setVisibility(View.VISIBLE);
                    Pethotel.setVisibility(View.GONE);
                    companygroup1.setOnCheckedChangeListener(null);
                    companygroup1.clearCheck();
                    companygroup1.setOnCheckedChangeListener(listener1);
                    companyvariety="동물카페";
                    break;
                case R.id.Pethotelcheck:
                    Petbury.setVisibility(View.GONE);
                    Hospital.setVisibility(View.GONE);
                    Petshop.setVisibility(View.GONE);
                    Petbeauty.setVisibility(View.GONE);
                    Petcafe.setVisibility(View.GONE);
                    Pethotel.setVisibility(View.VISIBLE);
                    companygroup1.setOnCheckedChangeListener(null);
                    companygroup1.clearCheck();
                    companygroup1.setOnCheckedChangeListener(listener1);
                    companyvariety="동물호텔";
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        setTitle("회원가입 화면");

        businesscheck = (CheckBox) findViewById(R.id.BusinessCheck);
        companygroup1 = (RadioGroup) findViewById(R.id.companygroup1);
        companygroup2 = (RadioGroup) findViewById(R.id.companygroup2);
        hospitalcheck = (RadioButton) findViewById(R.id.Hospitalcheck);
        petshopcheck = (RadioButton) findViewById(R.id.Petshopcheck);
        petburycheck = (RadioButton)findViewById(R.id.Petburycheck);
        petbeautycheck = (RadioButton)findViewById(R.id.Petbeautycheck);
        petcafecheck = (RadioButton)findViewById(R.id.Petcafecheck);
        pethotelcheck = (RadioButton)findViewById(R.id.Pethotelcheck);
        businessview1 = (LinearLayout) findViewById(R.id.BusinessView1);
        Hospital = (RelativeLayout) findViewById(R.id.Hospital);
        Petshop = (RelativeLayout)findViewById(R.id.Petshop);
        Petbury = (RelativeLayout)findViewById(R.id.Petbury);
        Petbeauty = (RelativeLayout)findViewById(R.id.Petbeauty);
        Petcafe = (RelativeLayout)findViewById(R.id.Petcafe);
        Pethotel = (RelativeLayout)findViewById(R.id.Pethotel);
        id = (EditText)findViewById(R.id.Id);
        pw = (EditText)findViewById(R.id.Pw);
        pwconfirm = (EditText)findViewById(R.id.PwConfirm);
        email = (EditText)findViewById(R.id.Email);
        nickname = (EditText)findViewById(R.id.Nickname);
        businessnumber = (EditText)findViewById(R.id.Businessnumber);
        businessaddress = (EditText)findViewById(R.id.Businessaddress);
        businesstime = (EditText)findViewById(R.id.Businesstime);
        company = (EditText)findViewById(R.id.Company);
        businessphone = (EditText)findViewById(R.id.Businessphone);
        btnregister = (Button)findViewById(R.id.btn_register);


        //일반회원인가 사업가인가 구분
       businesscheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(businesscheck.isChecked() == true){
                    businessview1.setVisibility(View.VISIBLE);
                    business_state = 'Y';
                }else{
                    businessview1.setVisibility(View.GONE);
                    Hospital.setVisibility(View.GONE);
                    Petshop.setVisibility(View.GONE);
                    Petbury.setVisibility(View.GONE);
                    Petbeauty.setVisibility(View.GONE);
                    Petcafe.setVisibility(View.GONE);
                    Pethotel.setVisibility(View.GONE);
                    business_state = 'N';
                }
            }
        });
        companygroup1.clearCheck();
        companygroup2.clearCheck();
        companygroup1.setOnCheckedChangeListener(listener1);
        companygroup2.setOnCheckedChangeListener(listener2);
        //회원가입 버튼 동작
        btnregister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if(business_state=='Y'){            //사업자이면 사업에 관한 정보 추가로 받아서 데이터베이스에 저장

                }
                Toast.makeText(getApplicationContext(),"가입이 완료되었습니다",Toast.LENGTH_SHORT).show();
                Intent newIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(newIntent);
            }
        });

    }



}