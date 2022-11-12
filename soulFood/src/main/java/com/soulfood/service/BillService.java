package com.soulfood.service;

import java.time.LocalDate;
import java.util.List;

import com.soulfood.exception.BillException;
import com.soulfood.model.Bill;

public interface BillService {

	public Bill addBill(Bill bill) throws BillException;

	public Bill updateBill(Bill bill) throws BillException;

	public Bill removeBill(Integer bid) throws BillException;

	public Bill viewBill(Integer bid) throws BillException;

	public List<Bill> viewAllBills(LocalDate startDate, LocalDate endDate) throws BillException;
	
	public Double CalculateTotalCost(Integer id)throws BillException;

}
