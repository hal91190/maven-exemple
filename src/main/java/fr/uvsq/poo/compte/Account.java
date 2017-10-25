package fr.uvsq.poo.compte;

import java.math.BigDecimal;

/**
 * La classe <code>Account</code> représente un compte bancaire.
 *
 * @author Stéphane Lopes
 * @version 2017
 */
class Account {
  private BigDecimal balance;

  /**
   * Crée un compte avec un montant initial.
   *
   * @param initialBalance le montant initial
   */
  public Account(BigDecimal initialBalance) {
    balance = initialBalance;
  }

  /**
   * Retourne le solde du compte.
   * @return le solde du compte
   */
  public BigDecimal getBalance() {
    return balance;
  }
}
