package com.example.trw.coursenuneoi;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvResult;
    EditText editText1;
    EditText editText2;
    Button btnCal;
    RadioGroup rgOperator;
    CustomViewGroup viewGroup1;
    CustomViewGroup viewGroup2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        int width = size.x;
        int height = size.y;

        Toast toast = Toast.makeText(getApplicationContext(), "Width = " + width + "Height = " + height, Toast.LENGTH_LONG);
        toast.show();

        viewGroup1 = (CustomViewGroup) findViewById(R.id.viewGroup1);
        viewGroup2 = (CustomViewGroup) findViewById(R.id.viewGroup2);

        viewGroup1.setButtonText("Hello");
        viewGroup1.setButtonText("Text");

        initInstances();
    }

    private void initInstances() {
        tvResult = (TextView) findViewById(R.id.tvResult);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        btnCal = (Button) findViewById(R.id.btnCal);
        rgOperator = (RadioGroup) findViewById(R.id.rbGroup);

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int val1=0;
                int val2=0;
                int sum=0;
                try {
                    val1 = Integer.parseInt(editText1.getText().toString());

                }catch (NumberFormatException e) {

                }
                try {
                    val2 = Integer.parseInt(editText2.getText().toString());

                }catch (NumberFormatException e) {

                }

//                Check Operator
                switch (rgOperator.getCheckedRadioButtonId()){
                    case R.id.rbPlus:
                        sum = val1 + val2;
                        break;
                    case R.id.rbMinus:
                        sum = val1 - val2;
                        break;
                    case R.id.rbMultiple:
                        sum = val1 * val2;
                        break;
                    case R.id.rbDivide:
                        sum = val1 / val2;
                        break;
                }
                //              Show Result

                tvResult.setText(sum + "");

                Intent intent = new Intent(MainActivity.this,
                        SecondActivity.class);
                intent.putExtra("result", sum);

//                Playground
                Coordinate c1 = new Coordinate();
                c1.x = 5;
                c1.y = 10;
                c1.z = 20;
                Bundle bundle = new Bundle();
                bundle.putInt("x", c1.x);
                bundle.putInt("y", c1.y);
                bundle.putInt("z", c1.z);
                intent.putExtra("cBundle", bundle);

//                Serializable Lab
                CoordinateSerializable c2 = new CoordinateSerializable();
                c2.x = 5;
                c2.y = 10;
                c2.z = 20;
                intent.putExtra("cSerializable", c2);
//                Parcelable
                CoordinateParcelable c3 = new CoordinateParcelable();
                c3.x = 5;
                c3.y = 10;
                c3.z = 20;
                intent.putExtra("cParcelable", c3);


//                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View view) {
        if(view == btnCal){

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_settings){
            Toast toast = Toast.makeText(getApplicationContext(), "return", Toast.LENGTH_LONG);
            toast.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        Save things here

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
//        Restore things here

    }
}
