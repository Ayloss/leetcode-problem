package main

import "fmt"

// 反转一半数字
// 首先, 负数以及以0为结尾的数字（0本身除外）肯定不是回文数
// 接着计算反转后的数字，但此处只计算到中间一半（相当于取后半部分进行反转)
// 比较前半部分和后半部分，一致的话即为回文数
func isPalindrome1(x int) bool {
	if x < 0  || (x % 10 == 0 && x != 0){
		return false
	}

	revertedNumber := 0
	// 计算后半部分的反转
	// 当x>revertedNumber时, 显然已经反转了一半
	for x > revertedNumber {
		revertedNumber = revertedNumber * 10 + x % 10
		x /= 10
	}

	// 当输入的整数的位数为奇数时
	// revertedNumber肯定会大于x，revertedNumber会比x多包含中间的一位，去掉这一位比较即可
	return x == revertedNumber || x == revertedNumber / 10
}

func main() {
	fmt.Println(isPalindrome1(1232))
}