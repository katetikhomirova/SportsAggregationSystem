package ua.nure.tikhomirova.sport_aggregation_system.rest.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usersport database table.
 * 
 */
@Entity
@Table(name="usersport")
@NamedQuery(name="UserSport.findAll", query="SELECT u FROM UserSport u")
public class UserSport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	//uni-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

	//uni-directional many-to-one association to Sport
	@ManyToOne
	@JoinColumn(name="sportId")
	private Sport sport;

	public UserSport() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Sport getSport() {
		return this.sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

}