package hcmiu.thesis.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Mail {
	private String to;
	private String from;
	private String subject;
	private String body;
}
