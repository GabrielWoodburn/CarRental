package dmacc.beans;

import javax.persistence.Embeddable;

@Embeddable
public class vehicle {
	private long id;
	private String model;
	private String make;
	private int age;
	private boolean availability;

}
