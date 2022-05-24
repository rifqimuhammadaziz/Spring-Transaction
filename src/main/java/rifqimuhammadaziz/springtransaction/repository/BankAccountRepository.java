package rifqimuhammadaziz.springtransaction.repository;

import org.springframework.data.repository.CrudRepository;
import rifqimuhammadaziz.springtransaction.entity.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {

    public BankAccount findByAccountNumber(String accountNumber);
}
