package employee;

import java.sql.Date;

//empId, name, deptId, salary
public class EmpVo {
	private String empId;
	private String name;
	private String deptId;
	private String jobId;
	private String hireDate;
	private String salary;
	public EmpVo(String empId, String name, String deptId, String jobId, String hireDate, String salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.deptId = deptId;
		this.jobId = jobId;
		this.hireDate = hireDate;
		this.salary = salary;
	}
	
	
	public String getEmpId() {
		return empId;
	}


	public void setEmpId(String empId) {
		this.empId = empId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDeptId() {
		return deptId;
	}


	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}


	public String getJobId() {
		return jobId;
	}


	public void setJobId(String jobId) {
		this.jobId = jobId;
	}


	public String getHireDate() {
		return hireDate;
	}


	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}


	public String getSalary() {
		return salary;
	}


	public void setSalary(String salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "EmpVo [empId=" + empId + ", name=" + name + ", deptId=" + deptId + ", jobId=" + jobId + ", hireDate="
				+ hireDate + ", salary=" + salary + "]";
	}
	
	
}
