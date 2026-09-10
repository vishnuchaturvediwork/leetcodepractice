

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 1, 5 };

		ContainsDuplicate bfSolution = new ContainsDuplicate();
		if (bfSolution.containsDuplicateBruteForce(nums)) {
			System.out.println("Contains duplicate");
		} else {
			System.out.println("Does not contains duplicate");
		}
		
		ContainsDuplicate optimizedSolution = new ContainsDuplicate();
		if (optimizedSolution.containsDuplicateBruteForce(nums)) {
			System.out.println("Contains duplicate");
		} else {
			System.out.println("Does not contains duplicate");
		}


	}

	boolean containsDuplicateBruteForce(int[] nums) {

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j])
					return true;
			}
		}

		return false;
	}
	
	boolean containsDuplicateOptimized(int[] nums) {
		
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
		}

		return false;
	}

}
