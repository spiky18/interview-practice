package com.leetcode.topinterviewquestions.easy.arrays;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class RemoveDuplicateFromArrayTest {

	@Test
	public void testRemoveDuplicates() {
		int[] nums={1,1,2};
		//int[] resultArray={1,2,1};
		int expectedSize= 2;
		RemoveDuplicateFromArray obj=new RemoveDuplicateFromArray();
		assertEquals(expectedSize, obj.removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}

}
