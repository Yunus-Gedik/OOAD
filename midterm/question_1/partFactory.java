public interface partFactory {
    String fact_name();
    cpu_ram attach_cpu_ram();
    display attach_display();
    battery attach_battery();
    storage attach_storage();
    camera attach_camera();
    Case attach_Case();
}
