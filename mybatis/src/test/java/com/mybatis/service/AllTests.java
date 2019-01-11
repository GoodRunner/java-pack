package com.mybatis.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BookServiceTests.class,
        StudentTests.class
})
@SpringBootTest
public class AllTests {

}
