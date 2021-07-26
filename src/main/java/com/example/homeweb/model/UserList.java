package com.example.homeweb.model;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "ユーザーリスト")
public class UserList {

	private String id;
	private String name;

	public UserList(String id,String name) {

	}

}
