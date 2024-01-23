package com.logisticsportal.demo.products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.logisticsportal.demo.products.*;
import com.logisticsportal.demo.repositories.ProductRepository;

@Component
@Service
public class ProductService {
	
		@Autowired
		ProductRepository productrep;
		
		public List<Product> getAllProducts() {
			return productrep.findAll();
		}
		
		public Product getProductbyID(int productID) {
			return productrep.findById(productID).get();
		}
//		public Product getProductbyName(String productName) {
//			List<Product> products=productrep.findAll();
//			Product product = null;
//			
//			for(Product pro:products) {
//				if(pro.getProductName().equalsIgnoreCase(productName))
//					product=pro;
//			}
//			return product;
		
//		}
		public Product addProduct(Product product) {
			product.setProductID(getMaxId());
			productrep.save(product);
			return product;
		}
		public int getMaxId()
		{
			return productrep.findAll().size()+1;
		}
		public Product updateProduct(Product product) {
			productrep.save(product);
			return product;
		}
		public AddResponse deleteProduct(int productID)
		{
			productrep.deleteById(productID);
			AddResponse res=new AddResponse();
			res.setMsg("Product Deleted");
			res.setId(productID);
			return res;
		}
		
}



//static HashMap<Integer,Product> productMap;
//
//public ProductService()
//{
//	productMap=new HashMap<Integer,Product>();
//	
//	Product appleProduct=new Product(301,"Apple","IPhone");
//	Product dellProduct=new Product(302,"Dell","Laptop");
//	Product nikeProduct=new Product(303,"Nike","Shoes");
//	
//	productMap.put(301, appleProduct);
//	productMap.put(302, dellProduct);
//	productMap.put(303, nikeProduct);
//}
//
//public List getAllProducts()
//{
//	List products=new ArrayList(productMap.values());
//	return products;
//}
//
//public Product getProductbyID(int id) {
//	Product product=productMap.get(id);
//	return product;
//}
//
//public Product getProductbyName(String productName) {
//	Product product = null;
//	for(int i:productMap.keySet())
//	{
//		if(productMap.get(i).getProductName().equals(productName))
//			product=productMap.get(i);
//	}
//	return product;
//}
//
//
//public Product addProduct(Product product) {
//	product.setProductID(getMaxId());
//	productMap.put(product.getProductID(), product);
//	return product;
//}
//
//public static int getMaxId()
//{
//	int max = 0;
//	for (int id:productMap.keySet())
//		if(max<=id)
//			max=id;
//	return max+1;
//}	
//
//public Product updateProduct(Product product)
//{
//	if(product.getProductID()>0)
//		productMap.put(product.getProductID(), product);
//		return product;
//}
//public AddResponse deleteProduct(int id)
//{
//	productMap.remove(id);
//	AddResponse res=new AddResponse();
//	res.setMsg("Product Deleted");
//	res.setId(id);
//	return res;
//}
