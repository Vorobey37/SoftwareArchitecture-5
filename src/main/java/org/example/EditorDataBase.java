package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class EditorDataBase implements DataBase{

    private Random random = new Random();
    private final ProjectFile projectFile;
    private Collection<Entity> entities;

    public EditorDataBase(ProjectFile projectFile) {
        this.projectFile = projectFile;
        load();
    }


    @Override
    public void save() {

    }

    @Override
    public void load() {

    }

    @Override
    public Collection<Entity> getAll() {
        if (entities == null){
            entities = new ArrayList<>();
            int entCount = random.nextInt(5, 11);
            for (int i = 0; i < entCount; i++){
                generateModelsAndTextures();
            }
        }
        return entities;
    }

    private void generateModelsAndTextures(){
        Model3D model3D = new Model3D();
        int txCount = random.nextInt(3);
        for (int i = 0; i < txCount; i++){
            Texture texture = new Texture();
            model3D.getTextures().add(texture);
            entities.add(texture);
        }
        entities.add(model3D);
    }
}
