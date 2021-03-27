package diagrama;

public interface Lista <T> {
	
	public void add(T o);

	public void add(int i, T t);

	public T remove(int i);

	public boolean removeFirst(T t);
	
	public T get(int i);

	public void clear();
	
	public T set(int i, T t);
	
	public int size();
	
	public boolean isEmpty();

	public boolean contains(T t);

	public int indexOff(T t);

	public int lastIndexOff(T t);
	
	public T[] toArray();
}

	