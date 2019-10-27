package blockchain.example.lex.Model;

import java.util.ArrayList;

/**
 * This class stores the data for each individual token that will be passed to the Users.
 * @author Alejandro Lopez
 */
public class Token {
    private String publicKey;
    private String tokenName;
    private String description;
    private String logoLocation;
    private ArrayList<Transaction> tokenTransactions;

    /**
     * Default constructor
     */
    public Token()
    {
        publicKey = "";
        tokenName = "";
        description = "";
        logoLocation = "";
        tokenTransactions = new ArrayList<>();

    }

    /**
     * Constructor that builds a Token object without passing an ArrayList for the
     * transactions.
     * @param publicKey Public key for the token.
     * @param tokenName Name of the token.
     * @param description Description of this token.
     * @param logoLocation File location of the logo.
     * Precondition: All String arguments must be Strings and not null.
     * Postcondition: Token object will be created.
     */
    public Token(String publicKey, String tokenName, String description,
                 String logoLocation)
    {
        if (publicKey != null && tokenName != null && description != null)
        {
            this.publicKey = publicKey;
            this.tokenName = tokenName;
            this.description = description;
        }
        tokenTransactions = new ArrayList<>();
    }

    /**
     * Constructor that takes all String arguments and an ArrayList arguments
     * for the transactions.
     * @param publicKey Public key for the token.
     * @param tokenName Name of the token.
     * @param description Description of this token.
     * @param logoLocation File location of the logo.
     * @param tokenTransactions List of transactions for this token.
     * Precondition: All String arguments must be Strings and not null and
     * ArrayList must be a valid ArrayList.
     * Postcondition: Token object will be created.
     */
    public Token(String publicKey, String tokenName, String description,
                 String logoLocation, ArrayList<Transaction> tokenTransactions)
    {
        if (publicKey != null && tokenName != null && description != null)
        {
            this.publicKey = publicKey;
            this.tokenName = tokenName;
            this.description = description;
        }
        tokenTransactions = new ArrayList<>();
        this.tokenTransactions = (ArrayList) tokenTransactions.clone();
    }

    //Accessors

    /**
     * Accessor method that gives access to the token's public key.
     * @return Token's public key
     */
    public String getPublicKey(){return publicKey;}
    /**
     * Accessor method that gives access to the token's name.
     * @return Token's name
     */
    public String getTokenName(){return tokenName;}
    /**
     * Accessor method that gives access to the token's description.
     * @return Token's description
     */
    public String getDescription(){return description;}
    /**
     * Accessor method that gives access to the location of the token's logo.
     * @return Token's logo location.
     */
    public String getLogoLocation(){return logoLocation;}
    /**
     * Accessor method that gives access to the token's ArrayList of transactions.
     * @return An ArrayList containing all of the token's transactions.
     */
    public ArrayList<Transaction> getTokenTransactions(){return tokenTransactions;}

    //Mutators
    public void setPublicKey(String publicKey)
    {
        if (publicKey != null)
            this.publicKey = publicKey;
    }

    public void setTokenName(String tokenName)
    {
        if (tokenName != null)
            this.tokenName = tokenName;
    }

    public void setDescription(String description)
    {
        if (description != null)
            this.description = description;
    }

    public void setLogoLocation(String logoLocation)
    {
        if (logoLocation != null)
            this.logoLocation = logoLocation;
    }
}
