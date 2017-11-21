package com.example.user.guess100;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.max;
import static android.R.attr.min;

public class MainActivity extends AppCompatActivity {

    private EditText edNum;
    private TextView tvSecret;
    private String secret;
    private TextView tvInfo;
    private Button bSend;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.findViews();
    }

    public void findViews(){
        edNum = (EditText) findViewById(R.id.number);
        tvInfo = (TextView) findViewById(R.id.info);
        tvSecret = (TextView) findViewById(R.id.secret);
        bSend = (Button) findViewById(R.id.send);
        secret = String.valueOf(ans);
        tvSecret.setText(secret);
//        num = Integer.parseInt(edNum.getText().toString());
//        String s_info = tvInfo.getText().toString();
//        String s_secret = tvSecret.getText().toString();
    }

    int ans = (int) (Math.random() * 100 + 1);
    int min = 1;
    int max = 100;

    public void again(View view){
        int ans2 = (int) (Math.random() * 100 + 1);
        ans = ans2;
        min = 1;
        max = 100;
        secret = String.valueOf(ans);
        tvSecret.setText(secret);
        edNum.setText("");
    }

    public void send(View view){
        num = Integer.parseInt(edNum.getText().toString());

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
