package xyz.thishome.yuelitao_book.pojo;

import java.util.ArrayList;
import java.util.List;

public class BookCartVo {

    private Integer userId;

    private List<BookProductVo> bookProducts = new ArrayList<>();

    public BookProductVo findBookOneForId(Integer id) {
        for (BookProductVo bookProduct : bookProducts) {
            if (bookProduct.getId().compareTo(id) == 0) {
                return bookProduct;
            }
        }
        return null;
    }

    public void addToListForId(BookProductVo bookProductVo) {
        bookProducts.add(bookProductVo);
    }

    public List<BookProductVo> findBookProductsForIds(Integer[] ids) {
        List<BookProductVo> findBookProductsForIds = new ArrayList<>();
        for (BookProductVo bookProduct : bookProducts) {
            for (Integer id : ids) {
                if (bookProduct.getId().compareTo(id) == 0) {
                    findBookProductsForIds.add(bookProduct);
                }

            }
        }
        return findBookProductsForIds;
    }

    public void removeBookProductsForIds(Integer[] ids) {
        List<BookProductVo> bookProductsForIds = findBookProductsForIds(ids);
        for (BookProductVo productsForId : bookProductsForIds) {
            bookProducts.remove(productsForId);
        }
    }

    public void removeBookOneForId(Integer bookId) {
        BookProductVo removeBook = null;
        for (BookProductVo bookProduct : bookProducts) {
            if (bookProduct.getId().compareTo(bookId) == 0) {
                removeBook = bookProduct;
            }
        }
        bookProducts.remove(removeBook);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setBookProducts(List<BookProductVo> bookProducts) {
        this.bookProducts = bookProducts;
    }

    public List<BookProductVo> getBookProducts() {
        return bookProducts;
    }

    @Override
    public String toString() {
        return "BookCartVo{" +
                "userId=" + userId +
                ", bookProducts=" + bookProducts +
                '}';
    }

}
