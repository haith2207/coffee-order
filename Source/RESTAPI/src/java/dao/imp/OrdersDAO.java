/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.imp;

import dao.IOrders;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Orders;
import utils.MakeConnection;

/**
 *
 * @author Huy Trinh
 */
public class OrdersDAO implements IOrders{
    @Override
    public  boolean save(Orders inData) {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = MakeConnection.makeConnection();
            String sql = "Insert into Orders values(?,?,?,?,?,?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, inData.getAddress());
            stm.setString(2, inData.getStatus());
            stm.setBoolean(3, inData.isDelete());
            stm.setInt(4, inData.getAccountID());
            stm.setDate(5, (Date) inData.getDateCreate());
            stm.setFloat(6, inData.getTotalprice());
            
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
            return result;
            
        }
    }
    @Override
    public  boolean update(Orders inData) {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = MakeConnection.makeConnection();
            String sql = "Update Orders set Address=?, Status=?, IsDelete=?, AccountID =?, DateCreate=?, TotalPrice=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, inData.getAddress());
            stm.setString(2, inData.getStatus());
            stm.setBoolean(3, inData.isDelete());
            stm.setInt(4, inData.getAccountID());
            stm.setDate(5, (Date) inData.getDateCreate());
            stm.setFloat(6, inData.getTotalprice());
            
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
            return result;
        }
    }
    @Override
    public  List<Orders> findAll() {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Orders> result = null;
        
        try {
            con = MakeConnection.makeConnection();
            String sql = "Select * From Orders";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                Orders order = new Orders();
                order.setId(rs.getInt(1));
                order.setAddress(rs.getString(2));
                order.setStatus(rs.getString(3));
                order.setDelete(rs.getBoolean(4));
                order.setAccountID(rs.getInt(5));
                order.setDateCreate(rs.getDate(6));
                order.setTotalprice(rs.getFloat(7));
                result.add(order);
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
            }
        }
        return result;
    }
    @Override
    public  Orders findByAddress(String address) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Orders result = null;
        try {
            con = MakeConnection.makeConnection();
            String sql = "Select * From Orders where Address=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, address);
            rs = stm.executeQuery();
            
            while (rs.next()) {
                result.setId(rs.getInt(1));
                result.setAddress(rs.getString(2));
                result.setStatus(rs.getString(3));
                result.setDelete(rs.getBoolean(4));
                result.setAccountID(rs.getInt(5));
                result.setDateCreate(rs.getDate(6));
                result.setTotalprice(rs.getFloat(7));
                
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
            }
        }
        return result;
    }
    @Override
    public  Orders findByID (int id){
         Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Orders result = null;
        try {
            con = MakeConnection.makeConnection();
            String sql = "Select * From Orders where ID=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            
            while (rs.next()) {
                result.setId(rs.getInt(1));
                result.setAddress(rs.getString(2));
                result.setStatus(rs.getString(3));
                result.setDelete(rs.getBoolean(4));
                result.setAccountID(rs.getInt(5));
                result.setDateCreate(rs.getDate(6));
                result.setTotalprice(rs.getFloat(7));
                
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
            }
        }
        return result;
    }
    @Override
    public  Orders findByAccountID (int id)
    {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Orders result = null;
        try {
            con = MakeConnection.makeConnection();
            String sql = "Select * From Orders where ID=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            
            while (rs.next()) {
                result.setId(rs.getInt(1));
                result.setAddress(rs.getString(2));
                result.setStatus(rs.getString(3));
                result.setDelete(rs.getBoolean(4));
                result.setAccountID(rs.getInt(5));
                result.setDateCreate(rs.getDate(6));
                result.setTotalprice(rs.getFloat(7));
                
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
            }
        }
        return result;
    }
}
