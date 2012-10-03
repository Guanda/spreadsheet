/**
 * 
 */
package edu.pitt.guandaw.spreadsheet.processor;

import edu.pitt.guandaw.spreadsheet.model.Cell;

/**
 * @author Guanda Wang
 *
 */
public class RawDataProcessor implements DataProcessor{

  /* (non-Javadoc)
   * @see edu.pitt.guandaw.spreadsheet.processor.DataProcessor#processData(java.lang.String)
   */
  @Override
  public Cell processData(String s) 
  {
    return new Cell(s);
  }
}
