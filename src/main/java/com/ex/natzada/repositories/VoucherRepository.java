package com.ex.natzada.repositories;

import com.ex.natzada.entities.Usuario;
import com.ex.natzada.entities.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {

	List<Voucher> findByUsuarioAndCreatedAtBetween(Usuario usuario, LocalDateTime start, LocalDateTime end);

    boolean existsByCode(String code);
}
