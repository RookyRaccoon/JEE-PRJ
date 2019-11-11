package efrei.m1.se.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity @Table(name = "Employees")
@NoArgsConstructor @ToString
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ID")
	@Getter @Setter @ToString.Exclude
	private String dbId;

	@Column(name = "NAME")
	@Getter @Setter
	private String name;

	@Column(name = "FIRSTNAME")
	@Getter @Setter
	private String surname;

	@Column(name = "HOMEPHONE")
	@Getter @Setter
	private String personalPhone;

	@Column(name = "MOBILEPHONE")
	@Getter @Setter
	private String mobilePhone;

	@Column(name = "WORKPHONE")
	@Getter @Setter
	private String workPhone;

	@Column(name = "ADDRESS")
	@Getter @Setter
	private String address;

	@Column(name = "POSTALCODE")
	@Getter @Setter
	private String postalCode;

	@Column(name = "CITY")
	@Getter @Setter
	private String city;

	@Column(name = "EMAIL")
	@Getter @Setter
	private String email;

	public User(String name, String surname, String personalPhone, String mobilePhone, String workPhone, String address, String postalCode, String city, String email) {
		this.name = name;
		this.surname = surname;
		this.personalPhone = personalPhone;
		this.mobilePhone = mobilePhone;
		this.workPhone = workPhone;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.email = email;
		this.dbId = null;
	}
}
