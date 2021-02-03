package so20171918.foundation.bank.so20171918_bank.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CustomerModel implements Serializable {
	@Id
	@Column
	private int customerid;
	@Column
	private String customername;
	@Column
	private int customerage;
	@Column
	private String customeradd;
	@Column
	private String acctype;
	@Column
	private double accbalance;
	public CustomerModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerModel(int customerid, String customername, int customerage, String customeradd, String acctype,
			double accbalance) {
		super();
		this.customerid = customerid;
		this.customername = customername;
		this.customerage = customerage;
		this.customeradd = customeradd;
		this.acctype = acctype;
		this.accbalance = accbalance;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public int getCustomerage() {
		return customerage;
	}
	public void setCustomerage(int customerage) {
		this.customerage = customerage;
	}
	public String getCustomeradd() {
		return customeradd;
	}
	public void setCustomeradd(String customeradd) {
		this.customeradd = customeradd;
	}
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	public double getAccbalance() {
		return accbalance;
	}
	public void setAccbalance(double accbalance) {
		this.accbalance = accbalance;
	}

}
