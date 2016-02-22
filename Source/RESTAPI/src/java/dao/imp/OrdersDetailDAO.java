/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.imp;

import dao.IOrdersDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Orders;
import models.OrdersDetail;
import utils.MakeConnection;

/**
 *
 * @author Huy Trinh
 */
public class OrdersDetailDAO implements IOrdersDetail{
@Override
    public  boolean save(OrdersDetail inData) {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = MakeConnection.makeConnection();
            String sql = "Insert into OrdersDetail values(?,?,?,?)";
            stm = con.prepareStatement(sql);
            stm.setInt(1, inData.getOrderID());
            stm.setInt(2, inData.getProductID());
            stm.setInt(3, inData.getQuantity());
            stm.setFloat(4, inData.getTotal());
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
    public  boolean update(OrdersDetail inData) {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = MakeConnection.makeConnection();
            String sql = "Update OrdersDetail set OrderID=?, ProductID=?, Quantity=?,Total=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, inData.getOrderID());
            stm.setInt(2, inData.getProductID());
            stm.setInt(3, inData.getQuantity());
            stm.setFloat(4, inData.getTotal());
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
    public  List<OrdersDetail> findAll() {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<OrdersDetail> result = null;
        try {
            con = MakeConnection.makeConnection();
            String sql = "Select * From OrdersDetail";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                OrdersDetail orderdetail = new OrdersDetail();
                orderdetail.setId(rs.getInt(1));
                orderdetail.setOrderID(rs.getInt(2));
                orderdetail.setProductID(rs.getInt(3));
                orderdetail.setQuantity(rs.getInt(4));
                orderdetail.setTotal(rs.getFloat(5));
                result.add(orderdetail);

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
    public  OrdersDetail findByOrdersID(int id) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        OrdersDetail result = null;
        try {
            con = MakeConnection.makeConnection();
            String sql = "Select * From OrdersDetail where OrdersID=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();

            while (rs.next()) {

                result.setId(rs.getInt(1));
                result.setOrderID(rs.getInt(2));
                result.setProductID(rs.getInt(3));
                result.setQuantity(rs.getInt(4));
                result.setTotal(rs.getFloat(5));

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
    public  OrdersDetail findByProductID(int id) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        OrdersDetail result = null;
        try {
            con = MakeConnection.makeConnection();
            String sql = "Select * From OrdersDetail where ProductID=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();

            while (rs.next()) {

                result.setId(rs.getInt(1));
                result.setOrderID(rs.getInt(2));
                result.setProductID(rs.getInt(3));
                result.setQuantity(rs.getInt(4));
                result.setTotal(rs.getFloat(5));

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
public OrdersDetail findByID(int id){
     Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        OrdersDetail result = null;
        try {
            con = MakeConnection.makeConnection();
            String sql = "Select * From OrdersDetail where ID=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();

            while (rs.next()) {

                result.setId(rs.getInt(1));
                result.setOrderID(rs.getInt(2));
                result.setProductID(rs.getInt(3));
                result.setQuantity(rs.getInt(4));
                result.setTotal(rs.getFloat(5));

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
