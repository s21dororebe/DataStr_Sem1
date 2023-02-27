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
	public void add(char newElement) {
		if(isFull())
			increaseArray();
		elements[elementCounter++] = newElement;// = elements[elementCounter] = newElement; elementCounter++; 
	}
	public void add(int index, char newElement) throws Exception {
		//2. verify the index - is it appropriate
		if(index >=0 && index <= elementCounter) {
			if(index == elementCounter)
				add(newElement);
			else {
				//3. verify is full 
				if(isFull())
					increaseArray();
				//4. copy from the end to the right side (using the index)
				for(int i = elementCounter; i > index; i--) {
					elements[i] = elements[i-1]; 
				}
				//5. add the new element in the specified index
				elements[index] = newElement;
				//6. increase element counter
				elementCounter++;
			}
		}
		else {
			throw (new Exception("Wrong index"));
		}
		
	}
	public void remove(int index) throws Exception {
		//verify is empty
		if(isEmpty()) 
			throw (new Exception("This array is empty"));
		//verify the index - is it appropriate
		if(index >= 0 && index < elementCounter) {
			if(elements[index] != ' ') {
				for(int i = index; i < elementCounter-1; i++) {
					elements[i] = elements[i+1];
				}
				elements[--elementCounter] = 0;
			} 
			else 
				throw (new Exception("This field is empty"));
			
		}
		else 
			throw (new Exception("Wrong index"));
			
	}
	public char get(int index) throws Exception {
		//verify is empty
		if(isEmpty()) 
			throw (new Exception("This array is empty"));
		//verify the index - is it appropriate
		if(index >= 0 && index < elementCounter)
			return elements[index];
		else
			throw (new Exception("Wrong index"));
	}
	public boolean search(char name) {
		for(int i = 0; i < elementCounter; i++) {
			if(elements[i] == name)
				return true;
		}
		return false;
	}





}
	
