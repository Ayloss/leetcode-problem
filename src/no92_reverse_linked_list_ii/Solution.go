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

func PrintList(li *ListNode) {
	p := li
	for p != nil {
		fmt.Println(p.Val)
		p = p.Next
	}
}

func reverseBetween(head *ListNode, m int, n int) *ListNode{
	if head == nil {
		return nil
	}

	i:=1
	var firstNodePrev *ListNode = nil // 第一个要反转的节点的前一个节点
	p1 := head // 前一个反转节点
	p2 := head.Next // 后一个反转节点
	for i < m && p2 != nil{ // 先找到第一个反转节点
		firstNodePrev = p1
		p1 = p2
		p2 = p2.Next
		i++
	}

	tail := p1 // 保存反转部分的尾部

	for i < n && p2 != nil{ // 进行反转
		nextP := p2.Next
		p2.Next = p1
		p1 = p2
		p2 = nextP
		i++
	}

	// 反转完毕时, p2肯定为反转的最后一个节点的下一个节点
	tail.Next = p2 // 尾部链接到下一个节点
	if firstNodePrev != nil {  // firstNodePrev如果不为空,说明反转的节点不是头节点
		firstNodePrev.Next = p1
	}

	if head.Next == p2 { // 如果n=1,head肯定变为反转部分的最后一个节点. 否则head不会改变
		return p1
	} else {
		return head
	}
}

func main() {
	li := createList([]int{1,2,3,4,5})
	li = reverseBetween(li, 2,5)
	PrintList(li)
}
