package com.lenoca.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lenoca.demo.entities.Voucher;

public interface VoucherRepository extends JpaRepository<Voucher, Long>{

}
