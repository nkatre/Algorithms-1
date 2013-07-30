package com.shubham.misc_problems;

// http://www.youtube.com/watch?v=bIgjzlumfsQ
public class TowerOfHanoi {
	// Assuming n-th disk is bottom disk (count down)
	void tower(int n, char sourcePole, char destinationPole, char auxiliaryPole)
	{
		// Base case (termination condition)
		if(0 == n)
			return;

		// Move first n-1 disks from source pole to auxiliary pole using destination as
		// temporary pole
		tower(n-1, sourcePole, auxiliaryPole, destinationPole);

		// Move the remaining disk from source pole to destination pole
		System.out.println("Move the disk " + n + " from " + sourcePole + " to " + destinationPole);

		// Move the n-1 disks from auxiliary (now source) pole to destination pole using source pole as
		// temporary (auxiliary) pole
		tower(n-1, auxiliaryPole, destinationPole, sourcePole);
	}

	void main()
	{
		tower(3, 'S', 'D', 'A');
	}
}
