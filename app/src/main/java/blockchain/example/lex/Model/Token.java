package blockchain.example.lex.Model;

import java.util.ArrayList;

import blockchain.example.lex.R;

/**
 * This class stores the data for each individual token that will be passed to the User.
 * @author Alejandro Lopez
 */
public class Token {
    private String publicKey;
    private String tokenName;
    private String description;
    private String companyName;
    private int logo;
    private double value;
    private ArrayList<Transaction> tokenTransactions;

    /**
     * Default constructor
     */
    public Token()
    {
        publicKey = "";
        tokenName = "";
        description = "";
        companyName = "";
        logo = R.drawable.alejandro;
        value = 0;
        tokenTransactions = new ArrayList<>();

    }

    /**
     * Constructor that builds a Token object without passing an ArrayList for the
     * transactions.
     * @param publicKey Public key for the token.
     * @param tokenName Name of the token.
     * @param description Description of this token.
     * @param logo File location of the logo.
     * Precondition: All String arguments must be Strings and not null.
     * Postcondition: Token object will be created.
     */
    public Token(String publicKey, String tokenName, String description,
                 int logo)
    {
        if (publicKey != null && tokenName != null && description != null)
        {
            this.publicKey = publicKey;
            this.tokenName = tokenName;
            this.description = description;
        }
        this.logo = logo;
        tokenTransactions = new ArrayList<>();
    }

    /**
     * Constructor that builds a Token object without passing an ArrayList for the
     * transactions.
     * @param publicKey Public key for the token.
     * @param tokenName Name of the token.
     * @param description Description of this token.
     * @param logo File location of the logo.
     * @param value Value held for current Token.
     * Precondition: All String arguments must be Strings and not null.
     * Postcondition: Token object will be created.
     */
    public Token(String publicKey, String tokenName, String description,
                 int logo, double value)
    {
        if (publicKey != null && tokenName != null && description != null)
        {
            this.publicKey = publicKey;
            this.tokenName = tokenName;
            this.description = description;
        }
        this.logo = logo;
        this.value = value;
        tokenTransactions = new ArrayList<>();
    }

    /**
     * Constructor that takes all String arguments and an ArrayList arguments
     * for the transactions.
     * @param publicKey Public key for the token.
     * @param tokenName Name of the token.
     * @param description Description of this token.
     * @param logo File location of the logo.
     * @param tokenTransactions List of transactions for this token.
     * Precondition: All String arguments must be Strings and not null and
     * ArrayList must be a valid ArrayList.
     * Postcondition: Token object will be created.
     */
    public Token(String publicKey, String tokenName, String description,
                 int logo, ArrayList<Transaction> tokenTransactions)
    {
        if (publicKey != null && tokenName != null && description != null)
        {
            this.publicKey = publicKey;
            this.tokenName = tokenName;
            this.description = description;
        }
        this.logo = logo;
        tokenTransactions = new ArrayList<>();
        this.tokenTransactions = (ArrayList) tokenTransactions.clone();
    }

    /**
     * Constructor that takes all String arguments and an ArrayList arguments
     * for the transactions.
     * @param publicKey Public key for the token.
     * @param tokenName Name of the token.
     * @param description Description of this token.
     * @param companyName Name of company associated with token.
     * @param logo File location of the logo.
     * @param tokenTransactions List of transactions for this token.
     * Precondition: All String arguments must be Strings and not null and
     * ArrayList must be a valid ArrayList.
     * Postcondition: Token object will be created.
     */
    public Token(String publicKey, String tokenName, String description,
                 String companyName, int logo, ArrayList<Transaction> tokenTransactions)
    {
        if (publicKey != null && tokenName != null && description != null && companyName != null)
        {
            this.publicKey = publicKey;
            this.tokenName = tokenName;
            this.description = description;
            this.companyName = companyName;
        }
        this.logo = logo;
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
     * Accessor method that gets the name of the company associated with the token.
     * @return Company's name
     */
    public String getCompanyName(){return companyName;}
    /**
     * Accessor method that gives access to the location of the token's logo.
     * @return Token's logo location.
     */
    public int getLogo(){return logo;}
    /**
     * Accessor method that gives access to the token's ArrayList of transactions.
     * @return An ArrayList containing all of the token's transactions.
     */
    public ArrayList<Transaction> getTokenTransactions(){return tokenTransactions;}

    public double getValue(){return value;}

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

    public void setCompanyName(String companyName)
    {
        if(companyName != null)
            this.companyName = companyName;
    }

    public void setLogo(int logo)
    {
        this.logo = logo;
    }
}
