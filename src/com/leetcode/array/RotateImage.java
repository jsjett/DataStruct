package com.leetcode.array;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // 首先将矩阵对折

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][col - j - 1];
                matrix[i][col - j - 1] = temp;
            }
        }

        //对角线折叠

        for (int i = 0; i < row; i++) {
           for (int j = col - 1 - i; j >= 0; j--) {
                int temp = matrix[col - j - 1][row - i - 1];
                matrix[col - j - 1][row - i - 1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        rotateImage.rotate(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j]);
                System.out.print(',');
            }
            System.out.println();
        }
    }
}
