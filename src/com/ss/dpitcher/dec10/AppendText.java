package com.ss.dpitcher.dec10;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author David Pitcher
 *
 */
public class AppendText
{
	//args[0] should be the pathname to a file you want to add text to. Further arguments will be the lines of text to add to the file.
	//
	//Make sure to use quotation marks correctly in arguments, e.g.,
	//	"Hello my name is David" is a single argument and thus will be a line written to the file.
	public static void main(String[] args)
	{
		File file = new File(args[0]);//attempt to get the specified file
		
		if(file.exists() && file.isFile() && file.canWrite())//file validation
		{
			int count = 0;//set up a counter to keep track of how many lines we've written
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)))
			{
				for(int i = 1; i < args.length; i++)//iterate through all arguments after the first
				{
					String line = args[i];//each of these arguments will be a line written to the file
					
					bw.append(line);
					bw.newLine();
					bw.flush();
					count++;
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();//print any errors
			}
			System.out.println("Written "+count+" lines to "+file.getName()+".");
		}
		else
		{
			System.out.println("Invalid file path. Now exiting.");
			System.exit(1);
		}
	}
}
