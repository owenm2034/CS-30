package Monus;

import java.util.ArrayList;

public class TestResults
{
  private ArrayList<StudentAnswerSheet> sheets;

  public TestResults(ArrayList<StudentAnswerSheet> shs)
  {
    sheets = new ArrayList<StudentAnswerSheet>();
    for (StudentAnswerSheet s : shs)
      sheets.add(s);
  }

  /** Precondition: sheets.size() > 0;
   *                all answer sheets in sheets have the same number of answers
   * @param key the list of correct answers represented as strings of length one
   *        Precondition: key.size() is equal to the number of answers
   *                      in each of the answer sheets in sheets
   * @return the name of the student with the highest score
   */
  public String highestScoringStudent(ArrayList<String> key)
  {
    // part B
    int highestScore = Integer.MIN_VALUE;
    String highestScorersName = null;
    for (StudentAnswerSheet sheet : sheets) {
      if ((sheet.getScore(key)) > highestScore) {
        highestScore = (int) (sheet.getScore(key));
        highestScorersName = sheet.getName();
      }
    }
    return highestScorersName;
  }
}
