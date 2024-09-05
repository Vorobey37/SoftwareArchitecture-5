package org.example;

public interface UILayer {

    void openProject(String fileName);
    void showProjectSettings();
    void saveProject();
    void printAllModels();
    void printAllTextures();
    void renderAll() throws InterruptedException;
    void renderModel(int id) throws InterruptedException;

}
