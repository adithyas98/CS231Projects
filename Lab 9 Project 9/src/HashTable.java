import java.util.ArrayList;
import java.util.Comparator;
public class HashTable<K,V> implements MyMap<K,V>{

	private ArrayList<ArrayList<KeyValuePair<K,V>>> array;
	private Comparator<K> comp;
	private int size=0;//this will hold the number of items in the hash table
	public HashTable( int initialCapacity ,Comparator<K>comp) {
		this.array = new ArrayList<ArrayList<KeyValuePair<K,V>>>( initialCapacity );
		for (int i = 0; i < initialCapacity; i++) {
			this.array.add( new ArrayList<KeyValuePair<K,V>>() );
		}
		this.comp=comp;
	}
	
	
	
	

	public String toString() { return this.array.toString(); }
	
	public static void main( String[] args ) {
		;
	}
	@Override
	public boolean containsKey(K key) {
		int hash=key.hashCode();//This will generate a hash code
		int index=Math.abs(hash)%this.array.size();//this will get the index
		//now I will check to see if the arraylist within this index has the value I am looking for
		for(KeyValuePair<K,V> pair:this.array.get(index)){
			//now I will use the comparator to compare the values
			if(this.comp.compare(pair.getKey(), key)==0){
				return true;
			}
			//The pointer pair is given a new thing to point to and therefore the value that it was originally pointing to is taken out of the stack since it has been used
			//This is the same for all other for loops below
		}
		return false;
		
	}
	@Override
	public V get(K key) {
		int hash=key.hashCode();//This will generate a hash code
		int index=Math.abs(hash)%this.array.size();//this will get the index
		//now I will check to see if the arraylist within this index has the value I am looking for
		for(KeyValuePair<K,V> pair:this.array.get(index)){
			//now I will use the comparator to compare the values
			if(this.comp.compare(pair.getKey(), key)==0){
				return pair.getValue();
			}
		}
		return null;
	}
	@Override
	public ArrayList<K> getKeys() {
		//create an arrayList that will be outputted
		ArrayList<K>keys=new ArrayList<K>();
		//I have to implement a nested for loop
		for(ArrayList<KeyValuePair<K, V>> lists:this.array){
			for(KeyValuePair<K,V> pair:lists){
				keys.add(pair.getKey());
			}
		}
		
		return keys;
		//Once keys is returned, the actual arraylist is transferred to the output of the function and therefore the pointer is garbage collected
		//The method is also taken out of the stack once it is used
		//This is the same for all other return statements below.
	}
	@Override
	public int size() {
		return this.size;
	}
	@Override
	public ArrayList<KeyValuePair<K,V>> getPairs() {
		//create an arrayList that will be outputted
				ArrayList<KeyValuePair<K,V>>keyValues=new ArrayList<KeyValuePair<K,V>>();
				//I have to implement a nested for loop
				for(ArrayList<KeyValuePair<K, V>> lists:this.array){
					for(KeyValuePair<K,V> pair:lists){
						keyValues.add(pair);
					}
				}
				return keyValues;
				
	}
	public ArrayList<V> getValues() {
		//create an arrayList that will be outputted
				ArrayList<V>Values=new ArrayList<V>();
				//I have to implement a nested for loop
				for(ArrayList<KeyValuePair<K,V>> lists:this.array){
					for(KeyValuePair<K,V> pair:lists){
						Values.add(pair.getValue());
					}
				}
				return Values;
	}

	@Override
	//This is using open addressing to deal with collisions
	public void put(K new_key, V new_value) {
		Integer hash = new_key.hashCode();//Generate hashcode
		int hash2=hash.hashCode();
		int index = Math.abs(hash2) % this.array.size();//Get the arraylist of keyvalue pairs from the index
		ArrayList<KeyValuePair<K,V>> sublist = this.array.get(index);//
		for (KeyValuePair<K,V> pair: sublist) {
			if (comp.compare(new_key, pair.getKey()) ==0) {//Will check to see if the key is already in the hash table
				pair.setValue( new_value );//Will set the new value
				return;
			}
		}
		sublist.add( new KeyValuePair<K,V>( new_key, new_value ) );//Otherwise it will create a new key value pair
		//We want to iterate the size counter here since we want it to only iterate when something new is created
		this.size++;
		
	}
	//The actual pointers new_key and New_value are garbage collected along with the actual method by being taken out of the stack because they are no longer in use any more
	




//I only changed this method since this is the only one that really interacted with the WordCounter class
	public KeyValuePair<K,V> getKeyValue(K Key) {
		//this will return a key value pair
		Integer hash=Key.hashCode();//This will generate a hash code
		int hash2=hash.hashCode();
		int index=Math.abs(hash2)%this.array.size();//this will get the index
		//now I will check to see if the arraylist within this index has the value I am looking for
		for(KeyValuePair<K,V> pair:this.array.get(index)){
			//now I will use the comparator to compare the values
			if(this.comp.compare(pair.getKey(), Key)==0){
				return pair;
			}
		}
		return null;
	}
	
	
	
	
	}


