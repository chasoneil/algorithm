package com.chason.structrue.class09;

import java.util.List;

/**
 *
 * 派对的最大快乐值
 *
 * 每个员工可能有一个或者多个下级 但是他只有他直接下级的信息  （对应出来就是多叉树了）
 * 每个员工只有一个唯一的直接上级
 * 基层员工是没有直接下级，所以数组为空
 *
 * 公司要举办party, 你可以给公司员工发请柬或者不发
 * 你发，他就一定来，不发就一定不来
 * 如果某个员工来了，他的直接下级就全部不会来 但是不是直接下级可以来
 * party 的整体快乐值 是来参加party的全部员工的happy 和
 * 你的目标是这个happy和最大化
 *
 * 给你一个多叉树的头节点 其实就是一个Employee对象
 * 怎么实现上述目的
 */
public class _01_MaxHappy {


    /*
        分析：对于任意一个员工X 我都有两种选择 给他发请柬 或者不给他发
        1. 如果给他发，意味着他的下级都不能发 ，所以这时的最大快乐值是  X.happy + 他下属员工都不来的时候的最大快乐值
        2. 如果不给他发，意味着X不来，它本身的最大快乐值是0， 但是他的员工你可以选择发或者不发
           这种情况下的最大快乐值是： 0 + Max（他下级A来的最大快乐值 他下级A不来的最大快乐值） + Max（下级B）+ ...

        所以我们需要 一颗树X 他来的最大快乐值，不来的最大快乐值
     */
    static int maxHappy(Employee boss) {

        Info res = process(boss);
        return Math.max(res.yes, res.no);
    }

    static Info process (Employee employee) {

        if (employee.nexts == null || employee.nexts.size() == 0) { // 这就意味着他已经是最下层节点了
            return new Info(employee.happy, 0);
        }

        int yes = employee.happy;       // employee 决定来  先给一个初始值他自己的happy
        int no = 0;                         // employee 决定不来 给他一个初始值0

        for (Employee E : employee.nexts) {
            Info eInfo = process(E);
            yes += eInfo.no;
            no += Math.max(eInfo.yes, eInfo.no);
        }

        return new Info(yes, no);
    }

    static class Info {

        int yes;
        int no;

        public Info (int yes, int no) {
            this.yes = yes;
            this.no = no;
        }

    }

    static class Employee {
        int happy; //每个员工有一个 happy值
        List<Employee> nexts;  // 该员工的下级
    }

}
