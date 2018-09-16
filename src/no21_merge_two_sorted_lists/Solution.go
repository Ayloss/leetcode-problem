package main

import "fmt"

type ListNode struct {
	Val int
	Next *ListNode
}

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	p := new(ListNode)
	p.Val = 0
	head := p

	// 把小的接到p的后边
	for l1 != nil && l2 != nil {
		if l1.Val < l2.Val {
			p, l1 = linkTail(p, l1)
		} else {
			p, l2 = linkTail(p, l2)
		}
	}

	// l2为空时
	for l1 != nil {
		p, l1 = linkTail(p, l1)
	}

	// l1为空时
	for l2 != nil {
		p, l2 = linkTail(p, l2)
	}

	return head.Next
}

// 把tail接到head后边,head同时移到tail
func linkTail(head *ListNode, tail *ListNode) (*ListNode, *ListNode) {
	head.Next = tail
	head = head.Next
	tail = tail.Next
	return head, tail
}

// 根据数组依照其顺序创建一个list
func createList(arr []int) *ListNode{
	p := new(ListNode)
	head := p
	for _,num := range arr {
		p.Next = new(ListNode)
		p = p.Next
		p.Val = num
	}

	return head.Next
}

func PrintList(li *ListNode) {
	for li != nil {
		fmt.Println(li.Val)
		li = li.Next
	}
}

func main() {
	l1 := createList([]int{1,2,7,13})
	l2 := createList([]int{0})

	p := mergeTwoLists(l1, l2)
	PrintList(p)
}