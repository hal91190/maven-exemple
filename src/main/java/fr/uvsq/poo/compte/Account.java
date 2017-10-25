package fr.uvsq.poo.compte;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

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
    if (initialBalance.compareTo(ZERO) < 0) {
      throw new IllegalArgumentException("Montant invalide");
    }
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
