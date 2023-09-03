import java.util.*;
import java.util.Scanner;
import java.util.Random;

class Game{
    public int number;
    public int inputnumber;
    public int numberOfGuess=0;

    public int get(){
        return numberOfGuess;
    }
    public void set(int numberOfGuess)
    {
        this.numberOfGuess=numberOfGuess;
    }
 Game(){
    Random rand=new Random();
    this.number=rand.nextInt(100);
}
void takeUserInput()
{
    System.out.println("Guess the number :");
Scanner sc=new Scanner(System.in);
inputnumber=sc.nextInt();
}
boolean correctNumber(){
    numberOfGuess++;
    if(inputnumber==number)
    {
        System.out.format("Guessed number is right,it was %d \n You guessed in %d attempts",number,numberOfGuess);
        return true;
    }
    else if(inputnumber<number){
        System.out.println("Number is too low...");
    }
    else if(inputnumber>number){
        System.out.println("Number is too high..");
    }
    return false;
}


}


public class GuessNumberGame {
    public static void main(String[] args) {
        Game g=new Game();
        boolean b=false;
        while(!b)
        {
            g.takeUserInput();
            b=g.correctNumber();
        }
        
    }
    
}
