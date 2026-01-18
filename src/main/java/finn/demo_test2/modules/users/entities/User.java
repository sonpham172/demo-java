package finn.demo_test2.modules.users.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_catalogue_id")
  private Long userCatalogueId;
  public Long getUserCatalogueId() {
    return userCatalogueId;
  }

  public void setUserCatalogueId(Long userCatalogueId) {
    this.userCatalogueId = userCatalogueId;
  }

  private String name;
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  private String email;
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  private String password;
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  private String phone;
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  private String address;
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  private String image;

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  @Column(name="created_at", updatable = false)
  private LocalDateTime createdAt;

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  @Column(name="updated_at")
  private LocalDateTime updatedAt;

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @PrePersist
  protected void onCreated() {
    createdAt = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdated() {
    updatedAt = LocalDateTime.now();
  }
}
