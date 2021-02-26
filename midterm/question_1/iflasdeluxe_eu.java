public class iflasdeluxe_eu implements partFactory {
    @Override
    public String fact_name() {
        return "Iflas Deluxe EU factory represents ";
    }

    public cpu_ram attach_cpu_ram(){
        return new cpu_ram_4();
    }
    public display attach_display(){
        return new display_24bit();
    }
    public battery attach_battery(){
        return new battery_ion();
    }
    public storage attach_storage(){
        return new storage_max_64();
    }
    public camera attach_camera(){
        return new camera_opt3();
    }
    public Case attach_Case(){
        return new Case_wp_1();
    }
}
