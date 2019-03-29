import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Graph<T> {
	Map<T,List<T>> adj = new HashMap<>();
	Stack<T> st = new Stack<>();
	Stack<T> result = new Stack<>();
    Set<T> visited = new HashSet<>();

	public void addVertex(T vert) {
		List<T> li = new LinkedList<>();
		adj.put(vert,li);
	}

	public void addEdge(T start, T des) {
		if(adj.containsKey(start)) {
			List<T> li = adj.get(start);
			li.add(des);
		}
		else {
			List<T> li = adj.get(start);
			li.add(des);
		}
	}

	public void printAdj() {
		for(T elem : adj.keySet()) {
			List<T> li = adj.get(elem);
			System.out.println(elem+" --> "+li);
		}
	}

	/*
	* When all the elements of an vertex in adjadency list are either visited or list is empty
	* Add that element to the result stack
	*/
	public void topologicalSort() {
		for(T elem: adj.keySet()) {
			if(!visited.contains(elem)) {
				st.push(elem);
				visited.add(elem);
				while(st.size() != 0) {
					T node = st.peek();
				    List<T> li = adj.get(node);
				    int count = 0;
				    for(int i = 0; i<li.size(); i++) {
				    	if(!visited.contains(li.get(i))) {
				    		count++;
				    	st.push(li.get(i));
				    	visited.add(li.get(i));
				    }
				    }
				    if(count == 0) {
				    	result.push(st.pop());
				    }
				}
			}
		}
	}

	public void printSorted() {
		List<T> li = result.stream().collect(Collectors.toList());
		System.out.println("result");
		for (int i = li.size()-1;i>=0 ;i-- ) {
			System.out.print(li.get(i)+" ");
		}
	}
}



public class Main {
	public static void main(String[] args) {
		Graph<String> gr = new Graph<>();
		gr.addVertex("0"); gr.addVertex("1"); gr.addVertex("2");
		gr.addVertex("5"); gr.addVertex("4"); gr.addVertex("3");
		//gr.addVertex("G");
		gr.addEdge("5","0"); gr.addEdge("5","2"); gr.addEdge("4","0");
		gr.addEdge("4","1"); gr.addEdge("2","3"); gr.addEdge("3","1");
		//gr.addEdge("D","F"); 
		gr.printAdj();
		gr.topologicalSort();
		gr.printSorted();
	}
}

