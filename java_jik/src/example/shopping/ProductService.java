package example.shopping;

import java.util.List;

public interface ProductService {

	/**새로운 제품 정보를 제품 리스트에 등록하는 
	 * 메소드
	 * @param productList 제품 리스트
	 * @param product 새로운 제품 정보
	 * @return 제품 등록 여부(true/false)
	 */
	boolean insertProduct(List<Product> productList, Product product);
	/**기존 제품 정보를 수정하는 메소드
	 * @param productList 제품 리스트
	 * @param index 수정할 제품의 번지
	 * @param product 수정할 제품 정보
	 * @return 수정 여부
	 */
	boolean updateProduct(List<Product> productList,int index, Product product);
	/**기존 제품 정보를 삭제하는 메소드
	 * @param productList 제품 리스트
	 * @param product 삭제할 제품 정보
	 * @return 삭제 여부
	 */
	boolean deleteProduct(List<Product> productList, Product product);
	/**제품 리스트에서 index 번지에 있는 제품을 가져오는 메소드
	 * @param productList 제품 리스트
	 * @param index  가져올 번지
	 * @return index 번지에 있는 제품 정보, 없으면 null
	 */
	Product getProduct(List<Product> productList, int index);
	/**제품 수량을 변경하는 메소드
	 * @param product 제품 정보
	 * @param amount 제품 수량(+면 제품을 구매, -면 제품을 판매)
	 */
	void productStock(Product product, int amount);
	/**제품 정보를 입력받아 제품 객체를 반환하는 메소드
	 * @return 입력받은 정보로 만든 제품 객체*/
	Product inputProduct();
}
