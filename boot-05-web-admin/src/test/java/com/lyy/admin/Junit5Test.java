package com.lyy.admin;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @program: boot-05-web-admin
 * @description:
 * @author: ly
 * @create: 2021-11-29 11:05
 **/
@DisplayName("junit5功能测试类")
public class Junit5Test {
        /**
         * 测试前置条件
         */
        @DisplayName("测试前置条件")
        @Test
        void testassumptions(){
            Assumptions.assumeTrue(true,"结果不是true");
            System.out.println("1111111");
        }
    /**
     * 断言：前面断言失败，后面的代码不会执行
     */
    @DisplayName("测试简单断言")
    @Test
    void  testSimpleAssertions(){



        int cal = cal(2, 3);
       assertEquals(5,cal,"业务逻辑计算失败");
        Object o1 = new Object();
        Object o2 = new Object();
        assertSame(o1,o2,"两个对象不一样");
    }
    @Test
    @DisplayName("组合断言")
    void all(){
        assertAll("test",
        ()->assertTrue(true && true,"结果不为true"),
                ()->assertEquals(1,2,"结果不是1")
        );

    }

    int cal(int i,int j){
        return i+j;
    }
    @DisplayName("异常断言")
    @Test
    void testException(){
        assertThrows(ArithmeticException.class,()->{int i=10/0;},"业务逻辑居然正常运行");
    }


    @DisplayName("测试displayname注解")
    @Test
    void testDisplayName(){
        System.out.println(1);
    }

    /**
     * 规定方法超时时间，超出时间测试就会出异常
     * @throws InterruptedException
     */
    @Timeout(value = 5,unit = TimeUnit.SECONDS)
    @Test
    void testTimeout() throws InterruptedException {
        Thread.sleep(5000);
    }

    @Disabled
    @Test
    void test2(){
        System.out.println("这是test2");
    }
    @BeforeEach
    void testBeforeEach(){
        System.out.println("测试就要开始了");
    }
    @AfterEach
    void testAfterEach(){
        System.out.println("测试结束了");
    }
    @BeforeAll
    static void   testBeforeAll(){
        System.out.println("所有测试就要开始了");
    }
    @AfterAll
   static void  testAfterAll(){
        System.out.println("所有测试已经结束了");
    }

}
