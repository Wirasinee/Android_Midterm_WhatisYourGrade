package com.example.whatisyourgrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class p2 extends AppCompatActivity {
    TextView mName_textView2, mShow_grade_textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String grade = intent.getStringExtra("grade");
        mName_textView2 = (TextView) findViewById(R.id.name_textView2);
        mShow_grade_textView = (TextView) findViewById(R.id.show_grade_textView);

        mName_textView2.setText(name);
        mShow_grade_textView.setText(grade);


    }
}
