package main

import (
	"fmt"
	"strconv"
)
// 最直观的做法，直接把数字化为字符串
// 对字符串从两边往中间进行比较
func isPalindrome(x int) bool {
	s := strconv.Itoa(x)

	for left:=0; left <= len(s)/2;left++ {
		right := len(s) - 1 - left

		if s[left] != s[right] {
			return false
		}
	}

	return true
}

func main() {
	fmt.Println(isPalindrome(-1))
}
