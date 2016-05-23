package ua.nure.tikhomirova.sport_aggregation_system.rest.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int id;

	private byte active;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Column(nullable = false, length = 100)
	private String email;

	@Column(nullable = false, length = 50)
	private String firstName;

	@Column(nullable = false, length = 1)
	private String gender;

	@Column(nullable = false, length = 50)
	private String lastName;

	@Column(nullable = false, length = 45)
	private String login;

	@Column(nullable = false, length = 45)
	private String password;

	private Integer rating;

	// bi-directional many-to-one association to Administration
	@OneToMany(mappedBy = "user")
	private List<Administration> administrations;

	// bi-directional many-to-one association to Sportrank
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rank")
	private Sportrank sportrank;

	// bi-directional many-to-one association to UserRole
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role")
	@JsonManagedReference
	private UserRole userrole;

	// bi-directional many-to-one association to UserTeam
	@OneToMany(mappedBy = "user")
	private List<UserTeam> userTeams;

	// bi-directional many-to-one association to UserSport
	@OneToMany(mappedBy = "user")
	private List<UserSport> usersports;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
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

	public Integer getRating() {
		return this.rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public List<Administration> getAdministrations() {
		return this.administrations;
	}

	public void setAdministrations(List<Administration> administrations) {
		this.administrations = administrations;
	}

	public Administration addAdministration(Administration administration) {
		getAdministrations().add(administration);
		administration.setUser(this);

		return administration;
	}

	public Administration removeAdministration(Administration administration) {
		getAdministrations().remove(administration);
		administration.setUser(null);

		return administration;
	}

	public Sportrank getSportrank() {
		return this.sportrank;
	}

	public void setSportrank(Sportrank sportrank) {
		this.sportrank = sportrank;
	}

	public UserRole getUserrole() {
		return this.userrole;
	}

	public void setUserrole(UserRole userrole) {
		this.userrole = userrole;
	}

	public List<UserTeam> getUserTeams() {
		return this.userTeams;
	}

	public void setUserTeams(List<UserTeam> userTeams) {
		this.userTeams = userTeams;
	}

	public UserTeam addUserTeam(UserTeam userTeam) {
		getUserTeams().add(userTeam);
		userTeam.setUser(this);

		return userTeam;
	}

	public UserTeam removeUserTeam(UserTeam userTeam) {
		getUserTeams().remove(userTeam);
		userTeam.setUser(null);

		return userTeam;
	}

	public List<UserSport> getUsersports() {
		return this.usersports;
	}

	public void setUsersports(List<UserSport> usersports) {
		this.usersports = usersports;
	}

	public UserSport addUsersport(UserSport usersport) {
		getUsersports().add(usersport);
		usersport.setUser(this);

		return usersport;
	}

	public UserSport removeUsersport(UserSport usersport) {
		getUsersports().remove(usersport);
		usersport.setUser(null);

		return usersport;
	}

}