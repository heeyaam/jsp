package co.sang.notice.product.service;

import java.util.List;

public interface ProductService {
	//자바에서 서비스하는 부분
	List<ProductVO> productSelectList();
	ProductVO productSelect(ProductVO vo);
	int productInsert(ProductVO vo);
	int productUpdate(ProductVO vo);
	int productDelete(ProductVO vo);

}
