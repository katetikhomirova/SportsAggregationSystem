package ua.nure.tikhomirova.sport_aggregation_system.rest.model;

import java.io.Serializable;
import javax.persistence.*;


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

	//uni-directional many-to-one association to Sport
	@ManyToOne
	@JoinColumn(name="sport", nullable=false)
	private Sport sportBean;

	//uni-directional many-to-one association to Competition
	@ManyToOne
	@JoinColumn(name="sportCompetition", nullable=false)
	private Competition competition;

	public SportCompetition() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sport getSportBean() {
		return this.sportBean;
	}

	public void setSportBean(Sport sportBean) {
		this.sportBean = sportBean;
	}

	public Competition getCompetition() {
		return this.competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

}