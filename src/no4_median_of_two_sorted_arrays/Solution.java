package no4_median_of_two_sorted_arrays;

/**
 * <p>具体的算法参见leetcode题解<a href=https://leetcode.com/problems/median-of-two-sorted-arrays/solution/>Median Of Two Sorted Arrays</a></p>
 * <br />
 * <p>中位数在统计学上的定义，是将一个集合分割为左右两个子集合，这两个子集合的元素个数是一致的。</p>
 * <p>如果我们考虑一个排序好的长度为m的数组A，取得其位置为i的中位数median。这个数组就可以分解为两个数组</p>
 * <blockquote>left_A{A[0],A[1]...A[i-1]}和right_A{A[i],A[i+1]..A[m-1]} </blockquote>
 * <p>我们暂时只考虑m为偶数的情况,比较方便理清算法的思路。</p>
 * <p>加入另外一个长度为n的数组B，我们来考虑本题的情况。我们可以将每一个数组作一个任意分割</p>
 * <blockquote>left_A{A[0],A[1]...A[i-1]}和right_A{A[i],A[i+1]..A[m-1]}</blockquote>
 * <blockquote>left_B{B[0],B[1]...B[j-1]}和right_B{B[j],B[j+1]..B[j-1]}</blockquote>
 * <p>我们将左边的部分放在一起，右边的部分放在一起，组成一个新的集合</p>
 * <blockquote>left_part{left_A,left_B}和right_part{right_A,right_B}</blockquote>
 * <p>如果我们规定left_part中的数全部小于right_part中的数，并且二者的元素个数一致，这个新的集合的中位数显然是</p>
 * <blockquote>median = (max(left_part) + min(right_part))/2</blockquote>
 * <p>于是我们可以用以下规定使得该情况成立</p>
 * <blockquote>
 *     <ol>
 *         <li>i+j=m-i+n-j+1 => j=(m+n+1)/2-i </li>
 *         <li>B[j-1]<=A[i] && A[i-1] <= B[j] (由上边描述可以知道,A[i]，B[j]属于右侧,A[i-1],B[j-1]属于左侧)</li>
 *     </ol>
 * </blockquote>
 * <p>于是我们就可以把问题转化为，在数组A中查找一个i，使得B[j-1]<=A[i] && A[i-1] <= B[j]。作了这步转化，我们就可以构造一个二分法进行查找了。</p>
 * <br/>
 * Created by status200 on 2018/3/23.
 */
public class Solution {

    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;

        // 由于j=(m+m+1)/2
        // 必须保证第一个数组的长度小于第二个
        // 否则i为[0,m)，可能会导致j小于0
        if (m > n) {
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }

        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;

            if (i < iMax && B[j - 1] > A[i]) { // 由于数组已经排序,B[j-1]>A[i]显然也有B[j]>A[i-1]
                iMin = i + 1; // i太小
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1; // i太大
            } else { // 找到i

                // 判断i和j是否有0的情况,不然i-1,j-1会使得数组下标出错
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
    
    public static void main(String[] args) {
        
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1,3},new int[]{2}));
    }
}
