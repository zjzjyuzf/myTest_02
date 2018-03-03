package com.yuzf.test;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

//合并
public class Test_01 {

	public ArrayList<Integer> merge(ArrayList<Integer> leftArr,ArrayList<Integer> rightArr){
		ArrayList<Integer> newArr = new ArrayList<Integer>();
		int left = 0;
		int right = 0;
		
		ArrayList<Integer> ll = new ArrayList<Integer>();
		ArrayList<Integer> rr = new ArrayList<Integer>();
		
		while(left < leftArr.size() && right < rightArr.size()) {
			if(leftArr.get(left) < rightArr.get(right)) {
				newArr.add(leftArr.get(left));
				ll.add(left);
				left++;
			}else {
				newArr.add(rightArr.get(right));
				rr.add(right);
				right++;
			}
		}
		
		for(int i = ll.size()-1; i >=0 ; i--) {
			leftArr.remove(leftArr.get(ll.get(i)));
			leftArr.remove((int)ll.get(i));
		}
		
		for(int j = rr.size()-1; j >=0 ; j--) {
			rightArr.remove(rightArr.get(rr.get(j)));
		}
		
		newArr.addAll(leftArr);
		newArr.addAll(rightArr);
		return newArr;
	}

	public ArrayList<Integer> mergeSort(ArrayList<Integer> arr) {

		if (arr.size() < 2) {
			return arr;
		}

		int middleSize = arr.size() / 2;
		ArrayList<Integer> leftArr = new ArrayList<Integer>();
		ArrayList<Integer> rightArr = new ArrayList<Integer>();
		
		int i = 0;
		for (; i < middleSize; i++) {
			leftArr.add(arr.get(i));
		}
		
		for(; i < arr.size(); i++) {
			rightArr.add(arr.get(i));   //Integer 与 int 需要 注意下
		}
		return merge(mergeSort(leftArr), mergeSort(rightArr));
	}

	@Test
	public void test() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(78);
		list.add(23);
		list.add(23);
		list.add(23);
		list.add(23);
		list.add(56);
		list.add(12);
		list.add(12);
		ArrayList<Integer> newList = mergeSort(list); 
		Iterator<Integer> it = newList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
