package com.example.homeworkinternetjson.api.model;

import com.google.gson.annotations.SerializedName;

public class Geo{

	@SerializedName("lng")
	private String lng;

	@SerializedName("lat")
	private String lat;

	public String getLng(){
		return lng;
	}

	public String getLat(){
		return lat;
	}

	@Override
 	public String toString(){
		return 
			"Geo{" + 
			"lng = '" + lng + '\'' + 
			",lat = '" + lat + '\'' + 
			"}";
		}
}