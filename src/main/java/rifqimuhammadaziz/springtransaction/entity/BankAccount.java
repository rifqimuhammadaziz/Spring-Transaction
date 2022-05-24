package rifqimuhammadaziz.springtransaction.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "bankaccount")
@Data
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;

    private String name;

    private double balance;

}
