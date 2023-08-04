package com.chason.fast.day01;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个文件的路径
 *
 * 统计该路径下所有的文件数量，隐藏文件也算，但是文件夹不算
 *
 */
public class _02_Files {


    /**
     * 其实本质就是 二叉树的遍历 我们用深度优先遍历 使用队列
     * 递归也可以解决问题
     * @return
     */
    public static int files(String path) {

        File file = new File(path);

        if (file.isFile()) {
            return 1;
        }

        // 初始目录给的是个文件夹

        int count = 0;
        Queue<File> queue = new LinkedList<>();

        queue.add(file);

        while (!queue.isEmpty()) {

            // 弹出队列中的元素
            File f = queue.poll();

            File[] files = f.listFiles();
            for (File file1 : files) {
                if (file1.isFile()) {
                    count++;
                }

                if (file1.isDirectory()) {
                    queue.add(file1);
                }
            }

        }
        return count;




    }


}
