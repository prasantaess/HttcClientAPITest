package com.qa.data;

public class Users {
	
	String name;
	String job;
	String id;
	String Created_Date;
	
	public Users() {
		
	}
	
	public Users(String name, String job ) {
		this.name=name;
		this.job=job;
		//this.id=id;
		//this.Created_Date=Created_Date;
		
		
		
	}

	// Generate getter and setter
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreated_Date() {
		return Created_Date;
	}

	public void setCreated_Date(String created_Date) {
		Created_Date = created_Date;
	}
	
	
	
	
	

}
