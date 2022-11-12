package com.soulfood.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soulfood.exception.BillException;
import com.soulfood.model.Bill;
import com.soulfood.service.BillService;

@RestController
public class BillController {
	
	@Autowired
	private BillService bService;
	
	@PostMapping("/bill")
	public ResponseEntity<Bill> registeBillHandler(@RequestBody Bill bill) throws BillException{
		
		Bill bill1 = bService.addBill(bill);
		
		
		return new ResponseEntity<Bill>(bill1,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/bill")
	public ResponseEntity<Bill> updateBillHandler(@RequestBody Bill bill) throws BillException{
		
		Bill bill1 = bService.updateBill(bill);
	
		return new ResponseEntity<Bill>(bill1,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/bill/{bid}")
	public ResponseEntity<Bill> deleteBillHandler(@PathVariable("bid")Integer bid) throws BillException{
		
		Bill bill1 = bService.removeBill(bid);

		return new ResponseEntity<Bill>(bill1,HttpStatus.OK);
	}
	
	@GetMapping("/bill/{bid}")
	public ResponseEntity<Bill> getBillHandler(@PathVariable("bid")Integer bid) throws BillException{
		
		Bill bill1 = bService.viewBill(bid);

		return new ResponseEntity<Bill>(bill1,HttpStatus.OK);
	}
	
	@GetMapping("/getBillByDate")
	public ResponseEntity<List<Bill>> getBillByDate(@RequestParam String startDate,@RequestParam String endDate) throws BillException{
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate start = LocalDate.parse(startDate, dtf);
		
		LocalDate end = LocalDate.parse(endDate, dtf);
			
		List<Bill> list = bService.viewAllBills(start, end);
		
		return new ResponseEntity<List<Bill>>(list,HttpStatus.OK);
		
	}
	
	@GetMapping("/getTotalAmount/{id}")
	public ResponseEntity<Double> getTotalAmountHandler1(@PathVariable("id")Integer id) throws BillException{
		
		Double bill1 = bService.CalculateTotalCost(id);

		return new ResponseEntity<Double>(bill1,HttpStatus.OK);
	}
	

}
