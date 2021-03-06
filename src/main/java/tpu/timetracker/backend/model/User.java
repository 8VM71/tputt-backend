package tpu.timetracker.backend.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER")
final public class User extends AbstractEntity {

  private static final long serialVersionUID = 6922279983192374791L;

  @NotNull
  @Size(min = 3, max = 64)
  private String username;

  @Size(min = 3, max = 64)
  private String name;

  private String email;

  protected User() {}

  public User(String username, String email, String name) {
    this.username = username;
    this.email = email;
    this.name = name;
  }

  public User(String username, String email) {
    this.username = username;
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}