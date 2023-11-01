import java.util.*;

public class Begin
{
  private User user;
  private Coin coin = new Coin(0);
  private Coin c = new Coin(0);
  private final Integer deck = new Integer(52);
  private String coinExplain = null;
  private int num;
  private int p1a;
  private int p1b;
  private int p2a;
  private double truncate;
  private int p2b;
  private Integer compare = new Integer(0);
  private int p1c = 0;
  private int hitscan;
  public Begin()
  {
    System.out.println(coin);
    System.out.println("");
    user = new User();
    user.setAnswer(0);
    questionB();
    start();
  }
  public void game()
  {
    p1a = pick(1,10);
    p1b = pick(1,11);
    p2a = pick(1,13);
    truncate = pick(1,13);
    p2b =(int)(truncate + 0.5);
    System.out.println("You have " + p1a + " & " + p1b);
    hit();
    next();
  }
  public void next()
  {
    if( p2a+p2b>21)
    {
      System.out.println("________________________________");
      System.out.println("The NPC was busted with " + (p2a + p2b) );
      System.out.println("You Won!");
      coin.winMoney();
      coin.checkMoney();
      if(coin.equals(c))
      {
        System.out.println("Man you are broke");
      }
      questionA();
    } 
    else if( p1a+p1b+p1c>21)
    {
      System.out.println("________________________________");
      System.out.println("You Lost!");
      System.out.println("You are busted with " + (p1a + p1b + p1c) );
      compare = coin.getMoney();
      if(compare.compareTo(compare) == 1)
      {
        System.out.println("Player got " + compare + " coins");
      }
      coin.loseMoney(coin.getMoney());
      coin.checkMoney();
      questionA();
    }
    else if (p2a+p2b>p1a+p1b+p1c)
    {
      System.out.println("________________________________");
      System.out.println("You Lost!");
      System.out.println( "You had " +(p1a+p1b+p1c));
      System.out.println( "The NPC won with " +(p2a+p2b));
      coin.loseMoney(coin.getMoney());
      coin.checkMoney();
      questionA();
    }
    else if(p1a+p1b+p1c == p2a+p2b)
    {
      System.out.println("________________________________");
      System.out.println("It was a draw");
      System.out.println("You both tied with " +(p1a+p1b));
      questionA();
    }
    else 
    {
      System.out.println("________________________________");
      System.out.println( "You won with " +(p1a+p1b+p1c));
      System.out.println( "Your opponent had " +(p2a+p2b));
      coin.winMoney();
      coin.checkMoney();
      if(coin.equals(c))
      {
        System.out.println("Man you are broke");
      }
      questionA();
    }
  }
  public void question()
  {
    System.out.println("Do you wanna start or do you need help?");
    System.out.println("1.Start");
    System.out.println("2.Help");
    System.out.println("3.Leave");
    Scanner s = new Scanner(System.in);
    try
    {
      user.setAnswer(s.nextInt());
    }
    catch(Exception e)
    {
      System.out.println("Please input a number for what you need.");
      question();
    }
  }
  public void endQuestion()
  {
    System.out.println("________________________________");
    System.out.println("Type 1 to play again and 3 to leave");
    System.out.println("If you leave your coins will not save and be set to 0");
    System.out.println("1.Play Again");
    System.out.println("2.Help I forgot how to play");
    System.out.println("3.Leave");
    System.out.println("________________________________");
    Scanner s = new Scanner(System.in);
    try
    {
      user.setAnswer(s.nextInt());
    }
    catch(Exception e)
    {
      System.out.println("Please input a number for what you need.");
      endQuestion();
    }
  }
  public void back()
  {
    if(user.getAnswer() == 2)
    {
      System.out.println("This is how you play");
      coinExplain= "Only the winners received coins. The amount of coins you get is randomly generated";
      System.out.println( "you start with " + deck + " cards");
      System.out.println(coinExplain);
      System.out.println("You the user are going against an npc");
      System.out.println("You have to get 21 or at least close to it to win");
      System.out.println("You can get lower than 21, but can't go over or else you instantly lose");
      System.out.println("If you both get the same amount then it is a tie and no one win or lose");
      System.out.println("Type the number 1 to go back to the Start");
      goBack();
    }
    else if(user.getAnswer() == 1)
    {
      System.out.println("The game begins");
      game();
    }
    else if(user.getAnswer() == 3)
    {
      System.exit(0);
    }
    else
    {
      questionB();
    }
  }
  
  public void goBack()
  {
    Scanner s = new Scanner(System.in);
    try
    {
      user.setAnswer(s.nextInt());
    }
    catch(Exception e)
    {
      System.out.println("Please input the number 1 go back to the Start.");
      goBack();
    }
    if(user.getAnswer() == 1)
    {
      questionB();
    }
    if(user.getAnswer() != 1)
    {
      System.out.println("You have to type 1 to go back");
      goBack();
    }
  } 
  
  public void start()
  {
    while(user.getAnswer() < 1 || user.getAnswer() > 2 )
    {
      questionB();
    }
  }
  public void questionB()
  {
    question();
    back();
  }
  public void questionA()
  {
    endQuestion();
    back();
  }
  public int pick(int min,int max)
  {
    num = (int)(Math.random()*(max-min+1)+min);
    return num;
  }
  public void hit()
  {
    System.out.println("Would you like to hit? \n 1:hit \n 2:don't hit");
    Scanner h = new Scanner(System.in);
    try
    {
      hitscan=(h.nextInt());
    }
    catch(Exception e)
    {
      System.out.println("Please input a number for what you need.");
      hit(); 
    }
    if (hitscan == 1)
    {
      p1c= pick(1,13);
      System.out.println("You got a " + p1c);
    }
    else if (hitscan == 2)
    {
      p1c = 0;
    }
    else
    {
      System.out.println("Please enter 1 or 2");
      hit();
    }
  }
}
