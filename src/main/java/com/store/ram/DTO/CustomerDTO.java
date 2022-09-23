package com.store.ram.DTO;



public class CustomerDTO {
	private Integer id; 
    private String name; 
    private String department; 
    private long mobile;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
    
    public CustomerDTO() {
    	
    }
	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", name=" + name + ", department=" + department + ", mobile=" + mobile + "]";
	}
	public CustomerDTO(Integer id, String name, String department, long mobile) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.mobile = mobile;
	}
	public CustomerDTO(String name, String department, long mobile) {
		super();
		this.name = name;
		this.department = department;
		this.mobile = mobile;
	}
	
    

}
