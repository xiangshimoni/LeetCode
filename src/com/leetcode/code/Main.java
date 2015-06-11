package com.leetcode.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.leetcode.code.Solution.ListNode;
import com.leetcode.code.Solution.TreeNode;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		//solution.reverseBits(2147483648);
		//int[] nums = {1};
		//solution.rotate(nums, 2);
		//System.out.println(solution.trailingZeroes(1808548329));
		int[] nums = {1,2,2}; 
		//System.out.println(solution.majorityElement(nums));
		/*
		 * solution.convertToTitle(26); solution.convertToTitle(27);
		 * solution.convertToTitle(52); solution.convertToTitle(53);
		 */
		//solution.compareVersion("0.1", "0.1.0");
		//solution.plusOne(nums);
		//solution.titleToNumber("AB");
		//solution.hammingWeight(2147483648);
		//solution.convert("PAYPALISHIRING", 4);
		
		//solution.countAndSay(200000);
		//solution.atoi("123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789");
		//System.out.println(solution.reverse(1000000003));
		//System.out.println(solution.isValid("]"));
		//solution.isPalindrome(11);
		//solution.singleNumber(nums);
		//solution.climbStairs1(4);
		/*
		System.out.println(solution.isNumber("0"));
		System.out.println(solution.isNumber("40.81"));
		System.out.println(solution.isNumber("40.e1"));
		System.out.println(solution.isNumber(" 005047e+6"));
		System.out.println(solution.isNumber("  9657.91e9"));
		System.out.println(solution.isNumber(".5e1"));
		System.out.println(solution.isNumber("0 "));
		System.out.println(solution.isNumber("0.1"));
		System.out.println(solution.isNumber(".1"));
		System.out.println(solution.isNumber("1. "));
		System.out.println(solution.isNumber("-.1 "));
		System.out.println(solution.isNumber("+.1 "));
		System.out.println(solution.isNumber("-1. "));
		System.out.println(solution.isNumber("abc"));
		System.out.println(solution.isNumber("1 a"));
		System.out.println(solution.isNumber(".e1"));
		System.out.println(solution.isNumber("2e10"));
		*/
		//solution.restoreIpAddresses("25525511133");
		//int[] A = {1,1,1,1,2,2,2};
		//solution.removeDuplicatesII(A);
		//List<List<Integer>> v = solution.subsetsWithDup(nums);
		//v.size();
		char[][] board = {
				{'C','A','A'},
				{'A','A','A'},
				{'B','C','D'},
		};
		//String word = "AAB";
		//System.out.println(solution.exist(board, "AAB"));
		//System.out.println(solution.exist(board, "SEE"));
		//System.out.println(solution.exist(board, "ABCESEEDASA"));
		//System.out.println(solution.exist(board, "ABCB"));
		//solution.uniquePaths(3, 3);
		int[][] obstacleGrid = {
				{0,0},
				{1,1},
				{0,0},
		};
		//solution.uniquePathsWithObstacles(obstacleGrid);
		int[] numbers = {-2,1};
		//solution.twoSum2(numbers, 6);
		//System.out.println(solution.isPalindrome("race a car"));
		//System.out.println(solution.isHappy(2));
		//System.out.println(solution.maxSubArray1(numbers));
		//System.out.println(solution.mySqrt(2));
		
		/*
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(3);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		ListNode res = solution.sortList(node1);
		*/
		
		/*
		int[] num = new int[]{-1,0,1,2,-1,-4};
		solution.threeSum(num);
		*/
		
		HashSet<String> set = new HashSet<String>();
		set.add("leet");
		set.add("code");
		set.add("duan");
		//solution.wordBreak("leetcode", set);
		
		//solution.simplifyPath("/home/././a/../b/../c/");
		//solution.simplifyPath("/a/./b/../../c/");
		//solution.simplifyPath("/home");
		
		TreeNode n1 = new TreeNode(-2);
		TreeNode n2 = new TreeNode(-3);
		n1.left = null;
		n1.right = n2;
		//solution.pathSum(n1, -5);
		
		int[] n = new int[]{1,1,1,3,2,2,2};
		//solution.singleNumberII(n);
		
		int[] s = new int[]{1,0,-1,0,-2,2};		
		//solution.fourSum(s, 0);
		
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		//solution.hasCycle(l1);
		//solution.removeNthFromEnd(l1, 2);
		//System.out.println(solution.isIsomorphic("ab", "aa"));
		//System.out.println(solution.isIsomorphic("egg", "add"));
		//System.out.println(solution.isIsomorphic("foo", "bar"));
		//System.out.println(solution.isIsomorphic("paper", "title"));
		//solution.rob(new int[]{2,1,1,2});
		//System.out.println(solution.romanToInt("XIV"));
		
		/*
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(2);
		ListNode ln3 = new ListNode(3);
		ListNode ln4 = new ListNode(6);
		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
		*/
		//solution.removeElements(ln1, 6);
		
		//solution.reverseList(ln1);
		
		//for(int i=100;i<1000;i++){
		//System.out.println(solution.rangeBitwiseAnd(100, i));
		//}
		
		//solution.longestCommonPrefix(new String[]{"abaac"});
		//System.out.println(solution.countPrimes(4));
		//System.out.println(solution.addBinary("1", "0"));
		
		/*
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(4);
		TreeNode t3 = new TreeNode(1);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(4);
		TreeNode t6 = new TreeNode(2);
		TreeNode t7 = new TreeNode(2);
		t1.left = t2;
		t1.right = t3;
		t2.right = t4;
		t4.left = t6;
		t3.right = t5;
		t5.left = t7;
		solution.isSymmetric(t1);
		*/
		
		ListNode ln1 = new ListNode(0);
		ListNode ln2 = new ListNode(1);
		ListNode ln3 = new ListNode(3);
		ListNode ln4 = new ListNode(4);
		ln2.next = ln3;
		ln3.next = ln4;
		//solution.mergeTwoLists(ln2, ln1);
		
		//solution.levelOrder(new TreeNode(1));
		
		ListNode nd1 = new ListNode(9);
		ListNode nd2 = new ListNode(8);
		ListNode nd3 = new ListNode(3);
		ListNode nd4 = new ListNode(1);
		ListNode nd5 = new ListNode(9);
		ListNode nd6 = new ListNode(5);
		ListNode nd7 = new ListNode(9);
		nd1.next = nd2;
		//nd2.next = nd3;
		//nd4.next = nd5;
		//nd5.next = nd6;
		//nd6.next = nd7;
		//solution.addTwoNumbers(nd1, nd4);
		
		int[] can = new int[]{2,3,6,7};
		solution.combinationSum(can, 7);
		
		
	}
	
	
}
