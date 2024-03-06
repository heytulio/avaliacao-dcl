package structure;

public class No {
	
	private int info;
	private No next;
	private No prev;
	
	public No(int info, No next, No prev) {
		this.info = info;
		this.next = next;
		this.prev = prev;
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public No getNext() {
		return next;
	}

	public void setNext(No next) {
		this.next = next;
	}

	public No getPrev() {
		return prev;
	}

	public void setPrev(No prev) {
		this.prev = prev;
	}
	
}
