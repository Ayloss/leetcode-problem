package main

import "fmt"

// 使用栈的括号匹配
func isValid(s string) bool {
	stack := make([]uint8, len(s)) // 数组作为栈
	top := -1
	for i:=0;i < len(s);i++ {
		currentCh := s[i]

		// 入栈
		if currentCh == '(' || currentCh == '{' || currentCh == '[' {
			top++
			stack[top] = s[i]
		} else {
			if top >= 0 {
				topCh := stack[top]

				// 成功匹配
				if (topCh == '(' && currentCh == ')') || (topCh == '{' && currentCh == '}') || (topCh == '[' && currentCh == ']') {
					top--
				} else { // 匹配失败
					return false
				}
			} else {
				return false
			}
		}
	}

	if top == -1 {
		return true
	} else {
		return false
	}
}

func main() {

	fmt.Println(isValid("()[]{}"))
}
