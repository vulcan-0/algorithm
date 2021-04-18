package org.vulcan.light.algorithm;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author luxiaocong
 * @createdOn 2021/4/17
 */
public class QueueTest {

    public static void main(String[] args) {
        Queue queue = new LinkedBlockingQueue();
        queue.offer('A');
        queue.offer('B');
        queue.offer('C');
        System.out.println(queue.element());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.element());
        System.out.println(queue.remove());
        System.out.println(queue.size());
    }

}
