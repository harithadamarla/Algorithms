package BloomInsuranceAgency;

public class TowersOfHanoi {

	class Stack {

		int c;
		int t;
		int a[];

	}

	Stack createStack(int capacity) {
		Stack stack = new Stack();
		stack.c = capacity;
		stack.t = -1;
		stack.a = new int[capacity];
		return stack;
	}

	boolean isFull(Stack stack) {
		return (stack.t == stack.c - 1);
	}

	// Stack is empty when top is equal to -1
	boolean isEmpty(Stack stack) {
		return (stack.t == -1);
	}

	void push(Stack stack, int item) {
		if (isFull(stack))
			return;
		stack.a[++stack.t] = item;
	}

	// Function to remove an item from stack. It
	// decreases top by 1
	int pop(Stack stack) {
		if (isEmpty(stack))
			return Integer.MIN_VALUE;
		return stack.a[stack.t--];
	}

	void moveDisksBetweenTwoPoles(Stack src, Stack dest, char s, char d) {
		int pole1TopDisk = pop(src);
		int pole2TopDisk = pop(dest);

		// When pole 1 is empty
		if (pole1TopDisk == Integer.MIN_VALUE) {
			push(src, pole2TopDisk);
			moveDisk(d, s, pole2TopDisk);
		}
		// When pole2 pole is empty
		else if (pole2TopDisk == Integer.MIN_VALUE) {
			push(dest, pole1TopDisk);
			moveDisk(s, d, pole1TopDisk);
		}
		// When top disk of pole1 > top disk of pole2
		else if (pole1TopDisk > pole2TopDisk) {
			push(src, pole1TopDisk);
			push(src, pole2TopDisk);
			moveDisk(d, s, pole2TopDisk);
		}
		// When top disk of pole1 < top disk of pole2
		else {
			push(dest, pole2TopDisk);
			push(dest, pole1TopDisk);
			moveDisk(s, d, pole1TopDisk);
		}
	}

	void moveDisk(char fromPeg, char toPeg, int disk) {
		System.out.println("moving disk " + disk + " from pole " + fromPeg + " to pole " + toPeg);
	}

	void tohIterative(int num_of_disks, Stack src, Stack aux, Stack dest) {
		int i, total_num_of_moves;
		char s = '1', d = '2', a = '3';

		// If number of disks is even, then interchange
		// destination pole and auxiliary pole
		if (num_of_disks % 2 == 0) {
			char temp = d;
			d = a;
			a = temp;
		}
		total_num_of_moves = (int) (Math.pow(2, num_of_disks) - 1);

		// Larger disks will be pushed first
		for (i = num_of_disks; i >= 1; i--)
			push(src, i);

		for (i = 1; i <= total_num_of_moves; i++) {
			if (i % 3 == 1)
				moveDisksBetweenTwoPoles(src, dest, s, d);

			else if (i % 3 == 2)
				moveDisksBetweenTwoPoles(src, aux, s, a);

			else if (i % 3 == 0)
				moveDisksBetweenTwoPoles(aux, dest, a, d);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num_of_disks = 3;

		TowersOfHanoi ob = new TowersOfHanoi();
		Stack src, dest, aux;

		// Create three stacks of size 'num_of_disks'
		// to hold the disks
		src = ob.createStack(num_of_disks);
		dest = ob.createStack(num_of_disks);
		aux = ob.createStack(num_of_disks);

		ob.tohIterative(num_of_disks, src, aux, dest);

	}

}
