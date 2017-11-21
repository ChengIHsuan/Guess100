package com.example.user.guess100;

import android.support.v7.app.AlertDialog;
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

    public void findViews(){
        EditText edNum = (EditText) findViewById(R.id.number);
        TextView tvInfo = (TextView) findViewById(R.id.info);
        TextView tvSecret = (TextView) findViewById(R.id.secret);
        Button bSend = (Button) findViewById(R.id.send);
        String secret = String.valueOf(ans);
        tvSecret.setText(secret);
//        int num = Integer.parseInt(edNum.getText().toString());
//        String s_info = tvInfo.getText().toString();
//        String s_secret = tvSecret.getText().toString();
    }

    int ans = (int) (Math.random() * 100 + 1);
    int min = 0;
    int max = 100;

    public void send(View view){
        EditText edNum = (EditText) findViewById(R.id.number);
        int num = Integer.parseInt(edNum.getText().toString());

        TextView tvSecret = (TextView) findViewById(R.id.secret);
        String secret = String.valueOf(ans);
        tvSecret.setText(secret);

        if (num < max & num > min) {
            if (num > ans) {
                max = num;
                new AlertDialog.Builder(this)
                        .setMessage(min + " to " + num)
                        .setPositiveButton("OK", null)
                        .show();
            } else if (num < ans) {
                min = num;
                new AlertDialog.Builder(this)
                        .setMessage(num + " to " + max)
                        .setPositiveButton("OK", null)
                        .show();
            } else if (num == ans) {
                new AlertDialog.Builder(this)
                        .setMessage("BINGO!!!")
                        .setNegativeButton("Close", null)
                        .show();
            }
        }else{
            new AlertDialog.Builder(this)
                    .setMessage("Please enter the number between " + min + " and " + max)
                    .setNegativeButton("Close", null)
                    .show();
        }
    }
}
