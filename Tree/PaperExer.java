package study.Tree;
/*
折纸问题，对折n次，打印每条棱的凹凸

解：动手可以发现 第一次折的棱 为凹 根节点
第二次折 在1上的为凹  1下为凸  第二层
第三次折  在2.1上为凹 下为凸
由此可见 左节点都为凹  右节点都为凸
中序遍历 给个boolean值  在right 时 打印 凸
 */
public class PaperExer {
    public static void printAllFolds(int n){
        printProcess(1,n,true);
    }
    public static void printProcess(int i,int n,boolean down){
        if(i>n) return;
        printProcess(i+1,n,true);
        System.out.print(down?"凹":"凸");
        printProcess(i+1,n,false);
    }

    public static void main(String[] args) {
        int n=3;
        printAllFolds(n);
    }
}
