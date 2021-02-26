public class iiamaniflas_classic implements partFactory{
    public display attach_display(){
        return new display_four_five();
    }
    public battery attach_battery(){
        return new battery_2000();
    }

    @Override
    public String fact_name() {
        return "I-I-Aman-Iflas Classic factory represents ";
    }

    public cpu_ram attach_cpu_ram(){
        return new cpu_ram_2_2_4();
    }
    public storage attach_storage(){
        return new storage_16();
    }
    public camera attach_camera(){
        return new camera_8_5();
    }
    public Case attach_Case(){
        return new Case_143();
    }
}
