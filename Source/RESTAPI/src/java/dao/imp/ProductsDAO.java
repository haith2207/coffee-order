/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.imp;

import dao.IProducts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Products;
import utils.MakeConnection;

/**
 *
 * @author Huy Trinh
 */
public class ProductsDAO implements IProducts {

    @Override
    public boolean save(Products inData) {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = MakeConnection.makeConnection();
            String sql = "Insert into Products values(?,?,?,?,?,?,?,?)";
            stm = con.prepareStatement(sql);

            stm.setString(1, inData.getName());
            stm.setFloat(2, inData.getPrice());
            stm.setString(3, inData.getImageLink());
            stm.setString(4, inData.getDescriptions());
            stm.setString(5, inData.getCoverLink());
            stm.setInt(6, inData.getCatID());
            stm.setString(7, inData.getStatus());
            stm.setBoolean(8, inData.isDelete());

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
    public  boolean update(Products inData) {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = MakeConnection.makeConnection();
            String sql = "Update Products set Name = ?, Price = ?, ImageLink = ?, Descriptons = ?,CoverLink=?, CatID=?, Status=?, IsDelete=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, inData.getName());
            stm.setFloat(2, inData.getPrice());
            stm.setString(3, inData.getImageLink());
            stm.setString(4, inData.getDescriptions());
            stm.setString(5, inData.getCoverLink());
            stm.setInt(6, inData.getCatID());
            stm.setString(7, inData.getStatus());
            stm.setBoolean(8, inData.isDelete());
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
    public  List<Products> findAll() {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Products> result = null;

        try {
            con = MakeConnection.makeConnection();
            String sql = "Select * From Products";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                Products product = new Products();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setPrice(rs.getFloat(3));
                product.setImageLink(rs.getString(4));
                product.setDescriptions(rs.getString(5));
                product.setCoverLink(rs.getString(6));
                product.setCatID(rs.getInt(7));
                product.setStatus(rs.getString(8));
                product.setDelete(rs.getBoolean(9));
                result.add(product);

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
    public  Products findByID(int id) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Products result = null;

        try {
            con = MakeConnection.makeConnection();
            String sql = "Select * From Products where ID=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();

            while (rs.next()) {
                result.setId(rs.getInt(1));
                result.setName(rs.getString(2));
                result.setPrice(rs.getFloat(3));
                result.setImageLink(rs.getString(4));
                result.setDescriptions(rs.getString(5));
                result.setCoverLink(rs.getString(6));
                result.setCatID(rs.getInt(7));
                result.setStatus(rs.getString(8));
                result.setDelete(rs.getBoolean(9));

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
    public  Products findByCatID(int id) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Products result = null;

        try {
            con = MakeConnection.makeConnection();
            String sql = "Select * From Products where CatID=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();

            while (rs.next()) {

                result.setId(rs.getInt(1));
                result.setName(rs.getString(2));
                result.setPrice(rs.getFloat(3));
                result.setImageLink(rs.getString(4));
                result.setDescriptions(rs.getString(5));
                result.setCoverLink(rs.getString(6));
                result.setCatID(rs.getInt(7));
                result.setStatus(rs.getString(8));
                result.setDelete(rs.getBoolean(9));

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
    public  Products findByName(String name) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Products result = null;

        try {
            con = MakeConnection.makeConnection();
            String sql = "Select * From Products where Name=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, name);
            rs = stm.executeQuery();

            while (rs.next()) {

                result.setId(rs.getInt(1));
                result.setName(rs.getString(2));
                result.setPrice(rs.getFloat(3));
                result.setImageLink(rs.getString(4));
                result.setDescriptions(rs.getString(5));
                result.setCoverLink(rs.getString(6));
                result.setCatID(rs.getInt(7));
                result.setStatus(rs.getString(8));
                result.setDelete(rs.getBoolean(9));

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
    public  Products findByPrice(float price) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Products result = null;

        try {
            con = MakeConnection.makeConnection();
            String sql = "Select * From Products where Price=?";
            stm = con.prepareStatement(sql);
            stm.setFloat(1, price);
            rs = stm.executeQuery();

            while (rs.next()) {

                result.setId(rs.getInt(1));
                result.setName(rs.getString(2));
                result.setPrice(rs.getFloat(3));
                result.setImageLink(rs.getString(4));
                result.setDescriptions(rs.getString(5));
                result.setCoverLink(rs.getString(6));
                result.setCatID(rs.getInt(7));
                result.setStatus(rs.getString(8));
                result.setDelete(rs.getBoolean(9));
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
