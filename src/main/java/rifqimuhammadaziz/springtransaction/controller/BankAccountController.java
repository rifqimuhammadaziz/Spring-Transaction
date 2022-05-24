package rifqimuhammadaziz.springtransaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rifqimuhammadaziz.springtransaction.dto.TransferRequest;
import rifqimuhammadaziz.springtransaction.entity.BankAccount;
import rifqimuhammadaziz.springtransaction.service.BankAccounService;

@RestController
@RequestMapping("/bankAccount")
public class BankAccountController {

    @Autowired
    private BankAccounService bankAccounService;

    // Create New Bank Account
    @PostMapping
    public BankAccount create(@RequestBody BankAccount bankAccount) {
        return bankAccounService.create(bankAccount);
    }

    // Get All Bank Account
    @GetMapping
    public Iterable<BankAccount> findAll() {
        return bankAccounService.findAll();
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferRequest transferRequest) {
        bankAccounService.transfer(
                transferRequest.getSender(),
                transferRequest.getReceiver(),
                transferRequest.getAmount()
        );
    }
}
