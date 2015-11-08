package knn;

public abstract class DatasetType {
	
	public abstract int getNumAttr();
	public abstract String getAttr(int index);
	public abstract void setAttr(int index, String value);
	public abstract String getClasse();
	//public abstract String getDesiredValue(); //?
}

