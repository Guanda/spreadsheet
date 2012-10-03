/*
 * @author: Guanda Wang
 * 
 */

package edu.pitt.guandaw.spreadsheet.model;

public class Cell {
	private int n;

	private float f;
	private boolean sign; // true => float

	public Cell add(Cell cell) 
	{
		if (this.sign || cell.isSign()) 
		{
			if (this.sign && cell.isSign()) 
			{
				return new Cell(String.valueOf(f + cell.getF()));
			} 
			else 
			{
				if (this.sign) 
				{
					return new Cell(String.valueOf(f + cell.getN()));
				} 
				else 
				{
					return new Cell(String.valueOf(cell.getF() + n));
				}
			}
		} 
		else 
		{
			return new Cell(String.valueOf(n + cell.getN()));
		}
	}

	public Cell minus(Cell cell) 
	{
		if (this.sign || cell.isSign()) 
		{
			if (this.sign && cell.isSign()) 
			{
				return new Cell(String.valueOf(f - cell.getF()));
			}
			else 
			{
				if (this.sign) 
				{
					return new Cell(String.valueOf(f - cell.getN()));
				} 
				else 
				{
					return new Cell(String.valueOf(n - cell.getF()));
				}
			}
		} 
		else 
		{
			return new Cell(String.valueOf(n - cell.getN()));
		}
	}

	public Cell multiply(Cell cell) 
	{
		if (this.sign || cell.isSign()) 
		{
			if (this.sign && cell.isSign()) 
			{
				return new Cell(String.valueOf(f * cell.getF()));
			} 
			else 
			{
				if (this.sign) 
				{
					return new Cell(String.valueOf(f * cell.getN()));
				} 
				else 
				{
					return new Cell(String.valueOf(n * cell.getF()));
				}
			}
		} 
		else 
		{
			return new Cell(String.valueOf(n * cell.getN()));
		}
	}

	public Cell divide(Cell cell) 
	{
		if (this.sign || cell.isSign()) 
		{
			if (this.sign && cell.isSign()) 
			{
				return new Cell(String.valueOf(f / cell.getF()));
			} 
			else 
			{
				if (this.sign) 
				{
					return new Cell(String.valueOf(f / cell.getN()));
				} 
				else 
				{
					return new Cell(String.valueOf(n / cell.getF()));
				}
			}
		} 
		else 
		{
			return new Cell(String.valueOf(n / cell.getN()));
		}
	}

	public boolean isSign() 
	{
		return sign;
	}

	public void setSign(boolean sign) 
	{
		this.sign = sign;
	}

	public Cell(String s) 
	{
		if (s.contains(".")) 
		{
			this.f = Float.parseFloat(s);
			this.sign = true;
		}
		else 
		{
			this.n = Integer.parseInt(s);
			this.sign = false;
		}
	}

	public int getN() 
	{
		return n;
	}

	public void setN(int n) 
	{
		sign = false;
		this.n = n;
	}

	public float getF() 
	{
		return f;
	}

	public void setF(float f) 
	{
		sign = true;
		this.f = f;
	}

	public String toString() 
	{
		if (sign) 
		{
			return String.valueOf(this.f);
		} 
		else 
		{
			return String.valueOf(this.n);
		}
	}

	/*
	 * public static void main(String[] args)
	 * { 
	 * 		Systenew Cell(); 
	 * }
	 */
}
