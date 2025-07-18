package com.app.dto.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
//@ToString
//@NoArgsConstructor 
//@AllArgsConstructor

@Data
public class Room {
	
	int roomId; //PK 기본키 식별자
	String bulidingNumber;
	int roomNumber; //호실번호
	int floor; //층수
	int maxGuestCount; //최대 숙박 인원
	String viewType; //뷰 구분 코드
					//오션뷰 시티뷰 마운틴뷰
					// OCN CTY MOT
					// 1	2	3
	
}