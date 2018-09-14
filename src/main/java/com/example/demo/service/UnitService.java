package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.dao.UnitMapper;
import com.example.demo.mapper.dao.UserMapper;
import com.example.demo.mapper.seconddao.SecondUnitMapper;
import com.example.demo.model.Unit;
import com.example.demo.model.Unit1;
import com.example.demo.util.AppUtil;
import com.google.gson.Gson;

/**  
* @Title: UnitService.java  
* @Package com.example.demo.service  
* @Description: TODO
* @author wdm  
* @date 2018年6月27日  上午9:10:33
* @version V1.0  
*/
@Service
public class UnitService {
	
	@Autowired private UnitMapper unit;
	@Autowired private UserMapper user;
	@Autowired private SecondUnitMapper units;
	
	/**
	 * spring +mybatis 事务处理
	 * @Description: 新增一个单位,同时把某条人员信息中的单位改为这条
	 * 事务隔离级别(Isolation) 四类  Read uncommitted 、Read committed 、Repeatable read 、Serializable / oracle 默认级别 Read committed  mysql 默认级别 Repeatable read
	 * 事务传播行为(propagation) :
	 *     PROPAGATION_REQUIRED：如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。这是默认值
	 *     PROPAGATION_REQUIRES_NEW：创建一个新的事务，如果当前存在事务，则把当前事务挂起
	 *     PROPAGATION_SUPPORTS：如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行
	 *     PROPAGATION_NOT_SUPPORTED：以非事务方式运行，如果当前存在事务，则把当前事务挂起
	 *     PROPAGATION_NEVER：以非事务方式运行，如果当前存在事务，则抛出异常
	 *     PROPAGATION_MANDATORY：如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。
	 *     PROPAGATION_NESTED：如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，则该取值等价于TransactionDefinition.PROPAGATION_REQUIRED
	 * readOnly	boolean	读写或只读事务，默认读写
	 * rollbackFor	Class对象数组，必须继承自Throwable	导致事务回滚的异常类数组
     * rollbackForClassName	类名数组，必须继承自Throwable	导致事务回滚的异常类名字数组
     * noRollbackFor	Class对象数组，必须继承自Throwable	不会导致事务回滚的异常类数组
     * noRollbackForClassName	类名数组，必须继承自Throwable	不会导致事务回滚的异常类名字数组    
     * 方法上注解属性会覆盖类注解上的相同属性
     *  Spring 建议不要在接口或者接口方法上使用该注解，因为这只有在使用基于接口的代理时它才会生效。
     *  @Transactional 注解应该只被应用到 public 方法上，这是由 Spring AOP 的本质决定的。如果你在 protected、private 或者默认可见性的方法上使用 @Transactional 注解，这将被忽略，也不会抛出任何异常
     * 默认情况下，只有来自外部的方法调用才会被AOP代理捕获，也就是，类内部方法调用本类内部的其他方法并不会引起事务行为，即使被调用方法使用@Transactional注解进行修饰。
	 * @author wdm  
	 * @throws Exception 
	 * @date 2018年6月27日  上午9:23:58
	 */
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void TstlUpdate() {
		String unitGuid=AppUtil.createGuid();
		int j=0;
		int i=0;
//		try {
//			j=this.user.annUpdate(unitGuid, "ot6r2g72fyCdGSLa0tyJmo4g4XiKqp4A");
//			i=this.unit.annAddUnit(new Unit(unitGuid, "古墓派", "0066"));
//		}catch (Exception e) {
//			
//		}
		j=this.user.annUpdate(unitGuid, "ot6r2g72fyCdGSLa0tyJmo4g4XiKqp4A");
		if(j>0) {
			i=this.unit.annAddUnit(new Unit(unitGuid, "古墓派", "0066"));
		}
//		int i=this.unit.annAddUnit(new Unit(unitGuid, "古墓派", "0066"));
		
		System.err.println("i="+i+"   j="+j);
		
	}
	
	public int addUnit(Unit unit) {
		return this.unit.addUnit(unit);
	}
	
	public List<Map<String, Object>> annselect(){
		return this.unit.annselect();
	}
	
	public List<Unit1> getAllUnit1(){
		return this.unit.getAllUnit1();
	}
	
	public List<Unit1> getAllUnits1(){
		System.err.println(new Gson().toJson(this.units.select()));
		return this.units.getAllUnit1();
	}
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void doTest() {
		//测试两个不同类型的数据库一起执行的事务
		int o=this.unit.annAddUnit(new Unit(AppUtil.createGuid(), "ORECLE", "9999"));
		int m=this.units.annAddUnit(new Unit(AppUtil.createGuid(32), "MYSQL", "9999"));//主键长度超出 保存失败
		System.err.println("o:="+o+"   m:="+m);
	}
	

}
