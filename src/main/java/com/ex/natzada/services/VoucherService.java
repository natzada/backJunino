package com.ex.natzada.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.natzada.entities.Usuario;
import com.ex.natzada.entities.Voucher;
import com.ex.natzada.entities.VoucherType;
import com.ex.natzada.repositories.UsuarioRepository;
import com.ex.natzada.repositories.VoucherRepository;
import com.ex.natzada.dto.DailyVoucherResponse;

@Service
public class VoucherService {

    @Autowired
    private final VoucherRepository voucherRepository;
    @Autowired
    private final UsuarioRepository usuarioRepository;

    public VoucherService(VoucherRepository voucherRepository, UsuarioRepository usuarioRepository) {
        this.voucherRepository = voucherRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Voucher getVoucherById(Long id) {
        return voucherRepository.findById(id).orElse(null);
    }

    public List<Voucher> getAll() {
        return voucherRepository.findAll();
    }

    public Voucher saveVoucher(Voucher voucher) {
        return voucherRepository.save(voucher);
    }

    public void deleteVoucherById(Long id) {
        voucherRepository.deleteById(id);
    }

    public Object generateDailyVoucher(Long userId) {
        Usuario usuario = usuarioRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        LocalDateTime endOfDay = LocalDate.now().atTime(LocalTime.MAX);

        List<Voucher> todaysVouchers = voucherRepository.findByUsuarioAndCreatedAtBetween(usuario, startOfDay, endOfDay);

        if (!todaysVouchers.isEmpty()) {
            Voucher existingVoucher = todaysVouchers.get(0);
            LocalDateTime nextAvailable = existingVoucher.getCreatedAt().toLocalDate().plusDays(1).atStartOfDay();
            long secondsLeft = LocalDateTime.now().until(nextAvailable, java.time.temporal.ChronoUnit.SECONDS);

            return new DailyVoucherResponse("Você já resgatou seu voucher hoje!", secondsLeft);
        }

        VoucherType[] types = VoucherType.values();
        VoucherType randomType = types[new Random().nextInt(types.length)];

        String code = generateUniqueCode();
        Voucher voucher = new Voucher(code, usuario, randomType, LocalDateTime.now());
        return voucherRepository.save(voucher);
    }

    private String generateUniqueCode() {
        String code;
        do {
            code = randomAlphaNumericFormatted(9);
        } while (voucherRepository.existsByCode(code));
        return code;
    }

    private String randomAlphaNumericFormatted(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
            if ((i + 1) % 3 == 0 && i != length - 1) {
                sb.append("-");
            }
        }

        return sb.toString();
    }
    
    
    
    
}