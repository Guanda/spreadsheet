/**
 * CSVParser.java will help us to read the target.csv
 * and generate the result.csv
 */
package edu.pitt.guandaw.spreadsheet.parser;

import java.io.BufferedReader;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import edu.pitt.guandaw.spreadsheet.model.Cell;
import edu.pitt.guandaw.spreadsheet.processor.DataProcessor;
import edu.pitt.guandaw.spreadsheet.processor.ProcessorFactory;

/**
 * @author Guanda Wang
 *
 */
public class CSVParser {
  public static Map<String, Cell> excel = new HashMap<String, Cell>();
  
  public static void main(String[] args)
  { 
    try {
      BufferedReader b = new BufferedReader(new FileReader(new File("target.csv")));
      
      File file = new File("temp.csv");
      file.createNewFile();
      
      FileWriter f = new FileWriter(new File("temp.csv"));
      String line;
      DataProcessor processor;
      try 
      {
        int row = 1; // row
        StringBuilder resultLine;
        while((line = b.readLine()) != null)
        {
          resultLine = new StringBuilder();
          //System.out.println(line);
          String[] cells = line.split(",");
          for(int i = 0; i < cells.length; i++)
          {
            char column = (char)(65+i);
            String cell = cells[i].trim();
            // strategy
            processor = ProcessorFactory.getProcessor(cell);
            Cell result = processor.processData(cell);
            String key = ""+column+row;
            excel.put(key, result);// reference HashMap
            if(result == null)
            {
              resultLine.append(cell).append(", ");
            }
            else 
            {
              resultLine.append(result).append(", ");
            }
          }
          f.write(resultLine.toString().substring(0, resultLine.length() - 2));
          f.write("\n");
          row++;
        }
        f.flush();
        f.close();
        b.close();
      } 
      catch (IOException e) 
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } 
    catch (FileNotFoundException e) 
    {
      // TODO
      e.printStackTrace();
    }
    catch (IOException e1) 
    {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    
    try 
    {
      BufferedReader b = new BufferedReader(new FileReader(new File("temp.csv")));
      
      File file2 = new File("result.csv");
      file2.createNewFile();
      
      FileWriter f = new FileWriter(new File("result.csv"));
      String line;
      try 
      {
        StringBuilder resultLine = new StringBuilder();
        DataProcessor processor;
        while((line = b.readLine()) != null)
        {
          resultLine = new StringBuilder();
          String[] cells = line.split(",");
          for(int i = 0; i < cells.length; i++)
          {
            String cell = cells[i].trim();
            // strategy
            processor = ProcessorFactory.getProcessor(cell);
            Cell result = processor.processData(cell);
            if(result == null)
            {
              resultLine.append(cell).append(", ");
            } 
            else 
            {
              resultLine.append(result).append(", ");
            }
          }
          f.write(resultLine.toString().substring(0, resultLine.length() - 2));
          f.write("\n");
        }
        f.flush();
        f.close();
        b.close();
      } 
      catch (IOException e) 
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } 
    catch (FileNotFoundException e) 
    {
      // TODO
      e.printStackTrace();
    } 
    catch (IOException e1) 
    {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
  }
}