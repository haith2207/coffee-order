/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.imp;

import dao.ICategories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Categories;
import utils.MakeConnection;

/**
 *
 * @author Huy Trinh
 */
public class CategoriesDAO implements ICategories{
@Override
    public  boolean save(Categories inData) {
        Connection con = null;

        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = MakeConnection.makeConnection();
            String sql = "Insert into Categories values(?,?,?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, inData.getName());
            stm.setString(2, inData.getStatus());
            stm.setBoolean(3, inData.isDelete());

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
    public  boolean update(Categories inData) {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = MakeConnection.makeConnection();
            String sql = "Update Categories set Name=?, Status=?, IsDelete=? where ID=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, inData.getName());
            stm.setString(2, inData.getStatus());
            stm.setBoolean(3, inData.isDelete());
            stm.setInt(4, inData.getId());

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
            } catch (SQLException e) {
                e.getMessage();
            }
        }
        return result;
    }
@Override
    public  List<Categories> findAll() {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Categories> result = null;
        try {
            con = MakeConnection.makeConnection();
            String sql = "Select * From Categories";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                Categories cate = new Categories();
                cate.setId(rs.getInt(1));
                cate.setName(rs.getString(2));
                cate.setStatus(rs.getString(3));
                cate.setDelete(rs.getBoolean(4));
                result.add(cate);
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
    public  Categories findOneByID(int id) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Categories result = null;
        try {
            con = MakeConnection.makeConnection();
            String sql = "Select * From Categories Where ID=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();

            while (rs.next()) {
                Categories cate = new Categories();
                cate.setId(rs.getInt(1));
                cate.setName(rs.getString(2));
                cate.setStatus(rs.getString(3));
                cate.setDelete(rs.getBoolean(4));

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
    public  Categories findByName(String name) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Categories result = null;
        try {
            con = MakeConnection.makeConnection();
            String sql = "Select * From Categories Where Name =?";
            stm = con.prepareStatement(sql);
            stm.setString(1, name);
            rs = stm.executeQuery();
            while (rs.next()) {
                result = new Categories();
                result.setId(rs.getInt(1));
                result.setName(rs.getString(2));
                result.setStatus(rs.getString(3));
                result.setDelete(rs.getBoolean(4));

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
