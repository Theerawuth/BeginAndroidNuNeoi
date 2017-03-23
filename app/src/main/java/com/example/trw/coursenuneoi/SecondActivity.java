package com.example.trw.coursenuneoi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tvResult;
    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        sum = intent.getIntExtra("result", 0);
//        Bundle
        Bundle bundle = intent.getBundleExtra("cBundle");
        int x = bundle.getInt("x");
        int y = bundle.getInt("y");
        int z = bundle.getInt("z");
//        Serializable
        CoordinateSerializable c2 = (CoordinateSerializable)
                intent.getSerializableExtra("cSerializable");
//        Parcelable
        CoordinateParcelable c3 = (CoordinateParcelable)
                intent.getParcelableExtra("cParcelable");
        initInstances();
    }

    private void initInstances() {
        tvResult = (TextView) findViewById(R.id.tvResult);
        tvResult.setText("Result = " + String.valueOf(sum));
    }
}
