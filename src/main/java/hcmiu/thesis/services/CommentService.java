package hcmiu.thesis.services;

import java.util.List;

import hcmiu.thesis.dtos.CommentDTO;
import hcmiu.thesis.dtos.ReplyDTO;

public interface CommentService {
	List<CommentDTO> getAllComments () ;
	
	List<ReplyDTO> getAllRepliesByCommentId (Integer id) ;

	List<CommentDTO> getCommentsDtoByPostId(Integer id);
}
