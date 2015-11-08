package knn;

import knn.Mush;
import knn.MushFactory;
import knn.MushValidationFactory;
import knn.Validator;
import knn.KNN;

public class TestClassify {

	public static void main(String args[]){
		Mush[] mush = MushFactory.getAllMush();
		Mush[] mush_test = MushValidationFactory.getAllMush();
		KNN<Mush> knn = new KNN<Mush>(3,mush);
		//System.out.println("Try to classify " + mush_test[0].getClasse() + ". \nResult = " + knn.classify(mush_test[0]));
		Validator<Mush> va = new Validator<Mush>(knn,mush_test);
		va.generateReport();
	}

}

