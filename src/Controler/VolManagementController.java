/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import Model.Aeroport;
import Model.EscalesVols;
import java.sql.*;
import java.util.*;
import java.sql.Date;
import configs.Crude;
import javax.swing.*;
import Model.Vol;
import Model.Escales;
import configs.MyConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author wiemz
 */
public class VolManagementController {
    private Aeroport getAeroportById(int aeroportId) {
        Aeroport aeroport = null;
        
        Connection connection = MyConnexion.getInstance().getConnection();
        try {
            String query = "SELECT * FROM Aeroport WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, aeroportId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        aeroport = new Aeroport(resultSet.getInt("id"), resultSet.getString("nom"), resultSet.getString("pays"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return aeroport;
    }
    public List getVolsList() {
        List<Object> volsList = new ArrayList<>();
        try {
            Connection connection = MyConnexion.getInstance().getConnection();
            String query = "SELECT id, aeroport_dep, aeroport_arr, heure_dep, heure_arr, date_dep, date_arr, num_vol, reservation, nombre_escales FROM vols";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        int id_aeroportDepart = resultSet.getInt("aeroport_dep");
                        int id_aeroportArrivee = resultSet.getInt("aeroport_arr");
                        int heureDepart = resultSet.getInt("heure_dep");
                        int heureArrive = resultSet.getInt("heure_arr");
                        String dateDepart = resultSet.getString("date_dep");
                        String dateArrivee = resultSet.getString("date_arr");
                        int numVol = resultSet.getInt("num_vol");
                        boolean reservation = resultSet.getBoolean("reservation");
                        int nombreEscales = resultSet.getInt("nombre_escales");
                        Aeroport aeroportDepart = getAeroportById(id_aeroportDepart);
                        Aeroport aeroportArrivee = getAeroportById(id_aeroportArrivee);
                        Vol vol = new Vol(id, numVol, aeroportDepart, aeroportArrivee, dateDepart, dateArrivee, heureDepart, heureArrive, reservation, nombreEscales);
                        volsList.add(vol);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return volsList;
    }
    
    public List<Vol> RechercherVolByNumVol(int nbEscales) {
        List<Vol> volsList = new ArrayList<>();

        try {
            Connection connection = MyConnexion.getInstance().getConnection();
            String query = "SELECT * FROM Vols WHERE nombre_escales = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, nbEscales); // Set the num_vol parameter

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        int id_aeroportDepart = resultSet.getInt("aeroport_dep");
                        int id_aeroportArrivee = resultSet.getInt("aeroport_arr");
                        int heureDepart = resultSet.getInt("heure_dep");
                        int heureArrive = resultSet.getInt("heure_arr");
                        String dateDepart = resultSet.getString("date_dep");
                        String dateArrivee = resultSet.getString("date_arr");
                        int numV = resultSet.getInt("num_vol");
                        boolean reservation = resultSet.getBoolean("reservation");
                        int nombreEscales = resultSet.getInt("nombre_escales");

                        Aeroport aeroportDepart = getAeroportById(id_aeroportDepart);
                        Aeroport aeroportArrivee = getAeroportById(id_aeroportArrivee);

                        Vol vol = new Vol(id, numV, aeroportDepart, aeroportArrivee, dateDepart, dateArrivee, heureDepart, heureArrive, reservation, nombreEscales);
                        volsList.add(vol);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return volsList;
    }


    public List<Escales> getEscalesList() {
        List<Escales> escalesList = new ArrayList<>();
        try {
            Connection connection = MyConnexion.getInstance().getConnection();
            String query = "SELECT id, heure_dep, heure_arr FROM escales";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        int heureDepart = resultSet.getInt("heure_dep");
                        int heureArrive = resultSet.getInt("heure_arr");

                        Escales escales = new Escales(id, heureDepart, heureArrive);
                        escalesList.add(escales);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return escalesList;
    }
    
    public List<Aeroport> getAeroportsList() {
        List<Aeroport> aeroportList = new ArrayList<>();
        try {
            Connection connection = MyConnexion.getInstance().getConnection();
            String query = "SELECT id, nom, pays FROM aeroport";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String nom = resultSet.getString("nom");
                        String pays = resultSet.getString("pays");

                        Aeroport aeroport = new Aeroport(id, nom, pays);
                        aeroportList.add(aeroport);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aeroportList;
    }
    
    public void AjouterAeroport(Aeroport aeroport) {
        try {
            Connection connection = MyConnexion.getInstance().getConnection();
            if (connection != null) {
                String query = "INSERT INTO aeroport (id,  nom, pays) VALUES (?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, aeroport.getId());
                    preparedStatement.setString(2, aeroport.getNom());
                    preparedStatement.setString(3, aeroport.getPays());

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Data inserted successfully!");
                    } else {
                        System.out.println("Failed to insert data.");
                    }
                }
            } else {
                System.out.println("Connection is null. Check your connection setup.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void AjouterEscales(Escales escale) {
        try {
            Connection connection = MyConnexion.getInstance().getConnection();
            if (connection != null) {
                String query = "INSERT INTO escales (id,  heure_dep, heure_arr) VALUES (?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, escale.getId());
                    preparedStatement.setInt(2, escale.getHeureDepart());
                    preparedStatement.setInt(3, escale.getHeureArrive());

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Data inserted successfully!");
                    } else {
                        System.out.println("Failed to insert data.");
                    }
                }
            } else {
                System.out.println("Connection is null. Check your connection setup.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int AjouterVol(Vol vol) {
        int generatedId = -1;

        try {
            Connection connection = MyConnexion.getInstance().getConnection();

            if (connection != null) {
                String query = "INSERT INTO Vols (aeroport_dep, aeroport_arr, heure_dep, heure_arr, date_dep, date_arr, num_vol, reservation, nombre_escales) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

                try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                    preparedStatement.setObject(1, vol.getId_AeroportDepart().getId());
                    preparedStatement.setObject(2, vol.getId_AeroportArrive().getId());
                    preparedStatement.setInt(3, vol.getHeureArrivee());
                    preparedStatement.setInt(4, vol.getHeureArrivee());
                    preparedStatement.setString(5, vol.getDateDepart());
                    preparedStatement.setString(6, vol.getDateArrive());
                    preparedStatement.setInt(7, vol.getNumVol());
                    preparedStatement.setBoolean(8, vol.isResOpen());
                    preparedStatement.setInt(9, vol.getNombreEscales());
                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Data inserted successfully!");

                        // Retrieve the generated ID
                        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                            if (generatedKeys.next()) {
                                generatedId = generatedKeys.getInt(1);
                                System.out.println("Generated ID: " + generatedId);
                            } else {
                                System.out.println("Failed to retrieve generated ID.");
                            }
                        }
                    } else {
                        System.out.println("Failed to insert data.");
                    }
                }
            } else {
                System.out.println("Connection is null. Check your connection setup.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return generatedId;
    }
    
    public boolean SupprimerVol(int volId) {
        boolean success = false;

        try {
            Connection connection = MyConnexion.getInstance().getConnection();

            if (connection != null) {
                String deleteEscaleQuery = "DELETE FROM escale_vols WHERE vol = ?";

                try (PreparedStatement deleteEscaleStatement = connection.prepareStatement(deleteEscaleQuery)) {
                    deleteEscaleStatement.setInt(1, volId);
                    deleteEscaleStatement.executeUpdate();
                        String deleteVolQuery = "DELETE FROM Vols WHERE id = ?";

                        try (PreparedStatement deleteVolStatement = connection.prepareStatement(deleteVolQuery)) {
                            deleteVolStatement.setInt(1, volId);
                            int volRowsAffected = deleteVolStatement.executeUpdate();

                            if (volRowsAffected > 0) {
                                System.out.println("Vol with ID " + volId + " deleted successfully!");
                                success = true;
                            } else {
                                System.out.println("No vol with ID " + volId + " found to delete.");
                            }
                        }
                }
            } else {
                System.out.println("Connection is null. Check your connection setup.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    public boolean ModifierVol(Vol vol, int id) {
        boolean success = false;

        try {
            Connection connection = MyConnexion.getInstance().getConnection();

            if (connection != null) {
                String query = "UPDATE Vols SET aeroport_dep=?, aeroport_arr=?, heure_dep=?, heure_arr=?, date_dep=?, date_arr=?, num_vol=?, reservation=?, nombre_escales=? WHERE id=?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setObject(1, vol.getId_AeroportDepart().getId());
                    preparedStatement.setObject(2, vol.getId_AeroportArrive().getId());
                    preparedStatement.setInt(3, vol.getHeureDepart());
                    preparedStatement.setInt(4, vol.getHeureArrivee());
                    preparedStatement.setString(5, vol.getDateDepart());
                    preparedStatement.setString(6, vol.getDateArrive());
                    preparedStatement.setInt(7, vol.getNumVol());
                    preparedStatement.setBoolean(8, vol.isResOpen());
                    preparedStatement.setInt(9, vol.getNombreEscales());
                    preparedStatement.setInt(10, id);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Vol with ID " + vol.getId() + " modified successfully!");
                        success = true;
                    } else {
                        System.out.println("No vol with ID " + vol.getId() + " found to modify.");
                    }
                }
            } else {
                System.out.println("Connection is null. Check your connection setup.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }


    public void AjouteEscalesVols(int volId, int escaleId) {
        try {
            Connection connection = MyConnexion.getInstance().getConnection();
            if (connection != null) {
                String query = "INSERT INTO escale_vols (vol, escale) VALUES (?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setObject(1, volId);
                    preparedStatement.setObject(2, escaleId);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Data inserted successfully!");
                    } else {
                        System.out.println("Failed to insert data.");
                    }
                }
            } else {
                System.out.println("Connection is null. Check your connection setup.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
