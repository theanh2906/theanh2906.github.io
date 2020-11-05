package hcmiu.thesis.entities;

import java.sql.Date;

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

@Entity
@Getter @Setter
@Table (name = "TBL_POST")
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer postId;
	@Column
	private Integer userId;
	@Column
	private String title;
	@Column
	private String content;
	@Column
	private Date createTime;
	@Column
	private String imagePath;
	@Column (name = "overallrating")
	private Double overall;
	@Column
	private String author;
	@Column (name = "abstract")
	private String abstracts;
	@Column
	private Integer statusId;
	
}
