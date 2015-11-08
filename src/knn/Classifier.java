package knn;

import knn.DatasetType;

public abstract class Classifier<T extends DatasetType> {
	abstract public String classify(T elem);
}