import java.util.Arrays;

public class MyIntArrayList {

    private int[] elements;
    private int size;

    public MyIntArrayList() {
        this(10);
    }
    public MyIntArrayList(MyIntArrayList c){
       this.size=c.size;
        for(int i=0;i<c.size;i++)
            this.elements[i]=c.elements[i];

    }

    public MyIntArrayList(int initialCapacity) {
        this.elements = new int[initialCapacity];
    }

    public boolean add(int e) {
        if (this.size == this.elements.length) {
            this.elements = Arrays.copyOf(this.elements, this.size * 2);
        }

        this.elements[size] = e;
        this.size++;

        return true;
    }
    public void add(int index, int element){
        this.size++;
        for(int i=this.size-1;i>=index+1;i--)
            this.elements[i]=this.elements[i-1];
        this.elements[index]=element;
    }

    public int size() {
        return this.size;
    }

    public int indexOf(int e) {
        for (int i=0; i<this.size; i++) {
            if (this.elements[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public int removeElementAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            // should throw IndexOutOfBoundsException
            System.out.println("Throwing IndexOutOfBoundsException when trying to" +
                    " remove element at position " + index);
            return -1;
        }

        int removedElement = this.elements[index];
        for (int i=index; i<this.size; i++) {
            this.elements[i] = this.elements[i+1];
        }
        this.size--;

        return removedElement;
    }

    public void clear() {
        this.size = 0;
    }

    public int set(int index, int e) {
        if (index < 0 || index >= this.size) {
            // should throw IndexOutOfBoundsException
            System.out.println("Throwing IndexOutOfBoundsException when trying to set" +
                    " the element " + e + " at position " + index);
            return -1;
        }

        int replacedElement = this.elements[index];
        this.elements[index] = e;
        return replacedElement;
    }
    boolean contains(int e){
        for(int i=0;i<this.size();i++)
            if(this.elements[i]==e)
                return true;
        return false;
    }
    public int get(int index){
        return this.elements[index];
    }

    public int lastIndexOf(int e){

        for(int i=this.size();i>=0 ; i--){
            if(this.get(i)==e) return i;

        }
        return -1;
    }
    public boolean remove(int e){
        for(int i=0;i<this.size();i++)
            if(this.elements[i]==e){
                for(int j=i;j<this.size()-1;j++)
                    this.elements[j]=this.elements[j+1];
                this.size--;
                return true;
            }
        return false;
    }
    public boolean addAll(int index, MyIntArrayList c){
        int n=this.size()-1;
        boolean ok=false;
        for(int i=this.size()+c.size()-1;i>=this.size() && n>=index;i--)
        {
            this.elements[i]=this.elements[n--];
            ok=true;
        }
        this.size+=c.size;
        n=0;
        for(int i=index;i<index+c.size();i++)
            elements[i]=c.elements[n++];
        return ok;

    }

    }

