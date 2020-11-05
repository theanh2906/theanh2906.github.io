package hcmiu.thesis.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_USER")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer userId;
	@Column
	private Integer accountId;
	@Column
	private String fullname;
	@Column
	private Date dob;
	@Column
	private String email;
	@Column
	private String nationality;
	@Column
	private String address;
	@Column
	private String bio;
	@Column
	private String avatarPath;
}
