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
@Table (name = "TBL_ACCOUNT")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)	@Column	private Integer accountId;
	@Column	private String username;
	@Column	private String password;
	@Column	private Integer role;
	@Column	private Integer status;
	@Column	private Date createTime;
}
