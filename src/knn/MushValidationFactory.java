package knn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class MushValidationFactory {
	

	public static Mush[] getAllMush()
	{
		Mush[] pf = null;
		String csvFile = MushValidationFactory.class.getResource("/knn/mush.validation.txt").getPath();
		BufferedReader br = null;
		String csvSplitBy = ",";
	 
		try {
	 
			br = new BufferedReader(new FileReader(csvFile));
			StringBuffer fileb = new StringBuffer();
			while (br.ready()) {
				fileb.append(br.readLine() + "\n");
			}
			String file = fileb.toString();
			        // use comma as separator
			String[] line = file.split("\n");
			pf = new Mush[line.length];
			for(int i = 0; i < line.length; i++)
			{
				
				String[] item = line[i].split(csvSplitBy);
				String[] d = new String[item.length];
				d[0] = "1";
				for(int index = 1; index < item.length; index++)
				{
					d[index] = item[index-1];
				}
				//attribute, class name,line/id
				pf[i] = new Mush(d, item[7],i);
				
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
		//shuffleArray(pf);
		return pf;
	}
	
	static void shuffleArray(Mush[] ar)
	  {
	    Random rnd = new Random();
	    for (int i = ar.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      Mush a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	  }
}

