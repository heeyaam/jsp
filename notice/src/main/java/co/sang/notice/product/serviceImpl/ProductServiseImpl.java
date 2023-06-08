package co.sang.notice.product.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.sang.notice.common.DataSource;
import co.sang.notice.product.service.ProductMapper;
import co.sang.notice.product.service.ProductService;
import co.sang.notice.product.service.ProductVO;

public class ProductServiseImpl implements ProductService {
	//productservice 인터페이스를 구현하는곳
	
	//DAO 선언부분  (DataSource = dao 객체 연결)
	SqlSession sqlSession = DataSource.getInstance().openSession();
	//mapper 연결 하는 부분(모델에서 데이터를 가져오는 부분)
	ProductMapper map = sqlSession.getMapper(ProductMapper.class);

	@Override
	public List<ProductVO> productSelectList() {
		
		return map.productSelectList();
	}

	@Override
	public ProductVO productSelect(ProductVO vo) {
	
		return map.productSelect(vo);
	}

	@Override
	public int productInsert(ProductVO vo) {
		
		return map.productInsert(vo);
	}

	@Override
	public int productUpdate(ProductVO vo) {
		
		return map.productUpdate(vo);
	}

	@Override
	public int productDelete(ProductVO vo) {
		
		return map.productDelete(vo);
	}

}
