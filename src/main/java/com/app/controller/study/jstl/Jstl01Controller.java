package com.app.controller.study.jstl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.dto.study.Product;

@Controller
public class Jstl01Controller {
	
	@GetMapping("/jstl1")
	public String jstl1(Model model) {
		
		
		model.addAttribute("msg", "오늘은 꽁짜 커피~");
		
		Product product = new Product();
		product.setId("proId");
		product.setName("proName");
		model.addAttribute("product", product);
		
		
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product("id1", "name1", 1));
		productList.add(new Product("id1", "name1", 1));
		productList.add(new Product("id1", "name1", 1));
		productList.add(new Product("id1", "name1", 1));
		productList.add(new Product("id1", "name1", 1));
				
		model.addAttribute("productList", productList);
		
		//coffee juice water
		//model.addAttribute("drinkType", "coffee");
		model.addAttribute("userType", "user");
		
		//user admin
		
		model.addAttribute("userType","admin");
		
		model.addAttribute("isLogin", true);
		//true : 로그인 o false : 로그인 x
		
		return "jstl/jstl1";
		
	}
	
	@GetMapping("/jstl2")
	public String jstl2(Model model) {
		
		model.addAttribute("msg1", "<부등호>");
		model.addAttribute("msg2", "&lt;부등호&gt");
		
		model.addAttribute("msgXml","<script>alert('경고!!')</script>");
		
		
		return "jstl/jstl2";
		
	}

}
