package datastr;

public class MyArrayList {
	private char[] elements;
	private final int DEFAULT_ARRAY_SIZE = 6;
	private int arraySize = DEFAULT_ARRAY_SIZE;
	private int elementCounter = 0;
	
	//no args constructor
	public MyArrayList() 
	{	
		elements = new char[arraySize]; //array with the size 6 (DEFAULT_ARRAY_SIZE)
	}
	//args constructor
	public MyArrayList(int inputArraySize) 
	{
		if(inputArraySize > 0) {
			arraySize = inputArraySize;
		}
		elements = new char[arraySize];
	}
	public boolean isFull()
	{
		//long if-else
		/**if(elementCounter == arraySize) {
			return true;
		} else {
			return false;
		}*/
		//short if-else
		//kopejais (if izteiksme)           ? ko darit true : ko darit false gadijumaa;
		//return (elementCounter == arraySize)? true          : false;
		
		return (elementCounter == arraySize);
	}
	public boolean isEmpty()
	{
		return (elementCounter == 0);
	}
	public int howManyElements() {
		return elementCounter;
	}
	private void increaseArray() {
		int newArraySize = (arraySize > 100)? (int)(arraySize*1.5) : arraySize*2;
		char[] newElements = new char[newArraySize];
		for(int i = 0; i < arraySize; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		arraySize = newArraySize;
	}
	





}
	
