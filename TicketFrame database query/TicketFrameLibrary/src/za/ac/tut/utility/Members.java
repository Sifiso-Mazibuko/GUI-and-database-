/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.utility;

/**
 *
 * @author sifiso
 */
public class Members {
    
    private String name;
    private String surname;
    private Integer cellphome;
    private Integer home;
    private Integer away;
    private Double cost;

    public Members(String name, String surname, Integer cellphome, Integer home, Integer away, Double cost) {
        this.name = name;
        this.surname = surname;
        this.cellphome = cellphome;
        this.home = home;
        this.away = away;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getCellphome() {
        return cellphome;
    }

    public void setCellphome(Integer cellphome) {
        this.cellphome = cellphome;
    }

    public Integer getHome() {
        return home;
    }

    public void setHome(Integer home) {
        this.home = home;
    }

    public Integer getAway() {
        return away;
    }

    public void setAway(Integer away) {
        this.away = away;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Members{" + "name=" + name + ", surname=" + surname + ", cellphome=" + cellphome + ", home=" + home + ", away=" + away + ", cost=" + cost + '}';
    }
    
    
}
