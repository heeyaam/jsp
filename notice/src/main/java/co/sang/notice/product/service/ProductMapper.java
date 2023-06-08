package co.sang.notice.product.service;

import java.util.List;

public interface ProductMapper {
	//batis 에서 서브스하는부분
	List<ProductVO> productSelectList();
	ProductVO productSelect(ProductVO vo);
	int productInsert(ProductVO vo);
	int productUpdate(ProductVO vo);
	int productDelete(ProductVO vo);
}
