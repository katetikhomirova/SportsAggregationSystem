package ua.nure.tikhomirova.sport_aggregation_system.rest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Column(nullable=false, length=100)
	private String email;

	@Column(nullable=false, length=50)
	private String firstName;

	@Column(nullable=false, length=1)
	private String gender;

	@Column(nullable=false, length=50)
	private String lastName;

	@Column(nullable=false, length=45)
	private String login;

	@Column(nullable=false, length=45)
	private String password;

	private int rating;

	//uni-directional many-to-one association to UserRole
	@ManyToOne
	@JoinColumn(name="role")
	private UserRole userrole;

	//uni-directional many-to-one association to Sportrank
	@ManyToOne
	@JoinColumn(name="rank")
	private Sportrank sportrank;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public UserRole getUserrole() {
		return this.userrole;
	}

	public void setUserrole(UserRole userrole) {
		this.userrole = userrole;
	}

	public Sportrank getSportrank() {
		return this.sportrank;
	}

	public void setSportrank(Sportrank sportrank) {
		this.sportrank = sportrank;
	}

}