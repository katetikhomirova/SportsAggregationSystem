package ua.nure.tikhomirova.sport_aggregation_system.rest.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the stage database table.
 * 
 */
@Entity
@Table(name="stage")
@NamedQuery(name="Stage.findAll", query="SELECT s FROM Stage s")
public class Stage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	//uni-directional many-to-one association to SportCompetition
	@ManyToOne
	@JoinColumn(name="sportCompetition")
	private SportCompetition sportcompetition;

	public Stage() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SportCompetition getSportcompetition() {
		return this.sportcompetition;
	}

	public void setSportcompetition(SportCompetition sportcompetition) {
		this.sportcompetition = sportcompetition;
	}

}