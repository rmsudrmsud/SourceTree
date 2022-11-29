package product;

import java.util.ArrayList;

public class ProductService {
	
	private ProductDao dao;
	
	public ProductService(){
	dao = new ProductDao();
	}
	
	public void addProduct(ProductVo vo) {
		dao.insert(vo);
	}
	
	public ProductVo getByNum(int num) {
		return dao.selectNum(num);
	}
	
	public ArrayList<ProductVo> getByName(String name){
		return dao.selectByName(name);
	}
	
	public ArrayList<ProductVo> getByPrice(int low, int high){
		return dao.selectByPrice(low, high);
	}
	
	public ArrayList<ProductVo> getAll() {
		return dao.selectAll();
	}
	
	public void editProduct(ProductVo vo) {
		dao.update(vo);
	}
	
	public void delProduct(int num) {
		dao.delete(num);
	}
}
