package test;

import java.util.*;

public class Oct31Two {

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2,7,-2,-5};
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list;

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				for (int k = 0; k < nums.length; k++) {
					if (i != k && j != k && i != j) {
						if (nums[i] + nums[j] + nums[k] == 0) {
							
							list = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
							
							Collections.sort(list);
							if (!res.contains(list))
								res.add(new ArrayList<>(list));
						}

					}
				}
			}
		}

		System.out.println(res);
	}

}
