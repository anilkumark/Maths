package com.solweaver.www.maths;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Integration extends AppCompatActivity {
    TextView Text_Eqn;
    EditText Edit_N;
    String Str_Eqn;
    Button Butt_Get, Butt_Go;
    LinearLayout Linear1, Linear2;

    EditText Edit_Input[];
    TextView Text_OutPut[];
    int count, n, temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.integration);

        Text_Eqn = (TextView) findViewById(R.id.textView2);
        Edit_N = (EditText) findViewById(R.id.editText1);
        Butt_Go = (Button) findViewById(R.id.button1);
        Butt_Get = (Button) findViewById(R.id.button2);
        Linear1 = (LinearLayout) findViewById(R.id.linear1);
        Linear2 = (LinearLayout) findViewById(R.id.linear2);

        Str_Eqn = "Consider our equation is like below<br/><br/>" +
                "<font color = '#FF0000'> ax^n + bx^n-1 + ...... + z</font>";
        Text_Eqn.setText(Html.fromHtml(Str_Eqn));

        Butt_Go.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                try {

                    n = 0;
                    removeView();
                    if(Edit_N.getText().toString().equalsIgnoreCase(""));
                    else {
                        n = Integer.parseInt(Edit_N.getText().toString());
                        InputBoxes(n);
                    }

                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), "Enter 'n' value Correctly",
                            Toast.LENGTH_LONG).show();
                }
            }
        });


        Butt_Get.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                try {

                    Linear2.removeAllViewsInLayout();
                    count = 0;

                    for(int i=0; i<=n; i++) {

                        if(Edit_Input[i].getText().toString().equalsIgnoreCase(""));
                        else
                            count ++;
                    }

                    if (count == n+1) {

                        integ();
                    }
                    else {

                        error();
                    }

                } catch (Exception e) {

                    Toast.makeText(getBaseContext(), "Enter The Values Correctly",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void removeView() {

        Linear1.removeAllViewsInLayout();
        Linear2.removeAllViewsInLayout();
    }

    public void InputBoxes(int n) {

        Edit_Input = new EditText[n+1];
        temp = n;

        for(int i=0; i<=n; i++) {

            Edit_Input[i] = new EditText(Integration.this);
            Edit_Input[i].setHint("Enter Co-efficient of x^"+ (temp-i));
            Edit_Input[i].setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL
                    | InputType.TYPE_NUMBER_FLAG_SIGNED);
            Linear1.addView(Edit_Input[i]);
        }
    }

    public void integ() {

        Text_OutPut = new TextView[n+1];

        for(int i=0; i<=n; i++) {

            String str = ((Float.parseFloat(Edit_Input[i].getText().toString())) /
                    ((temp-i)+1)) + " x^" + ((temp-i)+1);

            Text_OutPut[i] = new TextView(Integration.this);
            Text_OutPut[i].setText(str);
            Text_OutPut[i].setTextSize(16);
            Text_OutPut[i].setTextColor(Color.RED);
            Linear2.addView(Text_OutPut[i]);
        }


    }

    public void error() {

        Toast.makeText(getBaseContext(), "Enter the values", Toast.LENGTH_LONG).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_integration, menu);
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
