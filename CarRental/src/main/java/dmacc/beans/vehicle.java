package dmacc.beans;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Embeddable
public class vehicle {
	private long id;
	private String model;
	private String make;
	private int age;
	private boolean availability;

}