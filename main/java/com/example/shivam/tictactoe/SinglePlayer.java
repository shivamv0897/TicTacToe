package com.example.shivam.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SinglePlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button19);
        b10 =(Button) findViewById(R.id.button20);
        b11 =(Button) findViewById(R.id.button21);
    }

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11;
    int i = 1, d = 0, e=0;
    char[][] a = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    char[] b={'a','b','c','d','e','f','g','h','i'};
    String text;
    Move m=new Move();
    void compturn(View v)
    {   i++;
        GameTheory.set('0','x');
        m=GameTheory.FindbestMove(a);
        int row=m.row;
        int col=m.col;
        if(row==-1 || col==-1)
        {return;}
        a[row][col]='0';
        if(row==0)
            d=row+col;
        if(row==1)
            d=row+col+2;
        if(row==2)
            d=row+col+4;
        markC(d,v);
    }

     void markC(int d, View v) {
         switch (d)
         {
             case 0:
                 b1.setText("0");
                 b1.setEnabled(false);
                 a[0][0]='0';
                 b[0]='0';
                 win(v);
                 break;
             case 1:
                 b2.setText("0");
                 b2.setEnabled(false);
                 a[0][1]='0';
                 b[1]='0';
                 win(v);
                 break;
             case 2:
                 b3.setText("0");
                 b3.setEnabled(false);
                 a[0][2]='0';
                 b[2]='0';
                 win(v);
                 break;
             case 3:
                 b4.setText("0");
                 b4.setEnabled(false);
                 a[1][0]='0';
                 b[3]='0';
                 win(v);
                 break;
             case 4:
                 b5.setText("0");
                 b5.setEnabled(false);
                 a[1][1]='0';
                 b[4]='0';
                 win(v);
                 break;
             case 5:
                 b6.setText("0");
                 b6.setEnabled(false);
                 a[1][2]='0';
                 b[5]='0';
                 win(v);
                 break;
             case 6:
                 b7.setText("0");
                 b7.setEnabled(false);
                 a[2][0]='0';
                 b[6]='0';
                 win(v);
                 break;
             case 7:
                 b8.setText("0");
                 b8.setEnabled(false);
                 i++;
                 a[2][1]='0';
                 b[7]='0';
                 win(v);
                 break;
             case 8:
                 b9.setText("0");
                 b9.setEnabled(false);
                 a[2][2]='0';
                 b[8]='0';
                 win(v);
                 break;
         }

     }
    public void debug(int i,int index)
    {
        String d="";
        for(int h=0;h<9;h++)
            d=d+" "+b[h];
        Toast toast=Toast.makeText(this,Integer.toString(i)+"value of index="+Integer.toString(index)+" array:"+d,Toast.LENGTH_SHORT);
        toast.show();
    }
    public void win(View v)
    {    
        if(i>=4) {
            if((b[0]==b[4])&&(b[4]==b[8]))
            { if(b[0]=='x')e=1; if(b[0]=='0')e=2;message(v);}
            else if((b[6]==b[4])&&(b[4]==b[2]))
            {if(b[6]=='x')e=1; if(b[6]=='0')e=2; message(v);}
            else if((b[0]==b[1])&&(b[1]==b[2]))
            { if(b[0]=='x')e=1; if(b[0]=='0')e=2; message(v);}
            else if((b[3]==b[4])&&(b[4]==b[5]))
            {   if(b[3]=='x')e=1; if(b[3]=='0')e=2;
                message(v);
            }
            else if((b[6]==b[7])&&(b[7]==b[8]))
            { if(b[6]=='x')e=1; if(b[6]=='0')e=2; message(v);}
            else if((b[0]==b[3])&&(b[3]==b[6]))
            {if(b[0]=='x')e=1; if(b[0]=='0')e=2;message(v);}
            else if((b[1]==b[4])&&(b[4]==b[7]))
            {if(b[1]=='x')e=1; if(b[1]=='0')e=2;message(v); }
            else if((b[2]==b[5])&&(b[5]==b[8]))
            { if(b[2]=='x')e=1; if(b[2]=='0')e=2;message(v);}
            if(i==11 && e==0)
            {
                text="match draw";
                message(v);
            }
        }
        if(i%2==0)
            compturn(v);

    }
    public void message(View v)
    {
        if( e==1)
          {text="you win";}
        else if( e==2)
         {text="you loose";}
        else if(i==11 && e==0)
        {text="match draw";}
        Toast toast=Toast.makeText(this,text,Toast.LENGTH_LONG);
        toast.show();
       reset(v);
    }
    public void reset(View v)
    {   try {
        Thread.sleep(1000);
    }
        catch (Exception e)
        {
        } b1.setEnabled(true);
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
            b[i]=(char)(97+i);
        for(int k=0;k<3;k++)
            for(int n=0;n<3;n++)
                a[k][n]=' ';
        i=1;
        e=0;
    }
    public void smode(View v)
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void mark(View v)
    {
        switch (v.getId())
        {
            case R.id.button:
                b1.setText("x");
                b1.setEnabled(false);
                a[0][0]='x';
                i++;
                b[0]='x';
                win(v);
                break;
            case R.id.button2:
                b2.setText("x");
                b2.setEnabled(false);
                a[0][1]='x';
                i++;
                b[1]='x';
                win(v);
                break;
            case R.id.button3:
                b3.setText("x");
                b3.setEnabled(false);
                a[0][2]='x';
                i++;
                b[2]='x';
                win(v);
                break;
            case R.id.button4:
                b4.setText("x");
                b4.setEnabled(false);
                a[1][0]='x';
                i++;
                b[3]='x';
                win(v);
                break;
            case R.id.button5:
                b5.setText("x");
                b5.setEnabled(false);
                a[1][1]='x';
                i++;
                b[4]='x';
                win(v);
                break;
            case R.id.button6:
                b6.setText("x");
                b6.setEnabled(false);
                a[1][2]='x';
                i++;
                b[5]='x';
                win(v);
                break;
            case R.id.button7:
                b7.setText("x");
                b7.setEnabled(false);
                a[2][0]='x';
                i++;
                b[6]='x';
                win(v);
                break;
            case R.id.button8:
                b8.setText("x");
                b8.setEnabled(false);
                a[2][1]='x';
                i++;
                b[7]='x';
                win(v);
                break;
            case R.id.button19:
                b9.setText("x");
                b9.setEnabled(false);
                a[2][2]='x';
                i++;
                b[8]='x';
                win(v);
                break;
        }

    }
}