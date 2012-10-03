/**
 * 
 */
package edu.pitt.guandaw.spreadsheet.processor;

import edu.pitt.guandaw.spreadsheet.model.Cell;
import edu.pitt.guandaw.spreadsheet.parser.CSVParser;

/**
 * @author Guanda Wang
 *
 */
public class ReferenceProcessor implements DataProcessor
{

  /* (non-Javadoc)
   * @see edu.pitt.guandaw.spreadsheet.processor.DataProcessor#processData(java.lang.String)
   */
  @Override
  public Cell processData(String s) 
  {
    return CSVParser.excel.get(s.substring(1));
  }
}
