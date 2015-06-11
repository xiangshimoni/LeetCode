package com.leetcode.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import org.omg.CORBA.INTERNAL;

public class Solution {
	/**
	 * 不支持int最大值2147483648
	 * 
	 * @param n
	 * @return
	 */
	public int reverseBits(int n) {
		// 翻转二进制位(java中没有无符号整型，范围-2147483648到2147483648)
		/*
		 * String valStr = Integer.toBinaryString(n);
		 * System.out.println(valStr); StringBuilder builder = new
		 * StringBuilder(); for (int i = 0; i < 32; i++) { if (i >
		 * valStr.length() - 1) { builder.append("0"); } else {
		 * builder.append(valStr.charAt(valStr.length() - 1 - i)); } }
		 * System.out.println(builder.toString());
		 * System.out.println(Long.valueOf(builder.toString(),2)); return
		 * Integer.valueOf(builder.toString(), 2);
		 */
		int reverse_num = 0, i, temp;
		for (i = 0; i < 32; i++) {
			temp = (n & (1 << i));
			if (temp > 0)
				reverse_num |= (1 << ((32 - 1) - i));
		}
		System.out.println(reverse_num);
		return reverse_num;

	}

	/**
	 * 数组右移k位，参考《编程珠玑》
	 * 
	 * @param nums
	 *            数组
	 * @param k
	 *            向右移动的位数
	 */
	public void rotate(int[] nums, int k) {
		if (k == 0 || nums == null)
			return;
		k = k % nums.length;
		int tmp;
		for (int i = 0; i < (nums.length - k) / 2; i++) {
			tmp = nums[i];
			nums[i] = nums[nums.length - k - 1 - i];
			nums[nums.length - k - 1 - i] = tmp;
		}
		/*
		 * for (int i : nums) { System.out.print(i+"-"); } System.out.println();
		 */

		for (int i = 0; i < k / 2; i++) {
			tmp = nums[i + nums.length - k];
			nums[i + nums.length - k] = nums[nums.length - 1 - i];
			nums[nums.length - 1 - i] = tmp;
		}

		/*
		 * for (int i : nums) { System.out.print(i+" "); } System.out.println();
		 */

		for (int i = 0; i < nums.length / 2; i++) {
			tmp = nums[i];
			nums[i] = nums[nums.length - 1 - i];
			nums[nums.length - 1 - i] = tmp;
		}
		/*
		 * for (int i : nums) { System.out.print(i+" "); } System.out.println();
		 */
	}

	/**
	 * 计算n阶乘中尾部0的个数 非递归方式，防止栈溢出, 时间复杂度：O(logn)
	 * 
	 * @param n
	 * @return
	 */
	public int trailingZeroes(int n) {
		int count = 0;
		for (int i = 5; (n / i) >= 1;) {
			count += n / i;
			n /= 5;
		}
		return count;
	}

	/**
	 * 数组中超过[n/2]（向下取整）个数的元素
	 * 
	 * @param num
	 * @return
	 */
	public int majorityElement(int[] num) {
		HashMap<Integer, Integer> cnt = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; i++) {
			cnt.put(num[i], cnt.get(num[i]) == null ? 1 : cnt.get(num[i]) + 1);
		}
		for (int item : cnt.keySet()) {
			if (cnt.get(item) > num.length / 2) {
				return item;
			}
		}
		return -1;
	}

	/**
	 * Given a positive integer, return its corresponding column title as appear
	 * in an Excel sheet.
	 * 
	 * @param n
	 * @return
	 */
	public String convertToTitle(int n) {
		StringBuilder builder = new StringBuilder();
		int r;
		while (n > 0) {
			r = n % 26;
			n /= 26;
			if (r == 0) {
				builder.append('Z');
				n--;
			} else {
				builder.append((char) ('A' + r - 1));
			}
		}
		// System.out.println(builder.reverse().toString());
		return builder.reverse().toString();
	}

	/**
	 * 版本比较
	 * 
	 * @param version1
	 * @param version2
	 * @return
	 */
	public int compareVersion(String version1, String version2) {
		String[] s1 = version1.split("\\.");
		String[] s2 = version2.split("\\.");
		int minLength = Math.min(s1.length, s2.length);
		int i = 0;
		while (minLength-- > 0) {
			if (Integer.valueOf(s1[i]) > Integer.valueOf(s2[i]))
				return 1;
			else if (Integer.valueOf(s1[i]) < Integer.valueOf(s2[i]))
				return -1;
			i++;
		}
		int sum = 0;
		if (s1.length > s2.length) {
			for (int j = i; j < s1.length; j++) {
				sum += Integer.valueOf(s1[j]);
			}
			return sum > 0 ? 1 : 0;
		} else if (s1.length < s2.length) {
			for (int j = i; j < s2.length; j++) {
				sum += Integer.valueOf(s2[j]);
			}
			return sum > 0 ? -1 : 0;
		} else
			return 0;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	};

	/**
	 * 二叉树存在指定节点和的路径,使用递归算法
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && root.val == sum)
			return true;
		return hasPathSum(root.left, sum - root.val)
				|| hasPathSum(root.right, sum - root.val);
	}

	public int lengthOfLastWord(String s) {
		String[] s1 = s.split(" ");
		if (s1 == null)
			return 0;
		if (s1.length == 0)
			return 0;
		return s1[s1.length - 1].length();
	}

	/**
	 * 数字数组加一
	 * 
	 * @param digits
	 * @return
	 */
	public int[] plusOne(int[] digits) {
		int n = digits.length;
		int c = 1;
		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] + c > 9) {
				digits[i] = 0;
				c = 1;
			} else {
				digits[i] += c;
				c = 0;
			}
		}
		if (c == 1) {
			int[] ret = new int[n + 1];
			for (int i = 1; i < n + 1; i++)
				ret[i] = digits[i - 1];
			ret[0] = 1;
			return ret;
		} else {
			int[] ret = new int[n];
			for (int i = 0; i < n; i++)
				ret[i] = digits[i];
			return ret;
		}
	}

	/**
	 * Given a column title as appear in an Excel sheet, return its
	 * corresponding column number.
	 * 
	 * @param s
	 * @return
	 */
	public int titleToNumber(String s) {
		int x = 26;
		int sum = 0;
		int n = 0;
		for (int i = s.length() - 1; i >= 0; i--, n++) {
			sum += (s.charAt(i) - 'A' + 1) * Math.pow(x, n);
		}
		// System.out.println(sum);
		return sum;
	}

	public int hammingWeight(int n) {
		int m = 0;
		while (n > 0) {
			n &= n - 1;
			m++;
		}
		return m;
	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> listlist = new ArrayList<List<Integer>>();
		ArrayList<Integer> list;
		ArrayList<Integer> templist;
		if (numRows <= 0)
			return listlist;
		if (numRows == 1) {
			list = new ArrayList<>();
			list.add(1);
			listlist.add(list);
		} else {
			list = new ArrayList<>();
			list.add(1);
			listlist.add(list);
			templist = list;
			for (int i = 1; i < numRows; i++) {
				list = new ArrayList<>();
				list.add(1);
				int val;
				for (int j = 0; j < templist.size() - 1; j++) {
					val = templist.get(j) + templist.get(j + 1);
					list.add(val);
				}
				list.add(1);
				listlist.add(list);
				templist = list;
			}
		}
		return listlist;
	}

	public String convert(String s, int nRows) {
	    if(s == null || s.length()==0 || nRows <=0)
	        return "";
	    if(nRows == 1)
	        return s;
	    StringBuilder res = new StringBuilder();
	    int size = 2*nRows-2;
	    for(int i=0;i<nRows;i++)
	    {
	        for(int j=i;j<s.length();j+=size)
	        {
	            res.append(s.charAt(j));
	            if(i!=0 && i!=nRows-1 && j+size-2*i<s.length())
	                res.append(s.charAt(j+size-2*i));
	        }                
	    }
	    return res.toString();
	}
	
	public int removeElement(int[] A, int elem) {
		int res=0;  
        for(int i=0; i<A.length; ++i){  
            if(A[i]==elem){  
                res++;  
            }  
            else if(res>0){  
                A[i-res]=A[i];  
            }  
        }  
        return A.length-res;  
    }
	
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public int minDepth(TreeNode root) {
    	if(root==null)
    		return 0;
    	if(root.left==null) return minDepth(root.right)+1;
    	if(root.right==null) return minDepth(root.left)+1;
    	return Math.min(minDepth(root.right), minDepth(root.left))+1;
    }
	
	
	public String countAndSay(int n) {
		if(n<=0)
			return "";
		String ret = String.valueOf(1);
        for(int i = 1;i < n;i++){
        	ret = say(String.valueOf(ret));
        }
        return ret;
    }
	
	public String say(String str){
		char lastChar = str.charAt(0);
    	int cnt = 1;
    	String ret = "";
    	if(str.length()<=1)
    		return 1+str;
        for(int i = 1;i < str.length();i++){
        	if(str.charAt(i)==lastChar){
        		cnt++;
        		if(i==str.length()-1)
        			ret += String.valueOf(cnt)+String.valueOf(lastChar);
    		}
        	else{
        		ret += String.valueOf(cnt)+String.valueOf(lastChar);
        		if(i==str.length()-1)
        			ret+=1+String.valueOf(str.charAt(i));
        		cnt = 1;
        		lastChar = str.charAt(i);
        	}
        }
        return ret;
	}
	
	public int atoi(String str) {
		if(str == null)
			return 0;
		if(str.isEmpty())
			return 0;
		if(str.trim().equals(""))
			return 0;
		str =str.trim();
		char flag = '+';
		 
		// check negative or positive
		int i = 0;
		if (str.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}

		double result = 0;
	 

		while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
	 
		if (flag == '-')
			result = -result;	 

		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
	 
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
	 
		return (int) result;
    }
	
	int reverse(int x) {
        String str = String.valueOf(x);
        
        boolean isNeg = false;
        if (str.charAt(0) == '-') {
        	isNeg = true;
        	str = str.substring(1, str.length());
		}
        
        StringBuilder sb = new StringBuilder(str);
        str = sb.reverse().toString();
        
        int i = 0;
		double result = 0;
		while(str.length() > i){
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
		if(isNeg)
			result = -result;
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
			return 0;
		
		return (int)result;
    }
	
	public boolean isValid(String s) {
		if(s==null)
			return true;
		if(s.isEmpty()){
			return true;
		}
		boolean valid = true;
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
				stack.push(s.charAt(i));
			}
			else if(s.charAt(i)==')'){
				if(stack.isEmpty()) return false;
				if(stack.pop()!='(')
				{
					return false;
				}
			}
			else if(s.charAt(i)==']'){
				if(stack.isEmpty()) return false;
				if(stack.pop()!='[')
				{
					return false;
				}
			}
			else if(s.charAt(i)=='}'){
				if(stack.isEmpty()) return false;
				if(stack.pop()!='{')
				{
					return false;
				}
			}
		}
		if(!stack.isEmpty())
			valid = false;
		return valid;
    }
	
	/**
	 * 帕斯卡三角形第k行
	 * @param rowIndex
	 * @return
	 */
	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = null;
		if(rowIndex < 0)
		{
			list = new ArrayList<Integer>();
			return list;
		}
		else if(rowIndex==0){
			list = new ArrayList<Integer>();
			list.add(1);
		}
		else if(rowIndex==1){
			list = new ArrayList<Integer>();
			list.add(1);
			list.add(1);
		}
		else{
			List<Integer> templist = new ArrayList<Integer>();
			templist.add(1);
			templist.add(1);
			for (int i = 1; i < rowIndex; i++) {
				list = new ArrayList<>();
				list.add(1);
				int val;
				for (int j = 0; j < templist.size() - 1; j++) {
					val = templist.get(j) + templist.get(j + 1);
					list.add(val);
				}
				list.add(1);
				templist = list;
			}
		}
		return list;
    }
	
	/**
	 * 是否是回文
	 * @param x
	 * @return
	 */
	public boolean isPalindrome(int x) {
		if(x<0)
			return false;
        boolean ret = true;
        String str = String.valueOf(x);
        for(int i = 0;i<(str.length())/2;i++){
        	ret &= str.charAt(i)==str.charAt(str.length()-1-i);
        }
        
        return ret;
    }
	
	/**
	 * Single Number 
	 * @param A
	 * @return
	 */
	 public int singleNumber(int[] A) {
		 if(A==null)
			 return -1;
		 if(A.length==1)
			 return A[0];
		 int ans = 0;
		 for(int i= 0;i<=A.length-1;i++){
			 ans ^= A[i];
		 }
		 return ans;
	 }
	 
	 public int maxDepth(TreeNode root) {
		 if(root==null)
    		return 0;
		 if(root.left==null) return maxDepth(root.right)+1;
		 if(root.right==null) return maxDepth(root.left)+1;
		 return Math.max(minDepth(root.right), maxDepth(root.left))+1;
	 }	
	 
	 public boolean isSameTree(TreeNode p, TreeNode q) {
		 if(p==null && q==null)
			 return true;
		 if(p==null && q!=null)
			 return false;
		 if(p!=null && q==null)
			 return false;
	     return isSameTree(p.left, q.left) && isSameTree(p.right,q.right) && p.val==q.val;
	 }
	 
    public int searchInsert(int[] A, int target) {
    	if(A==null)
    		return 0;
    	for(int i=0;i<A.length;i++){
    		if(target<=A[i]){
    			return i;
    		}
    	}

    	return A.length;
    }
	    
    public void sortColors(int[] A) {
        int red = 0;
        int white = 0;
        int blue = 0;
        for(int a:A){
        	if(a==0) red++;
        	else if(a==1) white++;
        	else if(a==2) blue++;
        }
        for(int i=0;i<A.length;i++){
        	if(i<red) A[i]= 0;
        	else if(i>=red && i<white+red) A[i]= 1;
        	else if(i>=white+red && i<white+red+blue) A[i]= 2;
        }
    }
    
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public ListNode deleteDuplicates(ListNode head) {
    	if(head==null)
    		return null;
    	ListNode ret = new ListNode(head.val);
    	ListNode newList = ret;
    	ListNode nodeCurr = head;
    	while(nodeCurr != null){
    		if(nodeCurr.val != newList.val){
    			newList.next = new ListNode(nodeCurr.val);
    			newList = newList.next;
    		}
    		nodeCurr = nodeCurr.next;
    	}
    	
    	return ret;
    }
    
    public int climbStairs(int n) {
    	if(n<=0)
    		return 0;
    	if(n==1)
    		return 1;
    	else if(n==2)
    		return 2;
    	else{
    		return climbStairs(n-1)+climbStairs(n-2);
    	}
    }
    
    public int climbStairs1(int n) {
    	if(n<=0)
    		return 0;
    	if(n==1)
    		return 1;
    	else if(n==2)
    		return 2;
    	else{
	    	int[] a = new int[n+1];
	    	a[0] = 0;
	    	a[1] = 1;
	    	a[2] = 2;
	    	for(int i = 3;i < n+1; i++){
	    		a[i] = a[i-1]+a[i-2];
	    	}
	    	return a[n];
    	}
    }
    
    /**
     * Valid Number
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
    	if(s==null)
    		return false;
    	s = s.trim();
    	if(s.isEmpty())
    		return false;
        String pat = "^[+-]?(\\d+|\\d?\\.\\d+|\\d+(\\.\\d+)?|\\d+\\.\\d*|\\d+e[+-]?\\d+|\\d+\\.\\d*e[+-]?\\d+|\\d*\\.\\d+e[+-]*\\d+)$";
    	//String pat = "^\\d+(\\.\\d+)?$";
        return java.util.regex.Pattern.compile(pat).matcher(s).matches();
    }
    
    /**
     * Merge Sorted Array,合并排序的合并部分,
     * 不用插入排序，这样需要整体搬移数组
     * @param A 有序数组
     * @param m 有序数组A元素个数
     * @param B 有序数组
     * @param n 有序数组B元素个数
     */
    public void merge(int A[], int m, int B[], int n) {
        int i=0,j=0;
        int k=0;
        int[] C = new int[m+n+1];
        while(i<m && j<n){
        	if(A[i]<B[j]){
        		C[k++] = A[i++];
        	}
        	else{
        		C[k++] = B[j++];
        	}
        }
        while(i<m){
        	C[k++] = A[i++];
        }
        while(j<n){
        	C[k++] = B[j++];
        }
        for(i=0;i<k;i++){
        	A[i] = C[i];
        }
    }
    
    /**
     * 深度优先搜索DFS，剪枝
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
    	List<String> list = new ArrayList<String>();
    	if(s==null)
    		return list;
    	if(s.length()<4 || s.length()>12)
    		return list;
    	
    	dfsIP(s, 0);
    	
    	return ips;
    }
    
    Stack<Integer> dotIndexList = new Stack<Integer>();
    ArrayList<String> ips = new ArrayList<String>();
    public void dfsIP(String s,int cur){
    	if(dotIndexList.size()==4 && cur==s.length()){
    		/*
    		for (Integer integer : dotIndexList) {
    			System.out.print(integer+" ");
			}
    		System.out.println();
    		*/
    		ips.add(dotIndexList.get(0)+"."
    		+dotIndexList.get(1)
    		+"."+dotIndexList.get(2)
    		+"."+dotIndexList.get(3));
    		return;
    	}
    	if(cur+1>=s.length()+1 || dotIndexList.size()>=4)
    		return;
    	dotIndexList.push(Integer.parseInt(s.substring(cur, cur+1)));
		dfsIP(s, cur+1);
		dotIndexList.pop();
    	
    	if(cur+2>=s.length()+1 || s.substring(cur, cur+1).equals("0") || dotIndexList.size()>=4)
			return;
    	dotIndexList.push(Integer.parseInt(s.substring(cur, cur+2)));
		dfsIP(s, cur+2);
		dotIndexList.pop();
		
		if(cur+3>=s.length()+1 || s.substring(cur, cur+1).equals("0") || dotIndexList.size()>=4)
			return;
		if(Integer.parseInt(s.substring(cur, cur+3))<=255){
			dotIndexList.push(Integer.parseInt(s.substring(cur, cur+3)));
			dfsIP(s, cur+3);
			dotIndexList.pop();
		}
    }
    
    /**
     * Remove Duplicates from Sorted Array 
     * @param A
     * @return
     */
    public int removeDuplicates(int[] A) {
    	if(A == null || A.length == 0){
    		return 0;
    	}
    	int index = 0;
    	for(int i = 1;i < A.length; i++){
    		if(A[index] != A[i]){
    			A[++index] = A[i];
    		}
    	}
    	return index + 1;
    }
    
    /**
     * Remove Duplicates from Sorted Array II 
     * @param A
     * @return
     */
    public int removeDuplicatesII(int[] A) {
    	if(A == null || A.length == 0){
    		return 0;
    	}
    	int cnt = 1;
    	int num = 1;
    	for(int i = 1; i < A.length; i++){
    		if(A[i] == A[i-1]){
    			cnt++;
    			if(cnt < 3){
    				A[num++] = A[i];
    			}
    		}
    		else{
    			A[num++] = A[i];
    			cnt = 1;
    		}
    	}
    	
        return num;
    }
    
    public int search(int[] A, int target) {
    	return binarySearch(A, 0, A.length - 1, target);
    }
    
    public static int binarySearch(int[] A,int s,int e,int target){
    	int mid = (s+e)/2;
    	if(target == A[mid])
    		return mid;
    	if(s >= e)
    		return -1;
    	if(A[mid] >= A[e]){
    		//前半部分有序
    		if(target >= A[s] && target < A[mid]){
    			return binarySearch(A, s, mid - 1, target);
    		}
    		else{
    			return binarySearch(A, mid + 1, e, target);
    		}
    	}
    	else{
    		//后半部分有序
    		if(target > A[mid] && target <= A[e]){
    			return binarySearch(A, mid + 1, e, target);
    		}
    		else{
    			return binarySearch(A, s, mid - 1, target);
    		}
    	}
    }
    
    /**
     * 打印子集
     * @param S
     * @return
     */
    public List<List<Integer>> subsets(int[] S) {
    	Arrays.sort(S);
    	List<List<Integer>> listlist = new ArrayList<List<Integer>>();
    	ArrayList<Integer> list;
    	int n = 1<<S.length;
    	for(int i=0;i<n;i++){
    		list = new ArrayList<Integer>();
    		//add set elements
    		for(int k = 0;k < S.length;k++){
    			if((i & (1<<k)) > 0){
    				list.add(S[k]);
    			}
    		}
    		Collections.sort(list);
    		listlist.add(list);
    	}
    	
    	return listlist;
    }
    
    /**
     * 子集生成
     * DFS方法
     * @param S
     * @return
     */
    public List<List<Integer>> subsets1(int[] S) {
    	Arrays.sort(S);
    	List<List<Integer>> listlist = new ArrayList<List<Integer>>();
    	int[] B = new int[S.length];
    	print_subset(S,B,0,listlist);
    	return listlist;
    }
    
    /**
     * 递归产生子集
     * @param S
     * @param B
     * @param cur
     * @param listlist
     */
    static void print_subset(int[] S,int[] B,int cur,List<List<Integer>> listlist){
    	if(cur == S.length){
    		ArrayList<Integer> list = new ArrayList<Integer>();
    		for(int i=0;i<S.length;i++){
    			if(B[i]==1)
    				list.add(S[i]);
    		}
    		listlist.add(list);
    		return;
    	}
    	B[cur] = 0;
    	print_subset(S, B, cur+1, listlist);
    	B[cur] = 1;
    	print_subset(S, B, cur+1, listlist);
    }
    
    /**
     * 包含重复元素的子集枚举
     * @param S
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] num) {
    	ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(num == null || num.length ==0) {
            return result;
        }
        Arrays.sort(num);
        subsetsHelper(result, list, num, 0);

        return result;
    }
    
    /**
     * DFS/BackTrack
     * @param result
     * @param list
     * @param S
     * @param pos
     */
    private void subsetsHelper(ArrayList<List<Integer>> result,
            ArrayList<Integer> list, int[] S, int pos) {

            result.add(new ArrayList<Integer>(list));
            
            for (int i = pos; i < S.length; i++) {
                if ( i != pos && S[i] == S[i - 1]) {
                    continue;
                }    
                list.add(S[i]);
                //递归到下一层
                subsetsHelper(result, list, S, i + 1);
                //回溯
                list.remove(list.size() - 1);
            }
    }
    
    /**
     * Word Search
     * 每个字母不能重复使用
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
    	if(board==null || word == null)
    		return false;
    	boolean res = false;
    	//初始化访问矩阵
    	boolean[][] visited = new boolean[board.length][];
    	for(int i=0;i<visited.length;i++){
    		visited[i] = new boolean[board[0].length];
    		for(int j=0;j<visited[i].length;j++){
    			visited[i][j] = false;
    		}
    	}
    	for(int i=0;i<board.length;i++){
    		for(int j=0;j<board[0].length;j++){
    			if(board[i][j] == word.charAt(0)){
    				visited[i][j] = true;
    				res = existHelper(board, word, 1, i, j,-1,-1,visited);
    				visited[i][j] = false;
    				if(res)
    					return true;
    				else
    					continue;
    			}
    		}
    	}
        return res;
    } 
    
    private static boolean existHelper(char[][] board, String word,int cur,int x,int y,
    		int dx_last,int dy_last,boolean[][] visited){
    	if(cur == word.length()){
    		return true;
    	}
    	int[] dx = {1,0,-1,0};
    	int[] dy = {0,1,0,-1};
    	//下一步的时候，不能回退(方向不能返回)
    	for(int i = 0;i < dx.length; i++){
    		if(dx[i]+dx_last==0 && dy[i]+dy_last==0)
    			continue;
			int cx = x + dx[i];
			int cy = y + dy[i];
			if(cx >= 0 && cx < board.length && cy >= 0 && cy < board[0].length
					&& board[cx][cy] == word.charAt(cur)){
				if(visited[cx][cy])
					continue;
				visited[cx][cy] = true;
				if(existHelper(board,word,cur+1,cx,cy,dx[i],dy[i],visited))
					return true;
				else {
					visited[cx][cy] = false;
					continue;
				}
    		}
    	}
    	return false;
    }
    
    /**
     * DP方法：d[i][j] = d[i+1][j]+d[i][j+1]
     * 注意溢出
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
    	if(m<=0 || n<=0)
    		return 0;
    	if(m==1 || n==1)
    		return 1;
    	double[][] d = new double[m][];
    	for(int i=0 ; i<d.length ; i++) { 
    		 d[i] = new double[n];
    	}
    	d[m-1][n-1] = 1;
    	d[m-2][n-1] = 1;
    	d[m-1][n-2] = 1;
    	for(int i=m-1;i>=0;i--){
    		for(int j=n-1;j>=0;j--){
    			if(i==m-1 || j==n-1)
    				d[i][j] = 1;
    			else
    				d[i][j] = d[i+1][j]+d[i][j+1];
    		}
    	}
    	
    	return (int)d[0][0];
    }
    
    /**
     * Unique Paths
     * DFS在m和n太大的时候会出现time limited error
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
    	int[] res = new int[1];
    	uniquePathsHelper(m, n, 0, 0, res);
        return res[0];
    }
    
    private void uniquePathsHelper(int m,int n,int x,int y,int[] cnt){
    	if(x>m-1 || y>n-1)
    		return;
    	if(x==m-1 && y==n-1){
    		cnt[0]++;
    		return;
    	}
    	//向右走
    	if(y<n-1){
    		uniquePathsHelper(m,n,x,y+1,cnt);
    	}
    	//向下走
    	if(x<m-1){
	    	uniquePathsHelper(m,n,x+1,y,cnt);
    	}
    }
    
    /**
     * Unique Paths II 
     * 有障碍的路径数目
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length==0)
    		return 0;
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	if(obstacleGrid[m-1][n-1] == 1)
    		return 0;
    	double[][] d = new double[m][];
    	for(int i=0 ; i<d.length ; i++) { 
    		 d[i] = new double[n];
    	}
    	d[m-1][n-1] = 1;
    	
    	for(int i=m-1;i>=0;i--){
    		for(int j=n-1;j>=0;j--){
    			if(i==m-1 && j==n-1)
    				continue;
    			//最右边一列
    			if(j==n-1){
    				d[i][j] = d[i+1][j];
    				if(obstacleGrid[i][j] == 1)
        				d[i][j] = 0;
    				continue;
    			}
    			//最下面一行
    			if(i==m-1){
    				if(obstacleGrid[i][j] == 1)
        				d[i][j] = 0;
    				else
    					d[i][j] = d[i][j+1];
    				continue;
    			}
    			if(obstacleGrid[i][j] == 1)
    				d[i][j] = 0;
    			else
    			{
    				if(i==m-1 || j==n-1)
        				d[i][j] = 1;
    				else
    					d[i][j] = d[i+1][j]+d[i][j+1];
    			}
    		}
    	}
    	
    	return (int)d[0][0];  
    }
    
    /**
     * Two Sum
     * 双重循环时间复杂度太高
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum1(int[] numbers, int target) {
    	int[] res = new int[2];
    	if(numbers == null || numbers.length < 2)
    		return res;
    	boolean has = false;
    	for(int i=0;i<numbers.length-1;i++){
    		for(int j=i+1;j<numbers.length;j++){
    			if(numbers[i]+numbers[j] == target){
    				has = true;
    				res[0] = i+1;
    				res[1] = j+1;
    				break;
    			}
    		}
    	}
    	if(has){
    		Arrays.sort(res);
    	}
    	return res;
    }
    
    /**
     * Two Sum
     * 使用HashMap
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
    	Map<Integer, Integer> map = new HashMap<>(numbers.length*2);
        for(int i=0;i<numbers.length;i++){
            Integer company = map.get(target-numbers[i]);
            if(company==null)
                map.put(numbers[i], i);
            else
                return new int[]{company+1,i+1};
        }
        return null;
    }
    
    /**
     * 先排序后查找
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
    	int[] bak = new int[numbers.length];
    	for(int i=0;i<numbers.length;i++){
    		bak[i] = numbers[i];
    	}
    	int i=0,j=numbers.length-1;
    	Arrays.sort(numbers);
    	while(i<j){
    		if(numbers[i]+numbers[j] == target){
    			int x = numbers[i];
    			int y = numbers[j];
    			//找到元素，查找索引
    			//一个从前往后，一个从后往前
    			i = 0;
    			j = numbers.length-1; 
    			while(i<numbers.length){
    				if(bak[i] == x)
    					break;
    				i++;
    			}
    			while(j>=0){
    				if(bak[j] == y)
    					break;
    				j--;
    			}
    			int[] res = new int[]{i+1,j+1};
    			Arrays.sort(res);
    			return res;
    		}
    		else if(numbers[i]+numbers[j] < target){
    			i++;
    		}
    		else{
    			j--;
    		}
    	}
    	
        return null;
    }
    
    /**
     * Valid Palindrome 
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
    	if(s==null){
    		return false;
    	}
    	if(s.equals("")){
    		return true;
    	}
    	s = s.toLowerCase();
    	List<Character> list = new ArrayList<>();
    	for(int i=0;i<s.length();i++){
    		if((s.charAt(i)>='a' && s.charAt(i)<='z')
    				||(s.charAt(i)>='A' && s.charAt(i)<='Z')||(s.charAt(i)>='0' && s.charAt(i)<='9')){
    			list.add(s.charAt(i));
    		}
    	}
    	for(int i=0;i<list.size()/2;i++){
    		if(list.get(i) != list.get(list.size()-1-i)){
    			return false;
    		}
    	}
    	return true;
    }
    
    /**
     * Trapping Rain Water 
     * @param height
     * @return
     */
    public int trap(int[] height) {
    	if(height == null || height.length < 3){
    		return 0;
    	}
    	int n = height.length;
    	int[] leftHighest = new int[n];
    	int[] rightHighest = new int[n];
    	int max = 0;
    	leftHighest[0] = 0;
    	for (int i=1; i<n; i++) {
            if (height[i-1] > max) {
                max = height[i-1];
            }
            leftHighest[i] = max;
        }
    	
    	max = 0;
	    rightHighest[n-1] = 0;
	    for (int i=n-2; i>=0; i--) {
	        if (height[i+1] > max) {
	            max = height[i+1];
	        }
	        rightHighest[i] = max;
	    }
    	
	    int sum = 0;
	    for (int i=0; i<n; i++) {
	        int water = Math.min(leftHighest[i], rightHighest[i]) - height[i];
	        if (water > 0) {
	            sum += water;
	        }
	    }
    	
        return sum;
    }
    
    /**
     * Happy Number
     * 需要判断无限循环
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        boolean res = true;
        Set<Integer> set = new HashSet<>();
        int val = n;
        int sum = 0;
        while(val != 1){
	        while(val > 0){
	        	sum += (val%10)*(val%10);
	        	val = val/10;
	        }
	        if(set.contains(sum)){
	        	return false;
	        }
	        val = sum;
	        sum = 0;
	        set.add(val);
        }
        return res;
    }
    
    /**
     * Binary Tree Preorder Traversal 
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	if(root == null)
    		return list;
    	
    	list.add(root.val);
    	list.addAll(preorderTraversal(root.left));
    	list.addAll(preorderTraversal(root.right));
    	
        return list;
    }
    
    /**
     * Binary Tree Postorder Traversal
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	if(root == null)
    		return list;
    	
    	list.addAll(postorderTraversal(root.left));
    	list.addAll(postorderTraversal(root.right));
    	list.add(root.val);
    	
        return list;
    }
    
    /**
     * Maximum Subarray 
     * 分治法实现Divide and Conquer
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
    	int res = 0;
    	if(nums.length  == 1)
    		return nums[0];
    	res = maxSubArrayHelper(nums,0,nums.length);
        return res;
    }
    
    private int maxSubArrayHelper(int[] nums, int x, int y) {
    	if(y-x==1)
    		return nums[x];
    	int m = x+(y-x)/2;
    	int max = Math.max(maxSubArrayHelper(nums, x, m), 
    			maxSubArrayHelper(nums, m, y));
    	int v = 0,L,R;
    	L = nums[m-1];
    	for(int i = m-1;i>=x;i--){
    		v+=nums[i];
    		L = Math.max(L, v);
    	}
    	v = 0;
    	R = nums[m];
    	for(int i = m;i<y;i++){
    		v+=nums[i];
    		R = Math.max(R, v);
    	}
    	
    	return Math.max(max, L+R);
    }
    
    /**
     * Maximum Subarray 
     * 动态规划实现
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
    	int res = 0;
    	if(nums ==null || nums.length==0)  
            return res;
    	int global = nums[0];
    	int local = nums[0];
    	for(int i = 1;i<nums.length;i++){
    		local = Math.max(nums[i], local+nums[i]);
    		global = Math.max(local, global);
    	}

        return global;
    }
    
    /**
     * Sqrt(x) 
     * 分治法Divide and Conquer
     * 牛顿迭代法，数值分析
     * X[k+1] = 1/2*(x[k]+n/x[k]);
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        double v = 1.0;  
        while(Math.abs(v*v-x) > 1e-5)  
        {  
            v = (v+x/v)/2;  
        }  
      
        return (int)v; 
    }
    
    /**
     * Sort List
     * 快排的思想
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
    	if(head == null)
    		return null;
    	quickSortList(head, null);
    	return head;
    }
    
    private void quickSortList(ListNode begin,ListNode end){
    	if(begin != end){
    		ListNode partion = partion(begin, end);
    		quickSortList(begin, partion);
    		quickSortList(partion.next,end);
    	}
    }
    
    private ListNode partion(ListNode begin,ListNode end){
    	int key = begin.val;
    	ListNode p = begin;
    	ListNode q = p.next;
    	int tmp;
    	while(q!=end){
    		if(q.val < key){
    			p = p.next; 
    			tmp = p.val;
    			p.val = q.val;
    			q.val = tmp;
    		}
    		q = q.next;
    	}
    	tmp = p.val;
		p.val = begin.val;
		begin.val = tmp;
    	return p;
    }
    
    /**
     * 3Sum 
     * @param num
     * @return
     */
    public List<List<Integer>> threeSum(int[] num) {
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	 if (num == null || num.length < 3) return ret;  
         
         Arrays.sort(num);  
           
         int len = num.length;
         //遍历数组
         for (int i = 0; i < len-2; i++) {
        	 //
             if (i > 0 && num[i] == num[i-1]) {
            	 //与前一个数重复
            	 continue;  
             }
             find3Sum(ret,num, i+1, len-1, num[i]);  
         }  
           
         return ret;  
    }
    
    public void find3Sum(List<List<Integer>> ret,int[] num, int begin, int end, int target) {  
        int l = begin, r = end;  
        while (l < r) {  
            if (num[l] + num[r] + target == 0) {  
                List<Integer> ans = new ArrayList<Integer>();  
                ans.add(target);  
                ans.add(num[l]);  
                ans.add(num[r]);
                ret.add(ans);
                //略过重复的数
                while (l < r && num[l] == num[l+1]) {
                	l++;  
                }
                while (l < r && num[r] == num[r-1]) {
                	r--;  
                }
                l++;  
                r--;  
            } else if (num[l] + num[r] + target < 0) {  
                l++;  
            } else {  
                r--;  
            }  
        }  
    }  
    
    /**
     * Word Break
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, Set<String> wordDict) {
    	if(s==null || s.length() == 0){
    		return false;
    	}
    	boolean[] res = new boolean[s.length()+1];
    	res[0] = true;
    	for(int i=0;i<s.length();i++){
    		StringBuilder str = new StringBuilder(s.substring(0, i+1));
    		for(int j=0;j<=i;j++){
    			if(res[j] && wordDict.contains(str.toString())){
    				res[i+1] = true; 
    				break;
    			}
    			str.deleteCharAt(0);
    		}
    	}
    	
        return res[s.length()];
    }
    
    /**
     * Unique Binary Search Trees
     * http://yuanhsh.iteye.com/blog/2175677
     * 卡特兰数
     * 保证二叉排序树的性质，选取一个根节点，左边作为左子树，右边作为右子树
     * 前序遍历有序
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if(n<=1) return 1;
        int[] c = new int[n+1];
        c[0]=c[1]=1;
        for(int i=2; i<=n; i++) {
            for(int j=0; j<i; j++) {
                c[i] += c[j]*c[i-j-1];
            }
        }
        return c[n];
    }
    
    /**
     * Unique Binary Search Trees
     * https://leetcodenotes.wordpress.com/2013/10/01/leetcode-unique-binary-search-trees-%E7%BB%99n%EF%BC%8C1n%E7%9A%84%E6%95%B0%E5%AD%97%E8%83%BD%E7%BB%84%E6%88%90%E5%A4%9A%E5%B0%91%E7%A7%8D%E4%B8%8D%E5%90%8Crotation%E7%9A%84bst/
     * Time Limit Exceeded
     * @param n
     * @return
     */
    public int numTrees1(int n) {
    	return numTreesHelper(1, n);
    }
    
    int numTreesHelper(int p,int q){
    	if(p >= q)
    		return 1;
    	int num = 0;
    	for(int i = p;i<=q;i++){
    		int left = numTreesHelper(p, i-1);
    		int right = numTreesHelper(i+1, q);
    		num+=left*right;
    	}
    	return num;
    }
    
    /**
     * Simplify Path 
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
    	if(path == null || path.length()==0){
    		return "";
    	}
    	Stack<String> stack = new Stack<String>();
    	int i = 0;
    	while(i < path.length()){
    		int index = i;
    		StringBuilder builder = new StringBuilder();
    		while(i<path.length() && path.charAt(i)!='/'){
    			builder.append(path.charAt(i));
    			i++;
    		}
    		if(index != i){
    			String str = builder.toString();
    			if(str.equals("..")){
    				if(!stack.isEmpty()){
    					stack.pop();
    				}
    			}
    			else if(!str.equals(".")){
    				stack.push(str);
    			}
    		}
    		i++;
    	}
    		
    	String res = "";
    	while(!stack.isEmpty()){
    		String name = stack.get(0);
    		stack.removeElementAt(0);
    		res += "/" + name;
    	}
    	
    	if(res.length() == 0){
    		res = "/";
    	}
    	
        return res;
    }
    
    /**
     * Path Sum II 
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(root == null){
    		//res.add(list);
    		return res;
    	}
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	list.add(root.val);
    	pathSumHelper(res,list,root,0,sum);    	
    	return res;
    }
    
    private void pathSumHelper(List<List<Integer>> res,ArrayList<Integer> list,
    		TreeNode node,int cursum,int sum){
    	if(node == null){
    		return;
    	}
    	if(node.val + cursum == sum && node.left==null && node.right==null){
    		res.add(new ArrayList<Integer>(list));
    	}
    	if(node.left!=null)  
        {
    		list.add(node.left.val);
    		pathSumHelper(res, list,node.left, cursum+node.val , sum);
    		list.remove(list.size()-1);
        }
    	if(node.right!=null){
    		list.add(node.right.val);
    		pathSumHelper(res, list,node.right, cursum+node.val , sum);
    		list.remove(list.size()-1);
    	}
    }
    
    /**
     * Single Number II 
     * @param nums
     * @return
     */
    public int singleNumberII(int[] nums) {
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	for(int num:nums){
    		map.put(num, map.get(num)==null?1:(Integer)map.get(num)+1);
    	}
    	for(int i:map.keySet()){
    		if((Integer)map.get(i) == 1){
    			return i;
    		}
    	}
    	
        return 0;
    }
    
    /**
     * 4Sum 
     * @param num
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] num, int target) {
    	Arrays.sort(num);
    	HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
     
    	for (int i = 0; i < num.length; i++) {
    		for (int j = i + 1; j < num.length; j++) {
    			int k = j + 1;
    			int l = num.length - 1;
     
    			while (k < l) {
    				int sum = num[i] + num[j] + num[k] + num[l];
     
    				if (sum > target) {
    					l--;
    				} else if (sum < target) {
    					k++;
    				} else if (sum == target) {
    					ArrayList<Integer> temp = new ArrayList<Integer>();
    					temp.add(num[i]);
    					temp.add(num[j]);
    					temp.add(num[k]);
    					temp.add(num[l]);
     
    					if (!hashSet.contains(temp)) {
    						hashSet.add(temp);
    						result.add(temp);
    					}
     
    					k++;
    					l--;
    				}
    			}
    		}
    	}
    	return result;
     }
    
    /**
     * Intersection of Two Linked Lists 
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
        	return null;
        }
    	ListNode h1 = headA;
    	ListNode h2 = headB;
    	int len1 = 0;
    	int len2 = 0;
    	while(h1.next != null){
    		h1 = h1.next;
    		len1++;
    	}
    	while(h2.next != null){
    		h2 = h2.next;
    		len2++;
    	}
    	if(h1!=h2){
    		return null;
    	}
    	
    	int k = 0;
    	int abs = Math.abs(len1 - len2);
    	h1 = headA;
    	h2 = headB;
    	if(len1 >= len2){
    		for(k = 0;k < abs;k++){
    			h1 = h1.next;
    		}
    		while(h1 != h2){
    			h1 = h1.next;
    			h2 = h2.next;
    		}
    		return h1;
    	}
    	else {
    		for(k = 0;k < abs;k++){
    			h2 = h2.next;
    		}
    		while(h1 != h2){
    			h1 = h1.next;
    			h2 = h2.next;
    		}
    		return h1;
    	}
    }
    
    /**
     * Linked List Cycle
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
    	if(head == null || head.next == null || head.next.next == null){
    		return false;
    	}
    	ListNode h1 = head.next;
    	ListNode h2 = head.next.next;
    	while(h1 != h2){
    		h1 = h1.next;
    		if(h1 == null)
    			return false;
    		h2 = h2.next;
    		if(h2 == null)
    			return false;
    		h2 = h2.next;
    		if(h2 == null)
    			return false;
    	}
    	
    	return true;
    }
    
    /**
     * Remove Nth Node From End of List 
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if(head == null)
    		return null;
    	if(n <= 0){
    		return head;
    	}
    	ListNode h = head;
    	int len = 0;
    	while(h != null){
    		h = h.next;
    		len++;
    	}
    	if(n > len){
    		return head;
    	}
    	
    	int k = len - n;
    	int i = 0;
    	ListNode pre = null;
    	h = head;
    	while(h != null){
    		if(i == k){
    			if(pre == null){
    				head = head.next;
    				return head;
    			}
    			//remove node
    			pre.next = h.next;
    			h = null;
    			return head;
    		}
    		i++;
    		pre = h;
    		h = h.next;
    	}
    	
        return head;
    }
    
    /**
     * Isomorphic Strings 
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
    	if(s==null||t==null){
    		return false;
    	}
    	if(s.length()!=t.length()){
    		return false;
    	}
    	
        return isIsomorphicHelper(s,t)&&isIsomorphicHelper(t,s);
    }
    
    private boolean isIsomorphicHelper(String s, String t){
    	HashMap<Character, Character> map = new HashMap<Character,Character>();
    	for(int i=0;i<s.length();i++){
    		char c = s.charAt(i);
    		char c1 = t.charAt(i);
    		if(map.containsKey(c)){
    			if(map.get(c) == c1){
    				continue;
    			}
    			else{
    				return false;
    			}
    		}
    		else{
    			map.put(c, c1);	
    		}
    	}
    	return true;
    }
    
    
    /**
	 * House Robber 
	 * @param nums
	 * @return
	 */
    public int rob(int[] nums) {
		if(nums.length ==0 )
			return 0;
	    if(nums.length ==1 )
	    	return nums[0];
	    int[] dp = new int[nums.length+1];
     	
     	dp[0] = 0; 
     	dp[1] = nums[0]; 
     	for(int i=2;i <= nums.length;i++){
     		dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
     	}
     	
         return dp[nums.length];
    }
    
    /**
     * Roman to Integer 
     * @param s
     * @return
     */
    public int romanToInt(String s) {
    	if(s==null || s.length() == 0){
    		return -1;
    	}
    	int res = char2int(s.charAt(0));
    	int last,cur;
    	for(int i=1;i<s.length();i++){
    		last = char2int(s.charAt(i-1));
    		cur = char2int(s.charAt(i));
    		if(cur <= last){
    			res += cur;
    		}
    		else{
    			res = res - 2 * last + cur;
    		}
    	}
        return res;
    }
    
    private int char2int(char c){
    	int res = 0;
    	switch(c){
    	case 'I':
    		res = 1;
    		break;
    	case 'V':
    		res = 5;
    		break;
    	case 'X':
    		res = 10;
    		break;
    	case 'L':
    		res = 50;
    		break;
    	case 'C':
    		res = 100;
    		break;
    	case 'D':
    		res = 500;
    		break;
    	case 'M':
    		res = 1000;
    		break;
    	}
    	return res;
    }
    
    /**
     * Remove Linked List Elements 
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
        	return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
        	if(pre == null){
        		if(cur.val == val){
        			head = cur.next;
        			pre = null;
        			cur = head;
        		}
        		else{
        			pre = cur;
        			cur = cur.next;
        		}
        	}
        	else
        	{
	        	if(cur.val == val){
	        		//delete node
	        		pre.next = cur.next;
	        		cur = pre.next;
	        	}
	        	else
	        	{
		        	pre = cur;
		        	cur = cur.next;
	        	}
        	}
        }
    	
    	return head;
    }
    
    /**
     * Binary Tree Right Side View 
     * 思路：层次遍历
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	if(root == null){
    		return list;
    	}
    	
    	List<TreeNode> queue = new ArrayList<TreeNode>();
    	queue.add(root);
    	TreeNode cur = null;
    	while(queue.size() != 0){
    		int cnt = queue.size();
    		for(int i=0;i<cnt;i++){
    			cur = queue.get(0);
    			queue.remove(0);
    			if(cur.left != null) {
    				queue.add(cur.left);
    			}
    			if(cur.right != null){
    				queue.add(cur.right);
    			}
    		}
    		list.add(cur.val);
    	}
    	return list;
    }
    
    /**
     * Reverse Linked List 
     * 超时：Time Limit Exceeded
     * @param head
     * @return
     */
    public ListNode reverseList0(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
        ListNode node = head;
        Stack<ListNode> stack = new Stack<ListNode>();
        while(node != null){
        	stack.push(node);
        	node = node.next;
        }
        head = stack.pop();
        node = head;
        while(!stack.isEmpty()){
        	node.next = stack.pop();
        	node = node.next;
        }
        
        return head;
    }
    
    /**
     * Reverse Linked List 
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        
        ListNode newlist = null;
        while(cur != null){
        	pre.next = newlist;
        	newlist = pre;
        	pre = cur;
        	cur = cur.next;
        }
        pre.next = newlist;
        newlist = pre;
        
        return newlist;
    }
    
    /**
     * Bitwise AND of Numbers Range 
     * 按位与
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
    	 if(m == 0){
             return 0;
         }
         int k = 1;
         while(m != n){
             m >>= 1;
             n >>= 1;
             k <<= 1;
         }
         return m * k;
    }
    
    /**
     * Longest Common Prefix 
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
    	if(strs == null || strs.length == 0)
    		return "";
        StringBuilder builder = new StringBuilder();
        int minLen = strs[0].length();
        for(int i=0;i<strs.length;i++){
        	minLen = strs[i].length() < minLen?strs[i].length():minLen;
        }
        if(minLen == 0)
        	return "";
        boolean isSame = true;
        for(int i=0;i<minLen;i++){
        	isSame = true;
        	char c = strs[0].charAt(i);
        	for(int j=1;j<strs.length;j++){
        		isSame &= (c^strs[j].charAt(i))==0;
        		c = strs[j].charAt(i);
        	}
        	if(isSame){
        		builder.append(c);
        	}
        	else{
        		return builder.toString();
        	}
        }
        
        return builder.toString();
    }
    
    /**
     * Count Primes 
     * @param n
     * @return
     */
    public int countPrimes0(int n) {
    	int cnt = 0;
        for(int i=1;i<n;i++){
        	if(isPrime0(i))
        		cnt++;
        }
        return cnt;
    }
    
    /**
     * Time Limit Exceeded
     * @param n
     * @return
     */
    public static boolean isPrime0(int n){
    	if(n<=1)
    		return false;
    	if(n==2||n==3)
    		return true;
    	for(int i = 2;i*i<=n;i++){
    		if(n%i == 0){
    			return false;
    		}
    	}
    	return true;
    }
    
    /**
     * Count Primes 
     * 埃式筛法
     * @param n
     * @return
     */
    public int countPrimes(int n) {
    	if(n <= 1)
    		return 0;
    	int res = 0;
    	int[] prime = new int[n+1];
    	boolean[] isPrime = new boolean[n+1];
    	
    	for(int i=0;i<n;i++){
    		isPrime[i] = true;
    	}
    	
    	isPrime[0] = false;
    	isPrime[1] = false;
    	
    	for(int i=2;i<n;i++){
    		if(isPrime[i]){
    			prime[res++] = i;
    			for(int j=2*i;j<n;j+=i){
    				isPrime[j] = false;
    			}
    		}
    	}
    	
    	return res;
    }
    
    /**
     * 
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
    	if(a == null || b == null)
    		return null;
    	if(a.length() == 0)
    		return b;
    	if(b.length() == 0)
    		return a;
        
    	StringBuilder builder = new StringBuilder();
    	StringBuilder strA = new StringBuilder(a);
        StringBuilder strB = new StringBuilder(b);
        int c = 0;
        while(strA.length()>0 && strB.length()>0){
        	char c1 = strA.charAt(strA.length()-1);
        	strA.deleteCharAt(strA.length()-1);
        	char c2 = strB.charAt(strB.length()-1);
        	strB.deleteCharAt(strB.length()-1);
        	if(c1 == '0' && c2 == '0'){
        		if(c == 0){
        			builder.append('0');
        			c = 0;
        		}
        		else{
        			builder.append('1');
        			c = 0;
        		}
        	}
        	else if(c1 == '1' && c2 == '0'){
        		if(c == 0){
        			builder.append('1');
        			c = 0;
        		}
        		else{
        			builder.append('0');
        			c = 1;
        		}
        	}
        	else if(c1 == '0' && c2 == '1'){
        		if(c == 0){
        			builder.append('1');
        			c = 0;
        		}
        		else{
        			builder.append('0');
        			c = 1;
        		}
        	}else{
        		if(c == 0){
        			builder.append('0');
        			c = 1;
        		}
        		else{
        			builder.append('1');
        			c = 1;
        		}
        	}
        }
        
        while(strA.length()>0){
        	char c1 = strA.charAt(strA.length()-1);
        	strA.deleteCharAt(strA.length()-1);
        	if(c1 == '0'){
        		if(c == 0){
        			builder.append('0');
        			c = 0;
        		}
        		else{
        			builder.append('1');
        			c = 0;
        		}
        	}
        	else{
        		if(c == 0){
        			builder.append('1');
        			c = 0;
        		}
        		else{
        			builder.append('0');
        			c = 1;
        		}
        	}
        }
        while(strB.length()>0){
        	char c1 = strB.charAt(strB.length()-1);
        	strB.deleteCharAt(strB.length()-1);
        	if(c1 == '0'){
        		if(c == 0){
        			builder.append('0');
        			c = 0;
        		}
        		else{
        			builder.append('1');
        			c = 0;
        		}
        	}
        	else{
        		if(c == 0){
        			builder.append('1');
        			c = 0;
        		}
        		else{
        			builder.append('0');
        			c = 1;
        		}
        	}
        }
        
        if(c == 1){
        	builder.append('1');
        }
        
        return builder.reverse().toString();
    }
    
    /**
     * Number of Islands 
     * DFS,搜索过的填充为0
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int res = 0;
        
        for(int i=0;i<grid.length;i++){
    		for(int j=0;j<grid[0].length;j++){
    			if(grid[i][j] == '1'){
    				numIslandsHelper(grid,i,j);
    				res++;
    			}
    		}
    	}
        
        return res;
    }
    
    private void numIslandsHelper(char[][] grid,int x,int y) {
    	grid[x][y] = '0';
    	
    	int[] dx = {1,0,-1,0};
    	int[] dy = {0,1,0,-1};
    	//下一步的时候，不能回退(方向不能返回)
    	for(int i = 0;i < dx.length; i++){
    			int nx = x + dx[i];
    			int ny = y + dy[i];
    			if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length
    					&& grid[nx][ny] == '1'){
    				numIslandsHelper(grid, nx, ny);
    			}
    	}
    }
    
    /**
     * Balanced Binary Tree 
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
    	if(root == null)
    		return true;
    	int l = isBalancedHelper(root.left);
    	int r = isBalancedHelper(root.right);
    	int diff = l - r;
    	if(diff > 1 || diff < -1)
    		return false;
    	 
	    return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int isBalancedHelper(TreeNode root){
    	if(root == null){
    		return 0;
    	}
    	int l = isBalancedHelper(root.left);
    	int r = isBalancedHelper(root.right);
    	
    	return 1+(l>r?l:r);
    }
    
    /**
     * Symmetric Tree 
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
        	return true;
        }
        return isSymmetricHelper(root.left,root.right);
    }
    
    private boolean isSymmetricHelper(TreeNode left,TreeNode right){
    	if(left == null && right == null)
    		return true;
    	if((left != null && right == null) 
    			|| (left == null && right != null) 
    			|| (left.val != right.val))
    		return false;
    	return isSymmetricHelper(left.left, right.right) && 
    			isSymmetricHelper(left.right, right.left);
    }
    
    /**
     * Merge Two Sorted Lists
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(l1 == null)
    		return l2;
    	if(l2 == null)
    		return l1;
    	
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        ListNode head = null;
        ListNode cur = null;
        while(p1!=null && p2!=null){
        	if(p1.val <= p2.val){
        		if(head == null){
        			head = new ListNode(p1.val);
        			cur = head;
        			p1 = p1.next;
        			continue;
        		}
        		cur.next = new ListNode(p1.val);
        		cur = cur.next;
        		p1 = p1.next;
        	}
        	else{
        		if(head == null){
        			head = new ListNode(p2.val);
        			cur = head;
        			p2 = p2.next;
        			continue;
        		}
        		cur.next = new ListNode(p2.val);
        		cur = cur.next;
        		p2 = p2.next;
        	}
        }
        
        while(p1!=null){
        	cur.next = new ListNode(p1.val);
        	cur = cur.next;
        	p1 = p1.next;
        }
        
        while(p2!=null){
        	cur.next = new ListNode(p2.val);
        	cur = cur.next;
        	p2 = p2.next;
        }
        
        return head;
    }
    
    /**
     * Binary Tree Level Order Traversal
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> listlist = new ArrayList<List<Integer>>();
    	List<TreeNode> list = new ArrayList<TreeNode>();
    	List<Integer> list1 ;
    	if(root == null)
    		return listlist;
    	list.add(root);
    	TreeNode node;
    	while(list.size() != 0){
    		int n = list.size();
    		list1 = new ArrayList<Integer>();
    		for(int i=0;i<n;i++){
    			node = list.get(0);
        		list.remove(0);
        		list1.add(node.val);
        		
        		if(node.left != null)
        			list.add(node.left);
        		if(node.right != null)
        			list.add(node.right);
    		}
    		listlist.add(list1);
    	}
    	return listlist;
    }
    
    /**
     * Binary Tree Level Order Traversal II 
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> listlist = new ArrayList<List<Integer>>();
    	List<TreeNode> list = new ArrayList<TreeNode>();
    	List<Integer> list1 ;
    	if(root == null)
    		return listlist;
    	list.add(root);
    	TreeNode node;
    	while(list.size() != 0){
    		int n = list.size();
    		list1 = new ArrayList<Integer>();
    		for(int i=0;i<n;i++){
    			node = list.get(0);
        		list.remove(0);
        		list1.add(node.val);
        		
        		if(node.left != null)
        			list.add(node.left);
        		if(node.right != null)
        			list.add(node.right);
    		}
    		listlist.add(list1);
    	}
    	Collections.reverse(listlist);
    	return listlist;
    }
    
    /**
     * Implement strStr() 
     * Naive Search (Accept)
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
    	if(haystack == null)
    		return -1;
    	int N = haystack.length();
    	int M = needle.length();
    	
    	int i,j;
    	for (i = 0, j = 0; i < N && j < M; i++){
            if (haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            else{
                i -= j;//go back
                j = 0;
            }
        }
        if (j == M){
            return i - M;//match
        }
        else {
            return -1;//not match
        }
    }
    
    /**
     * Implement strStr() 
     * KMP algorithm
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr1(String haystack, String needle) {
    	if(haystack == null)
    		return -1;
    	//TODO 
    	
    	
        return -1;
    }
    
    /**
     * Add Two Numbers 
     * 左边对齐
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if(l1 == null)
    		return l2;
    	if(l2 == null)
    		return l1;
    	
    	ListNode head = null;
    	ListNode cur = null;
    	int c = 0;
    	
    	ListNode node1 = l1;
    	ListNode node2 = l2;

    	while(node1!=null && node2!=null){
			if(node1.val + node2.val + c >= 10){
				if(head == null){
					head = new ListNode(node1.val + node2.val+c - 10);
    				cur = head;
				}
				else
				{
					cur.next = new ListNode(node1.val + node2.val+c - 10);
					cur = cur.next;
				}
				c = 1;
			}
			else{
				if(head == null){
					head = new ListNode(node1.val + node2.val+c);
    				cur = head;
				}
				else{
					cur.next = new ListNode(node1.val + node2.val+c);
					cur = cur.next;
				}
				c = 0;
			}
			node1 = node1.next;
			node2 = node2.next;
		}
    	
    	while(node1 != null){
    		if(node1.val + c >= 10){
    			cur.next = new ListNode(node1.val + c - 10);
    			c = 1;
    		}
    		else{
    			cur.next = new ListNode(node1.val + c);
    			c = 0;
    		}
    		node1 = node1.next;
			cur = cur.next;
    	}
    	
    	while(node2 != null){
    		if(node2.val + c >= 10){
    			cur.next = new ListNode(node2.val + c - 10);
    			c = 1;
    		}
    		else{
    			cur.next = new ListNode(node2.val + c);
    			c = 0;
    		}
    		node2 = node2.next;
			cur = cur.next;
    		
    	}
    	
    	
    	if(c == 1){
    		cur.next = new ListNode(1);
    	}
        
        return head;
    }
    
    /**
     * Add Two Numbers 
     * 右边对齐
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
    	if(l1 == null)
    		return l2;
    	if(l2 == null)
    		return l1;
    	
    	ListNode head = null;
    	ListNode cur = null;
    	int c = 0;
    	
    	int len1 = 0;
    	int len2 = 0;
    	ListNode node1 = l1;
    	ListNode node2 = l2;
    	while(node1 != null){
    		len1++;
    		node1 = node1.next;
    	}
    	while(node2 != null){
    		len2++;
    		node2 = node2.next;
    	}
    	
    	if(len1 <= len2){
    		node1 = l1;
    		node2 = l2;
    		int start = 0;
    		while(start < len2-len1){
    			if(head == null){
    				head = new ListNode(node2.val);
    				cur = head;
    			}
    			else{
    				cur.next = new ListNode(node2.val);
    				cur = cur.next;
    			}
    			node2 = node2.next;
    			start++;
    		}
    	}
    	else{
    		node1 = l1;
    		node2 = l2;
    		int start = 0;
    		while(start < len1-len2){
    			if(head == null){
    				head = new ListNode(node1.val);
    				cur = head;
    			}
    			else{
    				cur.next = new ListNode(node1.val);
    				cur = cur.next;
    			}
    			node1 = node1.next;
    			start++;
    		}
    	}
    	
    	while(node1!=null && node2!=null){
			if(node1.val + node2.val + c >= 10){
				if(head == null){
					head = new ListNode(node1.val + node2.val+c - 10);
    				cur = head;
				}
				else
				{
					cur.next = new ListNode(node1.val + node2.val+c - 10);
					cur = cur.next;
				}
				c = 1;
			}
			else{
				if(head == null){
					head = new ListNode(node1.val + node2.val+c);
    				cur = head;
				}
				else{
					cur.next = new ListNode(node1.val + node2.val+c);
					cur = cur.next;
				}
				c = 0;
			}
			node1 = node1.next;
			node2 = node2.next;
		}
    	
    	if(c == 1){
    		cur.next = new ListNode(1);
    	}
        
        return head;
    }
    
    /**
     * Combination Sum 
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> listlist = new ArrayList<List<Integer>>();
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	for(int i=0;i<candidates.length;i++){
    		list.add(candidates[i]);
    		combinationSumHelper(listlist, list, candidates, target - candidates[i]);
    		list.remove(list.size()-1);
    	}
    	return listlist;
    }
    
    private void combinationSumHelper(List<List<Integer>> listlist,List<Integer> list
    		 ,int[] candidates,int target){
    	if(target < 0){
    		return;
    	}
    	if(target == 0){
    		listlist.add(new ArrayList<Integer>(list));
    		return;
    	}
    	for(int i=0;i<candidates.length;i++){
    		if(candidates[i]>=list.get(list.size()-1)){
	    		list.add(candidates[i]);
	    		combinationSumHelper(listlist,list,candidates,target - candidates[i]);
	    		list.remove(list.size()-1);
    		}
    	}
    }
}
