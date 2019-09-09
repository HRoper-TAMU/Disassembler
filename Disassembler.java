/*
Hayden Roper
926004150
*/

import java.util.*;
import java.io.*;

public class Disassembler 
{
	public static void main(String[] args)
	{
		//preload the symbol tables into maps
		Map<String,String> comp = new HashMap<String,String>(); //swapped
		comp.put("0101010","0");
		comp.put("0111111","1");
		comp.put("0111010","-1");
		comp.put("0001100","D");
		comp.put("0110000","A");
		comp.put("0001101","!D");
		comp.put("0110001","!A");
		comp.put("0001111","-D");
		comp.put("0110011","-A");
		comp.put("0011111","D+1");
		comp.put("0110111","A+1");
		comp.put("0001110","D-1");
		comp.put("0110010","A-1");
		comp.put("0000010","D+A");
		comp.put("0010011","D-A");
		comp.put("0000111","A-D");
		comp.put("0000000","D&A");
		comp.put("0010101","D|A");
		comp.put("1110000","M");
		comp.put("1110001","!M");
		comp.put("1110011","-M");
		comp.put("1110111","M+1");
		comp.put("1110010","M-1");
		comp.put("1000010","D+M");
		comp.put("1010011","D-M");
		comp.put("1000111","M-D");
		comp.put("1000000","D&M");
		comp.put("1010101","D|M");
		
		Map<String,String> dest = new HashMap<String,String>(); //swapped for disassembler
		dest.put("000","");//null
		dest.put("001","M");
		dest.put("010","D");
		dest.put("100","A");
		dest.put("011","MD");
		dest.put("101","AM");
		dest.put("110","AD");
		dest.put("111","AMD");
		
		Map<String,String> jump = new HashMap<String,String>(); //swapped
		jump.put("000","");//null
		jump.put("001","JGT");
		jump.put("010","JEQ");
		jump.put("011","JGE");
		jump.put("100","JLT");
		jump.put("101","JNE");
		jump.put("110","JLE");
		jump.put("111","JMP");
		
		Scanner in;
		try
		{	
		
			in = new Scanner(System.in);
			
			//pw = new PrintWriter(fout);
			int max = Integer.parseInt(in.nextLine());
			if(max>=1&&max<=30000)
			{
			for(int i=0;i<max;i++)
			{
				
				String line = in.nextLine();
				if(line!="")
				{
				//convert each binary symbol into .asm output 
				//first 3 A or C
				if(line.charAt(0)=='1')
				{
					//comp
					String c = line.substring(3,10);
					//dest
					String d = line.substring(10,13);
					//hump
					String j = line.substring(13);
					if(dest.get(d)!=""&&dest.get(d)!=null)
					{
						System.out.print(dest.get(d) + "=");
					}
					if(comp.get(c)!=null&&comp.get(c)!="")
					{
						System.out.print(comp.get(c));
					}
					if(jump.get(j)!=""&&jump.get(j)!=null)
					{
						System.out.print(";" + jump.get(j));
					}
					System.out.println();
					
				}
				else
				{
					//System.out.print("@");
					String sub = line.substring(1);
					int add = Integer.parseInt(sub,2);
					System.out.println("@" + add);
				}
					//if A go from binary to decimal num +@
					//if C look at other parts
				//next 7 are comp
					//use comp map to print 
				//next 3 dest --print before comp
					//use dest map to print first unless null
				//nest 3 jump
					//use jump map to print unless null
				}
				
			}
			}
			
			in.close();
		}
	catch(Exception e)
	{
		
	}	
		
		
		
	}
}