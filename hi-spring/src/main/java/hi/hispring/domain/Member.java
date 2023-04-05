package hi.hispring.domain;

public class Member {
  private Long id;
  public void setId(Long id) {
    this.id = id;
  }
  private String name;
  public void setName(String name) {
    this.name = name;
  }
  public Long getId() {
    return id;
  }
  public String getName() {
    return name;
  }

}
