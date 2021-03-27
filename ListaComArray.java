package diagrama;

public class ListaComArray <T> implements Lista<T> {

	
	private T[] array;
	private boolean resizable;
	private int initialCapacity;
	private int counter = 0;
	private static final int X = 11;
	
	public ListaComArray(){
		this(10);
	}
	
	public ListaComArray(int initialCapacity) {
		this(initialCapacity, true);
	}
	
	@SuppressWarnings("unchecked")
	public ListaComArray(int initialCapacity, boolean resizable) {
		this.resizable = resizable;
		this.initialCapacity = initialCapacity;
		this.array = (T[]) new Object[initialCapacity];		
	}
	
	public boolean isFull() {
		if (counter == array.length) {
			return true;
		} else {
			return false;
		}
	}
	
	private void resizeArrayList() {
		if (resizable == true && counter + 1 == this.array.length) {
			@SuppressWarnings("unchecked")
			T arrayCopy[] = (T[]) new Object[this.array.length + X];
			for (int i = 0; i < this.array.length; i++) {
				arrayCopy[i] = this.array[i];
			}
			this.array = arrayCopy;
		}	
	}
		
	@Override
	public void add(T o) {
		this.array[this.counter] = o;
		this.counter++;
		resizeArrayList();
	}
	
	@Override
	public void add(int i, T t) {
		if (this.array[i] == null) {
			this.array[i] = t;
		} else {
			@SuppressWarnings("unchecked")
			T arrayCopy[] = (T[]) new Object[counter + 1];
			int cont = 0;
			for (int j = i; j < counter; j++) {
				arrayCopy[cont] = this.array[j];
				cont++;
			}
			this.array[i] = t;
			cont = 0;
			for (int j = i + 1; j <= counter; j++) {
				this.array[j] = arrayCopy[cont];
				cont++;
			}
		}	
		counter++;
		resizeArrayList();
	}
	
	@Override
	public T remove(int i) {
		T val = this.array[i];
		counter--;
		this.array[i] = null;
		for (int j = i; j < this.counter; j++) {
			if(this.array.length > j + 1) {
				this.array[j] = this.array[j + 1];
			} else {
				this.array[j] = null;
			}			
		}
		return val;
	}

	@Override
	public boolean removeFirst(T t) {
		for (int j = 0; j < this.array.length; j++) {
			if(this.array[j] == t) {
				remove(j);
				return true;
			}
		}
		return false;
	}

	@Override
	public T get(int i) {
		return this.array[i];
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		this.array =(T[]) new Object[initialCapacity];;
		
	}

	@Override
	public T set(int i, T t) {
		T val = this.array[i];
		this.array[i] = t;
		return val;
	}

	@Override
	public int size() {
		return counter;
	}

	@Override
	public boolean isEmpty() {
		if (counter == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean contains(T t) {
		for (int j = 0; j < this.array.length; j++) {
			if (this.array[j] == t) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int indexOff(T t) {
		for (int j = 0; j < this.array.length; j++) {
			if(this.array[j] == t) {
				return j;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOff(T t) {
		int last = -1;
		for (int j = 0; j < this.array.length; j++) {
			if(this.array[j] == t) {
				last = j;
			}
		}
		return last;
	}

	@Override
	public T[] toArray() {
		return this.array;
	}

}
