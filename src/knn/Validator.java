package knn;

import java.util.LinkedList;

import knn.DatasetType;

//Class that receives a classifier and evaluates the same
public class Validator<T extends DatasetType> {
	private int[][] confusion;
	LinkedList<String> l;
	T[] datasetValidation;
	
	//passes the classifier already trained
	//and the validation dataset
	
	public Validator(KNN <T> algorithm, T[] datasetValidation)
	{
		this.datasetValidation = datasetValidation;
//		System.out.println("***");
//		System.out.println(datasetValidation.length);
		l = new LinkedList<String>();
		for(int i = 0; i < datasetValidation.length; i++)
		{
			//System.out.println(datasetValidation[i].getClasse());
			if (l.contains(datasetValidation[i].getClasse()) == false)
				l.add(datasetValidation[i].getClasse());
		}
		
		confusion = new int[l.size()][l.size()];
		
		for(int i = 0; i < datasetValidation.length; i++)
		{
			//System.out.println("*");
			int predict_index = -1;
			int desired_index = -1;
			String classe = algorithm.classify(datasetValidation[i]);
			//System.out.println(i + "Ture:" + datasetValidation[i].getClasse());
			//System.out.println(i + "Prediction:" + classe);
			//System.out.println("********");
			//System.out.println("**");	
			
			for(int j = 0; j < l.size(); j++)
			{
				if (classe.compareTo(l.get(j)) == 0)
				{
					predict_index = j;
					break;
				}
			}
			
			for(int j = 0; j < l.size(); j++)
			{
				if (datasetValidation[i].getClasse().compareTo(l.get(j)) == 0)
				{
					desired_index = j;
					break;
				}
			}
			
			confusion[desired_index][predict_index]++;	
			
//			if (desired_index != predict_index){
//				System.out.println("******************************************");
//				System.out.println("Desired: " + desired_index + " class: " + l.get(desired_index));
//				System.out.println("Predicted: " + predict_index + " class: " + l.get(predict_index));
//				System.out.println("Confusion:" + confusion[desired_index][predict_index]);
//				System.out.println("*******************************************");
//			}
			
		}
	}
	
	public double Accuracy()
	{
		int c = 0;
		for(int i = 0; i < l.size(); i++)
		{
			c += confusion[i][i];
		}
		return ((double)c)/datasetValidation.length;
	}
	
	public double Recall(String classe)
	{
		int classe_index = -1;
		for(int i = 0; i < l.size(); i++)
		{
			if (classe.compareTo(l.get(i)) == 0)
			{
				classe_index = i;
				break;
			}
		}
		
		int vp = confusion[classe_index][classe_index];
		int fn = 0;
		for(int i = 0; i < l.size(); i++)
		{
			if (i != classe_index)
			{
				fn += confusion[classe_index][i];
			}
		}
		
		return ((double) vp)/(vp+fn);
	}
	
	public double Precision(String classe)
	{
		int classe_index = -1;
		for(int i = 0; i < l.size(); i++)
		{
			if (classe.compareTo(l.get(i)) == 0)
			{
				classe_index = i;
				break;
			}
		}
		
		int vp = confusion[classe_index][classe_index];
		int fp = 0;
		for(int i = 0; i < l.size(); i++)
		{
			if (i != classe_index)
			{
				fp += confusion[i][classe_index];
			}
		}
		
		return ((double) vp)/(vp+fp);
	}
	
	public double f_measure(String classe, int w)
	{
		return ((w+1)*Recall(classe)*Precision(classe))/(Recall(classe)+(w*Precision(classe)));
	}
	
	public void generateReport()
	{
		System.out.println("Accuracy of the system: " + Accuracy());
		System.out.println();
		for(int i = 0; i < l.size(); i++)
		{
			System.out.println("Class Recall " + l.get(i) + ": " + Recall(l.get(i)));
			System.out.println("Precision Class " + l.get(i) + ": " + Precision(l.get(i)));
			System.out.println("Measure F Class " + l.get(i) + f_measure(l.get(i),1));
			System.out.println();
		}
		
		System.out.println("***************Matrix Confusion****************");
		System.out.println("                              Predict");
		System.out.println("                     Poisonous         Edible");
		
		for(int i = 0; i < l.size(); i++)
		{
			
			
			if (i==0){
				System.out.print("Desired Poisonous");
				for(int j = 0; j < l.size(); j++)
					System.out.print("     " + confusion[i][j] + "         ");		
			}
			else{
				System.out.print("        Edible   ");
				for(int j = 0; j < l.size(); j++)
					System.out.print("     " + confusion[i][j] + "          ");
				
			}
			
			System.out.println();
		}
	}

}
