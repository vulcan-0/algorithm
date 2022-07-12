package org.vc121.light.algorithm;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 队列的常用方法
 *
 * @author Sam Lu
 * @date 2021/4/17
 */
public class QueueTest {

    public static void main(String[] args) {
        Queue queue = new LinkedBlockingQueue();
        queue.offer('A');
        queue.offer('B');
        queue.offer('C');
        // print A
        System.out.println(queue.peek());
        // print A
        System.out.println(queue.poll());
        // print B
        System.out.println(queue.poll());
        // print C
        System.out.println(queue.peek());
        // print C
        System.out.println(queue.peek());
        // print 0
        System.out.println(queue.size());
    }

}
