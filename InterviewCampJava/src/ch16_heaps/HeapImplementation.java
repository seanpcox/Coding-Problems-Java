// @author: seanpcox

package ch16_heaps;

public class HeapImplementation {

	// We can use an array to store a heap
	// We implement the Complete Binary Tree using an array
	// a) ​index 0 is the root      
	// b) ​left(i) = 2*i + 1      
	// c) ​right(i) = 2*i + 2      
	// d) ​parent(i) = (i-1)/2
	
	// Complete Binary Tree means every level except the last is filled
	// Also all the nodes in the last level should be as far left as possible
	
	// To insert a number add it to the end, then propagate it up until its parent is greater
	
	// Delete Max, you take the very last node (bottom level, furthest right and add it to top
	// Then you "heapify", this means you compare top node with two below it
	// Whatever node out of those two is the max, and is greater than parent, you swap with parent
	// If a swap occurs you then do the same with where the parent was moved and the two beneath it
	// Eventually you will have a valid heap again
	
	// To delete a node, you swap the last element with it
	// If that last element is greater than the parent then you propogate it up, like insert
	// If that last element is less than either children then you heapify it
	
	// Time Complexity:
	// Insertion - O(log(N))
	// Deletion - O(log(N))
	// Lookup Max - O(1)
	
	// Max Heap Implementation 
	
	private final int maxSize;
	private final int[] array;
	private int size = 0;
	
	public HeapImplementation(int maxSize) {
		this.maxSize = maxSize;
		this.array = new int[maxSize];
	}
	
	public void insert(int e) {
		if(size >= maxSize) {
			throw new RuntimeException("Max size reached");
		}
		
		array[size] = e;
		
		if(size > 0) {
			propagate(size);
		}
		
		size++;
	}

	
	
	public int peek() {
		if(size <= 0) {
			throw new RuntimeException("Heap Empty");
		}
		
		return array[0];
	}
	
	public int poll() {
		if(size <= 0) {
			throw new RuntimeException("Heap Empty");
		}
		
		int max = array[0];
		
		swap(array, 0, size-1);
		
		size--;
		
		heapify(0);
		
		return max;
	}
	
	public void delete(int i) {
		if(size <= 0) {
			throw new RuntimeException("Heap Empty");
		}
		
		swap(array, i, size-1);
		
		size--;
		
		propagate(i);
		heapify(i);
	}
	
	private void heapify(int i) {
		int cLIndex = 2*i + 1;
		int cRIndex = 2*i + 2;
		
		int cLValue = (cLIndex < size) ? array[cLIndex] : Integer.MIN_VALUE;
		int cRValue = (cRIndex < size) ? array[cRIndex] : Integer.MIN_VALUE;
		
		int maxChild = Math.max(cLValue, cRValue);
		
		if(array[i] < maxChild) {
			if(maxChild == cLValue) {
				swap(array, i, cLIndex);
				heapify(cLIndex);
			} else {
				swap(array, i, cRIndex);
				heapify(cRIndex);
			}
		}
	}

	private void propagate(int i) {
		int parentI = getParentIndex(i);
		
		if(array[i] > array[parentI]) {
			swap(array, i, parentI);
			propagate(parentI);
		}
	}
	
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	private int getParentIndex(int i) {
		return (i - 1) / 2;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		
		if(size > 0) {
			for(int i = 0; i < size; i++) {
				builder.append(array[i]);
				builder.append(",");
			}
			
			builder.deleteCharAt(builder.length()-1);
		}
		
		builder.append("]");
		
		return builder.toString();
	}
	
	public static void main(String[] args) {
		HeapImplementation heap = new HeapImplementation(7);
		heap.insert(1);
		System.out.println(heap);
		heap.insert(2);
		System.out.println(heap);
		heap.insert(3);
		System.out.println(heap);
		heap.insert(4);
		System.out.println(heap);
		heap.insert(5);
		System.out.println(heap);
		heap.insert(6);
		System.out.println(heap);
		heap.insert(7);
		System.out.println(heap);
		
		heap.delete(1);
		System.out.println(heap);
		
		System.out.println(heap.poll());
		System.out.println(heap);
		System.out.println(heap.poll());
		System.out.println(heap);
	}
}
