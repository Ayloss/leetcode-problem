package main

import "fmt"

// 暴力法
// 直接产生所有的括号组
// 选择符合的括号组进行判断

func generateParenthesis(n int) []string {
	var allSequence []string
	helper := make([]uint8, 2*n)
	genSequence(0, &helper, &allSequence)

	return allSequence
}

func genSequence(level int, helper *[]uint8, allSequence *[]string) {
	if level >= len(*helper) {
		if isValid(*helper) {
			*allSequence = append(*allSequence,string(*helper))
		}
		return
	}

	(*helper)[level] = '('
	genSequence(level+1, helper, allSequence)
	(*helper)[level] = ')'
	genSequence(level+1, helper, allSequence)

}
func isValid(s []uint8) bool {

	// 平衡值, 用于判断括号是否匹配
	// 遇到(, +1
	// 遇到), -1
	// 如果小于0,)的数量多于(,肯定是不匹配的
	// 大于0，（多于),但可能还没判断完全部括号，不判断
	// 最后必须为0
	balance := 0
	for i:=0;i < len(s);i++ {
		ch := s[i]
		if ch == '(' {
			balance++
		} else {
			balance--
		}

		// 只有一直大于0才匹配成功
		if balance < 0 {
			return false
		}
	}

	// 最后必须为0
	if balance == 0 {
		return true
	} else {
		return false
	}
}
func main() {
	fmt.Println(generateParenthesis(1))
}