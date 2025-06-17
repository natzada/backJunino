package com.ex.natzada.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.natzada.entities.Voucher;
import com.ex.natzada.services.VoucherService;

@RestController
@RequestMapping("/voucher")
public class VoucherController {

	private final VoucherService voucherService;

	public VoucherController(VoucherService voucherService) {
		this.voucherService = voucherService;
	}

	@GetMapping("/")
	public ResponseEntity<List<Voucher>> findAll() {
		List<Voucher> vouchers = voucherService.getAll();

		return ResponseEntity.ok(vouchers);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Voucher> findVoucherById(@PathVariable Long id) {
		Voucher voucher = voucherService.getVoucherById(id);

		if (voucher != null) {
			return ResponseEntity.ok(voucher);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Voucher> createVoucher(@RequestBody Voucher voucher){
		Voucher newVoucher = voucherService.saveVoucher(voucher);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(newVoucher);
	}
	
	@DeleteMapping("/{id}")
	public void deleteVoucherById(@PathVariable Long id) {
		voucherService.deleteVoucherById(id);
	}

	@PostMapping("/daily/{userId}")
	public ResponseEntity<?> generateDailyVoucher(@PathVariable Long userId) {
	    try {
	        System.out.println("🎯 Resgatando voucher para userId = " + userId);
	        Object result = voucherService.generateDailyVoucher(userId);
	        return ResponseEntity.ok(result);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno: " + e.getMessage());
	    }
	}


	
}
