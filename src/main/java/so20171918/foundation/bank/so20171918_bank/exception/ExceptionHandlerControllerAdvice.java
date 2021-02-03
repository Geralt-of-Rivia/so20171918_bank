package so20171918.foundation.bank.so20171918_bank.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	@ExceptionHandler(MyException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	ExceptionResponse handleResourceNotfoundException(MyException exp,HttpServletRequest req)
	{
		ExceptionResponse exres = new ExceptionResponse();
		exres.setErrormsg(exp.getMessage());
		exres.setReqstURI(req.getRequestURI());
		return exres;
		
	}

	
}
