package tpu.timetracker.backend.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PROJECT")
final public class Project extends AbstractEntity {

  private static final long serialVersionUID = -319754945356826471L;

  @Size(min = 3)
  private String name;

  @Column
  private Integer color;

  @ManyToOne
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "WORKSPACE_ID")
  private Workspace workspace;

  public Project(Workspace ws, String name, Integer color) {
    this.workspace = ws;
    this.name = name;
    this.color = color;
  }

  public Project(Workspace ws, String name) {
    this.workspace = ws;
    this.name = name;
  }

  protected Project() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Workspace getWorkspace() {
    return workspace;
  }

  public Integer getColor() {
    return color;
  }

  public void setColor(Integer color) {
    this.color = color;
  }
}
