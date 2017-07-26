package org.myacs.web;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="user")
@SessionScoped
public class UserBean implements Serializable{
	private String name;
	private String password;
	private String failed;
	private String result ;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getPassword()
	{
		return password;
	}

	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getFailed()
	{
		return failed;
	}
	
	public String result()
	{
		return result;
	}
	
	public void verify()
	{
		if(name.equals("zyxia"))
		{
			failed = "";
			result = "welcome";
		}
		else
		{
			failed = "username or password wrong";
			result = null;
		}
	}
}