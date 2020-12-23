
//This will hold the key value pairs for the BSTree
public class KeyValuePair<Key,Value> {
	private Key key;
	private Value value;
	public KeyValuePair(Key key,Value value){
		//Initialize the value of the key
		this.key=key;//We don't want to have the ability to change the value of the key,thus there is no setter for this attribute.
		this.setValue(value);
		
	}
	public Key getKey() {
		return key;
	}
	public Value getValue() {
		return value;
	}
	public void setValue(Value value) {
		this.value = value;
	}
	
	public String toString(){
		return(this.key+","+this.value);
	}
	
}