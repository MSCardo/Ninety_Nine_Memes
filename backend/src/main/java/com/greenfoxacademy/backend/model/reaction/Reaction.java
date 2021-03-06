package com.greenfoxacademy.backend.model.reaction;

import com.greenfoxacademy.backend.model.meme.Meme;
import com.greenfoxacademy.backend.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public abstract class Reaction {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne(targetEntity = User.class)
  @JoinColumn(name = "user_id")
  private User user;
  @ManyToOne(targetEntity = Meme.class)
  @JoinColumn(name = "meme_id")
  private Meme meme;
  private Integer value;

  public abstract String getType();

  public Reaction(Integer value) {
    this.value = value;
  }
}