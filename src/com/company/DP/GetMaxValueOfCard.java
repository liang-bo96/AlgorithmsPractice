package com.company.DP;
/*给定一个整型数组arr，代表数值不同的纸牌排成一条线，
玩家A和玩家B依次拿走每张纸牌，
规定玩家A先拿，玩家B后拿，
但是每个玩家每次只能拿走最左或最右的纸牌，
玩家A和玩家B都绝顶聪明。请返回最后获胜者的分数。
*/
public class GetMaxValueOfCard {
    public static void main(String[] args) {
        System.out.println(Math.max(
                before(new int[]{70, 100, 1, 2}, 0, 3),
                after(new int[]{70, 100, 1, 2}, 0, 3)));
    }
    //先手拿到的最大分数
    public static int before(int[]arr,int left,int right){
        if(left == right){
            return arr[left];
        }
        int n1 = after(arr,left + 1,right) + arr[left];
        int n2 = after(arr,left,right - 1) + arr[right];
        return Math.max(n1,n2);
    }
    //后手拿到的最大分数
    //对手会拿走左边或者右边的牌，目的是为了让你得到的分数最少
    public static int after(int[]arr,int left,int right){
        if(left == right){
            return 0;
        }
        int n1 = before(arr,left + 1,right) ;
        int n2 = before(arr,left,right - 1);
        return Math.min(n1,n2);
    }
}
