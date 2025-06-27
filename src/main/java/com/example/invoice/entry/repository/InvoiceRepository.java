package com.example.invoice.entry.repository;

import com.example.invoice.entry.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {}
