package com.babynorth.test;


import junit.framework.TestCase;
import org.hibernate.SessionFactory;
import org.hibernate.engine.SessionFactoryImplementor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class CommonTest extends TestCase {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;




    @Test
    public void test() throws Exception {
        System.out.println(((SessionFactoryImplementor)sessionFactory).getConnectionProvider().getConnection());
    }
}
