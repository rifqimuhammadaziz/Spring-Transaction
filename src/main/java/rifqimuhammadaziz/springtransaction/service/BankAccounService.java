package rifqimuhammadaziz.springtransaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springtransaction.entity.BankAccount;
import rifqimuhammadaziz.springtransaction.repository.BankAccountRepository;

@Service
public class BankAccounService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public BankAccount create(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    public Iterable<BankAccount> findAll() {
        return bankAccountRepository.findAll();
    }

    public void transfer(BankAccount sender, BankAccount receiver, double amount) {

    }
}
