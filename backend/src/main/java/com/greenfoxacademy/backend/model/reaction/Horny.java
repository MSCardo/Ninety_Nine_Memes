package com.greenfoxacademy.backend.model.reaction;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Horny extends Reaction{

  public Horny(){super();}

  public Horny(Integer value) {
    super(value);
  }

  @Override
  public String getType() {
    return "Horny";
  }
}
