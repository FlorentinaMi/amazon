package com.amazon;

import com.amazon.services.ServiceSeller;
import com.amazon.ui.ProductUI;

import java.io.IOException;

public class AmazonApp {

    public static ProductUI product;

    public static void main(String[] args) throws IOException {
        // product.searchProductField();
        ServiceSeller serviceSeller =  new ServiceSeller();
        serviceSeller.addProducts();
    }

}
