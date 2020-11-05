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
@Table(name = "TBL_COMMENT")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)	@Column	private Integer commentId;
	@Column	private Integer userId;
	@Column	private Integer postId;
	@Column	private String content;
	@Column	private Date createTime;
	@Column	private Integer status;
	@Column	private Date updateTime;
	@Column	private String type;
	@Column (name = "replytocomment") private Integer replyTo;
	
	
}
