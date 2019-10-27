package blockchain.example.lex.Model;

//Token name (or ID)
//date stamp
//sender pubkey
//receiver pubkey

import java.util.Date;

/**
 * This is the Transaction class that stores the data for each transaction.
 * @author Alejandro Lopez
 */
public class Transaction {
    private int tokenID;
    private Date transactionTime;
    private User sender;
    private User receiver;

    /**
     * Constructor to create a Transaction item.
     * @param tokenID Token's ID
     * @param transactionTime Time of Token's transaction
     * @param sender Token sender
     * @param receiver Token receiever
     */
    public Transaction(int tokenID, Date transactionTime, User sender, User receiver)
    {
        this.tokenID = tokenID;
        this.transactionTime = new Date();
        this.transactionTime = transactionTime;
        this.sender = new User();
        this.sender = sender;
        this.receiver = new User();
        this.receiver = receiver;
    }

    //Accessors

    /**
     * Get the token's ID.
     * @return The ID of the token.
     */
    public int getToken(){return tokenID;}

    /**
     * Get the token's transaction time
     * @return Token's transaction time
     */
    public Date getTransactionTime(){return transactionTime;}

    /**
     * Get the data of the Token's sender
     * @return Token sender's Profile
     */
    public User getSender(){return sender;}

    /**
     * Get the data of the Token's receiver
     * @return Token receiver's Profile
     */
    public User getReceiver(){return receiver;}

}
