package co.sang.notice.product.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sang.notice.common.Command;
import co.sang.notice.product.service.ProductService;
import co.sang.notice.product.service.ProductVO;
import co.sang.notice.product.serviceImpl.ProductServiseImpl;

public class ProductList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse restponse) {
		// 제품리스트
		ProductService ps = new ProductServiseImpl();
		List<ProductVO> products = new ArrayList<>();
		request.setAttribute("products", products);
		return "product/productList";
	}

}
