package hcmiu.thesis.commons;

public class PostQuery {
	
	public static final String GET_ALL_POSTS = 
			"select new hcmiu.thesis.dtos.PostDTO (p.postId, p.userId, a.username, p.title, p.abstracts, p.content, p.author, p.createTime, c.categoryName, c.code, p.overall, s.statusName) "
		  + "from Post p "
		  + "join User u on p.userId = u.userId "
		  + "join Account a on u.accountId = a.accountId "
		  + "join PostCategory ac on p.postId = ac.postId "
		  + "join Category c on ac.categoryId = c.categoryId "
		  + "join Status s on p.statusId = s.statusId ";
	
	public static final String GET_ALL_POSTS_BY_STATUS = 
			"select new hcmiu.thesis.dtos.PostDTO (p.postId, p.userId, a.username, p.title, p.abstracts, p.content, p.author, p.createTime, c.categoryName, c.code, p.overall, s.statusName) "
		  + "from Post p "
		  + "join User u on p.userId = u.userId "
		  + "join Account a on u.accountId = a.accountId "
		  + "join PostCategory ac on p.postId = ac.postId "
		  + "join Category c on ac.categoryId = c.categoryId "
		  + "join Status s on p.statusId = s.statusId "
		  + "where p.statusId = ?1";
	
	public static final String GET_ALL_COMMENTS = 
			"select new hcmiu.thesis.dtos.CommentDTO (c.commentId, c.postId, a.username, u.avatarPath, c.content, c.type, c.createTime, c.replyTo) "
		  + "from Comment c "
		  + "join User u on c.userId = u.userId "
		  + "join Account a on u.accountId = a.accountId "
		  + "order by c.createTime desc";
}
