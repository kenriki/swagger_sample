package com.example.homeweb.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "ユーザーリスト")
public class UserList {

  private String id;
  private String name;

  public UserList(String str1, String str2) {
    this.id = str1;
    this.name = str2;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
