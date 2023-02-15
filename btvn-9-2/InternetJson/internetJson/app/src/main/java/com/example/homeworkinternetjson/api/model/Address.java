package com.example.homeworkinternetjson.api.model;

import com.google.gson.annotations.SerializedName;

public class Address{

	@SerializedName("zipcode")
	private String zipcode;

	@SerializedName("geo")
	private Geo geo;

	@SerializedName("suite")
	private String suite;

	@SerializedName("city")
	private String city;

	@SerializedName("street")
	private String street;

	public String getZipcode(){
		return zipcode;
	}

	public Geo getGeo(){
		return geo;
	}

	public String getSuite(){
		return suite;
	}

	public String getCity(){
		return city;
	}

	public String getStreet(){
		return street;
	}

	@Override
 	public String toString(){
		return 
			"Address{" + 
			"zipcode = '" + zipcode + '\'' + 
			",geo = '" + geo + '\'' + 
			",suite = '" + suite + '\'' + 
			",city = '" + city + '\'' + 
			",street = '" + street + '\'' + 
			"}";
		}
}