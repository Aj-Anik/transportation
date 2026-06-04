package com.iiuc.transportation.services;

import com.iiuc.transportation.model.Model;
import java.util.ArrayList;
import java.util.List;

public class Services {

    private List<Model> buses = new ArrayList<>();
    private Long idCounter = 1L;

    // 1
    public Model addBus(Model bus) {
        bus.setId(idCounter++);
        buses.add(bus);
        return bus;
    }

    // 2
    public List<Model> getAllBuses() {
        return buses;
    }

    // 3
    public Model getBusById(Long id) {
        for (Model b : buses) {
            if (b.getId().equals(id))
                return b;
        }
        return null;
    }

    // 4
    public boolean deleteBus(Long id) {
        for (Model b : buses) {
            if (b.getId().equals(id)) {
                buses.remove(b);
                return true;
            }
        }
        return false;
    }

    // 5
    public boolean updateBus(Long id, Model newBus) {
        Model old = getBusById(id);
        if (old != null) {
            old.setBusNumber(newBus.getBusNumber());
            old.setRouteName(newBus.getRouteName());
            old.setDriverName(newBus.getDriverName());
            old.setCapacity(newBus.getCapacity());
            old.setSchedule(newBus.getSchedule());
            old.setSemester(newBus.getSemester());
            old.setDriverPhone(newBus.getDriverPhone());
            old.setBusType(newBus.getBusType());
            old.setPickupPoint(newBus.getPickupPoint());
            old.setStatus(newBus.getStatus());
            old.setUserType(newBus.getUserType());
            return true;
        }
        return false;
    }

    // 6
    public List<Model> searchByRoute(String route) {
        List<Model> result = new ArrayList<>();
        for (Model b : buses) {
            if (b.getRouteName().equals(route))
                result.add(b);
        }
        return result;
    }

    // 7
    public Model searchByBusNumber(String number) {
        for (Model b : buses) {
            if (b.getBusNumber().equals(number))
                return b;
        }
        return null;
    }

    // 8
    public int totalBuses() {
        return buses.size();
    }

    // 9
    public List<Model> searchByDriverName(String name) {
        List<Model> result = new ArrayList<>();
        for (Model b : buses) {
            if (b.getDriverName().equals(name))
                result.add(b);
        }
        return result;
    }

    // 10
    public List<Model> searchByBusType(String type) {
        List<Model> result = new ArrayList<>();
        for (Model b : buses) {
            if (b.getBusType().equals(type))
                result.add(b);
        }
        return result;
    }

    // 11
    public List<Model> searchByPickupPoint(String point) {
        List<Model> result = new ArrayList<>();
        for (Model b : buses) {
            if (b.getPickupPoint().equals(point))
                result.add(b);
        }
        return result;
    }

    // 12
    public List<Model> searchByUserType(String type) {
        List<Model> result = new ArrayList<>();
        for (Model b : buses) {
            if (b.getUserType().equals(type))
                result.add(b);
        }
        return result;
    }

    // 13
    public List<Model> searchBySchedule(String schedule) {
        List<Model> result = new ArrayList<>();
        for (Model b : buses) {
            if (b.getSchedule().equals(schedule))
                result.add(b);
        }
        return result;
    }

    // 14
    public boolean updateStatus(Long id, String status) {
        Model b = getBusById(id);
        if (b != null) {
            b.setStatus(status);
            return true;
        }
        return false;
    }

    // 15
    public boolean updateDriverInfo(Long id, String name, String phone) {
        Model b = getBusById(id);
        if (b != null) {
            b.setDriverName(name);
            b.setDriverPhone(phone);
            return true;
        }
        return false;
    }
}
