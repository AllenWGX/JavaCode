package cn.live.wangongxi.leetcode.test;

import org.junit.Test;

import cn.live.wangongxi.leetcode.test.element.ListNode;

public class ReverseList {
	private void createList(ListNode first, int len) {
		for( int i = 1;i < len; ++i ) {
			ListNode next = new ListNode(i);
			first.setNext(next);	//first.next = next;
			first = next;
		}
	}
	
	private ListNode reverseList(ListNode last, ListNode cur) {
		ListNode ret = null;
		if( cur.getNext() == null ) {	//the last list node
			cur.setNext(last);	//reverse
			ret = cur;
		}else {
			ret = reverseList(cur, cur.getNext());
			cur.setNext(last);	//reverse
		}
		return ret;
	}
	
	private void printList(ListNode first) {
		while( first.getNext() != null ) {
			System.out.print(first.getVal() + "-->");
			first = first.getNext();
		}
		System.out.println(first.getVal());
	}
	
	@Test
	public void reverseList() {
		int len = 10;
		ListNode first = new ListNode(0);
		createList(first, len);
		printList(first);
		ListNode _first = reverseList(first,first.getNext());
		first.setNext(null);
		printList(_first);
	}
}
