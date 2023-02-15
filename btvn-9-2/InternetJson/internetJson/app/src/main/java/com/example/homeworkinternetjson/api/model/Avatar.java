package com.example.homeworkinternetjson.api.model;

import com.google.gson.annotations.SerializedName;

public class Avatar{

	@SerializedName("thumbnail")
	private String thumbnail;

	@SerializedName("photo")
	private String photo;

	public String getThumbnail(){
		return thumbnail;
	}

	public String getPhoto(){
		return photo;
	}

	@Override
 	public String toString(){
		return 
			"Avatar{" + 
			"thumbnail = '" + thumbnail + '\'' + 
			",photo = '" + photo + '\'' + 
			"}";
		}
}