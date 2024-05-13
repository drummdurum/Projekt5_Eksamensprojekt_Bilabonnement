package dk.kea.projekt5_eksamensprojekt_bilabonnement.repository;

import dk.kea.projekt5_eksamensprojekt_bilabonnement.model.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CarRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createNewNewCarEntry(CarModel carModel) {
        //insert sql
        final String CREATE_NEW_CAR_ENTRY_SQL = "INSERT INTO car (car_Serialnr, car_number, car_model, car_name, car_year, monthly_price, is_leased) VALUES (?,?,?,?,?,?,?)";
        //kald af JdbcTemplate med sql og paramter
        jdbcTemplate.update(CREATE_NEW_CAR_ENTRY_SQL, carModel.getCar_Serialnr(), carModel.getCar_number(), carModel.getCar_model(), carModel.getCar_name(), carModel.getCar_year(), carModel.getMonthly_price(), carModel.isIs_leased());
    }

    public List<CarModel> getFullListOfCars() {
        //henter fulde liste af car
        String DISPLAY_FULL_LIST_OF_CARS_SQL = "SELECT * FROM car";
        //kald af JdbcTemplate med sql og paramter
        List<CarModel> carModels = jdbcTemplate.query(DISPLAY_FULL_LIST_OF_CARS_SQL, new BeanPropertyRowMapper<>(CarModel.class));
        return carModels;
    }

    public List<CarModel> getSpecificNameFromCars() {
        String DISPLAY_SPECIFIC_NAME_FROM_CARS_SQL = "SELECT * FROM car WHERE id = 2";
        List<CarModel> carModels = jdbcTemplate.query(DISPLAY_SPECIFIC_NAME_FROM_CARS_SQL, new BeanPropertyRowMapper<>(CarModel.class));
        return carModels;
    }

    public void deleteFromListOfCars(int id) {
        //slette sql
        String DELETE_FROM_LIST_OF_CARS_SQL = "DELETE FROM car where id = ?";
        //kald af JdbcTemplate med sql og paramter
        jdbcTemplate.update(DELETE_FROM_LIST_OF_CARS_SQL, id);
    }

    public CarModel GetCarByIdForUpdate(int id) {
        //find SQL
        String GET_CAR_BY_ID_SQL = "SELECT * FROM car WHERE id = ?";
        //returner query-resultat fra JdbcTemplate, med rowmapper som omsætter databaserække til car
        return jdbcTemplate.queryForObject(GET_CAR_BY_ID_SQL, new Object[]{id}, new BeanPropertyRowMapper<>(CarModel.class));
    }

    public void UpdateCarEntryInDatabase(CarModel carModel) {
        //update sql
        String UPDATE_CAR_ENTRy_SQL = "UPDATE car SET car_Serialnr = ?, car_number = ?, car_model = ?, car_name = ?, car_year = ?, monthly_price = ?, is_leased = ? WHERE id = ?";
        //update db vha. JdbcTemplate
        jdbcTemplate.update(UPDATE_CAR_ENTRy_SQL, carModel.getCar_Serialnr(), carModel.getCar_number(), carModel.getCar_model(), carModel.getCar_name(), carModel.getCar_year(), carModel.getMonthly_price(), carModel.isIs_leased(), carModel.getId());
    }
}
