public class phoneStore_EU extends phoneStore{

    protected smartphone createPhone(String type) {
        if (type == "I-I-Aman-Iflas"){
            return new phone_iiamaniflas(new iiamaniflas_classic());
        }
        else if (type == "Maximum Effort"){
            return new phone_maxeffort(new maxeffort_classic());
        }
        else if (type == "IflasDeluxe"){
            return  new phone_iflasdeluxe(new iflasdeluxe_eu());
        }
        return null;
    }
}
