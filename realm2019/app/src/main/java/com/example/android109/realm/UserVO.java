package com.example.android109.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Data;

@Data
public class UserVO extends RealmObject {

  @PrimaryKey
  private String id;

  private String name;

  private int age;

}
