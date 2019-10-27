package blockchain.example.lex.Model;

/*
 * NOT CURRENTLY IN USE
 */

/**
 * Company will store the information of each individual company working with us.
 * @author Alejandro Lopez
 */
public class Company {
    /*
     *companyName stores the name of the company
     *description stores a short description of each company
     *websiteURL stores the main URL for the company's website
     *logoLocation stores the destination of the company logo
     */
    private String companyName = "";
    private String description = "";
    private String websiteURL = "";
    private String logoLocation = "";
    //add public key

    /**
     * Constructor, uses company name, description, and website url to build the
     * Company object
     * @param companyName name of the company
     * @param description description of each company
     * @param websiteURL url of the company's website
     * Precondition: Strings need to be passed as non-null values.
     * Postcondition: Company object will be created.
     */
    public Company(String companyName, String description,
                   String websiteURL)
        {if (companyName != null && description != null && websiteURL != null)
        {
            this.companyName = companyName;
            this.description = description;
            this.websiteURL = websiteURL;
        }
    }

    /**
     * Constructor, uses company name, description, and website url to build the
     * Company object
     * @param companyName name of the company
     * @param description description of each company
     * @param websiteURL url of the company's website
     * Precondition: Strings need to be passed as non-null values.
     * Postcondition: Company object will be created.
     */
    public Company(String companyName, String description,
                   String websiteURL, String logoLocation)
    {
        {if (companyName != null && description != null && websiteURL != null
            && logoLocation != null)
            this.companyName = companyName;
            this.description = description;
            this.websiteURL = websiteURL;
            this.logoLocation = logoLocation;
        }
    }

    //methods to add
    //getters
}
