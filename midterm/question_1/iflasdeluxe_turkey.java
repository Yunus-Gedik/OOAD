public class iflasdeluxe_turkey implements partFactory{

    @Override
    public String fact_name() {
        return "Iflas Deluxe Turkey factory represents ";
    }

    public cpu_ram attach_cpu_ram(){
        return new cpu_ram_8();
    }
    public display attach_display(){
        return new display_32bit();
    }
    public battery attach_battery(){
        return new battery_boron();
    }
    public storage attach_storage(){
        return new storage_max_128();
    }
    public camera attach_camera(){
        return new camera_opt4();
    }
    public Case attach_Case(){
        return new Case_wp_2();
    }
}
