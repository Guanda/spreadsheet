/**
 * 
 */
package edu.pitt.guandaw.spreadsheet.processor;

/**
 * @author Guanda Wang
 *
 */
public class ProcessorFactory 
{
  public static DataProcessor getProcessor(String s)
  {
    if(s.contains("="))
    {
      if(s.contains("+") || s.contains("-") || s.contains("*") || s.contains("/"))
      {
        return new CalculateProcessor();
      }
      else 
      {
        return new ReferenceProcessor();
      }
    } 
    else 
    {
      return new RawDataProcessor();
    }
  }
}
