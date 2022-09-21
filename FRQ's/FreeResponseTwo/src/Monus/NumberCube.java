package Monus;

public class NumberCube
{
  /** @return an integer value between 1 and 6, inclusive
    */
  public int toss()
  { 
    return (int) (Math.random() * 6) + 1;
  }
  
  public static void main(String[] args)
  {
    NumberCube cube = new NumberCube();
    for (int i = 0; i < 10; i++)
      System.out.println(cube.toss());
  }
}