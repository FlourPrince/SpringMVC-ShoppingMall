package com.shop.TestSpring;

import java.math.BigDecimal;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.Dao.ProductDao;
import com.shop.Service.ProductService;
import com.shop.Table.Product;
import com.shop.Tools.PageResult;

@RunWith(SpringJUnit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:spring.xml"})
public class SpringTest {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductDao productDao;

	/**
	 * 查询所有
	 */
	@Test
	public void test1() {
		List<Product> lst = productService.findAll();
		for (Product product : lst) {
			System.out.println(product.toString());
		}
	}

	/**
	 * 查询单笔数据
	 */
	@Test
	public void test2() {
		Product product = productService.selectOne1("999");
		System.out.println(product);
	}

	/**
	 * 加锁查询单笔数据
	 */
	@Test
	public void test3() {
		Product product = productService.selectOne1L("999");
		System.out.println(product);
	}

	/**
	 * 增加数据
	 */
	@Test
	public void test4() {
		Product product = new Product();
		product.setId("2");
		product.setProductNum("999");
		product.setCityName("上海");
		product.setDepartureTime("2020-03-03");
		product.setProductPrice(new BigDecimal(100));
		product.setProductStatus("0");
		product.setProductName("王老二");
		product.setProductDesc("测试");
		productService.insert(product);
	}

	/**
	 * 更新数据
	 */
	@Test
	public void test5() {
		Product product = new Product();
		product.setId("2");
		product.setProductNum("999");
		product.setCityName("上海");
		product.setDepartureTime("2020-03-03");
		product.setProductPrice(new BigDecimal(100));
		product.setProductStatus("0");
		product.setProductName("王老二");
		product.setProductDesc("测试更新");
		productService.updateOne1(product);
	}

	/**
	 * 删除数据
	 */
	@Test
	public void test6() {

		productService.deleteOne1("999");
	}

	/**
	 * 分页查询 1.直接截取list
	 * 分页查询 2.limit    先查询出总笔数，然后根据传进来的每页记录数 计算总页数。根据当前页数 算出 limit  from,end
	 * 分页查询 3.配置拦截器  拦截所有请求参数带查询笔数的请求，统一封装+limit
	 *         

	 */
	@Test
	public void test7() {
		List<Product> lst = productService.findAll();
		int currPage =1;   //当前页数
		int pageSize =2;   //每页数据
		
		int fromIndex=(currPage-1)*pageSize;
		int endIndex=currPage*pageSize;
		for (Product product : lst.subList(fromIndex, endIndex)) {
			System.out.println(product.toString());
		}
	}
	/**
	 * 分页查询
	 * 4. Map<String, Object> map=new HashMap<String, Object>();
        return getSqlSessionTemplate().selectList("ProductDao.findAll",map,new RowBounds(offset,limit));
        Mybatis的逻辑分页比较简单，简单来说就是取出所有满足条件的数据，然后舍弃掉前面offset条数据，然后再取剩下的数据的limit条
	 */
	@Test
	public void test8() {
		PageResult<Product> lst = productService.findAllByPage(2,2);
		for (Product product : lst.getResult()) {
			System.out.println(product.toString());
		}
	}
	
	@Test
	public void test9() {
		Long long1=   productDao.findAllByPageCount();
		System.out.println(long1);
	}
	


}
