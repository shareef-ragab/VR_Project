/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plagin;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author shareef_ragab
 */
public class DateBase {

    //<editor-fold defaultstate="collapsed" desc="varible">
    private String local, url, port, HostName, password, user, nameDataBase, codeData;
    private Connection conn;
    private ResultSet rs;
    private Statement stat;
    private PreparedStatement pst;
    private ResultSetMetaData rsmd;
    private DatabaseMetaData dbbmd;
//</editor-fold>

    /**
     *
     */
    public DateBase() {

    }

    /**
     *
     * @param local
     * @param url
     * @param schema
     * @param HostName
     * @param port
     * @param user
     * @param password
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public DateBase(final String local, final String url, final String schema, final String HostName, final String port, final String user, final String password) throws ClassNotFoundException, SQLException {
        setLocal(local);
        setUser(user);
        setPassword(password);
        setHostName(HostName);
        setPort(port);
        setNameDataBase(schema);
        setUrl(url);
        open(local, url, user, password);
    }

    /**
     *
     * @param url
     * @param schema
     * @param HostName
     * @param port
     * @param user
     * @param password
     * @throws SQLException
     */
    public DateBase(final String url, final String schema, final String HostName, final String port, final String user, final String password) throws SQLException {
        setUser(user);
        setPassword(password);
        setHostName(HostName);
        setPort(port);
        setNameDataBase(schema);
        setUrl(url);
        open(url, user, password);
    }

    /**
     *
     * @param local
     * @param url
     * @param user
     * @param password
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public DateBase(final String local, final String url, final String user, final String password) throws ClassNotFoundException, SQLException {
        open(local, url, user, password);
    }

    /**
     *
     * @param local
     * @param url
     * @param user
     * @param password
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public DateBase( final String url, final String user, final String password) throws ClassNotFoundException, SQLException {
        open(url, user, password);
    }

    //<editor-fold defaultstate="collapsed" desc="set && get">
    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    private void setLocal(final String local) {
        this.local = local;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    private void setUrl(final String url) {
        this.url = url;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    private void setPort(final String port) {
        this.port = port;
    }

    /**
     * @return the HostName
     */
    public String getHostName() {
        return HostName;
    }

    /**
     * @param HostName the HostName to set
     */
    private void setHostName(final String HostName) {
        this.HostName = HostName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    private void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    private void setUser(final String user) {
        this.user = user;
    }

    /**
     * @return the nameDataBase
     */
    public String getNameDataBase() {
        return nameDataBase;
    }

    /**
     * @param nameDataBase the nameDataBase to set
     */
    private void setNameDataBase(final String nameDataBase) {
        this.nameDataBase = nameDataBase;
    }

    /**
     * @return the codeData
     */
    public String getCodeData() {
        return codeData;
    }

    /**
     * @param codeData the codeData to set
     */
    public void setCodeData(final String codeData) {
        this.codeData = codeData;
    }

    /**
     * @return the conn
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * @param conn the conn to set
     */
    public void setConn(final Connection conn) {
        this.conn = conn;
    }

    /**
     * @return the rs
     */
    public ResultSet getRs() {
        return rs;
    }

    /**
     * @param rs the rs to set
     */
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    /**
     * @return the stat
     */
    public Statement getStat() {
        return stat;
    }

    /**
     * @param stat the stat to set
     */
    public void setStat(Statement stat) {
        this.stat = stat;
    }

    /**
     * @return the pst
     */
    public PreparedStatement getPst() {
        return pst;
    }

    /**
     * @param pst the pst to set
     */
    public void setPst(PreparedStatement pst) {
        this.pst = pst;
    }

    /**
     * @return the rsmd
     */
    public ResultSetMetaData getRsmd() {
        return rsmd;
    }

    /**
     * @param rsmd the rsmd to set
     */
    public void setRsmd(ResultSetMetaData rsmd) {
        this.rsmd = rsmd;
    }

    /**
     * @return the dbbmd
     */
    public DatabaseMetaData getDbbmd() {
        return dbbmd;
    }

    /**
     * @param dbbmd the dbbmd to set
     */
    public void setDbbmd(DatabaseMetaData dbbmd) {
        this.dbbmd = dbbmd;
    }
//</editor-fold>

    private void DB(String local, String url, String user, String password) throws ClassNotFoundException, SQLException {
        //<editor-fold defaultstate="collapsed" desc="statment">
        Class.forName(local);
        setConn(DriverManager.getConnection(url, user, password));
        setStat(getConn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE));
//</editor-fold>
    }

    private void DB(String url, String user, String password) throws SQLException {
        //<editor-fold defaultstate="collapsed" desc="statment">
        setConn(DriverManager.getConnection(url, user, password));
        setStat(getConn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE));
//</editor-fold>
    }

    private void open(String local, String url, String user, String password) throws SQLException, ClassNotFoundException {
        //<editor-fold defaultstate="collapsed" desc="statment">
        if (getRs() == null || getConn() == null || getStat() != null) {
            DB(local, url, user, password);
        }
//</editor-fold>
    }

    private void open(String url, String user, String password) throws SQLException {
        //<editor-fold defaultstate="collapsed" desc="statment">
        if (getRs() == null || getConn() == null || getStat() != null) {
            DB(url, user, password);
        }
//</editor-fold>
    }

    private boolean curoser(String query) throws SQLException {
        //<editor-fold defaultstate="collapsed" desc="statment">
        setRs(getStat().executeQuery(query));
        return getRs().next();
//</editor-fold>
    }

    /**
     *
     * @param query
     * @return
     * @throws SQLException
     */
    public boolean setCuroser(final String query) throws SQLException {
        return curoser(query);

    }

}
