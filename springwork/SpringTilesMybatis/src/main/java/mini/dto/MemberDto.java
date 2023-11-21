package mini.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberDto {
	private int num;
	private String name;
	private String pass;
	private String photo;
	private String hp;
	private String email;
	private Timestamp gaipday;
}
