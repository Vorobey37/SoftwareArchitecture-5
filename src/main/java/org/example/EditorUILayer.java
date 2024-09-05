package org.example;

import java.util.ArrayList;

public class EditorUILayer implements UILayer{

    private BusinessLogicalLayer businessLogicalLayer;
    private ProjectFile projectFile;
    private DataBaseAccess dataBaseAccessLayer;
    private DataBase dataBase;




    private void initialize(){
        dataBase = new EditorDataBase(projectFile);
        dataBaseAccessLayer = new EditorDataBaseAccess(dataBase);
        businessLogicalLayer = new EditorBusinessLogicalLayer(dataBaseAccessLayer);
    }

    @Override
    public void openProject(String fileName) {
        this.projectFile = new ProjectFile(fileName);
        initialize();
    }

    @Override
    public void showProjectSettings() {
        checkProjectFile();

        System.out.println(projectFile.getFileName());
        System.out.println(projectFile.getSetting1());
        System.out.println(projectFile.getSetting2());
        System.out.println(projectFile.isSetting3());

    }

    private void checkProjectFile(){
        if (projectFile == null){
            throw new RuntimeException("Файл проекта не определен");
        }
    }

    @Override
    public void saveProject() {
        checkProjectFile();
        dataBase.save();
        System.out.println("Изменения сохранены");
    }

    @Override
    public void printAllModels() {
        checkProjectFile();

        ArrayList<Model3D> model3DS = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();
        for (int i = 0; i < model3DS.size(); i++) {
            System.out.println(model3DS.get(i));
            for (Texture texture : model3DS.get(i).getTextures()) {
                System.out.println(texture);
            }
        }

    }

    @Override
    public void printAllTextures() {
        checkProjectFile();

        ArrayList<Texture> textures = (ArrayList<Texture>) businessLogicalLayer.getAllTextures();
        for (Texture texture : textures) {
            System.out.println(texture);
        }
    }

    @Override
    public void renderAll() throws InterruptedException {
        checkProjectFile();

        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderAllModels();
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.println("Операция выполнена за " + endTime + " мс");

    }

    @Override
    public void renderModel(int i) throws InterruptedException {
        checkProjectFile();

        ArrayList<Model3D> model3DS = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();
        if (i < 0 || i > (model3DS.size() - 1)){
            throw new RuntimeException("Номер указан некорректно");
        }

        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderModel3D(model3DS.get(i));
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.println("Операция выполнена за " + endTime + " мс");
    }
}
