package com.shop.ServiceImpl;

import com.shop.Dao.ProductDao;
import com.shop.Service.ProductService;
import com.shop.Table.Product;
import com.shop.Tools.PageResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("productService")
public class ProductServiceImpl  implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }
    
    @Override
    public PageResult<Product> findAllByPage(int pageIndex,int pageSize) {
        return productDao.findAllByPage( pageIndex, pageSize);
    }

	@Override
	public void insert(Product product) {
		productDao.insert(product);
	}

	@Override
	public Product selectOne1(String productNum) {
		return productDao.selectOne1(productNum);
	}
	
	@Override
	public Product selectOne1L(String productNum) {
		return productDao.selectOne1L(productNum);
	}
	
	@Override
	public void updateOne1(Product product) {
		productDao.updateOne1(product);
	}
	
	@Override
	public void deleteOne1(String productNum) {
		productDao.deleteOne1(productNum);
	}
}
