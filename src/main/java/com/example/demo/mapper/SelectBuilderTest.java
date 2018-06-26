package com.example.demo.mapper;

import org.apache.ibatis.jdbc.SQL;

/**  
* @Title: SelectBuilder.java  
* @Package com.example.demo.mapper  
* @Description: mybatis SelectBuilder
* @author wdm  
* @date 2018年6月25日  下午5:00:18
* @version V1.0  
*/
public class SelectBuilderTest {
	
	public static String Select() {
		return new SQL() {{
			SELECT("P.ID, P.USERNAME, P.PASSWORD, P.FULL_NAME");
		    SELECT("P.LAST_NAME, P.CREATED_ON, P.UPDATED_ON");
		    FROM("PERSON P");
		    FROM("ACCOUNT A");
		    INNER_JOIN("DEPARTMENT D on D.ID = P.DEPARTMENT_ID");
		    INNER_JOIN("COMPANY C on D.COMPANY_ID = C.ID");
		    WHERE("P.ID = A.ID");
		    WHERE("P.FIRST_NAME like ?");
		    OR();
		    WHERE("P.LAST_NAME like ?");
		    GROUP_BY("P.ID");
		    HAVING("P.LAST_NAME like ?");
		    OR();
		    HAVING("P.FIRST_NAME like ?");
		    ORDER_BY("P.ID");
		    ORDER_BY("P.FULL_NAME");
		}}.toString();
	}
	
	// Anonymous inner class
	public static String deletePersonSql() {
	  return new SQL() {{
	    DELETE_FROM("PERSON");
	    WHERE("ID = #{id}");
	  }}.toString();
	}
	// Builder / Fluent style
	public static String insertPersonSql() {
	  String sql = new SQL()
	    .INSERT_INTO("PERSON")
	    .VALUES("ID, FIRST_NAME", "#{id}, #{firstName}")
	    .VALUES("LAST_NAME", "#{lastName}")
	    .toString();
	  return sql;
	}
	// With conditionals (note the final parameters, required for the anonymous inner class to access them)
	public static String selectPersonLike(final String id, final String firstName, final String lastName) {
	  return new SQL() {{
	    SELECT("P.ID, P.USERNAME, P.PASSWORD, P.FIRST_NAME, P.LAST_NAME");
	    FROM("PERSON P");
	    if (id != null) {
	      WHERE("P.ID like #{id}");
	    }
	    if (firstName != null) {
	      WHERE("P.FIRST_NAME like #{firstName}");
	    }
	    if (lastName != null) {
	      WHERE("P.LAST_NAME like #{lastName}");
	    }
	    ORDER_BY("P.LAST_NAME");
	  }}.toString();
	}
	/**
	 * SelectBuilder 构造sql
	* @Description: TODO
	* @author wdm  
	* @date 2018年6月26日  上午10:13:11
	 */
	public static String SelectBuilder() {
		return new SQL() {{
			SELECT("A.*,B.DWBH,B.DWMC");
		    FROM("SYS_USER A");
		    LEFT_OUTER_JOIN("SYS_UNIT B ON A.SSDW=B.GUID");
		    WHERE("A.SSDW IS NOT NULL");
		    WHERE("B.DWMC LIKE '%'||#{0}||'%'");
		}}.toString();
	}
	public static void main(String[] args) {
		System.err.println(Select());
		System.err.println("-------------------------------------");
		System.err.println(deletePersonSql());
		System.err.println("-------------------------------------");
		System.err.println(insertPersonSql());
		System.err.println("-------------------------------------");
		System.err.println(selectPersonLike("IDS",null,"IDS"));
	}
	

}
