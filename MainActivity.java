package project.mizung;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context) {
            super(context, "groupDB", null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE user (user_id varchar2(20) PRIMARY KEY, user_name varchar2(40), user_enterprise varchar2(1), user_password varchar2(20), email varchar2(40));");
            db.execSQL("create table enterprise(\n" + "enterprise_number number primary key,\n" + "user_id varchar2(20),\n" + "enterprise_name varchar2(40),\n" + "enterprise_address varchar2(100),\n" + "enterprise_time varchar2(30),\n" + "enterprise_phone varchar2(20),\n" + "enterprise_variety varchar2(12),\n" + "photourl varchar2(200),\n" + "foreign key (user_id) references user(user_id));");
            db.execSQL("CREATE TABLE enterprise_hospital(\n" + "enterprise_number number,\n" + "user_id varchar2(20),\n" + "animal varchar2(80),\n" + "department varchar2(100),\n" + "treatment_special varchar2(200),\n" + "convenience varchar2(12),\n" + "photo varchar2(200),\n" + "foreign key (enterprise_number) references enterprise(enterprise_number),\n" + "foreign key (user_id)references user(user_id),\n" + "foreign key (photo)references enterprise(photourl));");
            db.execSQL("CREATE TABLE enterprise_shop(\n" + "enterprise_number number,\n" + "user_id varchar2(20),\n" + "animal varchar2(100),\n" + "goods varchar2(100),\n" + "convenience varchar2(100),\n" + "photo varchar2(200),\n" + "foreign key (enterprise_number) references enterprise(enterprise_number),\n" + "foreign key (user_id)references user(user_id),\n" + "foreign key (photo)references enterprise(photourl));");
            db.execSQL("CREATE TABLE enterprise_bury(\n" + "enterprise_number number,\n" + "user_id varchar2(20),\n" + "animal varchar2(40),\n" + "buries varchar2(60),\n" + "menu varchar2(100),\n" + "convenience varchar2(100),\n" + "photo varchar2(200),\n" + "foreign key (enterprise_number) references enterprise(enterprise_number),\n" + "foreign key (user_id)references user(user_id),\n" + "foreign key (photo)references enterprise(photourl));");
            db.execSQL("CREATE TABLE enterprise_hairshop(\n" + "enterprise_number number,\n" + "user_id varchar2(20),\n" + "animal varchar2(40),\n" + "convenience varchar2(100),\n" + "photo varchar2(200),\n" + "foreign key (enterprise_number) references enterprise(enterprise_number),\n" + "foreign key (user_id)references user(user_id),\n" + "foreign key (photo)references enterprise(photourl));");
            db.execSQL("CREATE TABLE enterprise_cafe(\n" + "enterprise_number number,\n" + "user_id varchar2(20),\n" + "animal varchar2(100),\n" + "menu varchar2(1000),\n" + "convenience varchar2(100),\n" + "photo varchar2(200),\n" + "foreign key (enterprise_number) references enterprise(enterprise_number),\n" + "foreign key (user_id)references user(user_id),\n" + "foreign key (photo)references enterprise(photourl))");
            db.execSQL("CREATE TABLE enterprise_hotel(\n" + "enterprise_number number,\n" + "user_id varchar2(20),\n" + "animal varchar2(100),\n" + "room varchar2(500),\n" + "convenience_animal varchar(400),\n" + "provision varchar(600),\n" + "photo varchar2(200),\n" + "foreign key (enterprise_number) references enterprise(enterprise_number),\n" + "foreign key (user_id)references user(user_id),\n" + "foreign key (photo)references enterprise(photourl));");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            
        }
    }
}