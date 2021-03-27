package diagrama;

public class NoLista<T>{
	
	private T info;
	private NoLista<T> next;
	
	
	public NoLista() {
		
	}
	
	public NoLista(T info, NoLista<T> next) {
		this.info = info;
		this.next = next;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public NoLista<T> getNext() {
		return next;
	}

	public void setNext(NoLista<T> next) {
		this.next = next;
	}	


}
