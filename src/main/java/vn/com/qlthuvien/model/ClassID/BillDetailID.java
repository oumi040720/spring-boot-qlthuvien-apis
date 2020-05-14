package vn.com.qlthuvien.model.ClassID;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class BillDetailID implements Serializable {

	private static final long serialVersionUID = -497937598710223002L;

	@Column(name = "BillID")
	@NotNull(message = "billDetail.NotNull.billID")
	private Long billID;

	@Column(name = "BookID")
	@NotNull(message = "billDetail.NotNull.bookID")
	private Long bookID;

	public BillDetailID() {
	}

	public BillDetailID(Long billID, Long bookID) {
		this.bookID = bookID;
		this.billID = billID;
	}

	public Long getBillID() {
		return billID;
	}

	public void setBillID(Long billID) {
		this.billID = billID;
	}

	public Long getBookID() {
		return bookID;
	}

	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billID == null) ? 0 : billID.hashCode());
		result = prime * result + ((bookID == null) ? 0 : bookID.hashCode());
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
		BillDetailID other = (BillDetailID) obj;
		if (billID == null) {
			if (other.billID != null)
				return false;
		} else if (!billID.equals(other.billID))
			return false;
		if (bookID == null) {
			if (other.bookID != null)
				return false;
		} else if (!bookID.equals(other.bookID))
			return false;
		return true;
	}

}
