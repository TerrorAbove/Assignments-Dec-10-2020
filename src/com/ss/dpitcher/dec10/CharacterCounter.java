package com.ss.dpitcher.dec10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author David Pitcher
 *
 */
public class CharacterCounter
{
	//program will take two arguments, file path and a single character to look for
	public static void main(String[] args)
	{
		File file = new File(args[0]);//attempt to get the specified file
		final char TARGET = args[1].charAt(0);//we will assume valid arguments passed in
		
		if(file.exists() && file.isFile() && file.canRead())//file validation
		{
			int count = 0;//set up a counter to keep track of occurrences of TARGET
			try (BufferedReader br = new BufferedReader(new FileReader(file)))
			{
				int readChar = -1;//used to store character data and see if we're at the end of document
				while((readChar = br.read()) > -1)//-1 means end of document
				{
					char ch = (char)readChar;
					
					if(ch == TARGET)
					{
						count++;
					}
				}
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			System.out.println("Counted "+count+" occurrences of '"+TARGET+"' in "+file.getName()+".");
		}
		else
		{
			System.out.println("Invalid file specified. System will exit.");
			System.exit(1);
		}
	}
}
