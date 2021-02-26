public class maxeffort_classic implements partFactory{

    public display attach_display(){
        return new display_five_five();
    }
    public battery attach_battery(){
        return new battery_3600();
    }

    public String fact_name() {
        return "Max Effort Classic factory represents ";
    }

    public cpu_ram attach_cpu_ram(){
        return new cpu_ram_2_8_8();
    }
    public storage attach_storage(){
        return new storage_64();
    }
    public camera attach_camera(){
        return new camera_12_8();
    }
    public Case attach_Case(){
        return new Case_151();
    }
}
