/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Accounts;

/**
 *
 * @author Huy Trinh
 */
public interface IAccounts {
   boolean save(Accounts inData);
      boolean update(Accounts inData);
      List<Accounts> findAll();
      Accounts findOneByUsername(String username);
      Accounts findOneByUsernameAndPassword(String username, String password);
      Accounts findOneById(int id);
}
