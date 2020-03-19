package com.shop.DaoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.shop.Dao.ProductDao;
import com.shop.Table.Product;
import com.shop.Tools.MySqlSessionTemplate;
import com.shop.Tools.PageResult;
@Repository("productDao")
public class ProductDaoImpl  extends MySqlSessionTemplate implements ProductDao{
	@Override
	public void insert(Product product) {
		 getSqlSessionTemplate().insert("ProductDao.insert",product);
	}
	
	
	@Override
    public List<Product> findAll() {
        return getSqlSessionTemplate().selectList("ProductDao.findAll");
    }

	@Override
    public PageResult<Product> findAllByPage(int pageIndex,int pageSize) {
		//分页查询主逻辑
		Map<String, Object> map=new HashMap<String, Object>();
		PageResult<Product> page=new PageResult();
		 List<Product> lst=null;
		 Long count= findAllByPageCount();  //总行数
		 if(count==0){
			 return null;
		 }
		 //总页数
		 long pageTotalIndex=(count/pageSize)+1;
		 
		 int offset =(pageIndex-1)*pageSize;
		 if(count>0) {
		         lst=getSqlSessionTemplate().selectList("ProductDao.findAll",map,new RowBounds(offset,pageSize));
		 }
		
		  page.setResult(lst);
		  page.setCount(count);
		  page.setPageTotalIndex(pageTotalIndex);
		  page.setPageSize(pageSize);
		  page.setPageIndex(pageIndex);
		/*
		 * page.setStartRowNo(startRowNo); page.setEndRowNo(endRowNo);
		 */
		 
         return page;
    }
	//查询总笔数
	@Override
	public long findAllByPageCount() {
		
		return  getSqlSessionTemplate().selectOne("ProductDao.findAllByPageCount");
	}
	
	
	
	@Override
	public Product selectOne1(String productNum) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("productNum", productNum);
		return getSqlSessionTemplate().selectOne("ProductDao.selectOne1", map);
	}

	
	@Override
	public Product selectOne1L(String productNum) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("productNum", productNum);
		return getSqlSessionTemplate().selectOne("ProductDao.selectOne1L", map);
	}

	@Override
	public void updateOne1(Product product) {
		getSqlSessionTemplate().update("ProductDao.updateOne1", product);
	}

	
	@Override
	public void deleteOne1(String productNum) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("productNum", productNum);
		
		getSqlSessionTemplate().delete("ProductDao.deleteOne1", map);
	}
    
}
