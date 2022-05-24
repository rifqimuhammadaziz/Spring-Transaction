package rifqimuhammadaziz.springtransaction.dto;

import lombok.Data;

@Data
public class TransferRequest {
    private String sender;
    private String receiver;
    private double amount;
}
