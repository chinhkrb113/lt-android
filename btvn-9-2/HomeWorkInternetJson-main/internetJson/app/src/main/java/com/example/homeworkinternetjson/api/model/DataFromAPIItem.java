package com.example.homeworkinternetjson.api.model;

import com.google.gson.annotations.SerializedName;

public class DataFromAPIItem{

	@SerializedName("website")
	private String website;

	@SerializedName("address")
	private Address address;

	@SerializedName("phone")
	private String phone;

	@SerializedName("name")
	private String name;

	@SerializedName("company")
	private Company company;

	@SerializedName("id")
	private int id;

	@SerializedName("avatar")
	private Avatar avatar;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	public String getWebsite(){
		return website;
	}

	public Address getAddress(){
		return address;
	}

	public String getPhone(){
		return phone;
	}

	public String getName(){
		return name;
	}

	public Company getCompany(){
		return company;
	}

	public int getId(){
		return id;
	}

	public Avatar getAvatar(){
		return avatar;
	}

	public String getEmail(){
		return email;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"DataFromAPIItem{" + 
			"website = '" + website + '\'' + 
			",address = '" + address + '\'' + 
			",phone = '" + phone + '\'' + 
			",name = '" + name + '\'' + 
			",company = '" + company + '\'' + 
			",id = '" + id + '\'' + 
			",avatar = '" + avatar + '\'' + 
			",email = '" + email + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}