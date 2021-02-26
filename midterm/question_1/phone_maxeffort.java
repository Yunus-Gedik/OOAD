public class phone_maxeffort extends smartphone{
    partFactory my_factory;
    phone_maxeffort(partFactory fact ){
        this.my_factory = fact;
    }

    void prepare() {
        System.out.println(my_factory.fact_name()+"Maximum Effort Phone: ");
        my_battery = my_factory.attach_battery();
        my_camera = my_factory.attach_camera();
        my_case = my_factory.attach_Case();
        my_storage = my_factory.attach_storage();
        my_cpu_ram = my_factory.attach_cpu_ram();
        my_display = my_factory.attach_display();
    }
}
