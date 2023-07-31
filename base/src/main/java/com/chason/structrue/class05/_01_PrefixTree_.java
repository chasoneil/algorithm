package com.chason.structrue.class05;

/**
 * 前缀树
 *
 * 前缀树包含三个重点
 * 节点 Node
 * 通过值 pass
 * 结束值 end
 *
 * 例如: 给定一个字符串数组  ["abc", "abd", "mnt", "kst"]
 * 创建前缀树都要从 根节点出发
 * abc Node(p=1,e=0) - a -> Node(p=1,e=0) - b ->Node(p=1,e=0) - c ->Node(p=1,e=1)
 * abd Node(p=2,e=0) - a -> Node(p=2,e=0) - b ->Node(p=1,e=0) - c ->Node(p=1,e=1)
 *                                              Node(p=2,e=0) - d ->Node(p=1,e=1)
 *
 * 前缀树实现了字符串的构建过程，每个字符出现的次数
 */
public class _01_PrefixTree_ {

    // 前缀树节点
    static class Node1 {

        int pass;
        int end;
        Node1[] nexts; // 表示通往下一个字符的路

        public Node1 () {
            pass = 0;
            end  = 0;
            // index = 0   ->  a 方向的路
            // index = 1   ->  b 方向的路
            // index = 2   ->  c 方向的路
            // ...

            // nexts[index] == null 表示该方向的路不存在
            // nexts[index] != null 表示该方向的路存在
            nexts = new Node1[26]; // 一共有26个字符
        }
    }

    static class PrefixTree1 {

        Node1 root;

        public PrefixTree1() {
            root = new Node1();
        }

        /**
         * 向前缀树中插入元素
         * @param word
         */
        public void insert (String word) {
            if (word == null) {
                return;
            }

            char[] strs = word.toCharArray();   // 将字符串转化成字符数组

            Node1 node = root; // 从头开始
            node.pass++;
            int path = 0;
            for (int i=0; i<strs.length; i++) {
                path = strs[i] - 'a';
                if (node.nexts[path] == null) {  // 没有这个路径, 自己创建 一条路
                    node.nexts[path] = new Node1();
                }
                node = node.nexts[path];
                node.pass++;
            }
            node.end++;

        }

        /**
         * word 字符串之前被加入过几次
         * @param word
         * @return
         */
        public int search (String word) {

            if (word == null) {
                return 0;
            }

            char[] chars = word.toCharArray();
            int path = 0;
            Node1 node = root;

            for (int i=0; i<chars.length; i++) {
                path = chars[i] - 'a';
                if (node.nexts[path] == null) { // 从来没有加入过这个字符串
                    return 0;
                }
                node = node.nexts[path];
            }

            return node.end;
        }

        /**
         * 所有字符串中， 有多少个是以 prefix 为前缀的
         * @param prefix
         * @return
         */
        public int prefixNumber(String prefix) {

            if (prefix == null) {
                return 0;
            }

            int path = 0;
            Node1 node = root;
            char[] chars = prefix.toCharArray();

            for (int i=0; i<chars.length; i++) {
                path = chars[i] - 'a';
                if (node.nexts[path] == null) {
                    return 0;
                }
                node = node.nexts[path];
            }

            return node.pass;
        }

        /**
         * 前缀树删除 word
         * @param word
         */
        public void delete(String word) {

            // 1. 查询字符串是否加入过

            if (search(word) != 0) {

                char[] chars = word.toCharArray();
                Node1 node = root;
                node.pass--;
                int path = 0;

                for (int i=0; i<chars.length; i++) {
                    path = chars[i] - 'a';
                    if (--node.nexts[path].pass == 0) { // 路径失效了，经过这个路上的字符串已经没了
                        node.nexts[path] = null;
                        return;
                    }
                    node = node.nexts[path];
                }

                --node.nexts[path].end; // 最后一个节点 end --
            }
        }

    }

}
