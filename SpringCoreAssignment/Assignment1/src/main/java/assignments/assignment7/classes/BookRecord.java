package assignments.assignment7.classes;

import org.springframework.beans.factory.annotation.Value;

public class BookRecord {

    private Integer bookId;
    private String bookName;
    private Double bookPrice;

    public BookRecord() {
        super();
    }

    public Integer getBookId() {
        return bookId;
    }

    @Value("#{T(java.lang.Integer).parseInt('178262')}")
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    @Value("Wing Of Fire")
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    @Value("#{T(java.lang.Double).parseDouble(T(java.lang.Math).sqrt(19382+10000))}")
    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString() {
        return "BookRecord{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookPrice='" + bookPrice + '\'' +
                '}';
    }
}
