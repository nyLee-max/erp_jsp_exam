package erp_jsp_exam.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import erp_jsp_exam.dao.impl.EmployeeDaoImpl;
import erp_jsp_exam.dto.Department;
import erp_jsp_exam.dto.Employee;
import erp_jsp_exam.dto.Title;
import erp_jsp_exam.util.JdbcUtil;


public class EmployeeDaoTest {
	private static Connection con = JdbcUtil.getConnection();
	private static EmployeeDaoImpl dao = EmployeeDaoImpl.getInstance();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao.setCon(con);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		con.close();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectEmployeeAll() {
		System.out.printf("%s()%n", "SelectEmployeeAll");
		List<Employee> empList = dao.selectEmployeeAll();
		Assert.assertNotNull(empList);
		empList.stream().forEach(System.out::println);
	}

	@Test
	public void test02SelectEmployeeByNo() {
		System.out.printf("%s()%n", "testSelectEmployeeByNo");
		Employee newEmp = new Employee(1003);
		Employee searchEmp = dao.selectEmployeeByNo(newEmp);
		Assert.assertNotNull(searchEmp);
		System.out.println(searchEmp);
	}

	@Test
	public void test03InsertEmployee() {
		System.out.printf("%s()%n", "testInsertEmployee");
		Employee newEmp = new Employee(1004 ,"이나연" , new Title(3) , new Employee(3427) , 6000000 , new Department(2), new Date());
		int res = dao.insertEmployee(newEmp);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectEmployeeByNo(newEmp));
	}

	@Test
	public void test04UpdateEmployee() {
		System.out.printf("%s()%n", "testUpdateEmployee");
		Employee newEmp = new Employee(1004, "김상건", new Title(1), new Employee(3427), 5000000, new Department(3), new Date());
		int res = dao.updateEmployee(newEmp);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectEmployeeByNo(newEmp));
	}

	@Test
	public void test05DeleteEmployee() {
		System.out.printf("%s()%n", "testDeleteEmployee");
		Employee newEmp = new Employee(1004);
		int res = dao.deleteEmployee(newEmp);
		Assert.assertEquals(1, res);
		dao.selectEmployeeAll().stream().forEach(System.out::println);
	}

}
