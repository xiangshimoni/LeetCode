package com.suanfa.code;

import java.util.ArrayList;
import java.util.List;

/**
 * ���㷨�������ž��䡷�鼮��Ŀ
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
	 * ��ӡ�Ӽ�
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
	 * �������Ƿ��в��ֵĺ�Ϊk
	 * ����ս������ƾ���2.1.4��
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
	 * DFS�������
	 * @param a
	 * @param n
	 * @param k
	 * @param i
	 * @param sum �µĺ�
	 * @return
	 */
	public static boolean partialSumDfs(int[] a,int n,int k,int i,int sum,List<Integer> list){
		//�������ֶ��Ѿ�ѡ�����ˣ��жϺ��Ƿ�Ϊָ����
		if(i == n) return sum == k;
		//��ѡ��a[i]���ݹ�����
		if(partialSumDfs(a, n, k, i+1, sum,list)){
			return true;
		}
		//ѡ��a[i]���ݹ�����
		if(partialSumDfs(a, n, k, i+1, sum+a[i],list)){
			list.add(a[i]);
			return true;
		}
		//�ݹ������������������ʧ��
		return false;
	}
	
	
    
	
}
