package com.suanfa.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 《算法竞赛入门经典》书籍题目
 * 
 * @author DC
 *
 */
public class Suanfa {
	public static void main(String[] args) {
		int[] A = { 1, 2, 4, 7 };
		Suanfa s = new Suanfa();
		//s.print_set(A, 0);
		//s.print_subset(3);
		//s.print_subset1(A, 0);
		s.partialSum(A, 13);
	}

	/**
	 * 打印子集
	 * 
	 * @param A
	 * @param cur
	 */
	public void print_set(int[] A, int cur) {
		if (cur == A.length) {
			for (int i = 0; i < cur; i++) {
				if (A[i] == 1)
					System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		A[cur] = 1;
		print_set(A, cur + 1);
		A[cur] = 0;
		print_set(A, cur + 1);
	}
	
	public void print_subset(int n,int s){
		for(int i =0 ;i<n;i++){
			if((s&(1<<i))>0)
				System.out.print(i);
		}
		System.out.println();
	}
	
	public void print_subset(int n){
		for(int i =0;i< (1<<n);i++){
			print_subset(n, i);
		}
	}
	
	public void print_subset1(int[] A,int cur){
		for(int i=0;i<cur;i++){
			System.out.print(A[i]+" ");
		}
		System.out.println();
		int s = cur>0?A[cur-1]+1:0;
		for(int i=s;i<A.length;i++){
			A[cur] = i;
			print_subset1(A, cur+1);
		}
	}
	
	/**
	 * 序列中是否有部分的和为k
	 * 《挑战程序设计竞赛2.1.4》
	 * @param a
	 * @param n
	 * @param k
	 */
	public List<Integer> partialSum(int[] a,int k){
		List<Integer> list = new ArrayList<Integer>();
		boolean ret = partialSumDfs(a, a.length, k,0,0,list);
		if(ret == true) 
			return list;
		else
			return null;
	}
	
	/**
	 * DFS搜索求和
	 * @param a
	 * @param n
	 * @param k
	 * @param i
	 * @param sum 新的和
	 * @return
	 */
	public static boolean partialSumDfs(int[] a,int n,int k,int i,int sum,List<Integer> list){
		//所有数字都已经选择完了，判断和是否为指定和
		if(i == n) return sum == k;
		//不选择a[i]，递归搜索
		if(partialSumDfs(a, n, k, i+1, sum,list)){
			return true;
		}
		//选择a[i]，递归搜索
		if(partialSumDfs(a, n, k, i+1, sum+a[i],list)){
			list.add(a[i]);
			return true;
		}
		//递归搜索不到结果，搜索失败
		return false;
	}
	
	
    
	
}
