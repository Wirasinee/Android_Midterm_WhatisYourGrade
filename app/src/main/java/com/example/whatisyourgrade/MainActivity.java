package com.example.whatisyourgrade;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText mName_editText,mScore_editText;
    Button mFind_button,mExit_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName_editText = (EditText) findViewById(R.id.name_editText) ;
        mScore_editText= (EditText) findViewById(R.id.score_editText);
        mFind_button= (Button) findViewById(R.id.find_button);
        mExit_button= (Button) findViewById(R.id.exit_button);

        mExit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Confirm Exit");
                dialog.setMessage("แน่ใจว่าต้องการออกจากแอพ?");
                dialog.setPositiveButton("ออก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }

                });
                dialog.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //โค้ดที่ต้องการให้ทำงาน เมือปุ่ม OK ใน dialog ถูกคลิค}
                    }

                });

                dialog.show();
            }
        });

        mFind_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mName_editText.getText().length()==0&&mScore_editText.getText().length()>0){
                    mName_editText.setError("ป้อนชื่อ");

                }
                else if(mName_editText.getText().length()>0&&mScore_editText.getText().length()==0){
                    mScore_editText.setError("ป้อนเกรด");

                }
                else if(mName_editText.getText().length()==0&&mScore_editText.getText().length()==0){
                    mName_editText.setError("ป้อนชื่อ");
                    mScore_editText.setError("ป้อนเกรด");

                }

               else if(mScore_editText.getText().length()>=0&&mName_editText.getText().length()>=0) {
                    Intent intent = new Intent(MainActivity.this,p2.class);//(context.คลาสปลายทางที่จะรัน)
                   String n =mName_editText.getText().toString();
                    intent.putExtra("name",n); //ส่งค่าไป (key,value)
                    int s = Integer.parseInt(mScore_editText.getText().toString());
                    String grade = getGrade(s);
                    intent.putExtra("grade",grade); //ส่งค่าไปแอคทิวิตีปลายทาง ดูบรรทัด14 BmiResuitActivity.java
                    startActivity(intent);

                }
            }
        });
    }
    String getGrade(int s){
        String g ="";
        if(s>=80){
            g="A";
        }else if(s>=70){
            g="B";
        }else if(s>=60){
            g="C";
        }else if(s>=50){
            g="D";
        }else{
            g="F";
        }
        return g;
    }
}
