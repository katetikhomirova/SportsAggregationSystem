package ua.nure.tikhomirova.sport_aggregation_system.rest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	//bi-directional many-to-one association to Team
	@OneToMany(mappedBy="usersport")
	private List<Team> teams;

	//bi-directional many-to-one association to Sport
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sportId")
	private Sport sport;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userId")
	private User user;

	public UserSport() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Team> getTeams() {
		return this.teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public Team addTeam(Team team) {
		getTeams().add(team);
		team.setUsersport(this);

		return team;
	}

	public Team removeTeam(Team team) {
		getTeams().remove(team);
		team.setUsersport(null);

		return team;
	}

	public Sport getSport() {
		return this.sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}