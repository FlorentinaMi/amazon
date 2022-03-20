package com.amazon.model;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends User {

    //Atributes
    private Basket basket;
    public List<Seller> Market;

    //Constructors
    public Buyer(String userEmail, String password, String address)
    {
        super(userEmail, password, address);
        basket = new Basket();
        Market = new ArrayList<>();
    }

    public Buyer(String userEmail, String password, String address, List<Seller> Market)
    {
        super(userEmail, password, address);
        basket = new Basket();
        this.Market = Market;
    }

    //Metodes (aka Functii)

    public void UpdateMarket(List<Seller> updatedMarket)
    {
        this.Market = updatedMarket;
    }

    //See products
    public void PrintMarket()
    {
        if(this.Market != null)
        {
            for (Seller s : this.Market)
            {
                System.out.println(s.getUserEmail() + ": ");
                for(Product p : s.Products)
                {
                    System.out.print(p.getName()+ ", ");
                }
                System.out.println();
            }
        }
    }

    //buy
    public void Buy(Product p)
    {
        if(!basket.AddToBasket(p)) // if(false)
        {
            System.out.println("Ba fraiere... Nu sunt atatea! Mai taie din ele! ");
        }

        System.out.println("Current Basket: ");
        basket.PrintBasket();
    }

}
