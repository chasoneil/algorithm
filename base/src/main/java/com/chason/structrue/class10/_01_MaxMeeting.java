package com.chason.structrue.class10;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一天有多场会议，但是只有一个会议室
 * 每场会议都有开始和结束时间
 *
 * 怎么安排能让一天开尽可能多的会议, 返回会议数
 *
 */
public class _01_MaxMeeting {

    static class Meeting {
        int start;
        int end;
        public Meeting (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static int maxMeeting1 (Meeting[] meetings) {

        return 0;
    }


    // ================ 暴力 ==================
    /*
        使用递归，对所有的可能会议形式进行全排列
     */




    // ============== 贪心 ==============
    /*
        贪心策略是： 哪个会议结束时间早，就先安排
     */

    static class MeetingComp implements Comparator<Meeting> {
        @Override
        public int compare(Meeting o1, Meeting o2) {
            return o1.end - o2.end;
        }
    }

    static int maxMeeting2 (Meeting[] meetings) {

        if (meetings == null || meetings.length == 0) {
            return 0;
        }

        Arrays.sort(meetings, new MeetingComp());   // 使用自己的策略进行排序

        int arranged = 0;       // 已安排的数量
        int arrangeTimeEnd = 0; // 已经安排的会议到达的时间点

        for (int i=0; i<meetings.length; i++) {

            if (meetings[i].start >= arrangeTimeEnd) {
                arranged++;
                arrangeTimeEnd = meetings[i].end;
            }
        }

        return arranged;
    }




}
