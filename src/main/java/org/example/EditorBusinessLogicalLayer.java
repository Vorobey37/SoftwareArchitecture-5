package org.example;

import java.util.Collection;
import java.util.Random;

public class EditorBusinessLogicalLayer implements BusinessLogicalLayer{

    private final DataBaseAccess editorDataBaseAccess;
    private Random random = new Random();

    public EditorBusinessLogicalLayer(DataBaseAccess editorDataBaseAccess) {
        this.editorDataBaseAccess = editorDataBaseAccess;
    }


    @Override
    public Collection<Texture> getAllTextures() {
        return editorDataBaseAccess.getAllTextures();
    }

    @Override
    public Collection<Model3D> getAllModels() {
        return editorDataBaseAccess.getAllModels();
    }

    @Override
    public void renderModel3D(Model3D model3D) throws InterruptedException {
        processRender(model3D);
    }

    @Override
    public void renderAllModels() throws InterruptedException {
        Collection<Model3D> models = editorDataBaseAccess.getAllModels();
        for (Model3D model : models) {
            processRender(model);
        }
    }

    private void processRender(Model3D model3D) throws InterruptedException {
        Thread.sleep(2500 - random.nextInt(2000));
    }
}
