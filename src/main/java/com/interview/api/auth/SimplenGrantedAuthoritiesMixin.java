package com.interview.api.auth;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SimplenGrantedAuthoritiesMixin {
  @JsonCreator
  public SimplenGrantedAuthoritiesMixin(@JsonProperty("authority") String role) {
  }
}
