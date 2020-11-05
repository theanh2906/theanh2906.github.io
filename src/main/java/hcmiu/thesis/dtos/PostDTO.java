package hcmiu.thesis.dtos;

import java.util.Date;
import java.util.List;

import hcmiu.thesis.entities.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO {
	private Integer postId;
	private Integer userId;
	private String username;
	private String title;
	private String abstracts;
	private String content;
	private String author;
	private Date createTime;
	private String categoryName;
	private String code;
	private Double overall;
	private List<Comment> comments;
	private String statusName;
	public PostDTO(Integer postId, Integer userId, String username, String title, String abstracts, String content, String author, Date createTime,
			String categoryName, String code, Double overall, String statusName) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.username = username;
		this.title = title;
		this.abstracts = abstracts;
		this.content = content;
		this.author = author;
		this.createTime = createTime;
		this.categoryName = categoryName;
		this.code = code;
		this.overall = overall;
		this.statusName = statusName;
	}
	
	
	
}