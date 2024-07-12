package com.xieahui.springboot.springaidemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.*;

@SpringBootTest
class SpringAiDemoApplicationTests {

    @Test
    void contextLoads() {

        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(10, 10, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10)
                        , Executors.defaultThreadFactory());
        executor.execute(() -> {
            System.out.println("Hello, Spring AI Demo!");
        });

        ExecutorService executorService = Executors.newFixedThreadPool(4);//该线程拥有四个线程
        executorService.execute(() -> {
            System.out.println("Hello, Spring AI Demo!");
        });

    }
}
