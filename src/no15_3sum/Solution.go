package main

import (
	"fmt"
	"sort"
)

// 对数组排序
// 固定住一个数,得到a+b=-c,即变为two sum的问题. 但此题若使用hashmap的方法将难以去重.
// 排序后,使用左右两个指针往中间遍历, 计算nums[left]+nums[right]是否等于target(target=-c)
func threeSum(nums []int) [][]int {

	var tuple [][]int
	sort.Ints(nums)

	for i, num := range nums {

		// 剪枝优化: 因为数组有序,只要被fix的数为正数,那么后边的数肯定都为正数,肯定不为正数
		if num > 0 {
			break
		}

		if i > 0 && nums[i -1] == num { // 跳过重复的数字
			continue
		}

		target := -num
		left, right := i + 1, len(nums)-1 // 注意这里left从i+1开始, 因为前边的数已经取过, 不需要再取, 否则会重复
		for left < right  {
			sum := nums[left] + nums[right]
			if sum > target {
				right--
			} else if sum < target {
				left++
			} else {
				tuple = append(tuple, []int{num, nums[left], nums[right]})
				left++
				right--
				for left < right && nums[left - 1] == nums[left]{ // 重复的数字不需要再取
					left++
				}
				for left < right && nums[right + 1] == nums[right] {
					right--
				}
			}
		}
	}

	return tuple
}

func main() {
	fmt.Println(threeSum([]int{-1,0,1,2,-1,-4}))
}
