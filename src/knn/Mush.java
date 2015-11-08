package knn;

import knn.DatasetType;

public class Mush extends DatasetType {
	String[] attr;
	String name;
	int id;
	//String desiredValue;
	
	@Override
	public String getAttr(int index) {
		return attr[index];
	}
	
	@Override
	public void setAttr(int index, String attr) {
		this.attr[index] = attr;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public String getClasse() {
		return name;
	}

	public Mush(String[] attr, String name, int id)
	{
		this.attr = attr;
		this.name = name;
		this.id = id;
	}
	
	@Override
	public int getNumAttr() {
		return 7;
	}

//	@Override
////	public String getDesiredValue() {
////		// TODO Auto-generated method stub
////		return "0";
////				
////	}

}