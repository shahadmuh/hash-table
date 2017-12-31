public class LinearHash<T> {

	public enum Status {
		empty, occupied, deleted
	};

	private int maxSize;
	private int size;
	private int c;
	private int current;
	private int[] keys;
	private Status[] statusT;
	private T[] data;

	public LinearHash(int maxSize, int c) {
		this.maxSize = maxSize;
		this.c = c;
		size = 0;
		current = -1;
		keys = new int[maxSize];
		statusT = new Status[maxSize];
		data = (T[]) new Object[maxSize];

		// Initialize all cells to empty
		for (int i = 0; i < maxSize; i++) {
			statusT[i] = Status.empty;
		}
	}

	public int size() {
		return size;
	}

	public boolean full() {
		return size == maxSize;
	}

	public T retrieve() {
		return data[current];
	}

	public void update(T val) {
		data[current] = val;
	}

	public void delete() {
		statusT[current] = Status.deleted;
		size--;
	}

public int insert(int key,T val){
int probes=1;
int x=key%maxSize; 
while(statusT[x].equals(Status.occupied) && probes<maxSize){
x=(x+c)%maxSize;
probes++;} 
if(probes<maxSize){
statusT[x]=Status.occupied;
data[x]=val;
keys[x]=key;
current=x;
size++;
return probes;}
else
return 0;}
 
public boolean find(int key){
int counter=0;
int position=key%maxSize;
while(!statusT[position].equals(Status.empty)&&counter<maxSize){
if(keys[position]==key){
current=position;
return true;}
counter++;
position=(position+c)%maxSize;}
return false;}
    
public String toString(){
String st="";
for(int s=0;s<size;s++){
st+=keys[s]+"\n";}
return st;}}
