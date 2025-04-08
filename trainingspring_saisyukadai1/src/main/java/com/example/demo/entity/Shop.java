package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Shop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "名前は必須です")
    @Size(max = 50, message = "名前は50文字以内で入力してください")
	private String name;
	
	private String type;
	
	@Pattern(
	    regexp = "^\\d{2,3}-\\d{4}-\\d{4}$",
	    message = "電話番号は「00-0000-0000」または「000-0000-0000」の形式で入力してください"
	)
	private String phone;
	
	@Min(value = 0, message = "売上は0以上でなければなりません")
	private Long sales;
	
	@Column(name = "created_date")
	private Date createdDate;
}