package org.example;

import java.util.Collection;

public interface DataBase {

    void save();
    void load();
    Collection<Entity> getAll();

}
