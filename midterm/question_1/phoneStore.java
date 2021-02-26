public abstract class phoneStore {
    smartphone orderPhone(String type){
        smartphone phone;
        phone = createPhone(type);
        if(phone == null){
            System.out.println("INVALID PHONE MODEL!");
            System.exit(-1);
        }
        phone.prepare();
        phone.attach_cpu_ram();
        phone.attach_display();
        phone.attach_battery();
        phone.attach_storage();
        phone.attach_camera();
        phone.attach_case();
        return phone;
    }

    protected abstract smartphone createPhone(String type);

}
