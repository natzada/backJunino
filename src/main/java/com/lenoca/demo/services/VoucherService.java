package com.lenoca.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenoca.demo.entities.Voucher;
import com.lenoca.demo.repository.VoucherRepository;

@Service
public class VoucherService {
private VoucherRepository voucherRepository;
	
	@Autowired
	public VoucherService(VoucherRepository voucherRepository) {
		this.voucherRepository = voucherRepository;
	}

	public Voucher getVoucherById(Long id) {
		return voucherRepository.findById(id).orElse(null);
		
	}
	
	public List<Voucher> getAll(){
		return voucherRepository.findAll();
	}
	
	public Voucher saveVoucher(Voucher voucher) {
		return voucherRepository.save(voucher);
	}
	public void deleteVoucherById(Long id) {
		voucherRepository.deleteById(id);
	}
}
