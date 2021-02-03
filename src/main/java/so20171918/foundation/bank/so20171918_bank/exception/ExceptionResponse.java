package so20171918.foundation.bank.so20171918_bank.exception;

public class ExceptionResponse {
	private String errormsg;
	private String reqstURI;
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	public String getReqstURI() {
		return reqstURI;
	}
	public void setReqstURI(String reqstURI) {
		this.reqstURI = reqstURI;
	}

}
