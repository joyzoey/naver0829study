package data.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemoDto {
	private int num;
	private String nickname;
	private String photo;
	private String memo;
	private int likes;
	private Timestamp writeday;
}
