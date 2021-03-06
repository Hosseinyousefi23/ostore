package executer;

import java.util.ArrayList;

import scheduler.MyThread;

public class Node {
	protected Node parrent;
	protected ArrayList<Node> children;
	protected String name;
	protected String content;
	

	public Node(String name) {
		children = new ArrayList<Node>();
		this.name = name;
	}

	public ArrayList<Node> getChildren() {
		return children;
	}

	public void addChild(Node n) {
		children.add(n);
	}

	public Node getParrent() {
		return parrent;
	}

	public void setParrent(Node parrent) {
		this.parrent = parrent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public void execute(MyThread thread) {
		for (Node n : children) {
			n.execute(thread);
		}
	}

	public boolean isNonTerminal() {
		return name.startsWith("<") && name.endsWith(">");
	}

	public void setContent(String content) {
		this.content = content;

	}

	public String getContent() {
		return content;
	}
	
	protected boolean intToBoolean(int i) {
		return i != 0;
	}

}
