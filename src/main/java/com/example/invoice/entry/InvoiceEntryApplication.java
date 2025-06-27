// src/main/java/com/example/invoice/entry/InvoiceEntryApplication.java
package com.example.invoice.entry;

import com.example.invoice.entry.repository.InvoiceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class InvoiceEntryApplication implements CommandLineRunner {
	@Autowired
	private InvoiceRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(InvoiceEntryApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("invoice table count: " + repo.count());
	}
}
