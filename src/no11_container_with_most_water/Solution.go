package main

import "fmt"

func Min(a int, b int) int{
	if a < b {
		return a
	} else {
		return b
	}
}

// 这种做法是一个贪心,证明查看https://leetcode.com/problems/container-with-most-water/discuss/6099/yet-another-way-to-see-what-happens-in-the-on-algorithm
// 使用左右两个指针, 每次循环计算此时的面积与最大的面积比较
// 移动左右指针时, 先比较一下此时左右两边的高度.因为向内移动指针时,x轴的长度一定变小,所以我们需要保证高度尽可能地高,把高的一边留下来.
func maxArea(height []int)int {
	left,right := 0, len(height) - 1

	maxSoFar := 0
	for left < right {
		area := (right - left) * Min(height[left], height[right])
		if area > maxSoFar {
			maxSoFar = area
		}

		if height[left] < height[right]{ // 比较左右两边移动指针
			left++
		} else {
			right--
		}

	}

	return maxSoFar
}

func main() {

	fmt.Println(maxArea([]int{1,8,6,2,5,4,8,3,7}))
}