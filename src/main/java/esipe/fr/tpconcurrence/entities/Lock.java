package esipe.fr.tpconcurrence.entities;

import io.swagger.annotations.ApiModel;

import java.time.LocalDateTime;
import java.util.Date;


@ApiModel(description = "un verrou")
@org.springframework.data.mongodb.core.mapping.Document("Lock")
public class Lock   {

  private String lockId = null;

  private String owner = null;

  private LocalDateTime created = null;

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public String getLockId() {
    return lockId;
  }

  public void setLockId(String lockId) {
    this.lockId = lockId;
  }
}

