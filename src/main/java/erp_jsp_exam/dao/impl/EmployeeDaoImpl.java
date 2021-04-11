package erp_jsp_exam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import erp_jsp_exam.dao.EmployeeDao;
import erp_jsp_exam.dto.Department;
import erp_jsp_exam.dto.Employee;
import erp_jsp_exam.dto.Title;

public class EmployeeDaoImpl implements EmployeeDao {

	private static EmployeeDaoImpl instance = new EmployeeDaoImpl();
	private static Connection con;

	public void setCon(Connection con) {
		this.con = con;
	}

	public static EmployeeDaoImpl getInstance() {
		if (instance == null) {
			instance = new EmployeeDaoImpl();
		}
		return instance;
	}

	public EmployeeDaoImpl() {

	}

	@Override
	public List<Employee> selectEmployeeAll() {
		String sql = "select EMP_NO ,EMP_NAME ,TITLE_NO ,TITLE_NAME ,MANAGER ,manager_name ,SALARY ,DEPT_NO ,DEPT_NAME ,FLOOR ,HIREDATE from vw_full_employee";
		try (PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Employee> list = new ArrayList<>();
				do {
					list.add(getEmployee(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Employee getEmployee(ResultSet rs) throws SQLException { //3.위에 sql문이랑 (TNO 를 TITLE_NO로) 바꾸고 없는건 추가
		int empNo = rs.getInt("EMP_NO");
		String empName = rs.getString("EMP_NAME");
		Title tno = new Title(rs.getInt("TITLE_NO"));

		try {//1.
			tno.setTitleName(rs.getString("TITLE_NAME"));

		} catch (SQLException e) {
		}

		Employee manager = new Employee(rs.getInt("MANAGER"));

		try {
			manager.setEmpName(rs.getString("manager_name"));
		} catch (SQLException e) {
		}

		int salary = rs.getInt("salary");

		Department dno = new Department(rs.getInt("DEPT_NO"));

		try {
			dno.setDeptName(rs.getString("DEPT_NAME"));
			dno.setFloor(rs.getInt("FLOOR"));
		} catch (SQLException e) {
		}

		Date hiredate = rs.getTimestamp("HIREDATE");

		return new Employee(empNo, empName, tno, manager, salary, dno, hiredate);

	}

	@Override
	public Employee selectEmployeeByNo(Employee employee) {
		String sql = "select EMP_NO ,EMP_NAME , TNO as TITLE_NO ,MANAGER ,SALARY ,DNO as DEPT_NO,HIREDATE from employee where EMP_NO = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, employee.getEmpNo());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getEmployee(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertEmployee(Employee employee) {
		String sql = "insert into employee values(? ,? ,?, ?, ?, ?, ?)";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, employee.getEmpNo());
			pstmt.setString(2, employee.getEmpName());
			pstmt.setInt(3, employee.getTitle().getTitleNo());
			pstmt.setInt(4, employee.getManager().getEmpNo());
			pstmt.setInt(5, employee.getSalary());
			pstmt.setInt(6, employee.getDepartment().getDeptNo());
			pstmt.setTimestamp(7, new Timestamp(employee.getHiredate().getTime()));
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateEmployee(Employee employee) {
		String sql = "update employee set EMP_NAME=? ,TNO=? ,MANAGER=? ,SALARY=? ,DNO=? ,HIREDATE = ? where EMP_NO = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, employee.getEmpName());
			pstmt.setInt(2, employee.getTitle().getTitleNo());
			pstmt.setInt(3, employee.getManager().getEmpNo());
			pstmt.setInt(4, employee.getSalary());
			pstmt.setInt(5, employee.getDepartment().getDeptNo());
			pstmt.setTimestamp(6, new Timestamp(employee.getHiredate().getTime()));
			pstmt.setInt(7, employee.getEmpNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteEmployee(Employee employee) {
		String sql = "delete from employee where EMP_NO = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, employee.getEmpNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
