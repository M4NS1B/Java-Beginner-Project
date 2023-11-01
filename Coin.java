public class Coin
{
  private int money;
  public Coin(int x)
  {
    money = x;
  }
  public Coin()
  {
  }
  public void winMoney()
  {
    money++;
    money+=3;
    money *= (int)((Math.random()+1)*(3));
    money = Math.abs(money);
    money--;
    System.out.println("You now have " + money + " coins");
  }
  public void loseMoney(int x)
  {
    money+= (Integer.MAX_VALUE-Integer.MIN_VALUE);
    if (x > 0)
    {
      int y = (int)((Math.random()+0.5)*(x/2));
      money -= y;
      System.out.println("You lost " + y + " coins");
      System.out.println("You now have " + money + " coins");
    }
    else
    {
      int y = (int)((Math.random()+1)*(x+10));
      money -= y;
      System.out.println("You lost " + y + " coins");
      System.out.println("You now have " + money + " coins");
    }
  }
  public void setMoney(int m)
  {
    money = m;
  }
  public int getMoney()
  {
    return money;
  }
  public void checkMoney()
  {
    if(money >= 1000000000)
    {
      System.out.println("You have reached the maximum coins achievable");
      System.out.println("Congratualtions, you are rich and have beaten the game!");
      System.out.println("Your coins will be reset to 0 now (You wasted all you cash on the stockmarket and it crashed)");
      setMoney(0);
    }
    if (money <= 0)
    {
      System.out.println("You are in debt");
      if(money <= -10000000)
      {
        System.out.println("The load sharks caught you");
        System.out.println("You died from the load sharks");
        setMoney(0);
      } 
    }
  }
  public boolean equals(Coin c)
  {
    return money == c.money;
  }
  public String toString()
  {
    return "Welcome to card game BlackJack \n  Coins: 0";
  }
}
