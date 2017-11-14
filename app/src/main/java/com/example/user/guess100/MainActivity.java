package com.example.user.guess100;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private MainActivity f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        f.findViews();
    }

    int ans = (int) (Math.random() * 100 + 1);

    public void findViews(){
        EditText edNum = (EditText) findViewById(R.id.number);
        TextView tvInfo = (TextView) findViewById(R.id.info);
        TextView tvSecret = (TextView) findViewById(R.id.secret);
        Button bSend = (Button) findViewById(R.id.send);
        int num = Integer.parseInt(edNum.getText().toString());
        String s_info = tvInfo.getText().toString();
        String s_secret = tvSecret.getText().toString();
        tvSecret.setText(ans);
    }


    int min = 0;
    int max = 100;

    public void send(View view){
        EditText edNum = (EditText) findViewById(R.id.number);
        int num = Integer.parseInt(edNum.getText().toString());


        if (num > ans) {
            max=num;
            new AlertDialog.Builder(this)
                    .setMessage(min + " to " + num)
                    .setPositiveButton("OK", null)
                    .show();
        } else if (num < ans) {
            min=num;
            new AlertDialog.Builder(this)
                    .setMessage(num + " to " + max)
                    .setPositiveButton("OK", null)
                    .show();
        } else if (num == ans) {
            new AlertDialog.Builder(this)
                    .setMessage("BINGO!!!")
                    .setNegativeButton("關閉", null)
                    .show();
        }
    }

}
