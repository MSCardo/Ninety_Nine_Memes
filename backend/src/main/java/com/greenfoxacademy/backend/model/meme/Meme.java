package com.greenfoxacademy.backend.model.meme;

import com.greenfoxacademy.backend.model.comment.Comment;
import com.greenfoxacademy.backend.model.user.User;
import com.greenfoxacademy.backend.model.reaction.Reaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Meme {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @ManyToOne(targetEntity = User.class)
  @JoinColumn(name = "user_id")
  private User user;
  private Timestamp timestamp;
  private String caption;
  @OneToMany(mappedBy = "meme", cascade = CascadeType.ALL)
  private List<Reaction> metaData;
  @OneToMany(mappedBy = "meme", cascade = CascadeType.ALL)
  private List<Comment> comment;
  private String url;

  public Meme() {
    Date date = new Date();
    this.timestamp = new Timestamp(date.getTime());
  }

  public Meme(String url, String caption, User user) {
    Date date = new Date();
    this.timestamp = new Timestamp(date.getTime());
    this.metaData = new ArrayList<>();
    this.url = url;
    this.caption = caption;
    this.user =user;
  }

  public void addReaction(Reaction reaction) {
    metaData.add(reaction);
  }
}
