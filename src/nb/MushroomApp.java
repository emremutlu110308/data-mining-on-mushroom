package nb;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import org.apache.poi.hssf.usermodel.*;  
import org.apache.poi.openxml4j.opc.OPCPackage;  
import org.apache.poi.poifs.filesystem.POIFSFileSystem;  
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;  
import org.apache.poi.xssf.usermodel.XSSFRow;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 

public class MushroomApp {
	
	private static ArrayList<Mushroom> trainingDataSet = new ArrayList<Mushroom>();
	private static ArrayList<Mushroom> testingDataSet = new ArrayList<Mushroom>();
	private static ArrayList<String> attributes = new ArrayList<String>();
	private static final int TRAINING_SHEET_NUMBER = 3;
	private static final int TESTING_SHEET_NUMBER = 4;	
	
	
	private static final String TRAINING_SHEET_PATH = "src/nb/CleanData_V3.xlsx";
	private static final String TESTING_SHEET_PATH = "src/nb/CleanData_V3.xlsx";
	
	private static Map<String, Object> countAiMap = new HashMap<String, Object>();
	private static Map<String, Object> countAiCiMap = new HashMap<String, Object>();
	private static final String CLASS_DISTRIBUTION = "class-distribution";
	private static char EDITABLE = 'e';
	private static char POISONOUS = 'p';
	private static int numOfTrainingClassLabel1=0;
	private static int numOfTrainingClassLabel2=0;
	
	public static void main(String[] args) {
		trainingDataSet = readData(TRAINING_SHEET_PATH, TRAINING_SHEET_NUMBER);
		testingDataSet = readData(TESTING_SHEET_PATH, TESTING_SHEET_NUMBER);
        trainModel();
        testingModel();
	}
   
	public static ArrayList<Mushroom> readData(String path, int sheetNumber) {
		// TODO Auto-generated method stub
		XSSFWorkbook workbook = null;  
		ArrayList mushroomList = new ArrayList<Mushroom>(); 
		
		//read training data
		try {   
			workbook = new XSSFWorkbook(new FileInputStream(path));  
			XSSFSheet firstSheet = workbook.getSheetAt(sheetNumber);
			Iterator<Row> iterator = firstSheet.iterator();
			
			//get first row which is the name of attribute
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if(!cell.getStringCellValue().trim().equals("")){
                     attributes.add(cell.getStringCellValue().trim());
                }
            }
			
			//get following row and initialize that attribute being used and 
			//separate training data sets and testing data set
			int rowNumber=1;
			while (iterator.hasNext()) {
		            nextRow = iterator.next();
		            cellIterator = nextRow.cellIterator();
                    Mushroom mushroom = new Mushroom();
		            int counter = 0;
                    while (cellIterator.hasNext()) {
		                Cell cell = cellIterator.next();
		                if(!cell.getStringCellValue().trim().equals("")){
		             
		                       mushroom.setAttributeByAttributeName(attributes.get(counter), 
		                		       cell.getStringCellValue().trim().charAt(0));
		                       counter++;
		                }
                    }
                    
                    mushroomList.add(mushroom); 
                    rowNumber++;
			}
		     workbook.close();
			
		} catch (IOException e) {  
			e.printStackTrace();  
		}  
	    return mushroomList;
	}
	
	

    public static void trainModel(){
    	 for (Mushroom mushroom:trainingDataSet){
    		 
    		 for(int i=0; i<attributes.size(); i++){
    			 String attribute = attributes.get(i);
    			 char classChar = mushroom.getClassDistribution();
    			 
    			 //count number of occurrence of AiCi, a number represent the 
    			 //order of the atrribute will be added before the attribute value
    			 if(!attribute.equals(CLASS_DISTRIBUTION)){
    				 char Ai = mushroom.getAttributeByAttributeName(attribute);
    			     String AiCi = Integer.toString(i)+ Character.toString(Ai)+Character.toString(classChar);
    		         if(!countAiCiMap.containsKey(AiCi)){
    		        	 int val = 0;
    		        	 countAiCiMap.put(AiCi, val+1);
    		         }
    		         else{
    		        	 int val = (Integer) countAiCiMap.get(AiCi);
    		        	 countAiCiMap.put(AiCi, val+1);
    		         }
    		         
    		         //count the number of Ai to calculate P(Ai)
    		         String myAi = Integer.toString(i) + Character.toString(Ai); 
    		         if(!countAiMap.containsKey(myAi)){
    		        	 int val = 0;
    		        	 countAiMap.put(myAi, val+1);
    		         }
    		         else{
    		        	 int val = (Integer) countAiMap.get(myAi);
    		        	 countAiMap.put(myAi, val+1);
    		         }
    			 }
    			 else{
    				 if(classChar==EDITABLE){
    					 numOfTrainingClassLabel1++;
    				 }
    				 else{
    					 numOfTrainingClassLabel2++;
    				 }
    			 }
    		 }
    	}
    }
    
    public static void testingModel(){
    	
    	int numTruePositive = 0;
    	int numFalsePositive = 0;
    	int numTrueNegative = 0;
    	int numFalseNegative = 0;
    	
    	for(Mushroom mushroom : testingDataSet){
    		char actualClass = mushroom.getClassDistribution();
    	    char predictClass;
    	    
    	    if (calculateProbability(mushroom, EDITABLE)>calculateProbability(mushroom, POISONOUS)){
    	    	predictClass = EDITABLE;
    	    }
    	    else{
    	    	predictClass = POISONOUS;
    	    }
    	    
    	    if((actualClass == EDITABLE) &&(predictClass == EDITABLE)){
    	    	numTruePositive++;
    	    }
    	    
    	    if((actualClass == EDITABLE) &&(predictClass == POISONOUS)){
    	    	numFalseNegative++;
    	    }
    	    
    	    if((actualClass == POISONOUS) &&(predictClass == EDITABLE)){
    	    	numFalsePositive++;
    	    }
    	    
    	    if((actualClass == POISONOUS) &&(predictClass == POISONOUS)){
    	    	numTrueNegative++;
    	    }
    	}
    	
    	double accuracy = (double)(numTruePositive+numTrueNegative)/
         (numTruePositive+numFalseNegative+numFalsePositive+numTrueNegative);
        double precision = (double)numTruePositive/(numTruePositive+numFalsePositive);
        double recall = (double)numTruePositive/(numTruePositive+numFalseNegative);
        double fMeasure = 2*precision*recall/(precision+recall);
    	
    	System.out.println("===================================================");
	    System.out.println("                  ||        Predict Class        ||");
	    System.out.println("                  ||===============================");
	    System.out.println("                  || Edible      ||   Poisonous ||");
	    System.out.println("===================================================");
	    System.out.println("Actual|| Edible   ||    " + numTruePositive + "         ||    " + numFalseNegative+"       ||");
	    System.out.println("      ||============================================");
	    System.out.println("Class || Poisonous||    " + numFalsePositive + "         ||    " + numTrueNegative+"      ||");
	    System.out.println("===================================================");
	    
	    System.out.println();
	    System.out.println();
	    
	    System.out.println("===================================================");
	    System.out.println("Overall Accuracy is: " + accuracy);
	    System.out.println("Overall Precision is: " + precision);
	    System.out.println("Overall F-Measure is: " + fMeasure);
    }
   
    public static double calculateProbability(Mushroom mushroom, char classLabel){
    	
    	int numOfTrainingClassLabel;
    	if(classLabel == EDITABLE){
    		numOfTrainingClassLabel = numOfTrainingClassLabel1;
    	}
    	else{
    		numOfTrainingClassLabel = numOfTrainingClassLabel2;
    	}
    	
    	double totalPAiCi = 1;
    	double totalPAi = 1;
    	String Ai = "";
    	for(int i=0; i<attributes.size(); i++){
    		char attrChar = mushroom.getAttributeByAttributeName(attributes.get(i));
    		String key = Integer.toString(i)+Character.toString(attrChar)+Character.toString(classLabel);
    		
    		//make Laplace adjustment
    		double nominator=1;
    		if(countAiCiMap.containsKey(key)){
    			nominator = ((Integer) countAiCiMap.get(key)).doubleValue() + 1;
    		}
    		
    		totalPAiCi = totalPAiCi * nominator/(numOfTrainingClassLabel + 2); 
    		
    		//make Laplace adjustment
    		String key2 = Integer.toString(i)+Character.toString(attrChar);
    		nominator=1;
    		if(countAiMap.containsKey(key2)){
    			nominator = ((Integer) countAiMap.get(key2)).doubleValue() + 1;
    		}
        	totalPAi = totalPAi * nominator /(numOfTrainingClassLabel1 + numOfTrainingClassLabel2 + 2); 
        	
    	}    	
    	return (double)totalPAiCi * ((double)numOfTrainingClassLabel/(numOfTrainingClassLabel1 + numOfTrainingClassLabel2))/(double)totalPAi;
    }
}
