/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plagin;

/**
 *
 * @author shareef_ragab
 */
public enum Face {
    FaceWelcome, PageCenter, ConnectDateBase, workbench;

    public static Face getFaceWelcome() {
        return FaceWelcome;
    }

    public static Face getPageCenter() {
        return PageCenter;
    }

    public static Face getConnectDateBase() {
        return ConnectDateBase;
    }

    public static Face getWorkbench() {
        return workbench;
    }

}
