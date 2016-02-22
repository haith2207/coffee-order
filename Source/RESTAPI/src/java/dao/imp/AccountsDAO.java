/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.imp;

import dao.IAccounts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Accounts;
import utils.Constant;
import utils.MakeConnection;

/**
 *
 * @author Huy Trinh
 */
public class AccountsDAO implements IAccounts{

    @Override
    public  boolean save(Accounts inData) {
        Connection con = null;
        PreparedStatement stm = null;

        boolean result = false;
        try {
            con = MakeConnection.makeConnection();
            String sql = "Insert into Accounts values(?,?,?,?,?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, inData.getUsername());
            stm.setString(2, inData.getPassword());
            stm.setString(3, inData.getRole());
            stm.setString(4, inData.getStatus());
            stm.setBoolean(5, inData.isDelete());

            int row = stm.executeUpdate();
            if (row > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return result;
    }

    @Override
public  boolean update(Accounts inData) {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = MakeConnection.makeConnection();
            String sql = "Update Accounts set Password=?,Role=?,Status=?,IsDelete=? where Username=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, inData.getPassword());
            stm.setString(2, inData.getRole());
            stm.setString(3, inData.getStatus());
            stm.setBoolean(4, inData.isDelete());
            stm.setString(5, inData.getUsername());
            int row = stm.executeUpdate();
            if (row > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return result;
    }
@Override
    public  List<Accounts> findAll() {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Accounts> result = null;
        try {
            con = MakeConnection.makeConnection();
            String sql = "Select * From Accounts";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                Accounts account = new Accounts();
                account.setId(rs.getInt(1));
                account.setUsername(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setRole(rs.getString(4));
                account.setStatus(rs.getString(5));
                account.setDelete(rs.getBoolean(6));
                     
                result.add(account);
            }

        } catch (SQLException e) {
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (con != null) {
                    con.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return result;
    }

    @Override
    public  Accounts findOneByUsername(String username) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Accounts result = null;
        try {
            con = MakeConnection.makeConnection();
            String sql = "Select * From Accounts Where Username=? ";
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            
            rs = stm.executeQuery();

            while (rs.next()) {
                result = new Accounts();
                result.setId(rs.getInt(1));
                result.setUsername(rs.getString(2));
                result.setPassword(rs.getString(3));
                result.setRole(rs.getString(4));
                result.setStatus(rs.getString(5));
                result.setDelete(rs.getBoolean(6));

            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (con != null) {
                    con.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return result;
    }

    @Override
    public  Accounts findOneByUsernameAndPassword(String username, String password) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Accounts result = null;
        try {
            con = MakeConnection.makeConnection();
            String sql = "Select * From Accounts Where Username=? AND Password =?";
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();
            while (rs.next()) {
                result = new Accounts();
                result.setId(rs.getInt(1));
                result.setUsername(rs.getString(2));
                result.setPassword(rs.getString(3));
                result.setRole(rs.getString(4));
                result.setStatus(rs.getString(5));
                result.setDelete(rs.getBoolean(6));

            }
            

        } catch (SQLException e) {
        }
        finally {
            try {
                if (stm != null) 
                {
                    stm.close();
                }
                if (con != null) 
                {
                    con.close();
                }
                if (rs != null) 
                {
                    rs.close();
                }
            } 
                catch (Exception e) 
                {
                e.getMessage();
            }
        }
        return result;

    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public  Accounts findOneById(int id) {
        Connection con = null;
        PreparedStatement stm = null;

        ResultSet rs = null;
        Accounts result = null;
        try {
            con = MakeConnection.makeConnection();
            String sql = "Select * From Accounts where ID=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);

            rs = stm.executeQuery();

            while (rs.next()) {
                result = new Accounts();
                result.setId(rs.getInt(1));
                result.setUsername(rs.getString(2));
                result.setPassword(rs.getString(3));
                result.setRole(rs.getString(4));
                result.setStatus(rs.getString(5));
                result.setDelete(rs.getBoolean(6));
             
            }

        } catch (SQLException e) {
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (con != null) {
                    con.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return result;
    }
}
