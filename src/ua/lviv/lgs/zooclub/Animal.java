package ua.lviv.lgs.zooclub;

import java.util.Objects;

public class Animal {
    private String name;
    private String typeOfAnimal;

    public Animal(String name, String typeOfAnimal) {
        this.name = name;
        this.typeOfAnimal = typeOfAnimal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfAnimal() {
        return typeOfAnimal;
    }

    public void setTypeOfAnimal(String typeOfAnimal) {
        this.typeOfAnimal = typeOfAnimal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return Objects.equals(getName(), animal.getName()) &&
                Objects.equals(getTypeOfAnimal(), animal.getTypeOfAnimal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getTypeOfAnimal());
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", typeOfAnimal='" + typeOfAnimal + '\'' +
                '}';
    }
}
