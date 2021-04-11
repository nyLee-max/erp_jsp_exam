package erp_jsp_exam.dto;

import java.util.Date;

public class Employee {
	private int empNo;
	private String empName;
	private Title tno;
	private Employee manager;
	private int salary;
	private Department dno;
	private Date hiredate;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empNo, String empName, Title tno, Employee manager, int salary, Department dno, Date hiredate) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.tno = tno;
		this.manager = manager;
		this.salary = salary;
		this.dno = dno;
		this.hiredate = hiredate;
	}
	public Employee(int empNo) {
		super();
		this.empNo = empNo;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Title getTno() {
		return tno;
	}
	public void setTno(Title tno) {
		this.tno = tno;
	}
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Department getDno() {
		return dno;
	}
	public void setDno(Department dno) {
		this.dno = dno;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", tno=" + tno + ", manager=" + manager
				+ ", salary=" + salary + ", dno=" + dno + ", hiredate=" + hiredate + "]";
	}
	public Title getTitle() {
		return tno;
	}
	public Department getDepartment() {
		return dno;
	}
	
	
}
