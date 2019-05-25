package com.ssm.entites;

import java.util.Date;

public class Book {
	private Integer id;

	private String bookName;

	private String author;

	private Float price;

	private Integer bookClassId;

	private Integer salesamount;

	private Integer storenumber;

	private String pictureUrl;

	private Date publishingdate;

	private Integer statusCode;

	private String remark;

	private BookClass bookClass;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName == null ? null : bookName.trim();
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author == null ? null : author.trim();
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getBookClassId() {
		return bookClassId;
	}

	public void setBookClassId(Integer bookClassId) {
		this.bookClassId = bookClassId;
	}

	public Integer getSalesamount() {
		return salesamount;
	}

	public void setSalesamount(Integer salesamount) {
		this.salesamount = salesamount;
	}

	public Integer getStorenumber() {
		return storenumber;
	}

	public void setStorenumber(Integer storenumber) {
		this.storenumber = storenumber;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
	}

	public Date getPublishingdate() {
		return publishingdate;
	}

	public void setPublishingdate(Date publishingdate) {
		this.publishingdate = publishingdate;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public BookClass getBookClass() {
		return bookClass;
	}

	public void setBookClass(BookClass bookClass) {
		this.bookClass = bookClass;
	}

	public Book(String bookName, String author, Float price, Integer bookClassId, Integer salesamount,
			Integer storenumber, String pictureUrl, Date publishingdate, Integer statusCode, String remark) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.bookClassId = bookClassId;
		this.salesamount = salesamount;
		this.storenumber = storenumber;
		this.pictureUrl = pictureUrl;
		this.publishingdate = publishingdate;
		this.statusCode = statusCode;
		this.remark = remark;
	}

	public Book(Integer id, String bookName, String author, Float price, Integer bookClassId, Integer salesamount,
			Integer storenumber, String pictureUrl, Date publishingdate, Integer statusCode, String remark) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.bookClassId = bookClassId;
		this.salesamount = salesamount;
		this.storenumber = storenumber;
		this.pictureUrl = pictureUrl;
		this.publishingdate = publishingdate;
		this.statusCode = statusCode;
		this.remark = remark;
	}

	public Book() {
		super();
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", author=" + author + ", price=" + price
				+ ", bookClassId=" + bookClassId + ", salesamount=" + salesamount + ", storenumber=" + storenumber
				+ ", pictureUrl=" + pictureUrl + ", publishingdate=" + publishingdate + ", statusCode=" + statusCode
				+ ", remark=" + remark + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookClassId == null) ? 0 : bookClassId.hashCode());
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pictureUrl == null) ? 0 : pictureUrl.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((publishingdate == null) ? 0 : publishingdate.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((salesamount == null) ? 0 : salesamount.hashCode());
		result = prime * result + ((statusCode == null) ? 0 : statusCode.hashCode());
		result = prime * result + ((storenumber == null) ? 0 : storenumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookClassId == null) {
			if (other.bookClassId != null)
				return false;
		} else if (!bookClassId.equals(other.bookClassId))
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pictureUrl == null) {
			if (other.pictureUrl != null)
				return false;
		} else if (!pictureUrl.equals(other.pictureUrl))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (publishingdate == null) {
			if (other.publishingdate != null)
				return false;
		} else if (!publishingdate.equals(other.publishingdate))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (salesamount == null) {
			if (other.salesamount != null)
				return false;
		} else if (!salesamount.equals(other.salesamount))
			return false;
		if (statusCode == null) {
			if (other.statusCode != null)
				return false;
		} else if (!statusCode.equals(other.statusCode))
			return false;
		if (storenumber == null) {
			if (other.storenumber != null)
				return false;
		} else if (!storenumber.equals(other.storenumber))
			return false;
		return true;
	}

}