package com.ss.dpitcher.dec10;

import java.io.File;

/**
 * 
 * @author David Pitcher
 *
 */
public class GetFilenames
{
	//args[0] should be the pathname of the directory you want to search
	public static void main(String[] args)
	{
		File dir = new File(args[0]);//attempt to create a File object from the pathname given
		
		if(dir.exists() && dir.isDirectory())//folder validation
		{
			String[] fileNames = dir.list();//retrieve all files under this directory with no filter
			
			for(String name : fileNames)
			{
				System.out.println(name);//print them one at a time
			}
		}
		else
		{
			System.out.println("Invalid directory path. Now exiting.");
			System.exit(1);
		}
	}
}
