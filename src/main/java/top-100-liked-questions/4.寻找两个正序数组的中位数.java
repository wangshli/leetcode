/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        if(l1 == 0){        //有一个数组长度为0
            double r;
            if(l2 % 2 == 0){
                r = (nums2[l2/2-1]+nums2[l2/2])/2.0;
            }
            else{
                r = nums2[l2/2];
            }
            return r;
        }
        if(l2 == 0){
            double r;
            if(l1 % 2 == 0){
                r = (nums1[l1/2-1] + nums1[l1/2])/2.0;
            }else{
                r = nums1[l1/2];
            }
            return r;
        }
        //两个数组长度都不为0
        int t = (l1 + l2)/2;
        int i = 0, j = 0, k = 0;
        double r = 0;
        //数组长度之和为奇数，取中间数
        if((l1 + l2)%2 == 1){   
            while(k < t && i < l1 && j < l2){
                if(nums1[i] < nums2[j]){
                    i++;
                }else{
                    j++;
                }
                k++;
            }
            if(k == t ){
                if(i!=l1 && j!=l2){
                    r = Math.min(nums1[i], nums2[j]);
                }else{
                    if(i==l1){
                        r = nums2[j];
                    }
                    if(j==l2){
                        r = nums1[i];
                    }
                }
            }else{
                if(i == l1){
                    while(k < t){
                        j++;
                        k++;
                    }
                    r = nums2[j];
                }else{
                    while(k < t){
                        i++;
                        k++;
                    }
                    r = nums1[i];
                }
            }
        }else{  
            //数组长度为偶数，取中间两个数平均
            while(k < t - 1 && i < l1 && j < l2){
                if(nums1[i] < nums2[j]){
                    i++;
                }else{
                    j++;
                }
                k++;
            }
            int r1 = 0, r2 = 0;
            if(k == t - 1){
                if(i!=l1 && j!=l2){
                    if(nums1[i] < nums2[j]){
                        r1 = nums1[i];
                        if(i < l1 - 1){
                            i++;
                            r2 = Math.min(nums1[i], nums2[j]);
                        }else{
                            r2 = nums2[j];
                        }
                    }else{
                        r1 = nums2[j];
                        if(j < l2 - 1){
                            j++;
                            r2 = Math.min(nums1[i], nums2[j]);
                        }else{
                            r2 = nums1[i];
                        }
                    }
                }else{
                    if(i == l1){
                        r1 = nums2[j];
                        r2 = nums2[j+1];
                    }
                    if(j == l2){
                        r1 = nums1[i];
                        r2 = nums1[i+1];
                    }
                }
                r =(r1 + r2)/2.0;
            }else{
                if(i==l1){
                    while(k < t - 1){
                        j++;
                        k++;
                    }
                    r1 = nums2[j];
                    r2 = nums2[j+1];
                    r = (r1+r2)/2.0;
                }
                if(j==l2){
                    while(k < t - 1){
                        i++;
                        k++;
                    }
                    r1 = nums1[i];
                    r2 = nums1[i+1];
                    r = (r1+r2)/2.0;
                }
            }
        }
        return r;
    }
}
// @lc code=end

