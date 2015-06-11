package com.suanfa.code;

/**
 * 挑战程序设计竞赛
 * @author Duan Cong
 *
 */
public class Challenge {

	public static void main(String[] args) {
		int[] dir = new int[]{1,1,0,1,0,1,1};
		int res = calc(3,dir);
		System.out.println(res);
	}

	/**
	 * POJ 3276
	 * @param K
	 * @param dir
	 * @return
	 */
	static int calc(int K,int[] dir){
		int N = dir.length;
		int[] f = new int[N]; 
		int res = 0;
		int sum = 0;
		
		for(int i=0;i+K <= N;i++){
			if((dir[i]+sum) % 2 != 0){
				res++;
				f[i] = 1;
			}
			sum += f[i];
			if(i-K+1>=0){
				sum -= f[i-K+1];
			}
		}
		
		for(int i=N-K+1;i < N;i++){
			if((dir[i]+sum) % 2 != 0){
				return -1;
			}
			if(i-K+1>0){
				sum -= f[i-K+1];
			}
		}
		
		return res;
	}
}
