public abstract class smartphone {
    String name;

    Case my_case;
    cpu_ram my_cpu_ram;
    display my_display;
    storage my_storage;
    camera my_camera;
    battery my_battery;

    abstract void prepare();

    void attach_cpu_ram(){
        System.out.println("Attaching cpu and ram: " + my_cpu_ram.get());
    }
    void attach_display(){
        System.out.println("Attaching display: " + my_display.get());
    }
    void attach_battery(){
        System.out.println("Attaching battery: " + my_battery.get());
    }
    void attach_storage(){
        System.out.println("Attaching storage: " + my_storage.get());
    }
    void attach_camera(){
        System.out.println("Attaching camera: " + my_camera.get());
    }
    void attach_case(){
        System.out.println("Enclosing phone case: " + my_case.get()+"\n");
    }
}
