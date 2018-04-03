package com.example.cliente.calculadorageometrica;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    View view;
    RadioGroup radioG;
    ImageView imageV;
    EditText editText;
    TextView textView;
    String resultS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void onRadioButtonClicked(View view){

        boolean checked = ((RadioButton) view).isChecked();

        textView = (TextView)findViewById(R.id.result);
        imageV = (ImageView) findViewById(R.id.image);

        textView.setText("");
        imageV.setImageResource(0);

        switch(view.getId()) {
            case R.id.radio_squareRectangle:
                if (checked) {
                    editText = (EditText) findViewById(R.id.base);
                    editText.setVisibility(View.VISIBLE);

                    editText = (EditText) findViewById(R.id.height);
                    editText.setVisibility(View.VISIBLE);

                    editText = (EditText) findViewById(R.id.radius);
                    editText.setVisibility(View.GONE);
                }
                    break;
            case R.id.radio_triangle:
                if (checked) {
                    editText = (EditText) findViewById(R.id.base);
                    editText.setVisibility(View.VISIBLE);

                    editText = (EditText) findViewById(R.id.height);
                    editText.setVisibility(View.VISIBLE);

                    editText = (EditText) findViewById(R.id.radius);
                    editText.setVisibility(View.GONE);
                }
                    break;
            case R.id.radio_circle:
                if (checked) {
                    editText = (EditText) findViewById(R.id.base);
                    editText.setVisibility(View.GONE);

                    editText = (EditText) findViewById(R.id.height);
                    editText.setVisibility(View.GONE);

                    editText = (EditText) findViewById(R.id.radius);
                    editText.setVisibility(View.VISIBLE);
                }
                    break;
        }
    }

    public void fazCalculos(View view){
        float baseV;
        float heightV;
        float radiusV;

        radioG = (RadioGroup) findViewById(R.id.radioGroup);
        int radioID = radioG.getCheckedRadioButtonId();

        EditText editTextBase = (EditText) findViewById(R.id.base);
        EditText editTextHeight = (EditText) findViewById(R.id.height);
        EditText editTextRadius = (EditText) findViewById(R.id.radius);






        float result;


       switch (radioID){
           case R.id.radio_squareRectangle:
               if( TextUtils.isEmpty(editTextBase.getText()) || TextUtils.isEmpty(editTextHeight.getText())){
                    if (TextUtils.isEmpty(editTextBase.getText())) {
                        editTextBase.setError(getResources().getString(R.string.nullField));
                    }
                    if (TextUtils.isEmpty(editTextHeight.getText())){
                        editTextHeight.setError(getResources().getString(R.string.nullField));
                    }

               }else {
                   baseV = Float.parseFloat(editTextBase.getText().toString());
                   heightV = Float.parseFloat(editTextHeight.getText().toString());
                   result = baseV * heightV;
                   resultS = getResources().getString(R.string.area) + ' ' + result + " cm²";
                   textView.setText(resultS);

                   if (baseV < heightV) {
                       imageV.setImageResource(R.drawable.retangle_vertical);
                   } else if (baseV != heightV) {
                       imageV.setImageResource(R.drawable.retangle);
                   } else {
                       imageV.setImageResource(R.drawable.square);
                   }
               }
               break;
           case R.id.radio_triangle:
               if( TextUtils.isEmpty(editTextBase.getText()) || TextUtils.isEmpty(editTextHeight.getText())){
                   if (TextUtils.isEmpty(editTextBase.getText())) {
                       editTextBase.setError(getResources().getString(R.string.nullField));
                   }
                   if (TextUtils.isEmpty(editTextHeight.getText())){
                       editTextHeight.setError(getResources().getString(R.string.nullField));
                   }

               }else {
                   baseV = Float.parseFloat(editTextBase.getText().toString());
                   heightV = Float.parseFloat(editTextHeight.getText().toString());
                   result = (baseV * heightV) / 2;
                   resultS = getResources().getString(R.string.area) + ' ' + result + " cm²";
                   textView.setText(resultS);

                   imageV.setImageResource(R.drawable.triangle);
               }
               break;
           case R.id.radio_circle:
               if( TextUtils.isEmpty(editTextRadius.getText())){

                   editTextRadius.setError(getResources().getString(R.string.nullField));

               }else {
                   radiusV = Float.parseFloat(editTextRadius.getText().toString());
                   result = (float) (3.141 * (radiusV * radiusV));
                   resultS = getResources().getString(R.string.area) + ' ' + result + " cm²";
                   textView.setText(resultS);

                   imageV.setImageResource(R.drawable.circle);
               }
               break;
       }
    }
}
