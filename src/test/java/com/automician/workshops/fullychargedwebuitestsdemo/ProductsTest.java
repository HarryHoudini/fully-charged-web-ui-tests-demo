package com.automician.workshops.fullychargedwebuitestsdemo;

import com.automician.workshops.fullychargedwebuitestsdemo.categories.Atomic;
import com.automician.workshops.fullychargedwebuitestsdemo.configs.BaseTest;
import com.automician.workshops.fullychargedwebuitestsdemo.pages.Products;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static com.automician.worshops.core.Gherkin.EXPECT;
import static com.automician.worshops.core.Gherkin.GIVEN;
import static com.automician.worshops.core.Gherkin.WHEN;

@Category(Atomic.class)
public class ProductsTest extends BaseTest {

    @Test
    public void createsProduct() {
        GIVEN("At Home page: ensure 'Atomic product' does not exist");
        Products products = new Products();
        products.open();
        products.ensureNoProduct("Atomic product");

        WHEN("New product created");
        products.addProduct("Atomic product");

        EXPECT("New product is shown in list");
        products.shouldHaveProduct("Atomic product");
    }

    @Test
    public void deletesProduct() {
        GIVEN("At Home page - ensure 'Atomic product' exist");
        Products products = new Products();
        products.open();
        products.ensureProduct("Atomic product");

        WHEN("Product deleted");
        products.deleteProduct("Atomic product");

        EXPECT("Product is not shown in list");
        products.shouldNotHaveProduct("Atomic product");
    }
}
