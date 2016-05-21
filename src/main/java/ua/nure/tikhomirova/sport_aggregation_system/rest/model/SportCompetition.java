package ua.nure.tikhomirova.sport_aggregation_system.rest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sportcompetition database table.
 * 
 */
@Entity
@Table(name="sportcompetition")
@NamedQuery(name="SportCompetition.findAll", query="SELECT s FROM SportCompetition s")
public class SportCompetition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	//bi-directional many-to-one association to Administration
	@OneToMany(mappedBy="sportcompetition", fetch=FetchType.EAGER)
	private List<Administration> administrations;

	//bi-directional many-to-one association to Competitor
	@OneToMany(mappedBy="sportcompetition", fetch=FetchType.EAGER)
	private List<Competitor> competitors;

	//bi-directional many-to-one association to Competition
	@ManyToOne
	@JoinColumn(name="sportCompetition", nullable=false)
	private Competition competition;

	//bi-directional many-to-one association to Sport
	@ManyToOne
	@JoinColumn(name="sport", nullable=false)
	private Sport sportBean;

	//bi-directional many-to-one association to Stage
	@OneToMany(mappedBy="sportcompetition", fetch=FetchType.EAGER)
	private List<Stage> stages;

	public SportCompetition() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Administration> getAdministrations() {
		return this.administrations;
	}

	public void setAdministrations(List<Administration> administrations) {
		this.administrations = administrations;
	}

	public Administration addAdministration(Administration administration) {
		getAdministrations().add(administration);
		administration.setSportcompetition(this);

		return administration;
	}

	public Administration removeAdministration(Administration administration) {
		getAdministrations().remove(administration);
		administration.setSportcompetition(null);

		return administration;
	}

	public List<Competitor> getCompetitors() {
		return this.competitors;
	}

	public void setCompetitors(List<Competitor> competitors) {
		this.competitors = competitors;
	}

	public Competitor addCompetitor(Competitor competitor) {
		getCompetitors().add(competitor);
		competitor.setSportcompetition(this);

		return competitor;
	}

	public Competitor removeCompetitor(Competitor competitor) {
		getCompetitors().remove(competitor);
		competitor.setSportcompetition(null);

		return competitor;
	}

	public Competition getCompetition() {
		return this.competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public Sport getSportBean() {
		return this.sportBean;
	}

	public void setSportBean(Sport sportBean) {
		this.sportBean = sportBean;
	}

	public List<Stage> getStages() {
		return this.stages;
	}

	public void setStages(List<Stage> stages) {
		this.stages = stages;
	}

	public Stage addStage(Stage stage) {
		getStages().add(stage);
		stage.setSportcompetition(this);

		return stage;
	}

	public Stage removeStage(Stage stage) {
		getStages().remove(stage);
		stage.setSportcompetition(null);

		return stage;
	}

}