package kr.co.saramin.aoptest;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

	public ProductVo findProduct(String name) {
		System.out.println("Finding " + name + " ...");
		
		if (true) {
			throw new RuntimeException("error: finding product");
		}
		
		return new ProductVo(name);
	}
}
