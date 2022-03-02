package tn.globebusiness.spring.entity;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Travel {
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id ;
	@Temporal(TemporalType.DATE)
	private Date date ;
	private String destination ;
	private int duration ;
	private String objective ;

}
