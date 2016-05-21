package ua.nure.tikhomirova.sport_aggregation_system.rest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sportrank database table.
 * 
 */
@Entity
@Table(name="sportrank")
@NamedQuery(name="Sportrank.findAll", query="SELECT s FROM Sportrank s")
public class Sportrank implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=50)
	private String name;

	//bi-directional many-to-one association to Standart
	@OneToMany(mappedBy="sportrank", fetch=FetchType.EAGER)
	private List<Standart> standarts;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="sportrank", fetch=FetchType.EAGER)
	private List<User> users;

	public Sportrank() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Standart> getStandarts() {
		return this.standarts;
	}

	public void setStandarts(List<Standart> standarts) {
		this.standarts = standarts;
	}

	public Standart addStandart(Standart standart) {
		getStandarts().add(standart);
		standart.setSportrank(this);

		return standart;
	}

	public Standart removeStandart(Standart standart) {
		getStandarts().remove(standart);
		standart.setSportrank(null);

		return standart;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setSportrank(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setSportrank(null);

		return user;
	}

}