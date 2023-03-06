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
	public boolean search(char inputElement) {
		for(int i = 0; i < elementCounter; i++) 
			if(elements[i] == inputElement)
				return true;
		return false;
	}
	
	//TODO sort
	public char[] sort(SortingType type) throws Exception {
		if(isEmpty()){
			throw (new Exception("This array is empty"));
		}
		else
		{
			char[] sortedArray = new char[elementCounter];
			for (int i = 0; i < elementCounter; i++){
				sortedArray[i] = elements[i];
			}
			///ascending order
			if(type == SortingType.ASC){
				for(int i = 0; i < elementCounter; i++){
					for(int j = 0; j < elementCounter-1; j++){
						if(elements[i] > elements[j]){
							char temp = sortedArray[i];
							sortedArray[i] = sortedArray[j];
							sortedArray[j] = temp;
						}
					}
				}
			}
			//descending order
			else if(type == SortingType.DESC){
				for(int i = 0; i < elementCounter; i++){
					for(int j = 0; j < elementCounter-1; j++){
						if(elements[i] < elements[j]){
							char temp = sortedArray[i];
							sortedArray[i] = sortedArray[j];
							sortedArray[j] = temp;
						}
					}
				}
			}
			else {
				throw (new Exception("Wrong sorting type!"));
			}
			return sortedArray;
		}

	}
	
	public char[] retrieveNextNeighbours(char inputElement) throws Exception {
		if(search(inputElement)) {
			int howManySearchedElements = 0;
			for(int i = 0 ; i < elementCounter; i++){
				if(elements[i] == inputElement){
					howManySearchedElements++;
				}
			}
			if(elements[elementCounter-1] == inputElement)
				howManySearchedElements--;

			char [] nextNeghbours = new char [howManySearchedElements];
			int indexForNeighbours = 0;
			for(int i = 0; i < elementCounter-1; i++){
				if(elements[i] == inputElement){
					nextNeghbours[indexForNeighbours] = elements[i+1];
					indexForNeighbours++;
				}
			}
			return nextNeghbours;
		}
		else {
			throw (new Exception("This element is not in the array"));
		}
	}
	public void print() throws Exception {
		if(!isEmpty()) {
			for(int i = 0; i < elementCounter; i++) {
				System.out.print(elements[i] + " ");
			}
			System.out.println();
		}
		else 
			throw (new Exception("This array is empty"));
			
	}
	public void makeEmpty() throws Exception {
		if(!isEmpty()) {
			arraySize = DEFAULT_ARRAY_SIZE;
			elementCounter = 0;
			elements = new char[arraySize];
		}
		else
			throw (new Exception("This array is empty"));
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



}
	
