package main

import "fmt"

type ListNode struct {
	Val int
	Next *ListNode
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

func reverseList(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}

	tail := head // 这个指针保存结尾
	p1 := head // 遍历的前一个节点
	p2 := head.Next // 遍历的后一个节点
	for p2 != nil {
		nextP := p2.Next // 需要先提前保存下一个节点
		p2.Next = p1
		p1 = p2
		p2 = nextP
	}

	tail.Next = nil // 最后把结尾的下一个置为空

	return p1
}

func PrintList(li *ListNode) {
	p := li
	for p != nil {
		fmt.Println(p.Val)
		p = p.Next
	}
}
func main() {

	li := createList([]int{1,2,3,4,5})
	li = reverseList(li)
	PrintList(li)
}