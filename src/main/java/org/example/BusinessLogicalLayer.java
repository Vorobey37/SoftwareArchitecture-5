package org.example;

import java.util.Collection;

public interface BusinessLogicalLayer {

    Collection<Texture> getAllTextures();
    Collection<Model3D> getAllModels();

    void renderModel3D(Model3D model3D) throws InterruptedException;
    void renderAllModels() throws InterruptedException;
}
