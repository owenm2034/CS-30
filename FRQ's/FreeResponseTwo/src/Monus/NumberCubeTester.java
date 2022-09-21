package Monus;

public class NumberCubeTester
{
  /** Returns an array of the values obtained by tossing a number cube numTosses times.
    *  @param cube a NumberCube
    *  @param numTosses the number of tosses to be recorded
    *         Precondition: numTosses > 0
    *  @return an array of numTosses values
    */
  public static int[] getCubeTosses(NumberCube cube, int numTosses)
  {
   // part a
      int[] tossResults = new int[numTosses];
      for (int i = 0; i < tossResults.length; i++) {
          tossResults[i] = cube.toss();
      }
      return tossResults;
  }

  /** Returns the starting index of a longest run of two or more consecutive repeated values
    *  in the array values.
    *  @param values an array of integer values representing a series of number cube tosses
    *         Precondition: values.length > 0
    *  @return the starting index of a run of maximum size;
    *          -1 if there is no run
    */
  public static int getLongestRun(int[] values) {
      // part b
      int longestRun = Integer.MIN_VALUE;
      int startingPosition = -1;
      for (int i = 1; i < values.length; i++) {
          boolean onRun = true;
          int currentRun = 0;
          int a = values[i - 1];
          int b = values[i];
          while (onRun) {
              if (a == b) {
                  currentRun++;
                  if (i + currentRun < values.length ) {
                      b = values[i + currentRun];
                  }
                  else {
                      onRun = false;
                  }
                  if (currentRun > longestRun) {
                        longestRun = currentRun;
                        startingPosition = i -1;
                  }
              }
              else {onRun = false;}
          }
      }
      return startingPosition;
  }

 public static void main(String[] args)
  {
    NumberCube cube = new NumberCube();

    // test getCubeTosses
    int[] results = NumberCubeTester.getCubeTosses(cube,10);
    if (results.length != 10)
      System.out.println("getCubeTosses returned an array that was the wrong size");
    else
      System.out.println("returned an array of the correct size");
    System.out.println("10 cube toss results:");
    for (int i = 0; i < results.length; i++)
    {
      System.out.print(results[i] + " ");
    }
    System.out.println();
    results = NumberCubeTester.getCubeTosses(cube,5);
     if (results.length != 5)
      System.out.println("getCubeTosses returned an array that was the wrong size");
     else
      System.out.println("returned an array of the correct size");
    System.out.println("5 cube toss results:");
    for (int i = 0; i < results.length; i++)
    {
      System.out.print(results[i] + " ");
    }
    System.out.println();
    // test find longest run
    // longest run at front
    int[] t1 = {1,1,1,1,3,3};
    int pos = NumberCubeTester.getLongestRun(t1);
    if (pos != 0)
      System.out.println("error on {1, 1, 1, 1, 3, 3}");
    else
      System.out.println("found correct index for longest run");
    System.out.println("longest run at " + pos + " for {1, 1, 1, 1, 3, 3}");
    // longest run at end
    int[] t2 = {1,1,2,3,3,3};
    pos = NumberCubeTester.getLongestRun(t2);
    if (pos != 3)
      System.out.println("error on {1,1,2,3,3,3}");
    else
      System.out.println("found correct index for longest run");
    System.out.println("longest run at " + pos + " for {1,1,2,3,3,3}");
    // no longest run
    int[] t3 = {1,2,3,4,5};
    pos = NumberCubeTester.getLongestRun(t3);
    if (pos != -1)
      System.out.println("error on {1,2,3,4,5}");
    else
      System.out.println("found correct index for longest run");
    System.out.println("longest run at " + pos + " for {1,2,3,4,5}");
    // test longest run in the middle
    int[] t4 = {1, 1, 2, 3, 3, 3, 4};
    pos = NumberCubeTester.getLongestRun(t4);
    if (pos != 3)
      System.out.println("error on  {1, 1, 2, 3, 3, 3, 4}");
    else
      System.out.println("found correct index for longest run");
    System.out.println("longest run at " + pos + " for {1, 1, 2, 3, 3, 3, 4}");
    // test with two equal length longest runs
     int[] t5 = {1,1,1,1,2,2,2,2};
     pos = NumberCubeTester.getLongestRun(t5);
     if (pos != 0 && pos != 4)
       System.out.println("error on {1,1,1,1,2,2,2,2}");
     else
      System.out.println("found correct index for longest run");
     System.out.println("longest run at " + pos + " for {1,1,1,1,2,2,2,2}");

  }

}