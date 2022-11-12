package com.soulfood.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soulfood.exception.BillException;
import com.soulfood.model.Bill;
import com.soulfood.repository.BillRepo;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepo bRepo;

	@Override
	public Bill addBill(Bill bill) throws BillException {

		if (bill == null) {
			throw new BillException("Please Enter Valid Input");
		}

		Bill b1 = bRepo.save(bill);

		return b1;

	}

	@Override
	public Bill updateBill(Bill bill) throws BillException {

		Bill b1 = bRepo.findById(bill.getBillId())
				       .orElseThrow(() -> new BillException("Bill details not found..."));

		b1 = bRepo.save(bill);

		return b1;
	}

	@Override
	public Bill removeBill(Integer bid) throws BillException {
		
		Bill b1 = bRepo.findById(bid)
		        .orElseThrow(()-> new BillException("Bill details not found..."));
		
		
		 bRepo.delete(b1);;
		 
		 
		 return b1;
		
	}

	@Override
	public Bill viewBill(Integer bid) throws BillException {
		
		Bill b1 = bRepo.findById(bid)
		        .orElseThrow(()-> new BillException("Bill details not found..."));
		
		
		return b1;
		
	}

	@Override
	public List<Bill> viewAllBills(LocalDate startDate, LocalDate endDate) throws BillException {
		
     List<Bill> list = bRepo.getBillByDate(startDate, endDate);
		
		if(list.size()==0) {
			throw new BillException("Bill details not found between "+ startDate + " and "+endDate);
		}
		
		return list;
		
	}

	@Override
	public Double CalculateTotalCost(Integer id) throws BillException {
		
		Bill b1 = bRepo.findById(id)
 		        .orElseThrow(()-> new BillException("Bill details not found..."));
		 
		 return b1.getTotalCost();
		
	}

}
