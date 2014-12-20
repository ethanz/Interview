package stackAndQueues;

public class NodeWithMin {

	public int data;
	public int min;
	public NodeWithMin next = null;

	public NodeWithMin(int value, int min) {
		data = value;
		this.min = min;
	}

	public NodeWithMin(int value) {
		data = value;

	}

	void appendToTail(int d) {
		NodeWithMin end = new NodeWithMin(d, min);
		NodeWithMin n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

}
