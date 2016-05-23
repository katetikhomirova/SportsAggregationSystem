package ua.nure.tikhomirova.sport_aggregation_system.rest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the team database table.
 * 
 */
@Entity
@Table(name="team")
@NamedQuery(name="Team.findAll", query="SELECT t FROM Team t")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=50)
	private String name;

	//bi-directional many-to-one association to Competitor
	@OneToMany(mappedBy="team")
	private List<Competitor> competitors;

	//bi-directional many-to-one association to UserSport
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userSport")
	private UserSport usersport;

	//bi-directional many-to-one association to UserTeam
	@OneToMany(mappedBy="team")
	private List<UserTeam> userTeams;

	public Team() {
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

	public List<Competitor> getCompetitors() {
		return this.competitors;
	}

	public void setCompetitors(List<Competitor> competitors) {
		this.competitors = competitors;
	}

	public Competitor addCompetitor(Competitor competitor) {
		getCompetitors().add(competitor);
		competitor.setTeam(this);

		return competitor;
	}

	public Competitor removeCompetitor(Competitor competitor) {
		getCompetitors().remove(competitor);
		competitor.setTeam(null);

		return competitor;
	}

	public UserSport getUsersport() {
		return this.usersport;
	}

	public void setUsersport(UserSport usersport) {
		this.usersport = usersport;
	}

	public List<UserTeam> getUserTeams() {
		return this.userTeams;
	}

	public void setUserTeams(List<UserTeam> userTeams) {
		this.userTeams = userTeams;
	}

	public UserTeam addUserTeam(UserTeam userTeam) {
		getUserTeams().add(userTeam);
		userTeam.setTeam(this);

		return userTeam;
	}

	public UserTeam removeUserTeam(UserTeam userTeam) {
		getUserTeams().remove(userTeam);
		userTeam.setTeam(null);

		return userTeam;
	}

}