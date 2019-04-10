/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeltion;

/**
 *
 * @author shareef_ragab
 */
public class classStudy {

    private String pathVeido, pathDiscrption, nameVeido, dateCreate, nameAuther;

    public classStudy(String pathVeido, String pathDiscrption, String nameVeido, String dateCreate, String nameAuther) {
        this.pathVeido = pathVeido;
        this.pathDiscrption = pathDiscrption;
        this.nameVeido = nameVeido;
        this.dateCreate = dateCreate;
        this.nameAuther = nameAuther;
    }

    public String getPathVeido() {
        return pathVeido;
    }

    public void setPathVeido(String pathVeido) {
        this.pathVeido = pathVeido;
    }

    public String getPathDiscrption() {
        return pathDiscrption;
    }

    public void setPathDiscrption(String pathDiscrption) {
        this.pathDiscrption = pathDiscrption;
    }

    public String getNameVeido() {
        return nameVeido;
    }

    public void setNameVeido(String nameVeido) {
        this.nameVeido = nameVeido;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getNameAuther() {
        return nameAuther;
    }

    public void setNameAuther(String nameAuther) {
        this.nameAuther = nameAuther;
    }
}
