package hcmiu.thesis.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmiu.thesis.dtos.CommentDTO;
import hcmiu.thesis.dtos.ReplyDTO;
import hcmiu.thesis.repositories.CommentRepository;
import hcmiu.thesis.repositories.EntityManagerRepository;
import hcmiu.thesis.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private EntityManagerRepository entityRepo;
	

	@Override
	public List<CommentDTO> getAllComments() {
		// TODO Auto-generated method stub
		return entityRepo.getAllComments().stream().filter(c -> c.getType().equals("comment")).collect(Collectors.toList());
	}

	@Override
	public List<ReplyDTO> getAllRepliesByCommentId(Integer id) {
		// TODO Auto-generated method stub
		return entityRepo.getAllComments().stream().filter(c -> c.getType().equals("reply") && c.getReplyTo() == id ).map(each -> {
			return new ReplyDTO(each.getCommentId(), each.getArticleId(), each.getUsername(), each.getAvatarPath(), each.getContent(), each.getType(), each.getCreateTime(), each.getReplyTo());
		}).collect(Collectors.toList());
	}

	@Override
	public List<CommentDTO> getCommentsDtoByPostId(Integer id) {
		// TODO Auto-generated method stub
		List<CommentDTO> listCommentDTO = new ArrayList<>();
		List<CommentDTO> listCommentByPostId = getAllComments().stream().filter(c -> c.getArticleId() == id).collect(Collectors.toList());
		listCommentByPostId.forEach(each -> {
			CommentDTO commentDTO = new CommentDTO();
			BeanUtils.copyProperties(each, commentDTO);
			commentDTO.setReplies(getAllRepliesByCommentId(each.getCommentId()));
			listCommentDTO.add(commentDTO);
		});
		
		return listCommentDTO;
	}

}
