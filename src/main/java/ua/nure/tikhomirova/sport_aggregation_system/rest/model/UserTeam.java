package ua.nure.tikhomirova.sport_aggregation_system.rest.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_team database table.
 * 
 */
@Entity
@Table(name="user_team")
@NamedQuery(name="UserTeam.findAll", query="SELECT u FROM UserTeam u")
public class UserTeam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	//uni-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

	//uni-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="teamId")
	private Team team;

	public UserTeam() {
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

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}