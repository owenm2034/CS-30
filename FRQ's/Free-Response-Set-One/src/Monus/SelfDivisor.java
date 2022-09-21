package Monus;

public class SelfDivisor
{

  /** @param number the number to be tested
   *         Precondition: number > 0
   *  @return true if every decimal digit of number is a divisor of number;
   *          false otherwise
   */
  public static boolean isSelfDivisor(int number) {
    // part A
    int divisor = number % 10;
    int remainingNum = number;
    while(divisor > 0 && (number % divisor == 0)) {
      remainingNum/=10;
      divisor = remainingNum % 10;
    }
    return divisor == 0;
  }

  /** @param start starting point for values to be checked
   *         Precondition: start > 0
   *  @param num the size of the array to be returned
   *         Precondition: num > 0
   *  @return an array containing the first num integers >= start that are self-divisors
   */
  public static int[] firstNumSelfDivisors(int start, int num)
  {
    // part B
    int[] firstNumSelfDivisors = new int[num];
    int aNum = start;
    for (int i = 0; i < firstNumSelfDivisors.length; i++ ) {
      while (!(isSelfDivisor(aNum))) {
        aNum++;
      }
      firstNumSelfDivisors[i] = aNum;
      aNum++;
    }
    return firstNumSelfDivisors;
  }

  /****************/

  public static void main (String[] args)
  {
    System.out.println("128: " + isSelfDivisor(128));
    System.out.println("26: " + isSelfDivisor(26));
    System.out.println("120: " + isSelfDivisor(120));
    System.out.println("102: " + isSelfDivisor(102));
    for (int n : firstNumSelfDivisors(10, 3))
      System.out.print(n + " ");
    System.out.println();
  }
}
