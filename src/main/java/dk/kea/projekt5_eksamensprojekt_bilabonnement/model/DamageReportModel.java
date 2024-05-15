package dk.kea.projekt5_eksamensprojekt_bilabonnement.model;

/**
 * Damage Report model class
 *
 * @author Viggo Beck, vibe0002@stud.kea.dk
 * @author Sebastian Drumm, sedr0001@stud.kea.dk
 */

public class DamageReportModel {
    int id;
    String report_name;
    String report_description;
    String report_employee_name;
    int car_id;

    public DamageReportModel() {
    }

    public DamageReportModel(int id, String report_name, String report_description, String report_employee_name, int car_id) {
        this.id = id;
        this.report_name = report_name;
        this.report_description = report_description;
        this.report_employee_name = report_employee_name;
        this.car_id = car_id;
    }

    public DamageReportModel(String report_name, String report_description, String report_employee_name) {
        this.report_name = report_name;
        this.report_description = report_description;
        this.report_employee_name = report_employee_name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReport_name() {
        return report_name;
    }

    public void setReport_name(String report_name) {
        this.report_name = report_name;
    }

    public String getReport_description() {
        return report_description;
    }

    public void setReport_description(String report_description) {
        this.report_description = report_description;
    }

    public String getReport_employee_name() {
        return report_employee_name;
    }

    public void setReport_employee_name(String report_employee_name) {
        this.report_employee_name = report_employee_name;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }
}
