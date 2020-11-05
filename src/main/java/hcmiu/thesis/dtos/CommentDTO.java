package hcmiu.thesis.dtos;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentDTO {
	
	private Integer commentId;
	
	private Integer articleId;
	
	private String username;
	
	private String avatarPath;
	
	private String content;
	
	private String type;
	
	private Date createTime;
	
	private Integer replyTo;
	
	private List<ReplyDTO> replies;

	public CommentDTO(Integer commentId, Integer articleId, String username, String avatarPath, String content, String type,
			Date createTime, Integer replyTo) {
		super();
		this.commentId = commentId;
		this.articleId = articleId;
		this.username = username;
		this.avatarPath = avatarPath;
		this.content = content;
		this.type = type;
		this.createTime = createTime;
		this.replyTo = replyTo;
	}
	
	
	
}
