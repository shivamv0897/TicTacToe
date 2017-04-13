package com.example.shivam.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void sp(View v)
    {
        Intent intent= new Intent(this,SinglePlayer.class);
        startActivity(intent);
    }
    public void tp(View v)
    {
        Intent intent =new Intent(this,TwoPlayer.class);
        startActivity(intent);
    }
    public void lm(View v)
    {
        Intent intent=new Intent(this,Lanmode.class);
        startActivity(intent);
    }
}
