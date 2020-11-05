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
@AllArgsConstructor
public class ReplyDTO {
	
	private Integer commentId;
	
	private Integer articleId;
	
	private String username;
	
	private String avatarPath;
	
	private String content;
	
	private String type;
	
	private Date createTime;
	
	private Integer replyTo;
	
}
