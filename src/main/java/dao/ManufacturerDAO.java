package dao;


import model.Manufacturer;

import java.util.List;

public interface ManufacturerDAO {

    void addManufacter(Manufacturer manufacturer);

    Manufacturer getById(int id);

    void updateManufacter(Manufacturer manyfacter);

    void deleteManufacter(int id);

    List<Manufacturer> getAll();
}