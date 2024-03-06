package structure;

public class Lista {
	
	private No ref;
	
	public Lista() {
		this.ref = null;
	}
	
	public void insere(int info) {
		No newNode = new No(info, null, null);
		if(isEmpty()) {
			ref = newNode;
			ref.setNext(ref);
			ref.setPrev(ref);
			return;
		}
		
		No aux = ref.getNext();
		newNode.setPrev(ref);
		newNode.setNext(aux);
		aux.setPrev(newNode);
		ref.setNext(newNode);
	}
	
	public String imprime() {
		if(isEmpty()) {
			return "Lista vazia;";
		}
		String retorno = "Sentido normal:";
		for(No n = ref.getNext(); n != ref; n = n.getNext()) {
			retorno = retorno+(n.getInfo()+" ");
		}
		retorno = retorno + (ref.getInfo()+" ");
		retorno = retorno+(" Sentido contrario:");
		retorno = retorno + (ref.getInfo()+" ");
		for(No n = ref.getPrev(); n != ref; n = n.getPrev()) {
			retorno = retorno+(n.getInfo()+" ");
		}
		return retorno;
	}
	
	public boolean isEmpty() {
		return ref == null;
	}
	
	public void print() {
		if(isEmpty()) {
			System.out.println("Empty list;");
			return;
		}
		System.out.println("Normal way;");
		for(No n = ref.getNext(); n != ref; n = n.getNext()) {
			System.out.println("Data: "+n.getInfo());
		}
		System.out.println("Data: "+ref.getInfo());
		
		System.out.println();
		System.out.println("Reverse way;");
		System.out.println("Data: "+ref.getInfo());
		for(No n = ref.getPrev(); n!=ref; n = n.getPrev()) {
			System.out.println("Data: "+n.getInfo());
		}
	}
	
	public void remove(int info, boolean duplicados) {
		if(isEmpty()) {
			System.out.println("Lista vazia;");
			return;
		}
		
		if(ref == ref.getNext() && ref == ref.getPrev()) {
			ref.setNext(null);
			ref.setPrev(null);
			ref = null;
			return;
		}
		
		No wanted = new No(info, null, null);
		int count = this.count(wanted.getInfo());	
		for(No n = ref.getNext(); n != ref; n = n.getNext()) {
			if(wanted.getInfo() == n.getInfo()) {
				if(duplicados && count > 0) {
					No prev = n.getPrev();
					prev.setNext(n.getNext());
					No next = n.getNext();
					next.setPrev(prev);
					count--;
					continue;
				}
				No prev = n.getPrev();
				prev.setNext(n.getNext());
				No next = n.getNext();
				next.setPrev(prev);
				return;
			}
		}
		if(ref.getInfo() == wanted.getInfo()) {
			No prev = ref.getPrev();
			prev.setNext(ref.getNext());
			No next = ref.getNext();
			next.setPrev(prev);
			ref = prev;
		}
	}
	
	public int count(int info) {
		if(isEmpty()) {
			return -1;
		}
		int count=0;
		for(No n = ref.getNext(); n != ref; n = n.getNext()) {
			if(n.getInfo() == info) {
				count++;
			}
		}
		if(ref.getInfo() == info) {
			count++;
		}
		return count;
	}
}
