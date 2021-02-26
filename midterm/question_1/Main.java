public class Main {
    public static void main(String[] args){
        phoneStore turk = new phoneStore_Turkey();
        phoneStore eu = new phoneStore_EU();
        phoneStore glob = new phoneStore_Global();

        turk.orderPhone("IflasDeluxe");
        turk.orderPhone("I-I-Aman-Iflas");
        turk.orderPhone("Maximum Effort");

        eu.orderPhone("IflasDeluxe");
        eu.orderPhone("I-I-Aman-Iflas");
        eu.orderPhone("Maximum Effort");

        glob.orderPhone("IflasDeluxe");
        glob.orderPhone("I-I-Aman-Iflas");
        glob.orderPhone("Maximum Effort");

        glob.orderPhone("");

    }
}
