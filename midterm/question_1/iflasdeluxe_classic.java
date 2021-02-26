public class iflasdeluxe_classic implements partFactory{

    @Override
    public String fact_name() {
        return "Iflas Deluxe Classic factory represents ";
    }

    public cpu_ram attach_cpu_ram(){
        return new cpu_ram_2_2_6();
    }
    public display attach_display(){
        return new display_five_three();
    }
    public battery attach_battery(){
        return new battery_2800();
    }
    public storage attach_storage(){
        return new storage_32();
    }
    public camera attach_camera(){
        return new camera_12_5();
    }
    public Case attach_Case(){
        return new Case_149();
    }
}
