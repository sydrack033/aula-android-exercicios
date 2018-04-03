package com.example.cliente.youtubeapi_aula04;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void reproduzVideo(View view){
        Intent myIntent = new Intent(MainActivity.this, VideoActivity.class);
        EditText edit = (EditText)findViewById(R.id.link_video);
        String link = edit.getText().toString();
        myIntent.putExtra("link", link);
        MainActivity.this.startActivity(myIntent);

    }

}
