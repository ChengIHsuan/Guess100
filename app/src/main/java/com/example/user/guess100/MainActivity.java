package com.example.user.guess100;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

    }


    private void findViews(){
        EditText edNum = (EditText) findViewById(R.id.number);
        TextView tvInfo = (TextView) findViewById(R.id.info);
        TextView tvSecret = (TextView) findViewById(R.id.secret);
        Button bSend = (Button) findViewById(R.id.send);
        int num = Integer.parseInt(edNum.getText().toString());
        String s_info = tvInfo.getText().toString();
        String s_secret = tvSecret.getText().toString();
        

    }

}
