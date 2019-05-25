package xyz.thishome.controller;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DeferredResultQueue {

    private static Queue<DeferredResult> queue = new ConcurrentLinkedQueue();

    public static void save(DeferredResult result) {
        queue.add(result);
    }

    public static DeferredResult getResult() {
        return queue.poll();
    }

}
