package kr.kh.spring.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberVO {
	String me_id;
	String me_pw;
	String me_email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date me_birthday;
	int me_authority;
	Date me_join_time;
	
}
