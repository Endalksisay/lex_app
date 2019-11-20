package blockchain.example.lex.ui.Merchants;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import blockchain.example.lex.Model.Company;
import blockchain.example.lex.Model.Company;
import blockchain.example.lex.R;

public class MerchantsViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private ArrayList<Company> companylist;

    public MerchantsViewModel() {
        companylist = new ArrayList<>();
        createCompanyList();
        Collections.sort(companylist,(o1,o2) -> o1.getCompanyName().compareTo(o2.getCompanyName()));
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }

    private void createCompanyList()
    {
        Company mcdonalds = new Company("MC123", "Mcdonalds",
                "Fast food chain.", R.drawable.mcdonalds);
        Company hollister = new Company("HOL5652", "Hollister",
                "Clothing chain.", R.drawable.hollister);
        Company abercrombie = new Company("AAF", "Abercrombie",
                "Clothing company.", R.drawable.abercrombie);
        Company vans = new Company("VASSC", "Vans",
                "Skate shoes and clothes.", R.drawable.vans);
        Company chickfila = new Company("CFAEMC", "Chick-fil-a",
                "Fast food restaurant.", R.drawable.chickfila);
        Company bestbuy = new Company("BB", "Best Buy",
                "Electronics retail store.", R.drawable.bestbuy);
        Company target = new Company("T4RG", "Target",
                "Retail store.", R.drawable.target);
        Company macys = new Company("M4C135", "Macy's",
                "Department store.", R.drawable.macys);
        Company homedepot = new Company("HDOA", "Home Depot",
                "Tool warehouse store.", R.drawable.homedepot);
        Company starbucks = new Company("SBWOM", "Starbucks",
                "Global coffee shop.", R.drawable.starbucks);
        Company amazon = new Company("4M421NG", "Amazon",
                "Online retail giant.", R.drawable.amazon);
        Company apple = new Company("APPLE", "Apple",
                "Computer company.", R.drawable.apple);
        Company pepsi = new Company("PCC", "Pepsi",
                "Refreshment drink company.", R.drawable.pepsi);
        Company asus = new Company("ACP", "Asus",
                "Computer hardware company.", R.drawable.asus);
        Company microsoft = new Company("MCS", "Microsoft",
                "Computer hardware/software company.", R.drawable.microsoft);
        Company hersheys = new Company("HOA", "Hershey's",
                "Chocolate company.", R.drawable.hersheys);
        Company cocacola = new Company("COKE", "Coca-Cola",
                "Refreshment drink company.", R.drawable.cocacola);
        Company burgerking = new Company("BK", "Burger King",
                "Fast food chain.", R.drawable.burgerking);
        Company lacoste = new Company("LAC", "Lacoste",
                "Clothing company.", R.drawable.lacoste);
        Company disney = new Company("WALT", "Walt Disney",
                "Mass media company.", R.drawable.disney);

        companylist.add(mcdonalds);
        companylist.add(hollister);
        companylist.add(abercrombie);
        companylist.add(vans);
        companylist.add(chickfila);
        companylist.add(bestbuy);
        companylist.add(target);
        companylist.add(macys);
        companylist.add(homedepot);
        companylist.add(starbucks);
        companylist.add(amazon);
        companylist.add(apple);
        companylist.add(pepsi);
        companylist.add(asus);
        companylist.add(microsoft);
        companylist.add(hersheys);
        companylist.add(cocacola);
        companylist.add(burgerking);
        companylist.add(lacoste);
        companylist.add(disney);
    }

    public ArrayList<Company> getCompanylist(){return companylist;}
}