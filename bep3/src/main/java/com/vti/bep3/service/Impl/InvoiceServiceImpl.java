package com.vti.bep3.service.Impl;

import com.vti.bep3.responsitory.InvoiceRepository;
import com.vti.bep3.service.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

//hoa don
@Service
@AllArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    final InvoiceRepository invoiceRepository;

    @Override
    public InvoiceService create(InvoiceService invoiceService) {
        return null;
    }

    @Override
    public InvoiceService update(InvoiceService invoiceService) {
        return null;
    }
}
