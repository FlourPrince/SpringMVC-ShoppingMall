package com.shop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.Service.ProductService;
import com.shop.Table.Product;
import com.shop.Tools.PageResult;

@Controller
@RequestMapping(path="/product")
public class ProductController {
     @Autowired
	private ProductService productService;
	 
	@RequestMapping(path="/findProductAll")
	 public ModelAndView findProductAll() {
		ModelAndView mav=new ModelAndView();
		List<Product> lst= productService.findAll();
		System.out.println(lst);
		   mav.addObject("productList",lst);
		   mav.setViewName("product-list");
		 return mav;
	 }
	
	@RequestMapping(path="/findProductAllByPage")
	 public ModelAndView findProductAllByPage(@RequestParam(value="pageIndex")int pageIndex, @RequestParam(value="pageSize")int pageSize) {
		ModelAndView mav=new ModelAndView();
		PageResult<Product> lst= productService.findAllByPage(pageIndex, pageSize);
		System.out.println(lst);
		   mav.addObject("productpagelist",lst);
		   mav.setViewName("product-pagelist");
		 return mav;
	 }
	
	
}
