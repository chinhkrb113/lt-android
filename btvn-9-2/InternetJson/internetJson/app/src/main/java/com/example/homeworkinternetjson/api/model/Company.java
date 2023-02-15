package com.example.homeworkinternetjson.api.model;

import com.google.gson.annotations.SerializedName;

public class Company{

	@SerializedName("bs")
	private String bs;

	@SerializedName("catchPhrase")
	private String catchPhrase;

	@SerializedName("name")
	private String name;

	public String getBs(){
		return bs;
	}

	public String getCatchPhrase(){
		return catchPhrase;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"Company{" + 
			"bs = '" + bs + '\'' + 
			",catchPhrase = '" + catchPhrase + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}