package com.soulfood.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.soulfood.model.MyErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BillException.class)
	public ResponseEntity<MyErrorDetails> billexceptionHandler(BillException ee,WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ee.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(CartException.class)
	public ResponseEntity<MyErrorDetails> cartexceptionHandler(CartException ee,WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ee.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<MyErrorDetails> cartegoryexceptionHandler(CategoryException ee,WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ee.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(ItemException.class)
	public ResponseEntity<MyErrorDetails> itemexceptionHandler(ItemException ee,WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ee.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<MyErrorDetails> orderexceptionHandler(OrderException ee,WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ee.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(RestaurantException.class)
	public ResponseEntity<MyErrorDetails> resturantexceptionHandler(RestaurantException ee,WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ee.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}

	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> noHandlerExceptionHandler(NoHandlerFoundException ee,WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ee.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> MethodArgumentExceptionHandler(MethodArgumentNotValidException ee){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage("Validation error");
		err.setDetails(ee.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(CustomerNotFound.class)
    public ResponseEntity<MyErrorDetails> CustomerNotFOundHandler(CustomerNotFound cnf,WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(cnf.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}

	@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<MyErrorDetails> illegealArgumentHandler(IllegalArgumentException cnf,WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(cnf.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler(Exception ee,WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ee.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}

}
