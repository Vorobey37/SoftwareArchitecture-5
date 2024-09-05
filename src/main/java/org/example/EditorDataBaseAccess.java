package org.example;

import java.util.ArrayList;
import java.util.Collection;

public class EditorDataBaseAccess implements DataBaseAccess{


    private final DataBase editorDataBase;

    public EditorDataBaseAccess(DataBase editorDataBase) {
        this.editorDataBase = editorDataBase;
    }


    @Override
    public void addEntity(Entity entity) {
        editorDataBase.getAll().add(entity);
    }

    @Override
    public void removeEntity(Entity entity) {
        editorDataBase.getAll().remove(entity);
    }

    @Override
    public Collection<Texture> getAllTextures() {
        Collection<Texture> textures = new ArrayList<>();
        for (Entity entity : editorDataBase.getAll()) {
            if (entity instanceof Texture){
                textures.add((Texture) entity);
            }
        }
        return textures;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        Collection<Model3D> model3DS = new ArrayList<>();
        for (Entity entity : editorDataBase.getAll()) {
            if (entity instanceof Model3D){
                model3DS.add((Model3D) entity);
            }
        }
        return model3DS;
    }
}
