package erp_jsp_exam.dao.service;

import java.sql.Connection;
import java.util.List;

import erp_jsp_exam.dao.impl.EmployeeDaoImpl;
import erp_jsp_exam.ds.JndiDs;
import erp_jsp_exam.dto.Employee;

public class EmployeeService {
	private Connection con = JndiDs.getConnection();
	private EmployeeDaoImpl dao = EmployeeDaoImpl.getInstance();

	public EmployeeService() {
		dao.setCon(con);
	}

	public List<Employee> showEmployees() {
		return dao.selectEmployeeAll();
	}

	public void addEmployee(Employee employee) {
		dao.insertEmployee(employee);
	}

	public Employee showEmployees(Employee employee) {
		return dao.selectEmployeeByNo(employee);
	}

	public void deleteEmployee(Employee employee) {
		dao.deleteEmployee(employee);
	}

	public void modifyEmployee(Employee employee) {
		dao.updateEmployee(employee);
	}
}
