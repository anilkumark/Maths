package com.solweaver.www.maths;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Linear extends AppCompatActivity {
    TextView Text_Eqn, Text_X, Text_Y;
    EditText Edit_a1, Edit_b1, Edit_c1, Edit_a2, Edit_b2, Edit_c2;
    String Str_Eqn;
    Button Butt_Get;

    float a1, a2, b1, b2, c1, c2;
    float x, y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear);

        Text_Eqn = (TextView) findViewById(R.id.textView2);
        Text_X = (TextView) findViewById(R.id.textView3);
        Text_Y = (TextView) findViewById(R.id.textView4);

        Edit_a1 = (EditText) findViewById(R.id.editText1);
        Edit_b1 = (EditText) findViewById(R.id.editText2);
        Edit_c1 = (EditText) findViewById(R.id.editText3);
        Edit_a2 = (EditText) findViewById(R.id.editText4);
        Edit_b2 = (EditText) findViewById(R.id.editText5);
        Edit_c2 = (EditText) findViewById(R.id.editText6);

        Butt_Get = (Button) findViewById(R.id.button1);


        Str_Eqn = "Consider our equation is like below<br/><br/>" +
                "<font color = '#FF0000'> a1 x + b1 y = c1" +
                "<br/>a2 x + b2 y = c2</font>";
        Text_Eqn.setText(Html.fromHtml(Str_Eqn));

        Butt_Get.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                try {

                    a1 = Float.parseFloat(Edit_a1.getText().toString());
                    b1 = Float.parseFloat(Edit_b1.getText().toString());
                    c1 = Float.parseFloat(Edit_c1.getText().toString());

                    a2 = Float.parseFloat(Edit_a2.getText().toString());
                    b2 = Float.parseFloat(Edit_b2.getText().toString());
                    c2 = Float.parseFloat(Edit_c2.getText().toString());

                    linear();

                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), "Enter The Values Correctly",
                            Toast.LENGTH_LONG).show();
                    Log.e("df", e.toString());
                }
            }
        });
    }

    public void linear() {

        float da1, da2, db1, db2, dc1, dc2;

        da1 = a1; da2 = a2;
        db1 = b1; db2 = b2;
        dc1 = c1; dc2 = c2;

        da1 = a1 * b2;
        db1 = b1 * b2;
        dc1 = c1 * b2;

        da2 = a2 * b1;
        db2 = b2 * b1;
        dc2 = c2 * b1;

        if(db1 == db2) {

            da2 = da2 * -1;
            db2 = db2 * -1;
            dc2 = dc2 * -1;
        }

        float sum_a = da1 + da2;
        float sum_c = dc1 + dc2;

        x = sum_c / sum_a;
        y = (c1 - (a1 * x)) / b1;

        String Str_X = "x value : <font color = '#FF0000'>" + x + "</font>";
        String Str_Y = "y value : <font color = '#FF0000'>" + y + "</font>";

        Text_X.setText(Html.fromHtml(Str_X));
        Text_Y.setText(Html.fromHtml(Str_Y));
    }

    public void error() {

        Toast.makeText(getBaseContext(), "Enter the values", Toast.LENGTH_LONG).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_linear, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
