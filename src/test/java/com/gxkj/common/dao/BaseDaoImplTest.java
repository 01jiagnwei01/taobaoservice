package com.gxkj.common.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-datasource-context.xml" ,"/spring-hibernate-context.xml","/spring-dao-context.xml"})
public class BaseDaoImplTest  extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	@Qualifier("basedao")
	private BaseDAO basedao;
	
	@Test
	public void  selectByHqlTest(){
		basedao.test();
	}

}
