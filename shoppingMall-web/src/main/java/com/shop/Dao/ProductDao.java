package com.shop.Dao;

import com.shop.Table.Product;
import com.shop.Tools.PageResult;

import java.util.List;

public interface ProductDao {
    public List<Product> findAll();
    
    public PageResult<Product> findAllByPage(int pageIndex,int pageSize);
    
    public long findAllByPageCount();
    
    public void insert(Product product);
    
    
    public Product selectOne1(String productNum);
    
    
    public Product selectOne1L(String productNum);

    
    public void updateOne1(Product product) ;
    
    
    public void deleteOne1(String productNum);

    
}
