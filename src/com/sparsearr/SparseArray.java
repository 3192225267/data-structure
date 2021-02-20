package com.sparsearr;

public class SparseArray {
    public static void main(String[] args) {
        show();
    }

    public static void show() {
        // 1.1 创建一个二维数组并赋值
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        // 1.2遍历二维数组
        for (int[] array : chessArr1
        ) {
            for (int i : array
            ) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }

        // 2 二维转稀疏数组
        // 记录非0值有多少个
        int sum = 0;
        // 2.1获取非0值数量
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 2.2 创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        // 2.3 创建一个计数器
        int count = 0;
        System.out.println("sum=" + sum);
        // 2.4 向稀疏数组赋值
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    System.out.println("count="+count);
                    // 二维数组中数据的位置
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    // 二维数组中数据的值
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        // 2.5 打印输出二维数组
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }



        // 3.将稀疏数组再转换为二维数组
        // 3.1 创建二维数组接收稀疏数组中的数据
        int chessArr2[][] = new int [sparseArr[0][0]][sparseArr[0][1]];

        // 3.2 将稀疏数组再转换为二维数组
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        // 3.3 遍历输出转换回来的二维数组
        System.out.println("转换回的二维数组");
        System.out.println("---------------------------------------");
        for (int[] array : chessArr1
        ) {
            for (int i : array
            ) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
    }
}
