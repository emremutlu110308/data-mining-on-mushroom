package knn;

import java.util.Arrays;
import java.util.LinkedList;

import knn.DatasetType;

class DistancePoint implements Comparable<DistancePoint>
{
	public double distance;
	public int indexInDataset;
	@Override
	public int compareTo(DistancePoint arg) {
		if (distance > arg.distance)
			return 1;
		else if (distance == arg.distance)
			return 0;
		else
			return -1;
	}
	
}

public class KNN<T extends DatasetType> extends Classifier<T> {
	
	int k;
	T[] dataset;
	
	public KNN(int k, T[] dataset)
	{
		this.k = k;
		this.dataset = dataset;
	}
	
	public String classify(T elem)
	{
		
		//take all classes
		LinkedList<String> l = new LinkedList<String>();
		for(int i = 0; i < dataset.length; i++)
		{
			if (l.contains(dataset[i].getClasse()) == false)
				l.add(dataset[i].getClasse());
		}
		
		//Hamming distance computed for each element
		DistancePoint[] distances = new DistancePoint[dataset.length];
		for(int i = 0; i < dataset.length; i++)
		{
			distances[i] = new DistancePoint();
			distances[i].indexInDataset = i;
			distances[i].distance = getHammingDistance(dataset[i],elem);
//			if (distances[i].distance == 0.0){
//				System.out.println("++++++++++++++++++++++++++++++++++++++++");
//				System.out.println(distances[i].distance);
//				System.out.println("+++++++++++++++++++++++++++++++++++++++++");
//			}
			
			
		}
				
		//orders based on 鈥嬧�媎efined in DistancePoint
		Arrays.sort(distances);
				
		//finds minimum distance
		int[] count = new int[l.size()];

		for(int i = 0; i < k; i++)
		{
			//System.out.println("****");
			//System.out.println("i: "+ i + "d" + distances[i].distance);
			for(int j = 0; j < l.size(); j++)
			{
				if (dataset[distances[i].indexInDataset].getClasse().compareTo(l.get(j)) == 0)
				{
					count[j]++;					
					break;
				}				
			
			}
			
		}
		
		// Default: if the count for two classes is equal, choose the class in advance.
		int max_count = Integer.MIN_VALUE;
		int target = -1;
		//System.out.println("l.size:"+ l.size());
		for(int i = 0; i < l.size(); i++)
		{
			//System.out.println("Count"+ i + ":" + count[i]);
			if (max_count < count[i])
			{
				max_count = count[i];
				target = i;
			}
		}
		
		if (target == -1)
			System.out.println("Erro in the computation");
		//System.out.println("target: " + target + " class: " + l.get(target));
		return l.get(target);
	}
	

//	public double minkowski_distance(T elem1, T elem2, int q)
//	{
//		double dist = 0;
//		for(int i = 0; i < elem1.getNumAttr(); i++)
//		{
//			dist += Math.pow(Math.abs(elem1.getAttr(i) - elem2.getAttr(i)),q); 
//		}
//		dist = Math.pow(dist, 1f/q);
//		
//		return dist;
//	}
	

    //From my point the following implementation would be ok:
	public double getHammingDistance(T elem1, T elem2) {

		double result = 0;
				
		for(int i = 0; i < elem1.getNumAttr(); i++){
			String sequence1 = elem1.getAttr(i);
			String sequence2 = elem2.getAttr(i);
			//System.out.println(sequence1);
			//System.out.println(sequence2);
			char[] s1 = sequence1.toCharArray();
			char[] s2 = sequence2.toCharArray();
			//int shorter = Math.min(s1.length, s2.length);
			//int longest = Math.max(s1.length, s2.length);
			for (int j=0; j<s1.length; j++) {
				if (s1[j] != s2[j]) result++;
			}
		}	
		//result += longest - shorter;
		return result;
}
 
}
