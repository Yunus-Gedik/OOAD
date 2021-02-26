public class iflasdeluxe_global implements partFactory{
    @Override
    public String fact_name() {
        return "Iflas Deluxe Global factory represents ";
    }

    public cpu_ram attach_cpu_ram(){
        return new cpu_ram_2();
    }
    public display attach_display(){
        return new display_24bit();
    }
    public battery attach_battery(){
        return new battery_cobalt();
    }
    public storage attach_storage(){
        return new storage_32();
    }
    public camera attach_camera(){
        return new camera_opt2();
    }
    public Case attach_Case(){
        return new Case_wp_50();
    }
}
