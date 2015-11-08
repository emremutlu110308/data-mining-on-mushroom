package knn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class MushFactory {
	

	public static Mush[] getAllMush()
	{
		Mush[] pf = null;
		String csvFile = MushFactory.class.getResource("/knn/mush.data.txt").getPath();
		BufferedReader br = null;
		String csvSplitBy = ";";
	 
		try {
	 
			br = new BufferedReader(new FileReader(csvFile));
			StringBuffer fileb = new StringBuffer();
			while (br.ready()) {
				fileb.append(br.readLine() + "\n");
			}
			String file = fileb.toString();
			// use semicolon as separator
			String[] line = file.split("\n");
			pf = new Mush[line.length];
			for(int i = 0; i < line.length; i++)
			{
				//for each line of data, to split attributes of it
				String[] item = line[i].split(csvSplitBy);			
				String[] d = new String[item.length];		
				d[0] = "1";
				for(int index = 1; index < item.length; index++)
				{
					d[index] = item[index-1];
				}
				//attribute, class name,line/id
				pf[i] = new Mush(d, item[7],i);
				//System.out.println(pf[i]);
			}
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//Simple swaps among instances
		//shuffleArray(pf);
		return pf;
	}
	
	static void shuffleArray(Mush[] ar)
	  {
	    Random rnd = new Random();
	    for (int i = ar.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap : ar[index] & ar[i] 
	      Mush a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	  }
}
