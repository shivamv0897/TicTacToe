package com.example.shivam.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TwoPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player);
        b1=  (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.button9);
        b3 = (Button) findViewById(R.id.button10);
        b3 = (Button) findViewById(R.id.button10);
        b4 = (Button) findViewById(R.id.button11);
        b5 = (Button) findViewById(R.id.button12);
        b6 = (Button) findViewById(R.id.button13);
        b7 = (Button) findViewById(R.id.button14);
        b8 = (Button) findViewById(R.id.button15);
        b9 = (Button) findViewById(R.id.button16);
        b10= (Button) findViewById(R.id.button17);
        b11= (Button) findViewById(R.id.button18);
    }
        Button b1 ,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;



    int i=2;
    char a[]={'a','b','c','d','e','f','g','h','i'};
    String text;
    public void mark(View v)
    {
        switch (v.getId())
        {
            case R.id.b1:
                 if(i%2==0)
                  b1.setText("x");
                 else
                     b1.setText("0");
                 b1.setEnabled(false);
                i++;
                win(0,v);
                 break;
            case R.id.button9:
                if(i%2==0)
                    b2.setText("x");
                else
                    b2.setText("0");
                b2.setEnabled(false);
                i++;
                win(1,v);
                break;
            case R.id.button10:
                if(i%2==0)
                    b3.setText("x");
                else
                    b3.setText("0");
                b3.setEnabled(false);
                i++;
                win(2,v);
                break;
            case R.id.button11:
                if(i%2==0)
                    b4.setText("x");
                else
                    b4.setText("0");
                b4.setEnabled(false);
                i++;
                win(3,v);
                break;
            case R.id.button12:
                if(i%2==0)
                    b5.setText("x");
                else
                    b5.setText("0");
                b5.setEnabled(false);
                i++;
                win(4,v);
                break;
            case R.id.button13:
                if(i%2==0)
                    b6.setText("x");
                else
                    b6.setText("0");
                b6.setEnabled(false);
                i++;
                win(5,v);
                break;
            case R.id.button14:
                if(i%2==0)
                    b7.setText("x");
                else
                    b7.setText("0");
                b7.setEnabled(false);
                i++;
                win(6,v);
                break;
            case R.id.button15:
                if(i%2==0)
                    b8.setText("x");
                else
                    b8.setText("0");
                b8.setEnabled(false);
                i++;
                win(7,v);
                break;
            case R.id.button16:
                if(i%2==0)
                    b9.setText("x");
                else
                    b9.setText("0");
                b9.setEnabled(false);
                i++;
                win(8,v);
                break;
        }

    }
    public void win(int index,View v)
    {
        if(i%2==0)
            a[index]='x';
        if(i%2!=0)
            a[index]='0';
        if(i<4)
            return;
        else {
                if((a[0]==a[4])&&(a[4]==a[8]))
                    message(v);
                else if((a[6]==a[4])&&(a[4]==a[2]))
                    message(v);
                else if((a[0]==a[1])&&(a[1]==a[2]))
                    message(v);
                else if((a[3]==a[4])&&(a[4]==a[5]))
                    message(v);
                else if((a[6]==a[7])&&(a[7]==a[8]))
                    message(v);
                else if((a[0]==a[3])&&(a[3]==a[6]))
                    message(v);
                else if((a[1]==a[4])&&(a[4]==a[7]))
                    message(v);
                else if((a[2]==a[5])&&(a[5]==a[8]))
                    message(v);
            }
    }
    public void message(View v)
    {
        if(i%2==0)
        text="player1 wins";
        else
            text="player2 wins";
        Toast toast=Toast.makeText(this,text,Toast.LENGTH_LONG);
        toast.show();
        reset(v);
    }
    public void reset(View v)
    {
       b1.setEnabled(true);
        b1.setText("");
        b2.setEnabled(true);
        b2.setText("");
        b3.setEnabled(true);
        b3.setText("");
        b4.setEnabled(true);
        b4.setText("");
        b5.setEnabled(true);
        b5.setText("");
        b6.setEnabled(true);
        b6.setText("");
        b7.setEnabled(true);
        b7.setText("");
        b8.setEnabled(true);
        b8.setText("");
        b9.setEnabled(true);
        b9.setText("");
        for(int i=0;i<9;i++)
            a[i]=(char)(97+i);
    }
    public void smode(View v)
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
