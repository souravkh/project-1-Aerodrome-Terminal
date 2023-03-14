/*
 * package cdac.model;
 * 
 * import java.util.Collection;
 * 
 * import jakarta.persistence.CascadeType; import jakarta.persistence.Column;
 * import jakarta.persistence.Entity; import jakarta.persistence.FetchType;
 * import jakarta.persistence.GeneratedValue; import
 * jakarta.persistence.GenerationType; import jakarta.persistence.Id; import
 * jakarta.persistence.JoinTable; import jakarta.persistence.ManyToMany; import
 * jakarta.persistence.Table;
 * 
 * 
 * 
 * @Entity
 * 
 * @Table(name = "user") public class User {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
 * 
 * @Column(name = "first_name") private String firstName;
 * 
 * @Column(name = "last_name") private String lastName;
 * 
 * private String email;
 * 
 * private String password;
 * 
 * @ManyToMany(cascade = CascadeType.ALL)
 * 
 * @JoinTable private Collection<Role> roles;
 * 
 * public User() {
 * 
 * }
 * 
 * public User(String firstName, String lastName, String email, String password,
 * Collection<Role> roles) { super(); this.firstName = firstName; this.lastName
 * = lastName; this.email = email; this.password = password; this.roles = roles;
 * } public Long getId() { return id; } public void setId(Long id) { this.id =
 * id; } public String getFirstName() { return firstName; } public void
 * setFirstName(String firstName) { this.firstName = firstName; } public String
 * getLastName() { return lastName; } public void setLastName(String lastName) {
 * this.lastName = lastName; } public String getEmail() { return email; } public
 * void setEmail(String email) { this.email = email; } public String
 * getPassword() { return password; } public void setPassword(String password) {
 * this.password = password; } public Collection<Role> getRoles() { return
 * roles; } public void setRoles(Collection<Role> roles) { this.roles = roles; }
 * 
 * }
 */