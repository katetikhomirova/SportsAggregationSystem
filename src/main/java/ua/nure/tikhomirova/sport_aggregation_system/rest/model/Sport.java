package ua.nure.tikhomirova.sport_aggregation_system.rest.model;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The persistent class for the sport database table.
 * 
 */
@Entity
@Table(name = "sport")
@NamedQuery(name = "Sport.findAll", query = "SELECT s FROM Sport s")
public class Sport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false)
	private byte isCommand;

	@Column(nullable = false, length = 50)
	private String name;

	// bi-directional many-to-one association to SportCategory
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sportCategory")
	@JsonBackReference
	private SportCategory sportcategory;

	// bi-directional many-to-one association to SportCompetition
	@OneToMany(mappedBy = "sportBean")
	private List<SportCompetition> sportcompetitions;

	// bi-directional many-to-one association to Standart
	@OneToMany(mappedBy = "sport")
	private List<Standart> standarts;

	// bi-directional many-to-one association to UserSport
	@OneToMany(mappedBy = "sport")
	private List<UserSport> usersports;

	public Sport() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getIsCommand() {
		return this.isCommand;
	}

	public void setIsCommand(byte isCommand) {
		this.isCommand = isCommand;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SportCategory getSportcategory() {
		return this.sportcategory;
	}

	public void setSportcategory(SportCategory sportcategory) {
		this.sportcategory = sportcategory;
	}

	public List<SportCompetition> getSportcompetitions() {
		return this.sportcompetitions;
	}

	public void setSportcompetitions(List<SportCompetition> sportcompetitions) {
		this.sportcompetitions = sportcompetitions;
	}

	public SportCompetition addSportcompetition(
			SportCompetition sportcompetition) {
		getSportcompetitions().add(sportcompetition);
		sportcompetition.setSportBean(this);

		return sportcompetition;
	}

	public SportCompetition removeSportcompetition(
			SportCompetition sportcompetition) {
		getSportcompetitions().remove(sportcompetition);
		sportcompetition.setSportBean(null);

		return sportcompetition;
	}

	public List<Standart> getStandarts() {
		return this.standarts;
	}

	public void setStandarts(List<Standart> standarts) {
		this.standarts = standarts;
	}

	public Standart addStandart(Standart standart) {
		getStandarts().add(standart);
		standart.setSport(this);

		return standart;
	}

	public Standart removeStandart(Standart standart) {
		getStandarts().remove(standart);
		standart.setSport(null);

		return standart;
	}

	public List<UserSport> getUsersports() {
		return this.usersports;
	}

	public void setUsersports(List<UserSport> usersports) {
		this.usersports = usersports;
	}

	public UserSport addUsersport(UserSport usersport) {
		getUsersports().add(usersport);
		usersport.setSport(this);

		return usersport;
	}

	public UserSport removeUsersport(UserSport usersport) {
		getUsersports().remove(usersport);
		usersport.setSport(null);

		return usersport;
	}

}