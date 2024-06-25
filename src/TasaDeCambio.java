public record TasaDeCambio( double time_last_update_unix,
                           String time_last_update_utc,
                           double time_next_update_unix,
                           String time_next_update_utc,
                           String base_code,
                           String target_code,
                           double conversion_rate) {

    /*public double obtenerTasa () {
        return conversion_rate;
    }*/
}