/**
 * 
 */
package edu.pitt.guandaw.spreadsheet.processor;

import edu.pitt.guandaw.spreadsheet.model.Cell;

/**
 * @author Guanda Wang
 *
 */
public class CalculateProcessor implements DataProcessor
{

  /* (non-Javadoc)
   * @see edu.pitt.guandaw.spreadsheet.processor.DataProcessor#processData(java.lang.String)
   */
  @Override
  public Cell processData(String s) 
  {
    s = s.substring(1);
    String[] calculs= s.split(" ");
    Cell first = new Cell(calculs[0]);
    Cell second = new Cell(calculs[1]);
    
    if(calculs[2].equals("+"))
    {
      return first.add(second);
    }
    else if (calculs[2].equals("-")) 
    {
      return first.minus(second);
    }
    else if (calculs[2].equals("*")) 
    {
      return first.multiply(second);
    }
    else if (calculs[2].equals("/")) 
    {
      return first.divide(second);
    }
    return null; // shouldn't be reached if called properly
  }
  
//  public static void main(String[] args)
//  {
//    System.out.println(new CalculateProcessor().processData("=1 3 +"));
//    System.out.println(new CalculateProcessor().processData("=2 3 *"));
//    System.out.println(new CalculateProcessor().processData("=1.0 3 /"));
//    System.out.println(new CalculateProcessor().processData("=1.5 3.5 +"));
//    System.out.println(new CalculateProcessor().processData("=2 3.0 /"));
//  }
}
