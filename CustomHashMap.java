  /*
	* Original effort for implementation of custom hashmap, methods:
	* 1. void put(Key,Value)
	* 2. V get() // returns the element type if present, else null
	* 3. int getSize() // returns the total number of current elements 
	* 4. void remove() // removes the element if present, else no action
	*/
public class CustomHashMap<K,V> {
	/*
	* Default values
	*/
int currentCapacity = 10;
int currentFills = 0;
float loadf = 0.75f;
Node[] arr;
	/*
	* No args constructor
	*/
	public CustomHashMap() {
		initilize();
	}

	/*
	* Constructor to preload initial capacity
	*/
	public CustomHashMap(int initialCapacity) {
		currentCapacity = initialCapacity;
		initilize();
	}

	/*
	*  Constructor to preload initial capacity and loadfactor
	*/
	public CustomHashMap(int initialCapacity, float loadFactor) {
		this.currentCapacity = initialCapacity;
		this.loadf = loadFactor;
		initilize();
	}

	public void initilize() {
	  arr = new Node[currentCapacity];
	}	

	/*
	* Returns current number of elements
	*/
	public int getSize() {
	return currentFills;
	}

	/*
	* Gets the element if present, else null is returned
	*/
	public V get(K key) {
	int hashInteger = key.hashCode();
	int index = hashInteger % currentCapacity;
	if(arr[index] == null) {
	return null;
	}
	Node<K,V> temp = arr[index];
	while(temp != null) {
	KeyValue<K,V> item = temp.item;
	if(key.equals(item.key)) {
		return item.value;
	}
	temp = temp.next;
	}
	return null;	
	}

	/*
	* Checks if rehashing is required then, inserts into the Array bucket
	*/
	public void put(K key, V value) {
	checkSizeRehash();
	KeyValue<K,V> temp = new KeyValue<>(key,value);
	int hashInteger = key.hashCode();
	int index = hashInteger % currentCapacity;
	insertIntoList(arr,index,temp);
	}

	public void remove(K key) {
	int hashInteger = key.hashCode();
	int index = hashInteger % currentCapacity;
	Node<K,V> temp = arr[index]; Node<K,V> prev = null;
	if(temp == null){
	return;
	}
	currentFills--;
	while(temp != null) {
	if(temp.item.key.equals(key)) {
		if(prev == null) {
		 arr[index] = temp.next; 
		 return;
		}
		else {

		prev.next = temp.next; return;
		}
	}
	prev = temp;
	temp = temp.next;
	}
	}

	/*
	* Search the last element of the bucket chain and insert the element
	*/
	public void insertIntoList(Node<K,V>[] arrTemp,int index,KeyValue<K,V> itemToInsert) {
	Node mainItem = arrTemp[index];
	currentFills++;
	if(mainItem == null) {
	arrTemp[index] = new Node(itemToInsert);
	return;
	}
	Node<K,V> temp = mainItem;
	while(temp.next != null) {
	temp = temp.next;
	}
	temp.next = new Node<>(itemToInsert);
	}

	/*
	* Check if load factor is less and then rehash
	*/
	public void checkSizeRehash() {
	float currLoad = (float)(currentFills+1)/(float)currentCapacity;
	if(currLoad < loadf) {
	return;
	}
	rehash();
	}

	/*
	* Rehashing by increasing to twice the initial capacity
	* creating new array and copying the old elements
	* old element is unreferenced
	*/
	public void rehash() {
	currentCapacity = 2 * currentCapacity;
	Node[] copyArr = new Node[currentCapacity];
	currentFills = 0;
	for(int i = 0; i<arr.length ; i++) {
		if(arr[i] != null) {
			Node<K,V> temp = arr[i];
			while(temp != null) {
			int index = temp.item.key.hashCode() % currentCapacity;
			insertIntoList(copyArr,index,temp.item);	
			temp = temp.next;
			}
		} 
	}
	arr = copyArr;
	}

	/* Debugging purposes only
	public void printAll() {
		for(int i =0; i<arr.length; i++) {
			System.out.print("Bucket: "+i+" --> ");
			if(arr[i] != null) {
				Node<K,V> temp = arr[i];
				while(temp!=null) {
					System.out.print(temp.item+" ---> "); 
					temp = temp.next;
				}

			}
			System.out.println();
		}
	}
	*/
}

	/*
	* Used to Chain linking 
	*/
class Node<K,V> {
	KeyValue<K,V> item;
	Node<K,V> next;
	public Node(KeyValue<K,V> item) {
	this.item = item;
	next = null;
	}

}

	/*
	* Stores the key and the value
	*/
class KeyValue<K,V> {
	K key; V value;
	public KeyValue(K key, V value) {
	this.key = key;
	this.value = value;
	}

	@Override
	public String toString() {
		return "<"+key+","+value+">";
	}
} 
