package com.example.shivam.tictactoe;

/**
 * Created by shivam on 4/5/2017.
 */
class Move
{
    int row=-1,col=-1;
}
public class GameTheory {
    static char computer,human;

    static void set(char a, char b)
    {
        computer=a;
        human=b;
    }
    static boolean isEmpty(char[][] b)
    {
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(b[i][j]==' ')
                    return true;
        return false;
    }
    static int value(char[][] b)    // Heuristic Function.
    {
        for(int row =0;row<3;row++)
        {
            if((b[row][0]==b[row][1])&&(b[row][1]==b[row][2])) {
                if (b[row][0] == computer)
                    return +10;
                else if (b[row][0] == human)
                    return -10;
            }
        }
        for(int col =0;col<3;col++)
        {
            if((b[0][col]==b[1][col])&&(b[1][col]==b[2][col])) {
                if (b[0][col] == computer)
                    return +10;
                else if (b[0][col] == human)
                    return -10;
            }
        }
        if (b[0][0]==b[1][1] && b[1][1]==b[2][2])
        {
            if (b[0][0]==computer)
                return +10;
            else if (b[0][0]==human)
                return -10;
        }

        if (b[0][2]==b[1][1] && b[1][1]==b[2][0])
        {
            if (b[0][2]==computer)
                return +10;
            else if (b[0][2]==human)
                return -10;
        }
        return 0;
    }
    static int minimax(char[][] b,int depth,boolean isMax)
    {
       int score=value(b);
        if(score==-10)
            return score;
        if(score==10)
            return score;
        if(!isEmpty(b))
            return 0;
        if(isMax)
        {
            int best=-1000;
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    if(b[i][j]==' ')
                    {
                       b[i][j]=computer;
                        best=Math.max(best,minimax(b,depth+1,!isMax));
                        b[i][j]=' ';
                    }
                }
            }
            return best;
        }
        else
        {
            int best=1000;
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    if(b[i][j]==' ')
                    {
                        b[i][j]=human;
                        best=Math.min(best,minimax(b,depth+1,!isMax));
                        b[i][j]=' ';
                    }
                }
            }
            return best;
        }
    }
    static Move FindbestMove(char[][] b)
    {
        int best=-1000;
        Move bestMove=new Move();
        bestMove.row=-1;
        bestMove.col=-1;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(b[i][j]==' ')
                {
                    b[i][j]=computer;
                    int fvalue=minimax(b,0,false);
                    b[i][j]=' ';
                    if(fvalue>best)
                    {
                        bestMove.row=i;
                        bestMove.col=j;
                        best=fvalue;
                    }
                }
            }
        }

        return bestMove;
    }
}
