package tpu.timetracker.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "WORSPACE")
final public class Workspace extends AbstractEntity {

  private static final long serialVersionUID = -6954901766752322592L;

  @Size(min = 3)
  private String name;

  @JoinColumn(name = "USER_ID")
  private String ownerId;

  @Column
  private String description;

  protected Workspace() {}

  public Workspace(String name, String ownerId, String description) {
    this.name = name;
    this.ownerId = ownerId;
    this.description = description;
  }

  public Workspace(String name, String ownerId) {
    this.name = name;
    this.ownerId = ownerId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOwnerId() {
    return ownerId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
