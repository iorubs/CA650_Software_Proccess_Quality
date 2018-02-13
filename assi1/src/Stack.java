// Generic Bounded stack taken and adapted from Joe's ca213 notes on stacks
// http://computing.dcu.ie/~jmorris/ca213/indexLect.html

public class Stack <T> { // bounded
	private T[] seq; // the sequence
	private int size = 0; // size of sequence

	Stack(int n) { // n>0
		seq = (T[])(new Object[n]);
	}

	Stack() {
		seq = (T[])(new Object[10000]);  // or this(10000);
	}

	boolean isEmpty() { return size==0;}

	boolean push(T t) {
		if (size<seq.length) {
				seq[size] = t; size++; return true;
		}
		else return false;
	}

	T pop() {
		if (isEmpty()) return null;
		else {
			size--; return seq[size];
		}
	}
}
