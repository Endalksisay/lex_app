package blockchain.example.lex.Model;

import java.util.ArrayList;

import blockchain.example.lex.R;

public class User
{
        private String name, password, phone;
        private ArrayList<Token> userTokens = new ArrayList<>();

    public User()
        {
            name = "Nikita";
            password = "password";
            phone = "5555555";
            createUserTokens();
        }

    public User(String name, String phone, String password) {
        this.name = name;
        this.phone = phone;
        this.password = password;
        createUserTokens();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Token> getUserTokens(){return userTokens;}
    private void createUserTokens()
    {
        Token mcdonalds = new Token("MC123", "  Mcdonalds   ",
                "McDonald's variety token.", R.drawable.mcdonalds,     9.50);
        Token hollister = new Token("HOL5652", "Hollister       ",
                "Hollister Bucks for clothes.", R.drawable.hollister,  21.10);
        Token abercrombie = new Token("AAF", "  Abercrombie ",
                "Abercrombie & Fitch token.", R.drawable.abercrombie,  5.00);
        Token starbucks = new Token("SBWOM", "  Starbucks   ",
                "Get your coffee here.", R.drawable.starbucks,         32.11);
        Token chickfila = new Token("CFAEMC", " Chick-fil-a ",
                "Eat more chickin with chicken bux.",R.drawable.chickfila,23.23);
        Token bestbuy = new Token("BB", "    Best Buy      ",
                "Best Buy Bucks buys more than bucks.", R.drawable.bestbuy,  2.53);
        Token target = new Token("T4RG", "  Target          ",
                "Target your daily needs with TarTokens.",R.drawable.target,23.33);
        Token macys = new Token("M4C135", "Macy's           ",
                "Macy's variety token.", R.drawable.macys, 32.32);
        Token homedepot = new Token("HDOA", "Home Depot     ",
                "Home Depot dollars for the home.", R.drawable.homedepot, 15.99);
        Token vans =        new Token("VASSCAH","Vans            ",
                "Skate or die with Vans.",    R.drawable.vans,     10.32);
        Token amazon = new Token("4M421NG", "Amazon           ",
                "Amazon amazonian currency.", R.drawable.amazon, 19.22);
        Token apple = new Token("APPLE", "Apple             ",
                "Apple Token.", R.drawable.apple, 11.11);

        userTokens.add(mcdonalds);
        userTokens.add(hollister);
        userTokens.add(abercrombie);
        userTokens.add(vans);
        userTokens.add(chickfila);
        userTokens.add(bestbuy);
        userTokens.add(target);
        userTokens.add(macys);
        userTokens.add(homedepot);
        userTokens.add(starbucks);
        userTokens.add(amazon);
        userTokens.add(apple);
    }

    public double getTotalTokenVal()
    {
        double total = 0;
        for (int i = 0; i < userTokens.size(); i++)
        {
            total += userTokens.get(i).getValue();
        }
        return total;
    }


}

