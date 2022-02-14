package checkoutCart.Actions;

import static checkoutCart.Actions.checkoutActions.fill_In_Fields;

public class FieldFillingIn {
    public static void fillInFields()
    {
        String email = "nsp@netnology.io";
        String CardNumber = "2223003122003222";
        String month = "02";
        String year = "25";
        String CVC = "234";
        fill_In_Fields(email,CardNumber,month,year,CVC);
    }
}
