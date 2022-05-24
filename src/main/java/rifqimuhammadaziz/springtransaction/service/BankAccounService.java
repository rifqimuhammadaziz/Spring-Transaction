package rifqimuhammadaziz.springtransaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springtransaction.entity.BankAccount;
import rifqimuhammadaziz.springtransaction.repository.BankAccountRepository;

import javax.transaction.Transactional;

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

    /*
    Transactional
    * To keep data integrity
    * If routine 1 (update sender balance) has no error, and routine 2 (update receiver balance) has error
    * Then database will roll back transaction (sender balance is no changed)
     */
    @Transactional
    public void transfer(String sender, String receiver, double amount) {
        BankAccount account1 = bankAccountRepository.findByAccountNumber(sender);
        if (account1 == null) {
            throw new RuntimeException("Sender Account is not valid");
        }
        if (account1.getBalance() < amount) {
            throw new RuntimeException("Balance is not enough");
        }
        account1.setBalance(account1.getBalance() - amount);
        bankAccountRepository.save(account1);

        BankAccount account2 = bankAccountRepository.findByAccountNumber(receiver);
        if (account2 == null) {
            throw new RuntimeException("Receiver Account is not valid");
        }
        account2.setBalance(account2.getBalance() + amount);
        bankAccountRepository.save(account2);
    }
}
